package ru.education.bootlab.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.education.bootlab.exception.ValidationFailedException;
import java.util.stream.Collectors;

@lombok.extern.slf4j.Slf4j
@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult result) {
        if (result.hasErrors()) {
            String errors = result.getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .sorted().collect(Collectors.joining("; "));
            log.error("Validation errors: {}",errors);
            throw new ValidationFailedException("Ошибка валидации: " + errors);
        }
    }
}
