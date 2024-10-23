import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab01Test {
   @org.junit.jupiter.api.Test
    void SumOfSquares(){
       assertEquals(8, Lab01.SumOfSquares(2,2));
       assertEquals(5, Lab01.SumOfSquares(1,2));
   }

    @Test
    void celsiusToFahrenheit() {
       assertEquals(32,Lab01.CelsiusToFahrenheit(0));
    }

    @Test
    void billTotal() {
       assertEquals(19.215,Lab01.billTotal(15),0.01);
       assertEquals(64.05,Lab01.billTotal(50),0.01);
    }

    @Test
    void pointDistance() {
       assertEquals(5,Lab01.pointDistance(3,0,0,4));
       assertEquals(13,Lab01.pointDistance(12,0,0,5));
    }

    @Test
    void crazyMath() {
       assertEquals(0,Lab01.crazyMath(-0.0),0.01);
       assertEquals(6.778,Lab01.crazyMath(3),0.01);
       assertEquals(2.472,Lab01.crazyMath(10),0.01);
    }
}