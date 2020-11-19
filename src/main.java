import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //输出page
        printPage();
        //定义答案数组，用于存储答案数据
        int[] anwers = new int[50];
        //进入系统循环
        while(true){
            Scanner sc = new Scanner(System.in);
            int no = sc.nextInt();
            if(no == 1){
                //输出50到一百以内的加减法
                anwers = creatTitle();
                continue;
            }
            if(no == 2){
                //输出50道题的答案
               printAnswers(anwers);
               continue;
            }
            if(no == 3){
                break;
            }else{
                System.out.println("输入无效，请重新输入！");
                continue;
            }
        }

        System.out.println("您已经退出。");

    }
    //生成指定范围的随机数
    static int creatNumber(int range){
        Random random = new Random();
        int r = random.nextInt(range);
        return r;
    }
    //生成随机算术符号（+ 或 -）
    static String creatMathSymbol(){
        int no = creatNumber(2);
        String mathSymbol;
        if(0 == no){
            mathSymbol = "+";
        }else{
            mathSymbol = "-";
        }
        return mathSymbol;
    }

    //生成算式功能 运用字符串的方式
    static String creatEquation(int number1,int number2,String mathSymbol){

        String s = number1 + mathSymbol + number2 + "=";
        return s;
    }

    //计算功能，接受运算数和运算符 进行运算 返回结果
    static int count(int number1,int number2,String mathSymbol){
        int answer = 200;
        if(mathSymbol == "+"){
            answer = number1 + number2;
        }
        if(mathSymbol == "-"){
            answer = number1 - number2;
        }
        return answer;
    }
    //检验算式是否符合要求  大于0且小于100
    static boolean chectOut(int number1,int number2,String mathSymbol){
        int answer = count(number1,number2,mathSymbol);
        if(answer < 0 || answer >=100){
            return false;
        }
        return true;
    }
    //生成题目功能,同时返回题目答案数组
    static int[] creatTitle(){
        int i = 0;
        //两个数
        int number1,number2;
        //算术符号
        String mathSymbol;
       //题目数组
        String strings[] = new String[50];
        //答案数组
        int[] answers = new int[50];
        //循环输出算式，记录答案
        while(i < 50){
            //随机初始化数据
            number1 = creatNumber(100);
            number2 = creatNumber(100);
            //随机初始化算术符号
            mathSymbol = creatMathSymbol();

            //检验成功则开始输出
            if(chectOut(number1,number2,mathSymbol)){
                //生成算式
                String s = new String();
                s = creatEquation(number1,number2,mathSymbol);
                //如果算式重复 跳出
                if(!(checkRepeat(i,s,strings))){
                  continue;
                }
                //输出算式
                System.out.print((i+1)+":\t"+ s + "\t\t");

                //记录答案
                int answer = count(number1,number2,mathSymbol);
                answers[i] = answer;
                //i递增 控制题目数
                i++;
                //每五个输出进行换行
                if(i%5 == 0){
                    System.out.println();
                }
            }
        }
        return answers;
    }

    //输出题目答案
    static void printAnswers(int[] answers){
        int i = 0;
        while(i<50){
            System.out.print((i+1)+":\t"+ answers[i] + "\t\t");
            i++;
            //每五个输出进行换行
            if(i%5 == 0){
                System.out.println();
            }

        }
    }

    //输出界面
    static void printPage(){
        System.out.println();
        System.out.println("**********开始菜单*********");
        System.out.println("  1.输出题目               ");
        System.out.println("  2.输出答案               ");
        System.out.println("  3.退出                  ");
        System.out.println("请输入对应编号：");
    }
    //重复算式的检验,如果没有s将其添加在数组末尾，如果有返回false
    static boolean checkRepeat(int n,String s, String[] strings){

        for( int i = 0;i<= n;i++){
            if(s.equals(strings[i])){
                return false;
            }
        }
        strings[n] = s;
        return true;
    }
}
