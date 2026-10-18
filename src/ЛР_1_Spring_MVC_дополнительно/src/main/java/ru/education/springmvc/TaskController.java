package ru.education.springmvc;
import java.time.OffsetDateTime;
import java.util.Locale;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
@RestController
public class TaskController {
    @GetMapping(value = "/about",
        produces = "text/plain;charset=UTF-8")
    public String about() {
        return "ФИО студента, группа номер группы";
    }
    @GetMapping(value = "/time",
        produces = "text/plain;charset=UTF-8")
    public String time() {
        return OffsetDateTime.now().toString();
    }
    @GetMapping(value = "/square", produces = "text/plain;charset=UTF-8")
    public String square(@RequestParam(name = "value") int value) {
        return Long.toString((long) value * value);
    }

    @GetMapping(value = "/length", produces = "text/plain;charset=UTF-8")
    public String length(@RequestParam(name = "text") String text) {
        return Integer.toString(text.length());
    }

    @GetMapping(value = "/uppercase", produces = "text/plain;charset=UTF-8")
    public String uppercase(@RequestParam(name = "text") String text) {
        return text.toUpperCase(Locale.ROOT);
    }

    @GetMapping(value = "/repeat", produces = "text/plain;charset=UTF-8")
    public String repeat(
        @RequestParam(name = "text") String text,
        @RequestParam(name = "count") int count) {
        if (count < 0 || (long) text.length() * count > 100_000) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Invalid repeat size");
        }
        return text.repeat(count);
    }
}
