package ru.education.bootlab.service;
import java.time.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;
import lombok.extern.slf4j.Slf4j;
import ru.education.bootlab.model.*;
import ru.education.bootlab.exception.UpstreamException;
@Service @Slf4j
public class ForwardingService {
 private final RestTemplate client;
 private final List<ModifyRequestService> modifiers;
 private final boolean enabled;
 private final String url;
 public ForwardingService(RestTemplateBuilder builder,List<ModifyRequestService> modifiers,
   @Value("${forwarding.enabled:true}") boolean enabled,
   @Value("${forwarding.url:http://localhost:8084/feedback}") String url) {
  client=builder.setConnectTimeout(Duration.ofSeconds(2)).setReadTimeout(Duration.ofSeconds(5)).build();
  this.modifiers=modifiers;this.enabled=enabled;this.url=url;
 }
 public void forward(Request request,Instant receivedAt) {
  if (!enabled) return;
  modifiers.forEach(m->m.modify(request));
  HttpHeaders headers=new HttpHeaders();headers.setContentType(MediaType.APPLICATION_JSON);
  headers.set("X-Request-Received-At",receivedAt.toString());
  try {
   ResponseEntity<Response> result=client.postForEntity(url,new HttpEntity<>(request,headers),Response.class);
   if (result.getBody()==null || result.getBody().getCode()!=Codes.SUCCESS)
    throw new UpstreamException(new IllegalStateException("Invalid upstream response"));
   log.info("Service 2 response: {}",result.getBody());
  } catch(RestClientException e) { log.error("Service 2 request failed",e);throw new UpstreamException(e); }
 }
}
