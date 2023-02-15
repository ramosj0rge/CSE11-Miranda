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
/* 
 * Tester Library v.3.0
-----------------------------------
Tests defined in the class: Open1C:
---------------------------
Open1C:
---------------
new Open1C:1(
 this.testC = new statementC:2(
  this.openEnded = 5)
 this.testC1 = 20
 this.testC2 = 6)
---------------
No test methods found.
 */