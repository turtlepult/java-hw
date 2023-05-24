package hw006;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import hw006.notebook.nb;

public class task {
    public static void main(String[] args) {
        List<nb> notebooks = new ArrayList<>();
        notebooks.add(new nb("Hernya", 8, 512, "Windows 10", "Black", 11000));
        notebooks.add(new nb("Ochko", 16, 256, "Windows 10", "Silver", 1200));
        notebooks.add(new nb("Dellete", 8, 256, "Ubuntu", "Black", 800));
        notebooks.add(new nb("Stroydvor", 16, 512, "Windows 10", "Gold", 1500));
        notebooks.add(new nb("Azer", 4, 128, "Windows 10", "Red", 500));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        int filterCriteria = scanner.nextInt();

        Map<String, Object> filterParams = new HashMap<>();
        switch (filterCriteria) {
            case 1:
                System.out.println("Введите минимальный объем ОЗУ:");
                int minRam = scanner.nextInt();
                filterParams.put("ram", minRam);
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД:");
                int minHdd = scanner.nextInt();
                filterParams.put("hdd", minHdd);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.next();
                filterParams.put("os", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.next();
                filterParams.put("color", color);
                break;
            default:
                System.out.println("Некорректный ввод.");
                return;
        }

        scanner.close();

        List<nb> filteredNotebooks = filterNotebooks(notebooks, filterParams);
        if (filteredNotebooks.isEmpty()) {
            System.out.println("Нет ноутбуков, удовлетворяющих заданным критериям.");
        } else {
            System.out.println("Найденные ноутбуки:");
            for (nb notebook : filteredNotebooks) {
                System.out.println(notebook.getBrand() + " - " + notebook.getPrice() + " руб.");
            }
        }
    }

    private static List<nb> filterNotebooks(List<nb> notebooks, Map<String, Object> filterParams) {
        List<nb> filteredNotebooks = new ArrayList<>();
        for (nb notebook : notebooks) {
            boolean passFilter = true;
            for (Map.Entry<String, Object> entry : filterParams.entrySet()) {
                switch (entry.getKey()) {
                    case "ram":
                        if (notebook.getRam() < (int) entry.getValue()) {
                            passFilter = false;
                        }
                        break;
                    case "hdd":
                        if (notebook.getHdd() < (int) entry.getValue()) {
                            passFilter = false;
                        }
                        break;
                    case "os":
                        if (!notebook.getOs().equals(entry.getValue())) {
                            passFilter = false;
                        }
                        break;
                    case "color":
                        if (!notebook.getColor().equals(entry.getValue())) {
                            passFilter = false;
                        }
                        break;
                }
            }
            if (passFilter) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }
}
