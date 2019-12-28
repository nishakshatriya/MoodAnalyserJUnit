package com.bridgelabz.moodanalyser;

    public class MoodException extends RuntimeException {
        public enum ExceptionType{
            ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD
        }
        ExceptionType type;
        public MoodException( ExceptionType type,String message) {
            super(message);
            this.type=type;
        }

}
