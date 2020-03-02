package by.it.busel.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get(currentFilePathGenerator());
        pathPrinterAsWindowsCMD(path);
        try {
            primitiveCmdEmulator(scanner, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T> String currentFilePathGenerator() {
        StringBuilder builder = new StringBuilder();
        String packageName = TaskC.class.getName().replace(TaskC.class.getSimpleName(), "")
                .replace(".", File.separator);
        builder.append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append(packageName);
        return builder.toString();
    }

    private static void pathPrinterAsWindowsCMD(Path path) {
        System.out.print(path.toString() + ">");
    }

    private static void primitiveCmdEmulator(Scanner scanner, Path path) throws IOException {
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("end")) {
                break;
            } else if (command.substring(0, 2).equals("cd")) {
                path = cdCmdProcess(path, command);
            } else if (command.equals(DIR_CMD)) {
                directoryAttributesPrinter(path);
            } else {
                System.out.printf("'%s' %s%n", command, NOT_RECOGNIZED_COMMAND);
            }
            pathPrinterAsWindowsCMD(path);
        }
    }

    private static Path cdCmdProcess(Path path, String command) {
        command = command.substring(2, command.length()).trim();
        if (command.equals(CD_TO_ROOT)) path = path.getRoot();
        else if (command.equals((CD_TO_PARENT)))
            path = path.getParent();
        else {
            Path resolve = path.resolve(command);
            if (Files.exists(resolve, LinkOption.NOFOLLOW_LINKS)) path = resolve;
        }
        return path;
    }

    private static void directoryAttributesPrinter(Path path) throws IOException {
        FileStore fileStore = Files.getFileStore(path);
        headerDirCmdPrinter(path, fileStore);
        int fileCounter = 0;
        long generalFileSize = 0;
        int elementCounter = bodyDirCmdPrinterAndCounter(path, fileCounter, generalFileSize);
        System.out.printf("%27s File(s)%12s bytes%n", fileCounter, generalFileSize);
        System.out.printf("%27s Dir(s)%13s bytes free%n%n", elementCounter - fileCounter, fileStore.getUsableSpace());
    }

    private static void headerDirCmdPrinter(Path path, FileStore fileStore) throws IOException {
        String volumeName = fileStore.name();
        String volumeSerialNumber = fileStore.getAttribute("volume:vsn").toString();
        String currentDirectory = path.toString();
        if (volumeName.length() > 0)
            System.out.printf(" Volume in drive %s is %s%n", currentDirectory.charAt(0), volumeName);
        else System.out.printf(" Volume in drive %s has no label%n", currentDirectory.charAt(0));
        System.out.printf(" Volume Serial Number is %s%n%n", volumeSerialNumber);
        System.out.printf(" Directory of %s%n%n", currentDirectory);
    }

    private static int bodyDirCmdPrinterAndCounter(Path path, int fileCounter, long generalFileSize) throws IOException {
        int elementsCounter = 0;
        for (Path element : Files.newDirectoryStream(path)) {
            elementsCounter++;
            BasicFileAttributes attributes = Files.readAttributes(element, BasicFileAttributes.class);
            generalFileSize += attributes.size();
            boolean isDirectory;
            if (!(isDirectory = attributes.isDirectory())) fileCounter++;
            System.out.printf("%s %8s %10s %s%n",
                    attributes.lastModifiedTime(),
                    isDirectory ? "<DIR>" : "",
                    isDirectory ? "" : attributes.size(),
                    element.getFileName());
        }
        return elementsCounter;
    }

    private static final String NOT_RECOGNIZED_COMMAND =
            "is not recognized as an internal or external command,\noperable program or batch file";

    private static final String CD_TO_ROOT = "\\";

    private static final String CD_TO_PARENT = "..";

    private static final String DIR_CMD = "dir";
}

