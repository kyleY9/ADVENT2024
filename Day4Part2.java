import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4Part2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day4Input.txt");

        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
            }
        }
        System.out.println("Total Matches: " + (diagonal(grid)));

        // "grid" represents a 2D array of Strings built from the input file

    }

    public static int diagonal(String[][] grid) {
        int matches = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c].equals("A") ) {
                    if (r - 1 >= 0 && c - 1 >= 0 && grid[r - 1][c - 1].equals("M")) {
                        if (r + 1 < grid.length && c + 1 < grid[0].length && grid[r + 1][c + 1].equals("S")) {
                            if (grid[r - 1][c + 1].equals("M")) {
                                if (grid[r + 1][c - 1].equals("S")) {
                                    matches++;
                                }
                            } else if (grid[r - 1][c + 1].equals("S")) {
                                if (grid[r + 1][c - 1].equals("M")) {
                                    matches++;
                                }
                            }
                        }
                    } else if (r - 1 >= 0 && c - 1 >= 0 && grid[r - 1][c - 1].equals("S")) {
                        if (r + 1 < grid.length && c + 1 < grid[0].length && grid[r + 1][c + 1].equals("M")) {
                            if (grid[r - 1][c + 1].equals("M")) {
                                if (grid[r + 1][c - 1].equals("S")) {
                                    matches++;
                                }
                            } else if (grid[r - 1][c + 1].equals("S")) {
                                if (grid[r + 1][c - 1].equals("M")) {
                                    matches++;
                                }
                            }
                        }
                    }





//                    if (r + 2 < grid.length && c - 2 >= 0 && grid[r + 1][c - 1].equals("A")) {  // downward slant left
//                        if (grid[r + 2][c - 2].equals("S")) {
//                            matches++;
//                        }
//                    }
//                    if (r - 2 >= 0 && c + 2 < grid[0].length && grid[r - 1][c + 1].equals("A")) {  // upward slant right
//                        if (grid[r - 2][c + 2].equals("S")) {
//                            matches++;
//                        }
//                    }
//                    if (r - 2 >= 0 && c - 2 >= 0 && grid[r - 1][c - 1].equals("A")) {  // upward slant left
//                        if (grid[r - 2][c - 2].equals("S")) {
//                            matches++;
//                        }
//                    }
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