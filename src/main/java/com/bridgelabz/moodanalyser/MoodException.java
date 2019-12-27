package com.bridgelabz.moodanalyser;

    public class MoodException extends RuntimeException {
        enum ExceptionType{
            ENTERED_NULL,ENTERED_EMPTY;
        }
        ExceptionType type;
        public MoodException( ExceptionType type,String message) {
            super(message);
            this.type=type;
        }

}
