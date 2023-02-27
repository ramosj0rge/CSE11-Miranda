import tester.*;

public class PairSelect {
    int[] getAs(Pair[] arr){
        int[] temp= new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i].a;
        }
        return temp;
    }

    void testPairSelect(Tester t){
        int[] expect = {2, 4, 6, 1};
        int[] expect1 = {3, 5, 3, 9};
        int[] expect2 = {0, 0, 0, 0};
        int[] expect3 = {-1, 100, 8, 6};
        Pair[] arr1 = {new Pair(2,6), new Pair(4, 5), new Pair(6, 9), new Pair(1, 3)};
        Pair[] arr2 = {new Pair(3,1), new Pair(5, 7), new Pair(3, 9), new Pair(9, 0)};
        Pair[] arr3 = {new Pair(0,1), new Pair(0, 7), new Pair(0, 9), new Pair(0, 0)};
        Pair[] arr4 = {new Pair(-1,1), new Pair(100, 7), new Pair(8, 34), new Pair(6, 66)};
        t.checkExpect(getAs(arr1), expect);
        t.checkExpect(getAs(arr2), expect1);
        t.checkExpect(getAs(arr3), expect2);
        t.checkExpect(getAs(arr4), expect3);
    }
}

class Pair{
    int a;
    int b;

    Pair(int a, int b){
        this.a = a;
        this.b =b;
    }


}
