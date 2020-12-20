package oopSystem2;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import oopSystem2.exercise.AddMixSubExercise;
import oopSystem2.exercise.AdditionExercise;
import oopSystem2.exercise.Exercise;
import oopSystem2.exercise.SubtractionExercise;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseBooks {
    private int number;
    private String addpath;
    private String subpath;
    private String mixpath;

    private Exercise add;
    private Exercise sub;
    private Exercise mix;

    private String bookspath;
    private String markingpath;

    private ArrayList<String[]> list;

    public Exercise getAdd() {
        return add;
    }

    public Exercise getSub() {
        return sub;
    }

    public Exercise getMix() {
        return mix;
    }

    //构造函数，绑定三套习题的文件路径与练习文件的存储位置
    public ExerciseBooks(int number) {
        this.number = number;
        this.addpath = "D:\\01-studyData\\2020大三实验报告\\软件构造\\mySystem\\src\\oopSystem2\\csvFile\\Exercise\\additionExercise" + this.number;
        this.subpath = "D:\\01-studyData\\2020大三实验报告\\软件构造\\mySystem\\src\\oopSystem2\\csvFile\\Exercise\\subtractionExercise" + this.number;
        this.mixpath = "D:\\01-studyData\\2020大三实验报告\\软件构造\\mySystem\\src\\oopSystem2\\csvFile\\Exercise\\addMixSubExerciseExercise" + this.number;
        this.bookspath = "D:\\01-studyData\\2020大三实验报告\\软件构造\\mySystem\\src\\oopSystem2\\csvFile\\ExerciseBooks\\exerciseBooks" + this.number;
        this.markingpath = "D:\\01-studyData\\2020大三实验报告\\软件构造\\mySystem\\src\\oopSystem2\\csvFile\\ExerciseMarking\\exerciseMarking" + this.number;
    }

        //    初始化并存入外存
    //批量产生加法，减法，加减混合习题各10套
    public void Updatequestionbank(){

        for(int i= 1; i<= 10;i++){
           Exercise exercise = new AdditionExercise();
            exercise.createExercise(50);
            exercise.writeCSV("D:\\01-studyData\\2020大三实验报告\\软件构造\\mySystem\\src\\oopSystem2\\csvFile\\Exercise\\additionExercise"+i);
        }
        for(int i= 1; i<= 10;i++){
            Exercise exercise = new SubtractionExercise();
            exercise.createExercise(50);
            exercise.writeCSV("D:\\01-studyData\\2020大三实验报告\\软件构造\\mySystem\\src\\oopSystem2\\csvFile\\Exercise\\subtractionExercise"+i);
        }
        for(int i= 1; i<= 10;i++){
            Exercise exercise = new AddMixSubExercise();
            exercise.createExercise(50);
            exercise.writeCSV("D:\\01-studyData\\2020大三实验报告\\软件构造\\mySystem\\src\\oopSystem2\\csvFile\\Exercise\\addMixSubExerciseExercise"+i);
        }
    }
    //产生练习集，加法，减法，加减混合习题集各一套组合成
    public void initBooks(){
        add = new AdditionExercise();
        add.createExercise(50);
        add.readCSV(addpath);

        sub = new SubtractionExercise();
        sub.createExercise(50);
        sub.readCSV(subpath);

        mix = new AddMixSubExercise();
        mix.createExercise(50);
        mix.readCSV(mixpath);
    }
    //答案记录 存入文件
    public void recordAnswer(){
        this.list = new ArrayList<String[]>();
        System.out.println("请输入答案:");
        System.out.println("如果中途退出请输入-999");
        int i = 0;
        String[] answers = new String[1];
        String answer;
        Scanner scanner = new Scanner(System.in);

       while(i < 150){

           answer = scanner.nextLine();

           if (answer.equals("-999")){
               break;
           }
           answers = new String[]{answer};
           list.add(answers);
           i++;
        }
       //写入CSV文件
        writeCSV(list);

    }
    //读取文件 继续做题
    public void  continueDoBooks(){
        //读取文件
        ArrayList<String[]> listread = new ArrayList<String[]>();
        readCSV(listread);
        this.list = listread;

        int i = listread.size();

        String[] answers = new String[1];
        String answer;
        Scanner scanner = new Scanner(System.in);
        while(i < 150){

            answer = scanner.nextLine();

            if (answer.equals("-999")){
                break;
            }
            answers = new String[]{answer};
            list.add(answers);
            i++;
        }
        if(i>=150){
            System.out.println("恭喜你！可算做完了呢");
        }

        //写入CSV文件
        writeCSV(list);


    }

    private void readCSV(ArrayList<String[]> listread){

        try {
            //创建
            CsvReader csvReader = new CsvReader(bookspath,',' , Charset.forName("gb2312"));
            csvReader.readHeaders();
            //读取
            while(csvReader.readRecord()){
                listread.add(csvReader.getValues());
            }
            //关闭
            csvReader.close();

            System.out.println("读入完成");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeCSV(ArrayList<String[]> list){

        try {
            String[] headers = {"结果"};
            CsvWriter csvWriter = new CsvWriter(bookspath,',' , Charset.forName("gb2312"));
            csvWriter.writeRecord(headers);

            for(int  j = 0; j < list.size();j++){
                String[] csvContent = list.get(j);
                csvWriter.writeRecord(csvContent);
            }
            csvWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入完成");

    }


    //批改习题
    public void marking(){
        ArrayList<String[]> marklist = new ArrayList<String[]>();
        ArrayList<String[]> readlist = new ArrayList<String[]>();
//        读取练习题的结果
        readCSV(readlist);

//       判断答案的正确性

        int j;
        for(int i = 0; i< 150;i++){
            String[] strings = new String[4];
            strings[0] = (i+1)+"";
           if (i<50){
               j =i;
               strings[1]=add.getEquations()[j].getAnswer()+"";
               strings[2]=readlist.get(i)[0];
               if((add.getEquations()[j].getAnswer()+"").equals(readlist.get(i)[0])){
                   strings[3]="答案正确";
               }else {
                   strings[3]="答案错误";
               }
           }
           else if(i<100){
               j= i-50;
               if (j<50){
                   strings[1]=sub.getEquations()[j].getAnswer()+"";
                   strings[2]=readlist.get(i)[0];
                   if((sub.getEquations()[j].getAnswer()+"").equals(readlist.get(i)[0])){
                       strings[3]="答案正确";
                   }else {
                       strings[3]="答案错误";
                   }
                   j++;
               }
           }else{
               j = i-100;
               if (j<50){
                   strings[1]=mix.getEquations()[j].getAnswer()+"";
                   strings[2]=readlist.get(i)[0];
                   if((mix.getEquations()[j].getAnswer()+"").equals(readlist.get(i)[0])){
                       strings[3]="答案正确";
                   }else {
                       strings[3]="答案错误";
                   }
                   j++;
               }
            }
            marklist.add(strings);
        }
//写入文件
        try {
            String[] headers = {"序号","正确答案","结果","批改结果"};
            CsvWriter csvWriter = new CsvWriter(markingpath,',' , Charset.forName("gb2312"));
            csvWriter.writeRecord(headers);

            for(int  k= 0; k < marklist.size();k++){
                String[] csvContent = marklist.get(k);
                csvWriter.writeRecord(csvContent);
            }
            csvWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入完成");
    }

    public void showMarking(){
        //从文件中读取
        ArrayList<String[]> listread = new ArrayList<String[]>();

        try {
            //创建
            CsvReader csvReader = new CsvReader(markingpath,',' , Charset.forName("gb2312"));
            csvReader.readHeaders();
            //读取
            while(csvReader.readRecord()){
                listread.add(csvReader.getValues());
            }
            //关闭
            csvReader.close();
//            System.out.println("读入完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //处理
        int t = 0;
        int f = 0;
        for(int i = 0;i<listread.size();i++){
            if(listread.get(i)[3].equals("答案正确")){
                t++;
            }
            if(listread.get(i)[3].equals("答案错误")){
               f++;
            }
        }
        //显示到控制台
        System.out.println("正确个数：" + t);
        System.out.println("错误个数：" + f);
    }



    //显示题目
    public void showBooks(){
        System.out.println("加法题目：");
        add.printExercise();
        System.out.println("减法题目：");
        sub.printExercise();
        System.out.println("加减混合题目：");
        mix.printExercise();
    }
    //显示答案
    public void showAnswer(){
        System.out.println("加法题目答案：");
        add.printAnswers();
        System.out.println("减法题目答案：");
        sub.printAnswers();
        System.out.println("加减混合题目答案：");
        mix.printAnswers();

    }


}
