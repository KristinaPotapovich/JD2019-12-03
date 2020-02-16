package by.it.kuzmichalex.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {

        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("Привет");
        }
        catch (NullPointerException | NumberFormatException e){
            StringBuilder outErr = new StringBuilder();
            outErr.append(e.getClass());
            ErrorHandler.processErr(e);
        }

    }



}
