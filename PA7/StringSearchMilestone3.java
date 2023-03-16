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
        if(q.startsWith("not"){
            
        }

    }
    public static void main(String[] args) throws IOException{
        String[] contents = FileHelper.getLines(args[0]);  // Array of lines in file
        //If only one arguments
        
        if(args.length == 1){
            // For loop through every index of contents (Lines in file)
            for(int i = 0 ; i < contents.length; i++){
                System.out.println(contents[i]); // Prints Lines one by one
            }
        }
        //If there are two arguments
        else{
            String[] check = args[1].split("="); //e.g. {"contains", "'This'"}
            String querycommand = check[1].substring(1, check[1].length()-1);  //e.g. This
            ContainsQuery query = new ContainsQuery(querycommand);
            for(int i = 0; i < contents.length; i++){
                if(query.matches(contents[i])){
                    System.out.println(contents[i]); //Prints line(s) containg the word
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

class lengthQuery implements Query{
    int length;
    lengthQuery(int length){
        this.length = length;
    }
    public boolean matches(String s){
        return s.length() == length;
    }
}

class greaterQuery implements Query{
    int length;
    greaterQuery(int length){
        this.length = length;
    }
    public boolean matches(String s){
        return s.length() > length;
    }
}

class lessQuery implements Query{
    int length;
    lessQuery(int length){
        this.length = length;
    }
    public boolean matches(String s){
        return s.length() < length;
    }
}

class startsQuery implements Query{
    String query;
    startsQuery(String query){
        this.query = query;
    }
    public boolean matches(String s){
        return s.startsWith(query);
    }
}

class endsQuery implements Query{
    String query;
    endsQuery(String query){
        this.query = query;
    }
    public boolean matches(String s){
        return s.endsWith((query));
    }
}

class notQuery implements Query{
    String query;
    notQuery(String query){
        this.query = query;
    }
    public boolean matches(String s){
        return !s.contains(query);
    }
}