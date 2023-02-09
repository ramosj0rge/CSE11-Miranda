class TextTweet{
    String contents;
    int likes;

    TextTweet(String contents, int likes){
        this.contents = contents;
        this.likes = likes;
    }

    boolean hasMention(String username){
        return contents.contains("@" + username);
    }

    boolean hasLike(){
        return likes <= 1; //this.likes?
    }

    String firstMention(){
        return contents.substring(contents.indexOf("@" + 1), contents.indexOf(""));
    }
    
}

class ReplyTweet{
    TextTweet replyTo;
    String contents;
    int likes;

    ReplyTweet(TextTweet replyTo, String contents, int likes){
        this.replyTo = replyTo;
        this.contents = contents;
        this.likes = likes;
    }

    boolean morePopularReply(){
        return this.likes > replyTo.likes;
    }

    int allLikes(){
        return this.likes + replyTo.likes;
    }

    boolean hasMention(String username){
        return contents.contains("@" + username) || replyTo.contents.contains("@" + username);
    }
}
