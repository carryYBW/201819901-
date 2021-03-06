package oopSystem2.exercise;


import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import oopSystem2.equation.AdditionEquation;
import oopSystem2.equation.Equation;
import oopSystem2.equation.SubtractionEquation;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public abstract class Exercise{

    private int amount; //题目数量
    protected Equation[] equations;//题目数组
    private int range;   //题目运算数范围
    private int percent; //加法所占半分比*100
    private int ceiling; //运算结果上限
    private int floor;   //运算结果下限

    public  Equation[] getEquations(){
        return equations;
    }
    public int getAmount() {
        return amount;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getCeiling() {
        return ceiling;
    }

    public void setCeiling(int ceiling) {
        this.ceiling = ceiling;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    //默认构造函数 设置一些默认值
    public Exercise(){
        this.setDefautValue();
        this.initExercise();
    }
    //设置默认值
    private  void setDefautValue(){
        this.amount = 50;
        this.range = 100;
        this.percent = 50;
        this.floor = 0;
        this.ceiling = 100;
    }

    private void initExercise(){
        this.equations = new Equation[this.amount];
    }


    //对习题的检查重复
    private boolean checkRepeat(int length, Equation equation, Equation[] equations){
        //进行循环
        for( int i = 0;i < length;i++){
            //判断之前元素有没有一样的元素
            if((equation.getOperator() == equations[i].getOperator()) && (equation.getRightNumber() == equations[i].getRightNumber()) && (equation.getLeftNumber() == equations[i].getLeftNumber())){
                return true;
            }
        }
        return false;
    }

    protected abstract Equation initAnEquation();

    public void createExercise(){
        int i = 0;
        while(i < this.amount){
            //初始化算式类
            equations[i] = initAnEquation();
            //初始化数值和符号
            equations[i].createLeftNumber(this.range);
            equations[i].createRightNumber(this.range);
            equations[i].createOperator();

            //计算答案
            equations[i].countAnswer();
            //检验答案是否合规，不合规重新换
            if(equations[i].checkRange(floor,ceiling)){
                //检查是否有重复算式,没有重复算式继续
                if(!(checkRepeat(i,equations[i],equations))){
                    i++;
                }
            }
        }
    }
    //指定练习数量
    public void createExercise(int amount){
        this.amount = amount;
        initExercise();
        createExercise();
    }




    //打印习题
    public void printExercise(){
        int i = 0;
        while(i < this.amount){
            String strings = (i+1) + ": " +equations[i].toString() + " =\t\t";
            System.out.print(strings);
            if(0 == (i+1)%5){
                System.out.println();
            }
            i++;
        }
        System.out.println();
    }
    //打印答案
    public void printAnswers(){
        int i = 0;
        while(i < this.amount){
            String strings = (i+1) + ": " +equations[i].getAnswer()+ "\t\t";
            System.out.print(strings);
            if(0 == (i+1)%5){
                System.out.println();
            }
            i++;
        }
        System.out.println();

    }
    //将习题的算式存入list中
    private ArrayList<String[]> equationsToList(){
        ArrayList<String[]> list = new ArrayList<String[]>();
        for (int i = 0; i < this.getAmount(); i++) {
            String[] strings = { equations[i].getLeftNumber()+"",equations[i].getRightNumber()+"",equations[i].getOperator(),equations[i].getAnswer()+"" };
            list.add(strings);
        }
        return list;
    }
    //将List中存储的数据设置习题集数据
    private void listToequations(ArrayList<String[]> list){
        for(int i = 0 ; i < list.size();i++){
            equations[i].setLeftNumber(Integer.parseInt(list.get(i)[0]));
            equations[i].setRightNumber(Integer.parseInt(list.get(i)[1]));
            equations[i].setOperator(list.get(i)[2]);
            equations[i].setAnswer(Integer.parseInt(list.get(i)[3]));
        }

    }
    //写入文件
    public  void writeCSV(String pathCSVWrite){

//        String pathCSVWrite = "D:\\01-studyData\\2020大三实验报告\\软件构造\\mySystem\\src\\oopSystem2\\csvFile\\writetest2";
            ArrayList<String[]> list = equationsToList();

        try {
            String[] headers = {"运算数1","运算数2","运算符","结果"};
            CsvWriter csvWriter = new CsvWriter(pathCSVWrite,',' , Charset.forName("gb2312"));
            csvWriter.writeRecord(headers);

            for(int i = 0; i < list.size();i++){
                String[] csvContent = list.get(i);
                csvWriter.writeRecord(csvContent);
            }

            csvWriter.close();
            System.out.println("写入完成");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //从文件中读取
    public  void readCSV(String pathCSV){

        ArrayList<String[]> listread = new ArrayList<String[]>();
        try {
            //创建
            CsvReader csvReader = new CsvReader(pathCSV,',' , Charset.forName("gb2312"));
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
        //调用函数。将读取的内容复制给对象
        listToequations(listread);
    }
}
