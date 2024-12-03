
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
            boolean safe = true;
            for (int i = 1; i < arr.length; i++) {
                safe = true;
                if (Integer.parseInt(arr[i]) > Integer.parseInt(arr[i - 1]) && (Integer.parseInt(arr[i]) < Integer.parseInt(arr[i - 1])  && (Math.abs((Integer.parseInt(arr[i]) - Integer.parseInt(arr[i - 1]))) <= 3))) {
                    safe = false;
                }
            }

            if (safe) {
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