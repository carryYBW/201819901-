package oopSystem2;
import oopSystem2.exercise.AddMixSubExercise;
import oopSystem2.exercise.AdditionExercise;
import oopSystem2.exercise.Exercise;
import oopSystem2.exercise.SubtractionExercise;
import java.util.Scanner;

public class Client {
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

    public static void booksWindows(){
        System.out.println();
        System.out.println("*********功能目录**********");
        System.out.println("  1.更新初始题库           ");
        System.out.println("  2.开始答题              ");
        System.out.println("  3.继续答题              ");
        System.out.println("  4.批改习题              ");
        System.out.println("  5.查看批改习题情况       ");
        System.out.println("  6.退出                 ");
        System.out.println("请输入对应编号：");
    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要的您要完成的习题集编号:");
        System.out.println("范围1~10：");
        int sc = scanner.nextInt();
        ExerciseBooks books = new ExerciseBooks(sc);
        books.initBooks();

        booksWindows();
        while(true){
             sc = scanner.nextInt();
            if (sc == 1 ){
                System.out.println("您确定要更新题库吗？Y:1 or N:2");
                sc = scanner.nextInt();
                if(sc == 1){
                    books.Updatequestionbank();
                }else{
                    continue;
                }
            }
            if(sc == 2){
                books.showBooks();
                books.recordAnswer();
            }
            if(sc == 3){
                books.showBooks();
                books.continueDoBooks();
            }
            if(sc == 4){
                books.marking();
            }
            if(sc == 5){
                books.showMarking();

            }
            if(sc == 6){
                break;
            }
        }
        System.out.println("您已成功退出！");





//        ExerciseBooks books =  new ExerciseBooks(1);
////        books.Updatequestionbank();
//    books.initBooks();
////        books.showBooks();
////        books.recordAnswer();
////        books.continueDoBooks();
//        books.marking();
//
//
//        while(true){
//            printKindOfExercise();
//            Exercise exercise = null;
//            Scanner scanner = new Scanner(System.in);
//            int sc = scanner.nextInt();
//            if(sc == 1){
//                exercise = new AdditionExercise();
//            }
//            else if(sc == 2){
//                exercise = new SubtractionExercise();
//            }
//            else if(sc == 3){
//                exercise = new AddMixSubExercise();
//            }
//            else if(sc == 4){
//                break;
//            }
//            else{
//                System.out.println("输入无效，请重新输入！");
//                continue;
//            }
//            printPage();
//            exercise.createExercise();
//            while(true){
//                int no = scanner.nextInt();
//                if(no == 1){
//                    exercise.printExercise();
//                    continue;
//                }
//                if(no == 2){
//                    exercise.printAnswers();
//                    continue;
//                }
//                if(no == 3){
//                    break;
//                }
//            }
//        }
//        System.out.println("您已经退出。");
    }

}
