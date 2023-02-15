class R{
    String str;
    R obj;

    R(String str, R obj){
        this.str = str;
        this.obj = obj;
    }


}

//class ExamplesR{
    //R newobj = new R("testing R object", R obj);
//}

/*Construct an example R object. Were you able to? 
Explain your example if you were able to, and explain why you think it’s not possible if you weren’t. 

    I was not able to construct an example R object as it gave me an error.
    I think it is not possible because you can not put the object made from a constructor inside
    a new object under the same constructor. (if that makes sense)
    */

/* On Twitter, it’s possible to reply to a reply to a Tweet (that’s not a typo, it’s a reply to a reply). 
This is true of many systems, like email, Facebook comments, Piazza followups, and so on. 
With the class structure in Drill3 with ReplyTweet and TextTweet (that is, without changing the fields as described above), 
could you construct an example of a reply to a reply to a Tweet? Why or why not?

    I do not think it is possible because in our case we are just replying to one tweet. We would be able to reply
    to multiple tweets, however, we would have to continously and indefinitely create methods
    that reply to the reply; reply to a reply to a reply to a reply..... Ultimately we could create
    many methods but limit the amount of replies however that will be tidy and annoying as a feature. 
    */

/* 
 * S C:\Users\sosaj\OneDrive\Documents\GitHub\CSE11 Miranda\PA3> ./run.bat ExamplesR
ExamplesR.java:14: error: ')' or ',' expected
    R newobj = new R("testing R object", R obj);
                                          ^     
ExamplesR.java:14: error: <identifier> expected 
    R newobj = new R("testing R object", R obj);
                                              ^ 
2 errors
 */