package ru.education.bootlab;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import java.util.*;
import java.util.stream.Stream;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(properties="forwarding.enabled=false") @AutoConfigureMockMvc
class FeedbackValidationTest {
    @Autowired MockMvc mvc;
    @Autowired ObjectMapper mapper;
    static Map<String, Object> valid() {
        Map<String, Object> data = new HashMap<>();
        data.put("uid", "1"); data.put("operationUid", "op-1");
        data.put("systemTime", "2026-10-16T10:00:00Z"); data.put("communicationId", 100);
        return data;
    }
    static Stream<Object[]> invalid() {
        List<Object[]> cases = new ArrayList<>();
        for (String field : List.of("uid", "operationUid", "systemTime"))
            for (Object value : Arrays.asList(null, "", "   ")) cases.add(new Object[]{field, value});
        for (String field : List.of("uid", "operationUid")) cases.add(new Object[]{field, "x".repeat(33)});
        for (Object value : Arrays.asList(null, 0, -1, 100001)) cases.add(new Object[]{"communicationId", value});
        return cases.stream();
    }
    @ParameterizedTest @MethodSource("invalid")
    void rejectsEachInvalidField(String field, Object value) throws Exception {
        Map<String, Object> data = valid(); data.put(field, value);
        mvc.perform(post("/feedback").contentType("application/json").content(mapper.writeValueAsBytes(data)))
            .andExpect(status().isBadRequest()).andExpect(jsonPath("$.code").value("failed"))
            .andExpect(jsonPath("$.errorCode").value("ValidationException"))
            .andExpect(jsonPath("$.details").value(org.hamcrest.Matchers.containsString(field)));
    }
    @Test void acceptsBoundariesAndOptionalFieldsOmitted() throws Exception {
        for (int id : List.of(1, 100000)) {
            Map<String, Object> data = valid();data.put("uid", "x".repeat(32));
            data.put("operationUid", "y".repeat(32)); data.put("communicationId", id);
            mvc.perform(post("/feedback").contentType("application/json").content(mapper.writeValueAsBytes(data)))
                .andExpect(status().isOk()).andExpect(jsonPath("$.code").value("success"))
                .andExpect(jsonPath("$.errorCode").value(""));
        }
    }
    @Test void returnsAllValidationErrorsTogether() throws Exception {
        mvc.perform(post("/feedback").contentType("application/json").content("{}"))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.details").value(org.hamcrest.Matchers.containsString("uid")))
            .andExpect(jsonPath("$.details").value(org.hamcrest.Matchers.containsString("operationUid")))
            .andExpect(jsonPath("$.details").value(org.hamcrest.Matchers.containsString("systemTime")))
            .andExpect(jsonPath("$.details").value(org.hamcrest.Matchers.containsString("communicationId")));
    }
    @Test void rejectsReservedUid() throws Exception {
        Map<String,Object> data=valid();data.put("uid","123");
        mvc.perform(post("/feedback").contentType("application/json").content(mapper.writeValueAsBytes(data)))
            .andExpect(status().isBadRequest()).andExpect(jsonPath("$.errorCode").value("UnsupportedCodeException"));
    }
    @Test void rejectsMalformedJson() throws Exception {
        mvc.perform(post("/feedback").contentType("application/json").content("{"))
            .andExpect(status().isBadRequest()).andExpect(jsonPath("$.errorCode").value("ValidationException"));
    }
    @Test void keepsLabOneEndpoint() throws Exception {
        mvc.perform(get("/hello?name=Petya")).andExpect(status().isOk()).andExpect(content().string("Hello, Petya!"));
    }
}
