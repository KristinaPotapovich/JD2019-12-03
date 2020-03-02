package by.it.filipovich.jd01_14;



public class TaskA {

    public static void main(String[] args) {

        String fileNameOne = Helper.pathToFile("dataTaskA.bin", TaskA.class);
        String fileNameTwo = Helper.pathToFile("resultTaskA.txt", TaskA.class);
        Helper.insertNumbers(fileNameOne);
        Helper.readAndWrite(fileNameOne,fileNameTwo);
    }
}
