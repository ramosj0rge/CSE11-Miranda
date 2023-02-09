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

}