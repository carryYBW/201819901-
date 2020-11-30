package oopSystem2.test;


import oopSystem2.exercise.AddMixSubExercise;
import oopSystem2.exercise.AdditionExercise;
import oopSystem2.exercise.Exercise;
import oopSystem2.exercise.SubtractionExercise;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExerciseTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束");
    }

    @Test
    public void additionExercise() {
        System.out.println("加法练习集");
        AdditionExercise additionExercise = new AdditionExercise();
        additionExercise.createExercise(100);
        additionExercise.printExercise();
        additionExercise.printAnswers();


    }
    @Test
    public void subExercise() {
        System.out.println("减法练习集");
        SubtractionExercise subtractionExercise = new SubtractionExercise();
        subtractionExercise.createExercise();
        subtractionExercise.printExercise();
        subtractionExercise.printAnswers();

    }
    @Test
    public void createExercise() {
        System.out.println("加减混合练习集");
        AddMixSubExercise addMixSubExercise = new AddMixSubExercise();
        addMixSubExercise.createExercise();
        addMixSubExercise.printExercise();
        addMixSubExercise.printAnswers();

    }
    @Test
    public void createExercise11() {
        System.out.println("练习集");
        Exercise exercise = new AdditionExercise();
        exercise.createExercise();
        exercise.printExercise();
        exercise.printAnswers();

    }
}