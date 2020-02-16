package by.it.popkov.jd01_13;


import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (true) {
            try {
                String row = scanner.nextLine();
                if (row.equals("END")) break;
                int num = (int) Double.parseDouble(row);
                sum = sum + num;
                double sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt)) {
                    throw new ArithmeticException();
                }
                System.out.println("Num=" + num + " sqrt of sum=" + sqrt);

            } catch (NumberFormatException | NullPointerException | ArithmeticException e) {
                UseFull.printException(e, TaskB.class.getName());
            }
        }
    }
}
