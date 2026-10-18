package ru.education.bootlab.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.education.bootlab.model.*;
import ru.education.bootlab.exception.ValidationFailedException;
@Service @RequiredArgsConstructor @Slf4j
public class BonusEnrichmentService {
 private final AnnualBonusService calculator;
 public void enrich(Request request,Response response) {
  boolean present=request.getPosition()!=null||request.getSalary()!=null||request.getBonus()!=null||request.getWorkDays()!=null||request.getQuarter()!=null||request.getCalculationYear()!=null;
  if(!present)return;
  try {
   if(request.getPosition()==null||request.getSalary()==null||request.getBonus()==null||request.getWorkDays()==null)
    throw new IllegalArgumentException("position, salary, bonus, workDays: передайте все поля расчета");
   int year=request.getCalculationYear()==null?java.time.Year.now().getValue():request.getCalculationYear();
   if(year<1900||year>9999)throw new IllegalArgumentException("calculationYear: требуется 1900–9999");
   response.setAnnualBonus(calculator.calculate(request.getPosition(),request.getSalary(),request.getBonus(),request.getWorkDays(),year));
   if(request.getQuarter()!=null)response.setQuarterlyBonus(calculator.calculateQuarterly(request.getPosition(),request.getSalary(),request.getBonus(),request.getWorkDays(),year,request.getQuarter()));
   log.info("Bonus calculated: {}",response);
  } catch(IllegalArgumentException e) {log.error("Bonus validation: {}",e.getMessage());throw new ValidationFailedException(e.getMessage());}
 }
}
