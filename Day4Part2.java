import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4Part2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Sample.txt");

        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
            }
        }
        System.out.println("Num Hor: " + horizontal(grid));
        System.out.println("Num Ver: " + vertical(grid));
        System.out.println("Num Diagonals: " + diagonal(grid));
        System.out.println("Total Matches: " + (horizontal(grid) + vertical(grid) + diagonal(grid)));

        // "grid" represents a 2D array of Strings built from the input file

    }

    public static int horizontal(String[][] grid) {
        int matches = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c].equals("X")) {
                    if (c + 3 < grid[0].length && grid[r][c + 1].equals("M")) { // horizontal right
                        if (grid[r][c + 2].equals("A")) {
                            if (grid[r][c + 3].equals("S")) {
                                matches++;
                            }
                        }
                    }
                    if (c - 3 >= 0 && grid[r][c - 1].equals("M")) { // horizontal left
                        if (grid[r][c - 2].equals("A")) {
                            if (grid[r][c - 3].equals("S")) {
                                matches++;
                            }
                        }
                    }
                }
            }
        }
        return matches;
    }

    public static int vertical(String[][] grid) {
        int matches = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c].equals("X")) {
                    if (r + 3 < grid.length && grid[r + 1][c].equals("M")) { // vertical down
                        if (grid[r + 2][c].equals("A")) {
                            if (grid[r + 3][c].equals("S")) {
                                matches++;
                            }
                        }
                    }
                    if (r - 3 >= 0 && grid[r - 1][c].equals("M")) { // vertical up
                        if (grid[r - 2][c].equals("A")) {
                            if (grid[r - 3][c].equals("S")) {
                                matches++;
                            }
                        }
                    }
                }
            }
        }
        return matches;
    }

    public static int diagonal(String[][] grid) {
        int matches = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c].equals("M") ) {
                    if (r + 2 < grid.length && c + 2 < grid[0].length && grid[r + 1][c + 1].equals("A")) {  // downward slant right
                        if (grid[r + 2][c + 2].equals("S")) {
                            matches++;
                        }
                    }
                    if (r + 2 < grid.length && c - 2 >= 0 && grid[r + 1][c - 1].equals("A")) {  // downward slant left
                        if (grid[r + 2][c - 2].equals("S")) {
                            matches++;
                        }
                    }
                    if (r - 2 >= 0 && c + 2 < grid[0].length && grid[r - 1][c + 1].equals("A")) {  // upward slant right
                        if (grid[r - 2][c + 2].equals("S")) {
                            matches++;
                        }
                    }
                    if (r - 2 >= 0 && c - 2 >= 0 && grid[r - 1][c - 1].equals("A")) {  // upward slant left
                        if (grid[r - 2][c - 2].equals("S")) {
                            matches++;
                        }
                    }
                }
            }
        }
        return matches;
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