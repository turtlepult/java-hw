package hw002;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
public class task_2 {
    public static void main(String[] args) {
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/hw002/file.txt");
            File file = new File(pathFile);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(parseLine(line));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String parseLine(String line) {
        Pattern pattern = Pattern.compile("\"фамилия\":\"(.*?)\",\"оценка\":\"(.*?)\",\"предмет\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            String lastName = matcher.group(1);
            String grade = matcher.group(2);
            String subject = matcher.group(3);

            StringBuilder sb = new StringBuilder();
            sb.append("Студент ").append(lastName)
                    .append(" получил ").append(grade)
                    .append(" по предмету ").append(subject);
            return sb.toString();
        } else {
            return "Не удалось распарсить строку.";
        }
    }
}
    
