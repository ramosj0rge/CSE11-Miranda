public class AveragePositives {
    public static void main(String[] args){
        double total = 0;
        int count = 0;
        for(int i = 0; i < args.length; i++){
            if(Double.parseDouble(args[i]) > 0){
                count += 1;
                total += Double.parseDouble(args[i]);
            }
        }
        if(count == 0){
            count++;
        }
        double average = total / count;
        System.out.println(average);
    }
}

