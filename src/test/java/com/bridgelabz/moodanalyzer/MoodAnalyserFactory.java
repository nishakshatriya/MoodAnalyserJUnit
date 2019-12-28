package com.bridgelabz.moodanalyzer;

import com.bridgelabz.moodanalyser.MoodAnalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String message)  {

        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser");
            Constructor<?> moodConstructor =moodAnalyserClass.getConstructor(String.class);
            try {
               Object moodObj=moodConstructor.newInstance(message);
               return (MoodAnalyser) moodObj;
            }catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
