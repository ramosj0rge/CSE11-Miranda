public class Stats {
    public static void main(String[] args){
        if(args[0].equals("--product")){
            double product = 1;
            for(int i = 1; i < args.length; i++){
                product *= Double.parseDouble(args[i]);
            }
            System.out.println(product);
        }
        else if(args[0].equals("--total")){
            double total = 0;
            for(int i = 1; i < args.length; i++){
                total += Double.parseDouble(args[i]);
            }
            System.out.println(total);
        }
        else if(args[0].equals("--mean")){
            double sum = 0;
            for(int i = 1; i < args.length; i++){
                sum += Double.parseDouble(args[i]);
            }
            double meanValue = sum / (args.length - 1);
            System.out.println(meanValue);
        }
        else if(args[0].equals("--max")){
            double max = Double.parseDouble(args[1]);
            for(int i = 1; i < args.length; i++){
                if(Double.parseDouble(args[i]) > max){
                    max = Double.parseDouble(args[i]);
                }
            }
            System.out.println(max);   
        }

        else if(args[0].equals("--min")){
            double min = Double.parseDouble(args[1]);
            for(int i = 1; i < args.length; i++){
                if(Double.parseDouble(args[i]) < min){
                    min = Double.parseDouble(args[i]);
                }
            }
            System.out.println(min);
        }
       else{
            System.out.println("Bad option " + args[0]);
        }
    }
    
}
