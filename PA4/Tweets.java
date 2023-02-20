import tester.*;

interface Tweet{
    public boolean isStartOfThreadBy(String author);
    public int totalLikes();
    public String unrollThread();
}

class TextTweet implements Tweet{
    String contents;
    int likes;
    String author;

    TextTweet(String contents, int likes, String author){
        this.contents = contents;
        this.likes = likes;
        this.author = author;
    }

    public boolean isStartOfThreadBy(String author){
        return author.equals(this.author);
    }
    public int totalLikes(){
        return likes;
    }
    public String unrollThread(){
        return author + "\n" + likes + " likes" + "\n" + contents + "\n";
    }

}

class ReplyTweet implements Tweet{
    String contents;
    int likes;
    String author;
    Tweet replyTo;

    ReplyTweet(String contents, int likes, String author, Tweet replyTo){
        this.contents = contents;
        this.likes = likes;
        this.author = author;
        this.replyTo = replyTo;
    }
    
    public boolean isStartOfThreadBy(String author){
        return author.equals(this.author) && replyTo.isStartOfThreadBy(author);
    }
    public int totalLikes(){
        return likes + replyTo.totalLikes();
    }
    public String unrollThread(){
        return replyTo.unrollThread() + "\n" + author + "\n" + likes +" likes" + "\n" + contents + "\n";
    }
}

class Tweets{

    TextTweet testA = new TextTweet("Pretend this is a real tweet", 5, "sosajorge");
    boolean test1 = this.testA.isStartOfThreadBy("sosajorge");
    int test2 = this.testA.totalLikes();
    String test3 = this.testA.unrollThread();

    
}
