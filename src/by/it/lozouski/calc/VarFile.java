package by.it.lozouski.calc;

import by.it.lozouski.jd01_14.Helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

class VarFile extends Helper {

    private static String varFile = Helper.getPath("vars.txt", VarFile.class);

    public static String getVarFile() {
        return varFile;
    }


    static void load(Parser parser) throws IOException {
        Files.lines(Paths.get(varFile)).forEach(expression -> {
            try {
                parser.calculate(expression);
                Logging.logFileRecord(expression + " variable stored in file 'vars.txt'");
            } catch (CalcException e) {
                e.printStackTrace();
            }
        });
    }

    static void save(Map<String, Var> vars) throws CalcException {
        try (PrintWriter printWriter = new PrintWriter(varFile)) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                printWriter.printf("%s=%s\n", entry.getKey(), entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new CalcException("error " + varFile);
        }
    }
}
