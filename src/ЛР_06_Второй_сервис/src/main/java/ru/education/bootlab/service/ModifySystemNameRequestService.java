package ru.education.bootlab.service;
import ru.education.bootlab.model.Request;
import org.springframework.stereotype.Service;
import org.springframework.core.annotation.Order;
import lombok.extern.slf4j.Slf4j;
@Service @Order(10) @Slf4j
public class ModifySystemNameRequestService implements ModifyRequestService {
 public void modify(Request request) { request.setSystemName(ru.education.bootlab.model.Systems.ERP); log.info("ModifySystemNameRequestService: {}",request); }
}
