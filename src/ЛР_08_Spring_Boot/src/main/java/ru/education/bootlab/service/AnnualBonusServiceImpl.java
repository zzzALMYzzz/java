package ru.education.bootlab.service;
import java.time.*;
import org.springframework.stereotype.Service;
import ru.education.bootlab.model.Positions;
@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {
 public double calculate(Positions p,double salary,double bonus,int days) {
  return calculate(p,salary,bonus,days,Year.now().getValue());
 }
 public double calculate(Positions p,double salary,double bonus,int days,int year) {
  int length=Year.of(year).length();validate(p,salary,bonus,days,length);
  return finite(salary*bonus*length*p.getPositionCoefficient()/days);
 }
 public double calculateQuarterly(Positions p,double salary,double bonus,int days,int year,int quarter) {
  if(quarter<1||quarter>4) throw new IllegalArgumentException("quarter: требуется 1–4");
  LocalDate start=LocalDate.of(year,(quarter-1)*3+1,1);
  int length=(int)java.time.temporal.ChronoUnit.DAYS.between(start,start.plusMonths(3));
  validate(p,salary,bonus,days,length);
  if(!p.isManager())throw new IllegalArgumentException("position: квартальная премия только для управленцев");
  return finite(salary*bonus*length*p.getPositionCoefficient()/days);
 }
 private void validate(Positions p,double salary,double bonus,int days,int max) {
  if(p==null)throw new IllegalArgumentException("position: обязательное поле");
  if(!Double.isFinite(salary)||salary<=0)throw new IllegalArgumentException("salary: требуется положительное конечное число");
  if(!Double.isFinite(bonus)||bonus<0)throw new IllegalArgumentException("bonus: требуется неотрицательное конечное число");
  if(days<1||days>max)throw new IllegalArgumentException("workDays: вне расчетного периода");
 }
 private double finite(double result) {
  if(!Double.isFinite(result))throw new IllegalArgumentException("bonus: переполнение результата");
  return result;
 }
}
