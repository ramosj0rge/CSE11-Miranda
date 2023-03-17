import java.nio.file.*;
import java.io.IOException;

interface Query{
    public boolean matches(String s);
}

interface Transform{
    public String transform(String s);

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
        String[] word = q.split("=");
        if(q.startsWith("not")){
            String[] command = q.substring(4, q.length()-1).split("=");
            if(command[0].equals("contains")){
                return new notQuery(new ContainsQuery(command[1].substring(1, command[1].length()-1)));
            }
            else if(command[0].equals("length")){
                return new notQuery(new lengthQuery(Integer.parseInt(command[1])));
            }
            else if(command[0].equals("greater")){
                return new notQuery(new greaterQuery(Integer.parseInt(command[1])));
            }
            else if(command[0].equals("less")){
                return new notQuery(new lessQuery(Integer.parseInt(command[1])));
            }
            else if(command[0].equals("starts")){
                return new notQuery(new startsQuery(command[1].substring(1, command[1].length()-1)));
            }
            else if(command[0].equals("ends")){
                return new notQuery(new endsQuery(command[1].substring(1, command[1].length()-1)));
            }
        }
        //e.g. "contains='This" -> command = ["contains", 'This']
        else if(word[0].equals("contains")){
            return new ContainsQuery(word[1].substring(1, word[1].length()-1));
        }
        //e.g. "length=7" -> command = ["length", "7"]
        else if(word[0].equals("length")){
            return new lengthQuery(Integer.parseInt(word[1]));
        }
        else if(word[0].equals("greater")){
            return new greaterQuery(Integer.parseInt(word[1]));
        }
        else if(word[0].equals("less")){
            return new lessQuery(Integer.parseInt(word[1]));
        }
        else if(word[0].equals("starts")){
            return new startsQuery(word[1].substring(1, word[1].length()-1));
        }
        else if(word[0].equals("ends")){
            return new endsQuery(word[1].substring(1, word[1].length()-1));
        }
        return null;
        
    }

    static Transform readTransform(String t){
        String[] transWord = t.split("=");// "last=10" -> ["last", "10"]

        //upper
        if(t.equals("upper")){
            return new upperTransform();
        }
        else if(t.equals("lower")){
            return new lowerTransform();
        }
        else if(transWord[0].equals("last")){
            return new lastTransform(Integer.parseInt(transWord[1]));
        }
        else if(transWord[0].equals("first")){
            return new firstTransform(Integer.parseInt(transWord[1]));
        }
        //e.g. "replace=i;I" -> ["replace", "'i':'I'"]
        else if(transWord[0].equals("replace")){
            String[] splitreplace = transWord[1].split(";"); //["'i'", "'I'"]
            String original = splitreplace[0].substring(1,splitreplace[0].length()-1);
            String replacement = splitreplace[1].substring(1,splitreplace[1].length()-1); 
            //["i", "I"]
            return new replaceTransform(original, replacement);
        }
        return null;

    }

    static boolean matchesAll(Query[] qs, String s){
        for(Query queries : qs){
            if(!queries.matches(s)){
                return false;
            }
        }
        return true;
    }

    static String applyAll(Transform[] ts, String s){
        for(Transform transforming : ts){
            s = transforming.transform(s);
        }
        return s;
    }

    public static void main(String[] args) throws IOException{
        String[] contents = FileHelper.getLines(args[0]);  // Array of lines in file
        //If only one arguments
        if(args.length == 0){
            System.out.println(contents);
        }
        else if(args.length == 1){
            // For loop through every index of contents (Lines in file)
            for(int i = 0 ; i < contents.length; i++){
                System.out.println(contents[i]); // Prints Lines one by one
            }
        }
        //If there are two arguments, run the Query class
        else{
            String[] querys = args[1].split("&");
            Query[] qs = new  Query[querys.length];
            for(int i = 0 ; i < querys.length; i ++){
                qs[i] = readQuery(querys[i]);
            }


            for(String line: contents){
                if(matchesAll(qs, line)){
                    String output = line;
                    
                    if(args.length == 3){
                        String[] transforms = args[2].split("&");
                        Transform[] tf = new  Transform[transforms.length];
                        for(int i = 0 ; i < transforms.length; i ++){
                            tf[i] = readTransform(transforms[i]);
                        }

                        output = applyAll(tf, output);
                    }

                    System.out.println(output);
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

class upperTransform implements Transform{
    public String transform(String s){
        return s.toUpperCase();
    }
}

class lowerTransform implements Transform{
    public String transform(String s){
        return s.toLowerCase();
    }
    
}

class firstTransform implements Transform{
    int first;

    firstTransform(int first){
        this.first = first;
    }
    
    public String transform(String s){
        if(s.length() < first){
            return s;
        }
        return s.substring(0, first);
    }
    
}

class lastTransform implements Transform{
    int last;
    
    lastTransform(int last){
        this.last = last;
    }

    public String transform(String s){
        if(s.length() < last){
            return s;
        }
        return s.substring(s.length() - last, s.length());
    }

}

class replaceTransform implements Transform{
    String org;
    String newone;

    replaceTransform(String org, String newone){
        this.org = org;
        this.newone = newone;
    }
    public String transform(String s){
        return s.replace(org, newone);
    }
    
}