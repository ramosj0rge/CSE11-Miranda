/*class statementB{
    String testB1;
    int testB1;

    statementB(String testB1){
        this.testB1 = testB1;
    }

    statementB(int testB1){
        this.testB1 = testB1;
    }

    String numberSequence(){
        return testB1 + "456";
    }

    int adding(){
        return testB1 + 2;
    }
}

class Open1B{
    statementB test3 = new statementB("123");
    statementB test4 = new statementB(3);

    String test32 = test3.numberSequence();
    int test42 = test4.adding();
}

/* 
 * Open1B.java:3: error: variable testB1 is already defined in class statementB
    int testB1;
        ^
Open1B.java:10: error: incompatible types: int cannot be converted to String
        this.testB1 = testB1;
                      ^
Open1B.java:18: error: incompatible types: String cannot be converted to int
        return testB1 + 2;
                      ^
3 errors
 */