package com.bridgelabz.moodanalyzer;

import com.bridgelabz.moodanalyser.MoodAnalyser;
import jdk.jfr.internal.PrivateAccess;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class MoodAnalyserFactory {


    public static MoodAnalyser createMoodAnalyser(String message) {

        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
            try {
                Object moodObj = moodConstructor.newInstance(message);
                return (MoodAnalyser) moodObj;
            } catch (IllegalAccessException e) {
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

    public static Constructor getConstructor(Class<?>... parameter) {
        Class<?> moodAnalyserClass = null;
        try {
            moodAnalyserClass = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(parameter);
            return moodConstructor;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();

        }
        return null;

    }


    public static Object getObjectConstructor(Constructor constructor, String... parameter) {
        try {
            Object message = null;
            Object obj = constructor.newInstance();
            return (MoodAnalyser) obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Object getObjectWhenNoParameter(Constructor constructor) {
        Object obj = null;
        try {
            obj = constructor.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }


    public Method getMethod(String methodName) {
       Constructor constructor = getConstructor();
       Object object = getObjectConstructor(constructor);
       // Method method = null;
        try {
           Method method = object.getClass().getDeclaredMethod(methodName, String.class);
            return method;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}

