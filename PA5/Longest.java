public class Longest {
    public static void main(String[] args){
        if(args.length == 0){
            return;
        }
        
        int max = args[0].length();
        String longest = args[0];
        for(int i = 0; i < args.length; i++){
            if(args[i].length() > max){
                max = args[i].length();
                longest = args[i];
            }
        }
        System.out.println(longest);
    }
}
