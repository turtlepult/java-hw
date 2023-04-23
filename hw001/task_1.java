//Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        
        Scanner input_n = new Scanner(System.in);
        System.out.println("Введите значение n: ");
        String val_n = input_n.nextLine();
        int n = Integer.parseInt(val_n);
        int sum = 0;
        int fac = 1;
        for(int i = 1; i <= n; i++){
            sum+=i;
            fac*=i;
        }
        System.out.println(sum);
        System.out.println(fac);
    }
}
