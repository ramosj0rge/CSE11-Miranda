import java.nio.file.*;
import java.io.IOException;
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
        /*
         * If 2 argments are given
         */
        else{
            ContainsQuery query = new ContainsQuery(args[1]);
            for(int i = 0; i < contents.length; i++){
                if(query.matches(contents[i])){
                    System.out.println(contents[i]);
                }
            }
        }
        
    }
}

class ContainsQuery{
    String query;

    ContainsQuery(String query){
        this.query = query;
    }

    boolean matches(String s){
        return s.contains(query);
    }
}


