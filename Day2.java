
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Sample.txt");
        System.out.println(fileData);

        // Code goes here!
        // Notes: Report must be either all inc or all dec. Difference between numbers may not exceed 3
        int safeReports = 0;
        for (String report : fileData) {
            String[] arr = report.split(" ");
            ArrayList<Integer> differenceList = new ArrayList<Integer>();
            for (int i = 1; i < arr.length; i++) {
                differenceList.add(Integer.parseInt(arr[i]) - Integer.parseInt(arr[i - 1]));
            }

            int incNums = 0;
            int decNums = 0;
            boolean strictInc = false;
            boolean strictDec= false;
            int numExcused = 0; // max one

            for (int i = 0; i < differenceList.size(); i++) {
                if (differenceList.get(i) > 0 && differenceList.get(i) <= 3) {
                    incNums++;
                } else if (differenceList.get(i) < 0 && Math.abs(differenceList.get(i)) <= 3) {
                    decNums++;
                }
            }

            System.out.print("Difference List Size: "  + differenceList.size() + " ");

            if (incNums == differenceList.size()) {
                strictInc = true;
            } else if (decNums == differenceList.size()) {
                strictDec = true;
            }

            for (int i = 0; i < differenceList.size(); i++) {
                if (strictInc) {
                    if ((differenceList.get(i) < 1 || differenceList.get(i) > 3) && numExcused == 0) {
                        differenceList.remove(i);
                        numExcused++;
                        i--;
                    }
                } else if (strictDec) {
                    if ((differenceList.get(i) > 1 || differenceList.get(i) > 3) && numExcused == 0) {
                        differenceList.remove(i);
                        numExcused++;
                        i--;
                    }
                }
            }

            System.out.print("Difference List Size: "  + differenceList.size() + " ");
            incNums = 0;
            decNums = 0;

            for (int i = 0; i < differenceList.size(); i++) {
                if (differenceList.get(i) > 0 && differenceList.get(i) <= 3) {
                    incNums++;
                } else if (differenceList.get(i) < 0 && Math.abs(differenceList.get(i)) <= 3) {
                    decNums++;
                }
            }

            System.out.print("Inc Nums = " + incNums + " ");
            System.out.print("Dec Nums = " + decNums + "\n");
            // If the amt of inc nums or the amt of dec nums equals the amount of nums in the list, then the report is SAFE!!!
            if (incNums >= differenceList.size() - 1  || decNums >= differenceList.size() - 1) {
                safeReports++;
            }
        }
        System.out.println(safeReports);

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


/*
fun 1:
[0,1,2,3, 5, 1, 5]
fun 2: [0,1,2,3,-1,5]
 */