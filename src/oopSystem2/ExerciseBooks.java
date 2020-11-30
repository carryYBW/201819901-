package oopSystem2;
import oopSystem2.exercise.AddMixSubExercise;
import oopSystem2.exercise.AdditionExercise;
import oopSystem2.exercise.Exercise;
import oopSystem2.exercise.SubtractionExercise;
import java.util.Scanner;

public class ExerciseBooks {
    public static void printPage(){
        System.out.println();
        System.out.println("**********开始菜单*********");
        System.out.println("  1.生成习题               ");
        System.out.println("  2.输出答案               ");
        System.out.println("  3.退出                  ");
        System.out.println("请输入对应编号：");
    }
    public static void printKindOfExercise(){
        System.out.println();
        System.out.println("**********习题类型*********");
        System.out.println("  1.全加法               ");
        System.out.println("  2.全减法               ");
        System.out.println("  3.加减混合              ");
        System.out.println("  4.退出                ");
        System.out.println("请输入对应编号：");
    }

    public static void main(String[] args) {


        while(true){
            printKindOfExercise();
            Exercise exercise = null;
            Scanner scanner = new Scanner(System.in);
            int sc = scanner.nextInt();
            if(sc == 1){
                exercise = new AdditionExercise();
            }
            else if(sc == 2){
                exercise = new SubtractionExercise();
            }
            else if(sc == 3){
                exercise = new AddMixSubExercise();
            }
            else if(sc == 4){
                break;
            }
            else{
                System.out.println("输入无效，请重新输入！");
                continue;
            }
            printPage();
            exercise.createExercise();
            while(true){
                int no = scanner.nextInt();
                if(no == 1){
                    exercise.printExercise();
                    continue;
                }
                if(no == 2){
                    exercise.printAnswers();
                    continue;
                }
                if(no == 3){
                    break;
                }
            }
        }
        System.out.println("您已经退出。");
    }

}
