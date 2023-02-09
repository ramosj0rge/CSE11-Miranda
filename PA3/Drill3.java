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
        return likes <= 1;
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
    }
}
