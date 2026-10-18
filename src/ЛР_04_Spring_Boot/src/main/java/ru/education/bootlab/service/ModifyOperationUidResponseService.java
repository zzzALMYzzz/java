package ru.education.bootlab.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.core.annotation.Order;
import ru.education.bootlab.model.Response;
@Service @Order(10) @Slf4j
public class ModifyOperationUidResponseService implements ModifyResponseService {
 public Response modify(Response response) { response.setOperationUid(java.util.UUID.randomUUID().toString()); log.info("ModifyOperationUidResponseService: {}",response); return response; }
}
