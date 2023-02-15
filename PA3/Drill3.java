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
        return this.likes >= 1;
    }

    String firstMention(){
        int start = contents.indexOf("@") + 1;
        int end = contents.indexOf(" ", start);
        
        if(start - 1 == -1|| end == -1){
            return "";
        }

        return contents.substring(start, end);
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

class Drill3{

    TextTweet drillTest = new TextTweet("Reminds me of anti-maskers, anti-vaccine, and anti-airborne crew @kprather88" ,18);
    boolean drillTest1 = this.drillTest.hasMention("kprather88");
    boolean drillTest2 = this.drillTest.hasLike();
    String drillTest3 = this.drillTest.firstMention();

    ReplyTweet test1 = new ReplyTweet(drillTest, "What a title!  I am going to check it out. @laurahowemt", 1);
    boolean test12 = this.test1.morePopularReply();
    int test13 = this.test1.allLikes();
    boolean test14 = this.test1.hasMention("laurahowemt");
}