import tester.*;

class CompileTimeErrors{
    
    // calculate the area of a right triangle
    double rightTriangleArea(double base, double height){
        return (base * height) * 0.5;
    }
    
    // square a number
    int squareNumber(int myNumber){
        return myNumber * myNumber;
    }
  
    double answer1 = this.rightTriangleArea(3, 5); // expected 7.5
    int answer2 = this.squareNumber(5); // expected 25 
}
