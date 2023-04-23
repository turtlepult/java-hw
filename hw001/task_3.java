import java.util.Scanner;
//Реализовать простой калькулятор
public class task_3 {
    public static void main(String[] args) {
        Scanner inpu = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        String val1 = inpu.nextLine();
        int num1 = Integer.parseInt(val1);
        System.out.println("Введите операцию:  ");
        String oper = inpu.nextLine();
        System.out.println("Введите первое число: ");
        String val2 = inpu.nextLine();
        int num2 = Integer.parseInt(val2);
        
        switch (oper) {
            case "+":
                System.out.println(num1+num2);
                break;
            case "-":
                System.out.println(num1-num2);
                break;
            case "*":
                System.out.println(num1*num2);
                break;
            case "/":
                if(num2==0){
                    System.out.println("на 0 делить нельзя!!!");
                    break;
                }else{System.out.println(num1/num2);}
                break;
        }
    }
}
