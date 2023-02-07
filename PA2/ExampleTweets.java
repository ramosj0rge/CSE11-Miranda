class User{
    //Initializes the variables
    String userName;
    String fullName;
    int followers;

    //User construct with values assigned to variables from above
    User(String userName, String fullName, int followers){
        this.userName = userName;
        this.fullName = fullName;
        this.followers = followers;
    }

    //Uses the values and variables to create a string representing the name of the User Tweet
    String toText(){
        return fullName + " @" + userName;
    }
}

class Tweet{
    //Initializes the variables for the content of the tweet
    String text;
    User userName;
    int likes;
    String id;

    //A construct that assigned values to the variables mentioned above
    Tweet(String text, User userName, int likes, String id){
        this.text= text;
        this.userName = userName;
        this.likes = likes;
        this.id = id;
    }

    //Checks if one tweet is bigger than the other
    boolean longerThan(Tweet other){
        if(this.text.length() > other.text.length()){
                return true;
        }
        return false;
    }
         
    //Checks if the likes of one tweet is greater than the other
    boolean moreLikes(Tweet other){
        if(this.likes > other.likes){
            return true;
        }
        return false;
    }

    //Gives us the text of the tweet along with the username and the number of likes
    String toText(){
        return this.userName.toText() + " : " + this.text + " : " + this.likes + " Likes";
    }

    //Gives out the link to the tweet
    String toLink(){
        return "https://twitter.com/" + this.userName.userName + "/status/" + this.id;
    }


}

//Testing
class ExampleTweets{

    //First User
    User test1 = new User("acmucsd", "ACM@UCSD", 56);
    //Full name of the User 
    String test1b = this.test1.toText();

    //Creates a new variable that takes in the contents of the tweet from a user
    Tweet test1c = new Tweet("Ants are cool", test1, 3, "1394184426817343488?cxt=HHwWgMCi_a7WkdkmAAAA");
    Tweet test1d = new Tweet("It's week 7 so that's a thing, you should join us for some events in the meantime! Join us in some events: https://amcurl.com/events", test1, 
    2, "1392332620223029255?cxt=HHwWjoCp2YTJx9ImAAAA");

    boolean test21 = test1c.longerThan(test1d); //Expected false
    boolean test22 = test1c.moreLikes(test1d); //Expected true

    //text and link of both tweets from first user
    String test23 = test1c.toText();
    String test24 = test1c.toLink();
    String test25 = test1d.toText();
    String test26 = test1d.toLink();

    //Second and Third User
    User test3 = new User("UCSDJacobs", "UCSD Engineering", 13700);
    User test3a = new User("kprather88", "Kimberly Prather, Ph.D.", 86200);
    String test3b = this.test3.toText();
    String test3c = this.test3a.toText();

    //Contennt of tweet of Second and Third User
    Tweet test3d = new Tweet("Love this full circle moment, as @MattNewsomeSD, a @UCSanDiego mechanical engineering alumnus and now Senior VPat @CubicTS, shares a day-in-his-life with current mechanical engineering and data science students during Take a Triton to Work day! Thanks, Matt! #TritonPride🔱",
    test3, 9, "1621574804603310080?cxt=HHwWgMDU0a_s_oAtAAAA");
    Tweet test3e = new Tweet("Reminds me of anti-maskers, anti-vaccine, and anti-airborne crew (all the same).", test3a, 11, "1622801174255775746?cxt=HHwWhMDRyb3ErIUtAAAA");

    boolean test31 = test3d.longerThan(test3e); //Exepcted True
    boolean test32 = test3d.moreLikes(test3e); //False

    //Text and Links of tweets from Second and Third User
    //I was unable to obtain the picture that came with the tweet for the tweet test3d from UCSDJacobs and the actual picture of the emoji used
    String test33 = test3e.toText();
    String test34 = test3e.toLink();
    //I was also unable to obtain the picture from the tweet with this class design
    String test35 = test3d.toText();
    String test36 = test3d.toLink();

    
}