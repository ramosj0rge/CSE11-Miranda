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
    ReplyTweet testA2 = new ReplyTweet("But it isn't a real tweet", 213, "sosajorge", testA);
    boolean test4 = this.testA2.isStartOfThreadBy("sosajorge");
    int test5 = this.testA2.totalLikes();
    String test6 = this.testA2.unrollThread();

    
    TextTweet testB = new TextTweet("These must come out as false", 2, "anonymoususer");
    boolean test7 = this.testB.isStartOfThreadBy("adidas");
    int test8 = this.testA.totalLikes();
    String test9 = this.testB.unrollThread();
    ReplyTweet testB2 = new ReplyTweet("So, tell me, does it come out as false?", 23, "notanonymous", testB);
    boolean test10 = this.testB2.isStartOfThreadBy("anonymoususer");
    int test11 = this.testB.totalLikes();
    String test12 = this.testB.unrollThread();

}
