package ru.education.bootlab;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.education.bootlab.dao.UserRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
@SpringBootTest @AutoConfigureMockMvc
class SecurityIntegrationTest {
 @Autowired MockMvc mvc; @Autowired UserRepository users; @Autowired PasswordEncoder encoder;
 @Test void protectsPages() throws Exception {mvc.perform(get("/list")).andExpect(status().is3xxRedirection()).andExpect(redirectedUrlPattern("**/login"));mvc.perform(get("/api/students")).andExpect(status().isUnauthorized());}
 @Test void registrationLoginAndLogout() throws Exception {
  String email="security-test@example.invalid",password="TestPass123!";
  mvc.perform(post("/register/save").with(csrf()).param("firstName","Артем").param("lastName","Петров").param("email",email).param("password",password)).andExpect(redirectedUrl("/register?success"));
  var user=users.findByEmail(email).orElseThrow(); assertNotEquals(password,user.getPassword());assertTrue(encoder.matches(password,user.getPassword()));assertEquals("ROLE_USER",user.getRoles().iterator().next().getName());
  mvc.perform(post("/login").with(csrf()).param("username",email).param("password",password)).andExpect(authenticated()).andExpect(redirectedUrl("/list"));
  mvc.perform(get("/api/students").with(httpBasic(email,password))).andExpect(status().isOk());
  mvc.perform(post("/register/save").with(csrf()).param("firstName","Артем").param("lastName","Петров").param("email",email.toUpperCase()).param("password",password)).andExpect(status().isOk()).andExpect(model().hasErrors());
  mvc.perform(post("/logout").with(csrf()).with(user(email))).andExpect(unauthenticated()).andExpect(redirectedUrl("/login?logout"));
 }
 @Test void refusesWrongPassword() throws Exception {mvc.perform(post("/login").with(csrf()).param("username","missing@example.invalid").param("password","incorrect")).andExpect(unauthenticated()).andExpect(redirectedUrl("/login?error"));}
 @Test void requiresCsrf() throws Exception {mvc.perform(post("/register/save")).andExpect(status().isForbidden());mvc.perform(post("/saveStudent").with(user("test"))).andExpect(status().isForbidden());}
 @Test void invalidRegistration() throws Exception {mvc.perform(post("/register/save").with(csrf()).param("firstName","").param("email","bad").param("password","x")).andExpect(status().isOk()).andExpect(model().attributeHasFieldErrors("user","firstName","lastName","email","password"));}
 @Test void publicPagesRender() throws Exception {for(String path:new String[]{"/","/register","/login"})mvc.perform(get(path)).andExpect(status().isOk());}
 @Test void actuatorRequiresAuthentication() throws Exception {mvc.perform(get("/actuator/health")).andExpect(status().isOk());mvc.perform(get("/actuator/beans")).andExpect(status().is3xxRedirection());}
}
