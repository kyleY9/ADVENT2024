import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day5_Part2 {
    private static ArrayList<String> rules;
    private static int ruleNumber = 0;

    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/MySample.txt");
        int total = 0;
        rules = new ArrayList<>();
        ArrayList<String> lists = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).contains("|")) {
                rules.add(fileData.get(i));
            } else {
                lists.add(fileData.get(i));
            }
        }
        for (String list : lists) {
            ArrayList<Integer> myList = new ArrayList<>();
            boolean safe = true;
            String[] temp = list.split(",");
            for (String str : temp) {
                myList.add(Integer.parseInt(str));
            }
            for (int i = 0; i < rules.size(); i++) {
                ruleNumber = i;
                String numOne = rules.get(i).split("\\|")[0];
                String numTwo = rules.get(i).split("\\|")[1];
                if (list.contains(numOne) && list.contains(numTwo)) {
                    int index1 = myList.indexOf(Integer.parseInt(numOne));
                    int index2 = myList.indexOf(Integer.parseInt(numTwo));
                    System.out.println("CALL TO CHANGE ORDER --------------");
                    System.out.println("Original Arr: " + myList);
                    if (index1 > index2) {
                        safe = false;
                        System.out.println(rules.get(i));
                        myList = changeOrder(myList, myList.get(index1));
                    }
                }
            }
            if (!safe) {
                System.out.println(myList + "---------My List");
                System.out.println(myList.get(myList.size() / 2));
                total += myList.get(myList.size() / 2);
            }
        }
        System.out.println("Total: " + total);
    }

    public static ArrayList<Integer> changeOrder(ArrayList<Integer> arr, int switchNum) {
        ArrayList<Integer> correctArr = new ArrayList<Integer>();
        for (int i = 0; i < arr.size(); i++) {
            boolean violatesRule = false;
            System.out.println("Arr before removal: " + arr);
            arr.remove(arr.indexOf(switchNum));
            arr.add(i, switchNum);
            for (int k = 0; k <= ruleNumber; k++) {
                String numOne = rules.get(k).split("\\|")[0];
                String numTwo = rules.get(k).split("\\|")[1];
                if (arr.contains(Integer.parseInt(numOne)) && arr.contains(Integer.parseInt(numTwo))) {
                    int index1 = arr.indexOf(Integer.parseInt(numOne));
                    int index2 = arr.indexOf(Integer.parseInt(numTwo));
                    System.out.println("Array after Removal: " + arr);
                    System.out.println(rules.get(k));
                    System.out.println("Index #1: " + index1);
                    System.out.println("Index #2: " + index2);
                    if (index1 > index2) {
                        System.out.println("Index " + i + " violates!");
                        violatesRule = true;
                    } else {
                        System.out.println("No violation here!");
                        correctArr = arr;
                    }
                }
            }
            if (!violatesRule) {
                System.out.println("Correct Array: " + correctArr);
                return correctArr;
            }
        }
        return correctArr;
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