package by.it.plugatar.calc;

import java.io.*;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) throws CalcException, IOException {
        String line;
        Scanner scan = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        LogFile log = null;
        log = new LogFile();
        VarFile.load();
        while (true) {
            line = scan.next();
            if (line.equals("end")) {
                log.close();
                break;
            }
            Var result = null;
            try {
                result = parser.calc(line);//Var
                //printer.print(result);
                if (result != null) printer.print(result);
            } catch (CalcException e) {
                // e.printStackTrace();
                System.out.println(e.getMessage());
                log.print(e.getMessage());
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
    }
}
