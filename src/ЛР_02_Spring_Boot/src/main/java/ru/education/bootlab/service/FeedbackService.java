package ru.education.bootlab.service;

import org.springframework.stereotype.Service;
import ru.education.bootlab.exception.UnsupportedCodeException;
import ru.education.bootlab.model.Request;
import ru.education.bootlab.model.Response;
import java.time.Instant;
import java.util.Objects;

@Service
public class FeedbackService {
    public Response process(Request request) {
        if ("123".equals(request.getUid())) throw new UnsupportedCodeException();
        return response(request, "success", "", "");
    }

    public Response response(Request request, String code, String errorCode, String message) {
        return Response.builder()
            .uid(request == null ? "" : Objects.toString(request.getUid(), ""))
            .operationUid(request == null ? "" : Objects.toString(request.getOperationUid(), ""))
            .systemTime(Instant.now().toString())
            .code(code).errorCode(errorCode).errorMessage(message).build();
    }
}
