package oopSystem1;
public class Exercise {

    private int amount; //题目数量
    private Equation[] equations;//题目数组
    private int range;   //题目运算数范围
    private int percent; //加法所占半分比*100
    private int ceiling; //运算结果上限
    private int floor;   //运算结果下限

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
        this.amount = 50;
        this.range = 100;
        this.percent = 50;
        this.floor = 0;
        this.ceiling = 100;
        this.equations = new Equation[amount];
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

    //生产习题集
    public void createExercise(){
        int i = 0;
        while(i < this.amount){
            //初始化算式类
            equations[i] = new Equation();

            equations[i].createLeftNumber(this.range);
            equations[i].createRightNumber(this.range);
            equations[i].createOperator(this.percent);

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

    //打印习题
    public void printExercise(){
        int i = 0;
        while(i < amount){
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
        while(i < amount){
            String strings = (i+1) + ": " +equations[i].getAnswer()+ "\t\t";
            System.out.print(strings);
            if(0 == (i+1)%5){
                System.out.println();
            }
            i++;
        }
        System.out.println();
    }
}
