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

    public boolean isStartOfThreadBy(String author){
        return author.equals(this.author);
    }
    public int totalLikes(){
        return likes;
    }
    public String unrollThread(){
        return author + "/n" + likes + " likes" + "/n" + contents;
    }

}

class ReplyTweet implements Tweet{
    String contents;
    int likes;
    String author;
    Tweet replyTo;
    
    public boolean isStartOfThreadBy(String author){
        return author.equals(this.author) && replyTo.isStartOfThreadBy(author);
    }
    public int totalLikes(){
        return likes + replyTo.totalLikes();
    }
    public String unrollThread(){
        return replyTo.unrollThread() + "/n" + author + "/n" + likes +" likes" + "/n" + contents;
    }
}
