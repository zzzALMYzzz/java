package ru.education.bootlab;
import org.junit.jupiter.api.Test;
import ru.education.bootlab.service.AnnualBonusServiceImpl;
import ru.education.bootlab.model.Positions;
import static org.junit.jupiter.api.Assertions.*;
class AnnualBonusServiceTest {
 final AnnualBonusServiceImpl service=new AnnualBonusServiceImpl();
 @Test void commonYear() {assertEquals(80300,service.calculate(Positions.DEV,10000,1,100,2023),.001);}
 @Test void leapYear() {assertEquals(80520,service.calculate(Positions.DEV,10000,1,100,2024),.001);}
 @Test void centuryRules() {assertEquals(80520,service.calculate(Positions.DEV,10000,1,100,2000),.001);assertEquals(80300,service.calculate(Positions.DEV,10000,1,100,2100),.001);}
 @Test void managerQuarter() {assertEquals(26288.88888888889,service.calculateQuarterly(Positions.TL,10000,1,90,2024,1),.001);}
 @Test void quarterLengths() {assertEquals(26000,service.calculateQuarterly(Positions.TL,10000,1,91,2024,1),.001);assertEquals(26000,service.calculateQuarterly(Positions.TL,10000,1,92,2023,3),.001);}
 @Test void rejectsNonManager() {assertThrows(IllegalArgumentException.class,()->service.calculateQuarterly(Positions.DEV,1,1,1,2024,1));}
 @Test void validatesNumbers() {for(double s:new double[]{0,-1,Double.NaN,Double.POSITIVE_INFINITY}) assertThrows(IllegalArgumentException.class,()->service.calculate(Positions.HR,s,1,1,2024));}
 @Test void validatesDays() {for(int d:new int[]{0,-1,367}) assertThrows(IllegalArgumentException.class,()->service.calculate(Positions.HR,1,1,d,2024));}
 @Test void validatesQuarter() {assertThrows(IllegalArgumentException.class,()->service.calculateQuarterly(Positions.PO,1,1,1,2024,5));}
 @Test void zeroBonus() {assertEquals(0,service.calculate(Positions.CTO,10000,0,200,2024));}
}
