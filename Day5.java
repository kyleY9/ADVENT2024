import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        System.out.println(fileData);
        int total = 0;
        ArrayList<String> rules = new ArrayList<>();
        ArrayList<String> lists = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).contains("|")) {
                rules.add(fileData.get(i));
            } else {
                lists.add(fileData.get(i));
            }
        }

        for (int i = 0; i < lists.size(); i++) {
            ArrayList<Integer> myList = new ArrayList<>();
            for (String rule: rules) {
                String numOne = rule.split("|")[0];
                String numTwo = rule.split("|")[1];
                if (lists.get(i).contains(numOne) && lists.get(i).contains(numTwo)) {
                    myList = new ArrayList<>();
                     String[] temp = lists.get(i).split(",");
                     for (String str : temp) {
                         myList.add(Integer.parseInt(str));
                     }

                     int index1 = myList.indexOf(Integer.parseInt(numOne));
                     int index2 = myList.indexOf(Integer.parseInt(numTwo));

                     if (index2 < index1) {
                         myList.remove(index2);
                         myList.add(index2, Integer.parseInt(numOne));
                         myList.remove(index1);
                         myList.add(index1, Integer.parseInt(numTwo));
                     }
                }
            }
            System.out.println(myList);
            System.out.println(myList.get(myList.size() / 2));
            total += myList.get(myList.size() / 2);
        }
        System.out.println(total);
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