package ru.education.bootlab;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest @AutoConfigureMockMvc
class CrudIntegrationTest {
 @Autowired MockMvc mvc; @Autowired ObjectMapper mapper;
 @Test void studentsLifecycle() throws Exception {lifecycle("students","{\"name\":\"Артем\",\"surname\":\"Петров\",\"faculty\":\"РТФ\",\"age\":20}");}
 @Test void disciplinesLifecycle() throws Exception {lifecycle("disciplines","{\"name\":\"Java\",\"hours\":72}");}
 void lifecycle(String path,String json) throws Exception {
  String base="/api/"+path;
  String body=mvc.perform(post(base).contentType("application/json").content(json)).andExpect(status().isCreated()).andExpect(jsonPath("$.success").value(true)).andReturn().getResponse().getContentAsString();
  long id=mapper.readTree(body).path("data").path("id").asLong();
  mvc.perform(get(base+"/"+id)).andExpect(status().isOk()).andExpect(jsonPath("$.data.id").value(id));
  mvc.perform(put(base+"/"+id).contentType("application/json").content(json)).andExpect(status().isOk());
  mvc.perform(get(base)).andExpect(status().isOk()).andExpect(jsonPath("$.data").isArray());
  mvc.perform(delete(base+"/"+id)).andExpect(status().isOk()).andExpect(jsonPath("$.success").value(true));
  mvc.perform(get(base+"/"+id)).andExpect(status().isNotFound()).andExpect(jsonPath("$.success").value(false));
  mvc.perform(put(base+"/"+id).contentType("application/json").content(json)).andExpect(status().isNotFound());
  mvc.perform(delete(base+"/"+id)).andExpect(status().isNotFound());
 }
 @Test void invalidStudent() throws Exception {mvc.perform(post("/api/students").contentType("application/json").content("{}")) .andExpect(status().isBadRequest()).andExpect(jsonPath("$.success").value(false));}
 @Test void invalidDiscipline() throws Exception {mvc.perform(post("/api/disciplines").contentType("application/json").content("{\"name\":\" \",\"hours\":0}")) .andExpect(status().isBadRequest());}
 @Test void invalidPath() throws Exception {mvc.perform(get("/api/students/abc")).andExpect(status().isBadRequest());}
}
