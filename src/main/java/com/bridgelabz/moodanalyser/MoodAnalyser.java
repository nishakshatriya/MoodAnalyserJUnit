package com.bridgelabz.moodanalyser;

public class MoodAnalyser {

 private String message;
public MoodAnalyser()
{

}
public MoodAnalyser(String message)
{
    this.message=message;
}
        public String analyse() throws MoodException {
            try{
                if (message.length()==0)
                    throw new MoodException(MoodException.ExceptionType.ENTERED_EMPTY,"plz enter valid entry");
                if(message.contains("sad"))
                    return "Sad";
                else
                    return "happy";
            } catch(NullPointerException e)
            {
                throw  new MoodException(MoodException.ExceptionType.ENTERED_NULL,"plz enter valid entry");
            }
        }
    }

