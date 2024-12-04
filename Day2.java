
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
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
            for (int difference: differenceList) {
                if (difference > 0 && difference <= 3) {
                    incNums++;
                } else if (difference < 0 && Math.abs(difference) <= 3) {
                    decNums++;
                }

                // If the amt of inc nums or the amt of dec nums equals the amount of nums in the list, then the report is SAFE!!!
                if (incNums == differenceList.size() || decNums == differenceList.size()) {
                    safeReports++;
                }
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
