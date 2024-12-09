import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3_Part2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
        ArrayList<String> goodData = new ArrayList<>();
        String input = String.join("", fileData);

        boolean enabled = true;
        String regex = "mul\\([0-9]+,[0-9]+\\)|do\\(\\)|don't\\(\\)"; // get only the do's, don'ts, and muls
        Matcher m = Pattern.compile(regex).matcher(input);
        while (m.find()) {
            goodData.add(m.group());
        }
        System.out.println(goodData);

        int total = 0;
        for (String item : goodData) {
            if (item.equals("don't()")) {
                enabled = false;
            } else if (item.equals("do()")) {
                enabled = true;
            } else if (enabled) {
                int num1 = Integer.parseInt(item.substring(item.indexOf("(") + 1, item.indexOf(",")));
                int num2 = Integer.parseInt(item.substring(item.indexOf(",") + 1, item.indexOf(")")));
                total += num1 * num2;
            }
        }
        System.out.println(total);

//        regex = "[1-9]+"; // get only the numbers
//        m = Pattern.compile(regex).matcher(goodData.toString());
//        goodData = new ArrayList<>();
//        while (m.find()) {
//            goodData.add(m.group());
//        }
//        System.out.println(goodData);
//        System.out.println("Size: " + goodData.size());
//
//        for (int i = 0; i < goodData.size(); i+=2) {
//            int num1 = Integer.parseInt(goodData.get(i));
//            int num2 = Integer.parseInt(goodData.get(i + 1));
//            total += num1 * num2;
//        }
//        System.out.println(total);
   }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}