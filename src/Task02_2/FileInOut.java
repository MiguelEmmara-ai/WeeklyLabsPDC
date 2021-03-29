package WeeklyTasks.Task02_2;

import java.io.*;

/**
 * <h1>Task 2.2 File I/O</h1>
 * Copy all the letters from T02_input.txt to T02_output.txt
 * Reverse the letters' order in each line
 * Convert all letters to uppercase
 *
 * @author  Miguel Emmara - 18022146
 * @version 1.0
 * @since   09-03-2021
 */

public class FileInOut {
    // Static fields in order to easily change the directory
    public static final String filePath = "./resources/T02_input.txt";
    public static final String fileOutputPath = "./resources/T02_output.txt";

    public static void main(String[] args) throws IOException {
        System.out.println("Read File " + filePath);
        readFile(filePath);

        System.out.println("\n\nRead File Output " + fileOutputPath);
        writeFile();
        readFile(fileOutputPath);
    }

    /**
     * This method is used to writeFile.
     */
    private static void writeFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            String line = bufferedReader.readLine();

            do {
                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < line.length(); i++) {
                    if (Character.isLetter(line.charAt(i))) {
                        stringBuilder.append(line.charAt(i));
                    }
                }

                // Reverse the text
                stringBuilder.reverse();
                stringBuilder.append("\n");

                String readText = stringBuilder.toString();

                PrintWriter outputStream;
                try {
                    // Append to the file, rather than override
                    outputStream = new PrintWriter(new FileOutputStream(fileOutputPath, true));

                    outputStream.append(readText.toUpperCase());

                    outputStream.close();

                } catch (FileNotFoundException e) {
                    System.out.println("Error opening the file out.txt." + e.getMessage());
                }

                line = bufferedReader.readLine();

            } while (line != null);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            System.err.println("IOException Error: " + ex.getMessage());
        }
    }

    /**
     * This method is used to writeFile.
     * @param path this is the location to the directory
     */
    private static void readFile(String path) throws IOException {
        int Char;

        // File Validation
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.out.println("File not found, make sure you place the file inside the correct directory");
        }

        // Travers through the file
        while (true) {
            assert fileReader != null;
            if ((Char = fileReader.read()) == -1) break;
            System.out.print((char) Char);
        }
    }
}