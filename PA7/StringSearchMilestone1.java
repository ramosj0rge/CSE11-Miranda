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
        if(args.length == 1){
            String[] contents = FileHelper.getLines(args[0]);
            for( int i = 0 ; i < contents.length; i++){
                System.out.println(contents[i]);
            }
            
        }
    }
}
