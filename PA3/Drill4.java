import java.lang.Math;

class Drill4{

    String phaseOfWater(int number){
        if(number >= 100){
            return "vapor";
        }
        else if(number > 0){
            return "liquid";
        }
        else{
            return "solid";
        }
    }

    int maxDifference(int a, int b, int c){
        int dif1 = Math.abs(a - b);
        int dif2 = Math.abs(a-c);
        int dif3 = Math.abs(b-c);

        return Math.max(dif1, Math.max(dif2, dif3));
    }

   double ringArea(double inner, double outer){
        return Math.PI * Math.pow(outer, 2) -  Math.PI * Math.pow(inner, 2);
   }

   String drillTest41 = phaseOfWater(2); //Expected liquid
   String drillTest42 = phaseOfWater(-1); //Expected Solid
   String drillTest48 = phaseOfWater(101); //Expected Vapor
   String drillTest49 = phaseOfWater(1/2); //Interesting Test 1/2 = 0.5 but since it is int 1/2 = 1; so expected liquid

   int drillTest43 = maxDifference(3, 2, 0); //Expected 3
   int drillTest44 = maxDifference(-10, 50, 1); //Expected 60

   double drillTest45 = ringArea(2, 3);
   double drillTest46 = ringArea(-2, 0);
   double drillTest47 = ringArea(-3, 5);

}