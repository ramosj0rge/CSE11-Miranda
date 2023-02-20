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
        double temp = n/d;
        return temp;
    }
}