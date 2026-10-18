package ru.education.bootlab.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.core.annotation.Order;
import ru.education.bootlab.model.Response;
@Service @Order(20) @Slf4j
public class ModifySystemTimeResponseService implements ModifyResponseService {
 public Response modify(Response response) {
  response.setSystemTime(ru.education.bootlab.util.DateTimeUtil.getCustomFormat().format(new java.util.Date()));
  log.info("ModifySystemTimeResponseService: {}",response); return response; }
}
