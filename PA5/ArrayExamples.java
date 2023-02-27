import tester.*;

class Pair{
    int a;
    int b;

    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}


public class ArrayExamples {
    String joinWith(String[] arr, String separator){
        if(arr.length == 0){
            return "";
        }
        else{
            String result = "";
            for(int i = 0; i < arr.length; i++){
                if(i == arr.length - 1){
                    result += arr[i];
                    break;
                }
                result += arr[i] + separator;
            }
            return result;
        }
        
    }
    // If all elements in arr are true, return true. Otherwise false.
    boolean allTrue(boolean[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == false){
                return false;
            }
        }
        return true;
    }

    boolean allWithinRange(double[] arr, double low, double high){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < low || arr[i] >= high){
                return false;
            }
        }
        return true;
    }

    Pair maxmin(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return new Pair(min, max);
    }

    String earliest(String[] arr){
        String lowest = arr[0]; // j c a 
        for(int i = 0; i < arr.length; i++){
            if(arr[i].compareTo(lowest) < 0){
                lowest = arr[i];
            }
        }
        return lowest;
    }

    int lookup(String[] keys, int[] values, String key){
        for(int i = 0; i < keys.length; i++){
            if(keys[i].equals(key)){
                return values[i];
            }
        }
        return -1;
    }

    void testArrayExamples(Tester t){
        String[] arr = {"b", "a"};
        t.checkExpect(joinWith(arr, ";"), "b;a");
        t.checkExpect(joinWith(arr, "-"), "b-a");
        t.checkExpect(joinWith(arr, "o"), "boa");

        boolean[] bool1 = {true, false};
        boolean[] bool2 = {true, true};
        boolean[] bool3 = {};
        t.checkExpect(allTrue(bool1),false);
        t.checkExpect(allTrue(bool2), true);
        t.checkExpect(allTrue(bool3), true);


        double[] arr1 = {2,4,10,9};
        t.checkExpect(allWithinRange(arr1, 2, 10), false);
        t.checkExpect(allWithinRange(arr1, 1,200), true);
        t.checkExpect(allWithinRange(arr1, 4.0,5.0), false);

        int[] temp1 = {1 ,3 ,7};
        int[] temp2 = {10 ,6 ,7};
        int[] temp3 = {50 ,3 ,100};
        t.checkExpect(maxmin(temp1), new Pair(1,7));
        t.checkExpect(maxmin(temp2), new Pair(6,10));
        t.checkExpect(maxmin(temp3), new Pair(3,100));

        String[] str1 = { "a" , "c", "b"};
        String[] str2 = { "abc" , "cll", "bps"};
        String[] str3 = { "48i4j" , "oifj", ";dfg"};

        t.checkExpect(earliest(str1),"a");
        t.checkExpect(earliest(str2), "abc");
        t.checkExpect(earliest(str3), "48i4j");

        String[] keys = {"orange", "apple", "pop", "pineapple", "hello", "find", "play"};

        int[] val = {1,5,3,8,4,6,7};
        t.checkExpect(lookup(keys, val, "orange"), 1);
        t.checkExpect(lookup(keys, val, "pineapple"), 8);
        t.checkExpect(lookup(keys, val, "play"), 7);
    
    }
}