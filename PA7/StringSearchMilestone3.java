import java.nio.file.*;
import java.io.IOException;

interface Query{
    public boolean matches(String s);
}

class FileHelper {
    static String[] getLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path)).toArray(String[]::new);
        }
        catch(IOException e) {
            System.err.println("Error reading file " + path + ": " + e);
            return new String[]{"Error reading file " + path + ": " + e};
        }
    }
}
class StringSearch{
    static Query readQuery(String q){
        

    }
    public static void main(String[] args) throws IOException{
        
        String[] contents = FileHelper.getLines(args[0]);  // Array of lines in file

        /*
         * If only one argument if given
         */
        if(args.length == 1){
            // For loop through every index of contents (Lines in file)
            for(int i = 0 ; i < contents.length; i++){
                // Prints Lines one by one
                System.out.println(contents[i]);
            }
        }
        else{
            String[] check = args[1].split("=");
            //e.g. {"contains", "'This'"}
            String querycommand = check[1].substring(1, check[1].length()-1);
            //e.g. This
            ContainsQuery query = new ContainsQuery(querycommand);
            for(int i = 0; i < contents.length; i++){
                if(query.matches(contents[i])){
                    System.out.print(contents[i]);
                }
            } 
        }
    }
}

class ContainsQuery implements Query{
    String query;

    ContainsQuery(String query){
        this.query = query;
    }

    public boolean matches(String s){
        return s.contains(query);
    }
}

class NotInQuery
