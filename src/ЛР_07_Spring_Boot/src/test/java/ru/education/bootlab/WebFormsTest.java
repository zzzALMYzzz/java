package ru.education.bootlab;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest @AutoConfigureMockMvc
class WebFormsTest {
 @Autowired MockMvc mvc;
 @Test void pagesRender() throws Exception {for(String p:new String[]{"/","/list","/addStudentForm","/groups","/addGroupForm"})mvc.perform(get(p)).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith("text/html"));}
 @Test void validStudentForm() throws Exception {mvc.perform(post("/saveStudent").param("name","Артем").param("surname","Петров").param("faculty","РТФ").param("age","20")).andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/list"));}
 @Test void invalidStudentForm() throws Exception {mvc.perform(post("/saveStudent").param("name","").param("age","abc")).andExpect(status().isOk()).andExpect(model().attributeHasFieldErrors("student","name","age"));}
 @Test void validGroupForm() throws Exception {mvc.perform(post("/saveGroup").param("name","номер группы").param("faculty","РТФ").param("course","2")).andExpect(redirectedUrl("/groups"));}
 @Test void invalidGroupForm() throws Exception {mvc.perform(post("/saveGroup").param("name"," ").param("course","0")).andExpect(status().isOk()).andExpect(model().attributeHasFieldErrors("studyGroup","name","course"));}
 @Test void missingStudentForm() throws Exception {mvc.perform(get("/showUpdateForm").param("studentId","999999")).andExpect(status().isNotFound());}
 @Test void actuatorEndpoints() throws Exception {for(String path:new String[]{"health","info","metrics","mappings","beans"})mvc.perform(get("/actuator/"+path)).andExpect(status().isOk());}
}
