package by.it.filipovich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        TaskA taskA = new TaskA();
        try {
            if(Math.random()>0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (NumberFormatException | NullPointerException e){
            Helper.printException(e,taskA);
        }
    }
}
