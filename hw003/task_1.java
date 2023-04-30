package hw003;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task_1 {
    public static void main(String[] args) {
        var main_list = getRList(10, 0, 10);
        System.out.println(main_list.toString());
        main_list.removeIf((item) -> {
            return item%2==0;
        });
        System.out.println(main_list.toString());
    }
    
    public static List<Integer> getRList (Integer n, Integer from, Integer to){
        List<Integer> main_list = new ArrayList<Integer>();
        Random r = new Random();
        for(int i = 0; i<n; i++){
            main_list.add(r.nextInt(from, to + 1));
        }
        return main_list;
    }
}
