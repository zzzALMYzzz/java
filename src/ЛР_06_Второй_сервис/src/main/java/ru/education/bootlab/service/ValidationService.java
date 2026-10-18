package ru.education.bootlab.service;

import org.springframework.validation.BindingResult;

public interface ValidationService {
    void isValid(BindingResult result);
}
