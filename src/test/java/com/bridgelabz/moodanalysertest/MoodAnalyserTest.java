package com.bridgelabz.moodanalysertest;

import com.bridgelabz.moodanalyser.MoodAnalyser;
import com.bridgelabz.moodanalyser.MoodException;
import com.bridgelabz.moodanalyzer.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class MoodAnalyserTest {

    @Test
    public void givenMooodAnalyser_whenProper_Shouldreturn() {
        MoodAnalyserFactory.createMoodAnalyser("i am happoy");


    }

    @Test
    public void givenMoodAnalyser_whenProper_ShouldReturnObject() {
        Constructor<?> constructor = null;
        try {
            constructor = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser").getConstructor(String.class);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Object obj = constructor.newInstance("plz enter valid entry");
            MoodAnalyser moodAnalyser = (MoodAnalyser) obj;
            String mood = moodAnalyser.analyse();
            Assert.assertEquals("happy", mood);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenGivenSad_shouldReturnSad() {
        MoodAnalyser analyzer = new MoodAnalyser("I am sad now.");
        String message = null;
        try {
            message = analyzer.analyse();
        } catch (MoodException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Sad", message);
    }

    @Test
    public void whengivenhappy_shouldReturnHappy() {
        MoodAnalyser moodanalyzer = new MoodAnalyser("I am happy now");
        String message = null;
        try {
            message = moodanalyzer.analyse();
        } catch (MoodException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("happy", message);
    }

    @Test
    public void whenGivenSadMessageSAlphabetCapital_shouldReturnSad() {
        MoodAnalyser analyser = new MoodAnalyser("I am sad now");
        String message = null;
        try {
            message = analyser.analyse();
        } catch (MoodException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Sad", message);


    }

    @Test
    public void whenGivenNull_shouldReturnHappy() {
        MoodAnalyser analyser = new MoodAnalyser(null);
        String message = null;
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodException.class);
            message = analyser.analyse();
            Assert.assertEquals("Happy", message);
        } catch (MoodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void whenGivenNull_ShouldThrow() {
        MoodAnalyser analyser = new MoodAnalyser(null);
        String message = "";
        try {
            analyser.analyse();
        } catch (MoodException e) {
            Assert.assertEquals("plz enter valid entry", e.getMessage());
        }

    }

    @Test
    public void WhenGivenObjectMessage_ShouldReturnTrue() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am Happy");
        MoodAnalyser object = MoodAnalyserFactory.createMoodAnalyser("I am Happy");
        Assert.assertEquals(true, moodAnalyser.equals(object));
    }

    @Test
    public void WhenGivenWrongClassName_ShouldReturnNoSuchClassError() {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            try {
                throw new MoodException(MoodException.ExceptionType.NO_SUCH_METHOD, "Invalid Entry ");
            } catch (MoodException a) {
                a.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            try {
                throw new MoodException(MoodException.ExceptionType.NO_SUCH_CLASS, "Invalid Entry ");

            } catch (MoodException a) {
                a.printStackTrace();

            }
        }
    }

    @Test
    public void WhenGivenWrongMethodName_ShouldReturnNoSuchMethod() {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser").getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            try {
                throw new MoodException(MoodException.ExceptionType.NO_SUCH_METHOD, "Invalid Entry");
            } catch (MoodException a) {
                a.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            try {

                throw new MoodException(MoodException.ExceptionType.NO_SUCH_CLASS, "Invalid Entry");
            } catch (MoodException a) {
                a.printStackTrace();
            }
        }
    }

    @Test
    public void WhenGivenConstructorWithParameter_ShouldReturnObject() {

        Constructor constructor = MoodAnalyserFactory.getConstructor(String.class);
        Object object = MoodAnalyserFactory.getObjectConstructor(constructor, "I am Happy");
        MoodAnalyser moodAnalyser = (MoodAnalyser) object;
        Assert.assertEquals(true, moodAnalyser.equals(new MoodAnalyser("I am Happy")));
    }


    @Test
    public void WhenGivenConstructorWithNoParameter_ShouldReturnObject() {
        //   Constructor constructor = null;
        Constructor constructor = MoodAnalyserFactory.getConstructor();
        Object object = MoodAnalyserFactory.getObjectWhenNoParameter(constructor);
        MoodAnalyser moodAnalyser = (MoodAnalyser) object;
        Assert.assertEquals(true, moodAnalyser.equals(new MoodAnalyser()));


    }


    /*@Test
    public void WhenMethodInvoked_ShouldReturnCorrect() {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor(String.class);
            Object obj = MoodAnalyserFactory.getObjectConstructor(constructor,"happy");
            Method method = MoodAnalyser.class.getDeclaredMethod("analyseMethod");
            Object obj1 = method.invoke(obj);
            Assert.assertEquals("happy",obj1.toString());

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
*/

    @Test
    public void WhenMethodInvoked_ShouldReturnProperMessage() throws ClassNotFoundException {
        Method method = new MoodAnalyserFactory().getMethod("analyseMethod");
        // String mood = null;
        try {
            String mood = (String) method.invoke(new MoodAnalyser(), "i am happy");
            Assert.assertEquals("happy", mood);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void WhenGivenImproperField_ShouldThrowException() {
        try {
            Class<?> cls = null;
            cls = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser");
           // Constructor constructor = cls.getConstructor(String.class);
            Field field = cls.getField("message12");
            Assert.assertEquals("message", field);
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        }catch (NoSuchFieldException e) {
                e.getMessage();
        }
    }
    }