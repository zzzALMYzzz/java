package ru.education.bootlab.service;
import ru.education.bootlab.model.Request;
import org.springframework.stereotype.Service;
import org.springframework.core.annotation.Order;
import lombok.extern.slf4j.Slf4j;
@Service @Order(20) @Slf4j
public class ModifySourceRequestService implements ModifyRequestService {
 public void modify(Request request) { request.setSource("Service 1"); log.info("ModifySourceRequestService: {}",request); }
}
