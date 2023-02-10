class statementC{
    int openEnded;

    statementC(int openEnded){
        this.openEnded = openEnded;
    }

    int square(int number1){
        return this.openEnded * number1;
    }

    int addition(int number1){
        return this.openEnded + number1;
    }


}

class Open1C{
    statementC testC = new statementC(5);
    int testC1 = testC.square(4);
    int testC2 = testC.addition(1);
}