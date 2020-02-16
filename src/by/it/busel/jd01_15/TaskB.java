package by.it.busel.jd01_15;

import java.io.*;

/**
 * JavaDoc
 */
public class TaskB {

    private static StringBuilder builder = new StringBuilder();

    private static boolean rowToBeDeleted = false;

    public static void main(String[] args) {
        Class<TaskB> taskBClass = TaskB.class;
        readSourceCodeOf(taskBClass);
        writeSourceCodeWithoutComments(taskBClass);
        //the first one-line comment
        // the second one-line comment
    }

    private static void readSourceCodeOf(Class<TaskB> taskBClass) {
        try (BufferedReader reader = new BufferedReader(new FileReader
                (filePathGenerator(taskBClass.getSimpleName() + ".java", taskBClass)))
        ) {
            deletesCommentsWhileReadingFrom(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deletesCommentsWhileReadingFrom(BufferedReader reader) throws IOException {
        String row;
        while ((row = reader.readLine()) != null) {
            if (!rowToBeDeleted) {
                row = cutIfContainsOpeningCommentPart(row);
            } else {
                row = cutIfContainsClosingCommentPart(row);
            }
            builder.append(row).append(!rowToBeDeleted ? '\n' : "");
        }
        rowToBeDeleted = false;
    }

    private static String cutIfContainsOpeningCommentPart(String row) {
        int firstCommentCharPointer;
        if ((firstCommentCharPointer = row.indexOf('/')) != -1) {
            char c = row.charAt(firstCommentCharPointer + 1);
            if (c == '/') {
                rowToBeDeleted = false;
                row = row.substring(0, firstCommentCharPointer);
            } else if (c == '*') {
                rowToBeDeleted = true;
                if (firstCommentCharPointer > 0) builder.append(row, 0, firstCommentCharPointer);
                if (canContainClosingCommentPart(row, firstCommentCharPointer)) {
                    row = cutIfContainsClosingCommentPart(row.substring(firstCommentCharPointer + 2));
                } else row = "";
            }
        }
        return row;
    }

    private static String cutIfContainsClosingCommentPart(String row) {
        int firstCommentCharPointer;
        if ((firstCommentCharPointer = row.indexOf('*')) != -1
                && row.charAt(firstCommentCharPointer + 1) == '/') {
            rowToBeDeleted = false;
            if (canContainClosingCommentPart(row, firstCommentCharPointer)) {
                row = cutIfContainsOpeningCommentPart(row.substring(firstCommentCharPointer + 2));
            } else {
                row = "";
            }
        } else {
            row = "";
        }
        return row;
    }

    private static boolean canContainClosingCommentPart(String row, int firstCommentCharPointer) {
        return row.length() - firstCommentCharPointer >= 4;
    }

    private static void writeSourceCodeWithoutComments(Class<TaskB> taskBClass) {
        try (PrintWriter writer = new PrintWriter(new FileWriter
                (filePathGenerator(taskBClass.getSimpleName() + ".txt", taskBClass)))) {
            writer.print(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*the first multiline comment*/
    private static <T> String filePathGenerator(String fileName, Class<T> classStructure) {
        StringBuilder builder = new StringBuilder();
        String packageName = classStructure.getName().replace(classStructure.getSimpleName(), "")
                .replace(".", File.separator);
        builder.append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append(packageName)
                .append(fileName);
        return builder.toString();
    }
    /*
    the second multiline comment
     */
}
