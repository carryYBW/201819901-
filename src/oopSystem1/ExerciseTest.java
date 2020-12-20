package oopSystem1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExerciseTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("开始");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("结束\n");
    }

    @Test
    public void createExercise() {
        Exercise exercise = new Exercise();
        exercise.createExercise();
        exercise.printExercise();
        exercise.printAnswers();
    }
}