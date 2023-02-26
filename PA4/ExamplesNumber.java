import tester.*;

interface Number {
    int numerator();
    int denominator();
    Number add(Number other);
    Number multiply(Number other);
    String toString();
    double toDouble();
  }

class WholeNumber implements Number{
    int n;
    WholeNumber (int n){
        this.n = n;
    }

    public int numerator(){
        return n;
    }
    public int denominator(){
        return 1;
    }
    
    public Number add(Number other){
        return new Fraction(this.numerator()*other.denominator() + this.denominator()*other.numerator(), other.denominator()*this.denominator());
    }

    public Number multiply(Number other){
        return new Fraction(this.numerator()*other.numerator(), this.denominator()*other.denominator());
    }
    public String toString(){
        return String.valueOf(n);
    }
    public double toDouble(){
        double temp = n;
        return temp;

    }

}

class Fraction implements Number{
    int n;
    int d;
    Fraction (int n, int d){
        this.n = n;
        this.d = d;
    }

    public int numerator(){
        return n;
    }
    public int denominator(){
        return d;
    }
    
    public Number add(Number other){
        return new Fraction(this.numerator()*other.denominator() + this.denominator()*other.numerator(), other.denominator()*this.denominator());
    }

    public Number multiply(Number other){
        return new Fraction(this.numerator()*other.numerator(), this.denominator()*other.denominator());
    }
    public String toString(){
        return String.valueOf(n) + "/" + String.valueOf(d);
    }
    public double toDouble(){
        double a = this.n;
        double b = this.d;
        double temp = a / b;
        return temp;
    }
}

//Testing

class ExamplesNumber{
    WholeNumber num1 = new WholeNumber(8);
    WholeNumber num2 = new WholeNumber(6);
    int test1 = num1.numerator();
    int test2 = num1.denominator();
    int test19 = num2.numerator();
    int test20 = num2.denominator();
    Number test3 = num1.add(num2);
    Number test4 = num1.multiply(num2);
    String test5 = num1.toString();
    String test6 = num2.toString();
    double test7 = num1.toDouble();
    double test8 = num2.toDouble();

    Fraction num3 = new Fraction(2, 3);
    Fraction num4 = new Fraction(3, 4);
    int test9 = num3.numerator();
    int test10 = num3.denominator();
    int test11 = num4.numerator();
    int test12 = num4.denominator();
    Number test13 = num3.add(num4);
    Number test14 = num3.multiply(num4);
    String test15 = num3.toString();
    String test16 = num4.toString();
    double test17 = num3.toDouble();
    double test18 = num4.toDouble();

    //Exploration
    double ex1 = 0.1 + 0.2 + 0.3;
    double ex2 = 0.1 + (0.2 + 0.3);

    Fraction ex3 = new Fraction(1, 10);
    Fraction ex4 = new Fraction(2, 10);
    Fraction ex5 = new Fraction(3, 10);

    Number test21 = ex3.add(ex4);
    Number test22 = ex5.add(test21);
    String test23 = test22.toString();

    Number test24 = ex5.add(ex4);
    Number test25 = ex3.add(test24);
    String test26 = test25.toString();

    void testTweets(Tester t){
        t.checkExpect(this.test1, 8);
        t.checkExpect(this.test2, 1);
        t.checkExpect(this.test19, 6);
        t.checkExpect(this.test20, 1);
        t.checkExpect(this.test3, new Fraction(14,1));
        t.checkExpect(this.test4, new Fraction(48, 1));
        t.checkExpect(this.test5, "8");
        t.checkExpect(this.test6, "6");
        t.checkExpect(this.test7, 8.0);
        t.checkExpect(this.test8, 6.0);

        t.checkExpect(this.test9, 2);
        t.checkExpect(this.test10, 3);
        t.checkExpect(this.test11, 3);
        t.checkExpect(this.test12, 4);
        t.checkExpect(this.test13, new Fraction(17,12));
        t.checkExpect(this.test14, new Fraction(6, 12));
        t.checkExpect(this.test15, "2/3");
        t.checkExpect(this.test16, "3/4");
        double a = 2;
        double b = 3;
        double c = 4;
        t.checkExpect(this.test17, a/b);
        t.checkExpect(this.test18, b/c);
    }

}