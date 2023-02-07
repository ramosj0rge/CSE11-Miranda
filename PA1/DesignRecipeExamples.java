import tester.*;

class DesignRecipeExamples {

    //Calculates the perimeter of a rectangle
    int perimeter(int width, int height){
        return 2 * (width + height);
    }

    //Tests for perimeter Method
    int perimeterTest1 = this.perimeter(5, 10); //expected 30
    int perimeterTest2 = this.perimeter(2, 5); //expected 14

    //Finds the area of a region between two rectangles (one inside of another)
    int borderArea(int bigWidth, int bigHeight, int smallWidth, int smallHeight){
        return (bigWidth * bigHeight) - (smallWidth * smallHeight);
    }

    //Tests for borderArea Method
    int borderTest1 = this.borderArea(6,6, 2,4); //expected 28
    int borderTest2 = this.borderArea(10,10, 6,5); //expected 70

    //Converts celsius to Kelvin (Converter Method)
    int celsiusToK(int celsius){

        /*Takes int celsius and adds 273 for an estimate Kelvin value
        Conversion taken from google*/
        return celsius + 273;
    }

    //Tests for celsiusToK Method
    int celsiusTest1 = this.celsiusToK(5); //expected 278
    int celsiusTest2 = this.celsiusToK(32); //expected 305
    

    //Converts money into total of pennies (Combiner Method)
    int pennyConverter(int dollars, int cents){

        //Multiples each dollar by 100 and adds the cents
        return dollars * 100 + cents; 
    }
    
    //Tests for pennyConverter Method
    int pennyTest1 = this.pennyConverter(20, 54); //expected 2054
    int pennyTest2 = this.pennyConverter(0, 6); //expected 6

    //Assuming the output is incorrect because the dollar parameter value is too big
    int pennyTest3 = this.pennyConverter(100000000, 1); //expected 100000000001
    
}
