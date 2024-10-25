import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

class EchoOdds {

    /**
     * reads a file of line seperated integers and writes only the odds out.
     * @param fileName the file you want to read from
     */
    static void echoOdds(String fileName) {
        String outFN = fileName.substring(0,fileName.lastIndexOf('.')) + "out";
        try(Scanner s = new Scanner(new File(fileName));
            PrintWriter w = new PrintWriter(new FileWriter(outFN))){
            while (s.hasNextLine()){
                String nl = s.nextLine();
                try{
                    int num = Integer.parseInt(nl);
                    if (num % 2 != 0) {
                        w.println(num);
                    }
                }
                catch (NumberFormatException e) {
                    Files.delete(Path.of(outFN));
                    throw new InputMismatchException("input contains a non-integer value");
                }
            }
        }
        catch(IOException e){
            System.err.println("An error occurred while reading or writing: " + e.getMessage());
        }
    }
}

