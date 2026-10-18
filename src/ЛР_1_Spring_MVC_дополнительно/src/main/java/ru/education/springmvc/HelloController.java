package ru.education.springmvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    @GetMapping(value = "/hello",
        produces = "text/plain;charset=UTF-8")
    public String hello(
        @RequestParam(name = "name", defaultValue = "World")
        String name) {
        return "Hello, " + name + "!";
    }
}
