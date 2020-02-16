package by.it.kuzmichalex.jd01_15;
/*
ыыыыыыыыыыыыыы
ляляляляляляля
*/

import java.io.*;

//Коммент для тестирования самоедтва кода
public class TaskB {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        String sFileName = FHelper.getFileName("TaskB.java", TaskB.class);
        readText(sFileName);
        saveText(FHelper.getFileName("TaskB.txt", TaskB.class));
        System.out.println(result);
    }

    /**
     * Save text to file
     * @param sFileName file name
     * */
    private static void saveText(String sFileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(sFileName))
        ) {
            pw.printf("%3s ", result);
        } catch (IOException e) {
            System.out.println("Output error. File:" + sFileName);
        }
    }

    /**
     * коммент для тестирования самоедства кода
     */
    private static void readText(String sFileName/*дадада. Тут - тоже*/) {
        try (BufferedReader br = new BufferedReader(new FileReader(sFileName))) {
            int currByte;
            int prevByte = -1;   //Ещё коммент.
            int state = 0;
            while ((currByte = br.read()) != -1) {
                switch (state) {
                    case 0:  //Ожидание комментария
                        if ((prevByte == '/') && (currByte == '/')) state = 1;
                        if ((prevByte == '/') && (currByte == '*')) state = 2;
                        break;
                    case 1: //Ожинание окончания однострочного комментария
                        if ((prevByte == 13) || (currByte == 10)) state = 0;
                        break;
                    case 2: //Ожидание окончания многострочного комментария
                        if ((prevByte == '*') && (currByte == '/')) {
                            state = 0;
                            currByte = -1;
                            prevByte = -1;
                        }
                        break;
                }
                if ((state == 0) && (prevByte != -1)) result.append((char) prevByte);
                prevByte = currByte;
            }
            if ((state == 0) && (prevByte != -1)) result.append((char) prevByte);
        } catch (IOException e) {
            System.out.println("Error reading file:" + sFileName);
        }
    }
}