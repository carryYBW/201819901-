package oopSystem2.test;


import oopSystem2.ExerciseBooks;
import oopSystem2.exercise.AddMixSubExercise;
import oopSystem2.exercise.AdditionExercise;
import oopSystem2.exercise.SubtractionExercise;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExerciseTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束");
    }

    @Test//完成单个文件的写入工作测试
    public void additionExercise() {
        System.out.println("加法练习集");
        AdditionExercise additionExercise = new AdditionExercise();
        additionExercise.createExercise(50);
     additionExercise.writeCSV("D:\\01-studyData\\2020大三实验报告\\软件构造\\mySystem\\src\\oopSystem2\\csvFile\\writetest2");
        additionExercise.printExercise();
        additionExercise.printAnswers();


    }
    @Test//完成单个文件的读取工作测试
    public void additionExercise2() {
        System.out.println("加法练习集");
        AdditionExercise additionExercise = new AdditionExercise();
        additionExercise.createExercise(50);
        additionExercise.readCSV("D:\\01-studyData\\2020大三实验报告\\软件构造\\mySystem\\src\\oopSystem2\\csvFile\\writetest2");
        additionExercise.printExercise();
        additionExercise.printAnswers();
    }
    @Test//测试练习集的生产状况及功能
    public void ExerciseBooks() {
        ExerciseBooks books =  new ExerciseBooks(1);
//  books.Updatequestionbank();
        books.initBooks();
        books.showBooks();
        books.recordAnswer();

    }
    @Test
    public void subExercise() {
        System.out.println("减法练习集");
        SubtractionExercise subtractionExercise = new SubtractionExercise();
        subtractionExercise.createExercise(50);
        subtractionExercise.printExercise();
        subtractionExercise.printAnswers();

    }
    @Test
    public void createExercise() {
        System.out.println("加减混合练习集");
        AddMixSubExercise addMixSubExercise = new AddMixSubExercise();
        addMixSubExercise.createExercise(50);
        addMixSubExercise.printExercise();
        addMixSubExercise.printAnswers();

    }
    
}