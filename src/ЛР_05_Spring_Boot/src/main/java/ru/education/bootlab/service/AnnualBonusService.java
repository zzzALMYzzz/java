package ru.education.bootlab.service;
import ru.education.bootlab.model.Positions;
public interface AnnualBonusService {
 double calculate(Positions position,double salary,double bonus,int workDays);
 double calculate(Positions position,double salary,double bonus,int workDays,int year);
 double calculateQuarterly(Positions position,double salary,double bonus,int workDays,int year,int quarter);
}
