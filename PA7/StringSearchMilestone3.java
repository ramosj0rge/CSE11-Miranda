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
        //e.g. "notlength=5" -> ["notlength", "5"]
        String[] command = q.split("=");
        if(q.startsWith("not")){
            if(command[1].equals("contains")){
                return new notQuery(new ContainsQuery(command[1].substring(1, command[1].length()-1)));
            }
            else if(command[1].equals("length")){
                return new notQuery(new lengthQuery(Integer.parseInt(command[1])));
            }
            else if(command[1].equals("greater")){
                return new notQuery(new greaterQuery(Integer.parseInt(command[1])));
            }
            else if(command[1].equals("less")){
                return new notQuery(new lessQuery(Integer.parseInt(command[1])));
            }
            else if(command[1].equals("starts")){
                return new notQuery(new startsQuery(command[1].substring(1, command[1].length()-1)));
            }
            else if(command[1].equals("ends")){
                return new notQuery(new endsQuery(command[1].substring(1, command[1].length()-1)));
            }
        }
        else if(command[1].equals("contains")){
            return new ContainsQuery(command[1].substring(1, command[1].length()-1));
        }
        else if(command[1].equals("length")){
            return new lengthQuery(Integer.parseInt(command[1]));
        }
        else if(command[1].equals("greater")){
            return new greaterQuery(Integer.parseInt(command[1]));
        }
        else if(command[1].equals("less")){
            return new lessQuery(Integer.parseInt(command[1]));
        }
        else if(command[1].equals("starts")){
            return new startsQuery(command[1].substring(1, command[1].length()-1));
        }
        else if(command[1].equals("ends")){
            return new endsQuery(command[1].substring(1, command[1].length()-1));
        }
        return null;
        
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
        //If there are two arguments, run the Query class
        else{
            System.out.println(readQuery(contents[1]));
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
        return Integer.parseInt(s) == length;
    }
}

class greaterQuery implements Query{
    int length;
    greaterQuery(int length){
        this.length = length;
    }
    public boolean matches(String s){
        return Integer.parseInt(s) > length;
    }
}

class lessQuery implements Query{
    int length;
    lessQuery(int length){
        this.length = length;
    }
    public boolean matches(String s){
        return Integer.parseInt(s) < length;
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
    Query query;
    
    notQuery(Query query){
        this.query = query;
    }
    public boolean matches(String s){
        if(!query.matches(s)){
            return true;
        }
        return false;
    }
}