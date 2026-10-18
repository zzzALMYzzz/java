package ru.education.bootlab.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.education.bootlab.exception.UnsupportedCodeException;
import ru.education.bootlab.model.*;
import java.util.*;
@Service @RequiredArgsConstructor @Slf4j
public class FeedbackService {
 private final List<ModifyResponseService> modifiers;
 public Response process(Request request) {
  if ("123".equals(request.getUid())) { log.error("Unsupported uid: {}",request.getUid()); throw new UnsupportedCodeException(); }
  Response response=response(request,"success","","");
  for (ModifyResponseService modifier: modifiers) response=modifier.modify(response);
  return response;
 }
 public Response response(Request request,String code,String errorCode,String message) {
  ErrorCodes error=switch(errorCode) {
   case "ValidationException" -> ErrorCodes.VALIDATION_EXCEPTION;
   case "UnsupportedCodeException" -> ErrorCodes.UNSUPPORTED_EXCEPTION;
   case "UnknownException" -> ErrorCodes.UNKNOWN_EXCEPTION;
   case "UpstreamException" -> ErrorCodes.UPSTREAM_EXCEPTION;
   default -> ErrorCodes.EMPTY;
  };
  ErrorMessages description=switch(error) {
   case VALIDATION_EXCEPTION -> ErrorMessages.VALIDATION;
   case UNSUPPORTED_EXCEPTION -> ErrorMessages.UNSUPPORTED;
   case UNKNOWN_EXCEPTION -> ErrorMessages.UNKNOWN;
   case UPSTREAM_EXCEPTION -> ErrorMessages.UPSTREAM;
   default -> ErrorMessages.EMPTY;
  };
  Response response=Response.builder().uid(request==null?"":Objects.toString(request.getUid(),""))
   .operationUid(request==null?"":Objects.toString(request.getOperationUid(),""))
   .systemTime(ru.education.bootlab.util.DateTimeUtil.getCustomFormat().format(new Date()))
   .code("success".equals(code)?Codes.SUCCESS:Codes.FAILED).errorCode(error).errorMessage(description).details(message).build();
  log.info("Response created: {}",response); return response;
 }
}
