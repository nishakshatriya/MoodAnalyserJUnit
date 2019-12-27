package com.bridgelabz.moodanalysertest;

import com.bridgelabz.moodanalyser.MoodAnalyser;
import com.bridgelabz.moodanalyser.MoodException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {

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
            message= analyser.analyse();
            Assert.assertEquals("Happy", message);
        } catch (MoodException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void whenGivenNull_ShouldThrow() {
        MoodAnalyser analyser = new MoodAnalyser(null);
        String message ="";
        try {
            analyser.analyse();
        } catch (MoodException e) {
            Assert.assertEquals("plz enter valid entry", e.getMessage());
        }

    }

}