class statementOne{
    String test1;

    statementOne(String test1){
        this.test1 = test1;
    }

    int lengthOf(){
        return test1.length();
    }
        
} 

class statementTwo{
    String test1;

    statementTwo(String test1){
        this.test1 = test1;
    }

    String addOn(){
        return test1 + "456";
    }        
}

class Open1A{

    statementOne test11 = new statementOne("Jorge");
    int test12 = test11.lengthOf();

    statementTwo test21 = new statementTwo("123");
    String test22 = test21.addOn();
}