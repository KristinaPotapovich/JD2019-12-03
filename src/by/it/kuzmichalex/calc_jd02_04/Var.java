package by.it.kuzmichalex.calc_jd02_04;


import java.io.*;
import java.util.*;

abstract class Var implements Operation {
    /*
     * array for mapping
     * Key - Var name
     * Value - Var value
     * */
    private static Map<String, Var> mapVars = new HashMap<>();

    public static Var getCreatedVar(String expression) throws CalcException {
        Var returnVar = mapVars.get(expression);
        if (returnVar == null) throw new CalcException("Undefined variable: " + expression);
        return returnVar;
    }

    /**
     * override Object.toString method
     */
    @Override
    public String toString() {
        return ("abstract class Var");
    }

    /*
      Create Var from expression
      1.12 Scalar
      {1.23, 4.56} Vector
      {{1.23, 4.56},{7.89, 10.1112}} matrix

      @param strExperession - Строковое выражение с переменной типа Scalar Vector или Matrix
     *                       Имена quit, exit, end, printvar, sortvar не разрешаются!
     * @return Var
     */
   /* static Var createVar(String strExperession) throws CalcException {

        if (strExperession.matches(Patterns.SCALAR))
            return new Scalar(strExperession);
        else if (strExperession.matches(Patterns.VECTOR))
            return new Vector(strExperession);
        else if (strExperession.matches(Patterns.MATRIX))
            return new Matrix(strExperession);
        else if (strExperession.matches(Patterns.VARNAME)) {
            Var returnVar = mapVars.get(strExperession);
            if (returnVar == null) throw new CalcException("Undefined variable: " + strExperession);
            return returnVar;
        } else {
            if (strExperession.length() == 0) throw new CalcException("Empty right part");
            throw new CalcException("Expression " + strExperession + " contains madness.");
        }
    }*/

    /**
     * convert all Vars to String
     *
     * @return String like VarName=Value\n
     */
    static String printVars() {
        StringBuilder retValue = new StringBuilder();
        if (mapVars.isEmpty()) return ("No Vars defined");
        Set<Map.Entry<String, Var>> entries = mapVars.entrySet();
        for (Map.Entry<String, Var> varMapValue : entries) {
            retValue.append(varMapValue.getKey()).append("=");
            retValue.append(varMapValue.getValue().toString());
            retValue.append('\n');
        }
        return retValue.toString();
    }

    /**
     * convert all Vars to String witch sorting by key
     *
     * @return String like VarName=Value\n
     */
    static String sortVars() {
        StringBuilder retValue = new StringBuilder();
        if (mapVars.isEmpty()) return ("No Vars defined");
        TreeMap<String, Var> sortedVars = new TreeMap<>(mapVars);
        Set<Map.Entry<String, Var>> entries = sortedVars.entrySet();
        for (Map.Entry<String, Var> nextSorted : entries) {
            retValue.append(nextSorted.getKey()).append("=").append(nextSorted.getValue().toString()).append('\n');
        }
        return retValue.toString();
    }

    /**
     *
     */
    static void saveVarToFile() {
        String sFileName = FHelper.getFileName("vars.txt", Var.class);
        try (PrintWriter pw = new PrintWriter(new FileWriter(sFileName))
        ) {
            String sVars = sortVars();
            pw.print(sVars);
        } catch (IOException e) {
            Logger.printAndLog("Error saving vars to file " + sFileName);
        }
    }

    static void loadVarsFromFile() {
        String sFileName = FHelper.getFileName("vars.txt", Var.class);
        Parser tmpParser = new Parser();
        try (BufferedReader br = new BufferedReader(new FileReader(sFileName))) {
            while (true) {
                String readedString = br.readLine();
                if(readedString==null)break;
                Logger.printAndLog("Execute expression from file: " + readedString);
                tmpParser.calc(readedString);
            }
        } catch (IOException e) {
            Logger.printAndLog("Error reading saved vars from file " + sFileName);
        } catch (CalcException e) {
            Logger.printAndLog("Error parsing saved vars " + e.getMessage());
        }

    }


    /////////// Methods for add operation
    @Override
    public Var add(Var rightOperand) throws CalcException {
        //System.out.println("Var.add var" + rightOperand);
        return null;
    }

    public Var add(Scalar leftOperand) throws CalcException {
        throw new CalcException("Operation " + leftOperand + " + " + this + " inpossible");
        //System.out.println("Var.add Scalar " + leftOperand + " + " + this + " Не существует");
        //return null;
    }

    public Var add(Vector leftOperand) throws CalcException {
        throw new CalcException("Operation " + leftOperand + " + " + this + " impossible");
        //System.out.println("Var.add Vector " + leftOperand + " + " + this + " Не существует");
        //return null;
    }

    public Var add(Matrix leftOperand) throws CalcException {
        throw new CalcException("Operation " + leftOperand + " + " + this + " impossible");
        //System.out.println("Var.add Matrix " + leftOperand + " + " + this + " Не существует");
        //return null;
    }

    /////////// Methods for sub operation
    @Override
    public Var sub(Var rightOperand) throws CalcException {
        throw new CalcException("Operation " + this + " - " + rightOperand + " impossible");
        //System.out.println("Var.add var" + rightOperand);
        //return null;
    }

    public Var sub(Scalar leftOperand) throws CalcException {
        throw new CalcException("Operation " + leftOperand + " - " + this + " impossible");
        //System.out.println("Var.add Scalar " + leftOperand + " - " + this + " Не существует");
        //return null;
    }

    public Var sub(Vector leftOperand) throws CalcException {
        throw new CalcException("Operation " + leftOperand + " - " + this + " impossible");
        //System.out.println("Var.add Vector " + leftOperand + " - " + this + " Не существует");
        //return null;
    }

    public Var sub(Matrix leftOperand) throws CalcException {
        throw new CalcException("Operation " + leftOperand + " - " + this + " impossible");
        //System.out.println("Var.add Matrix " + leftOperand + " - " + this + " Не существует");
        //return null;
    }

    /////////// Methods for mul operation
    @Override
    public Var mul(Var rightOperand) throws CalcException {
        //System.out.println("Var.mul var" + rightOperand);
        return null;
    }

    public Var mul(Scalar leftOperand) throws CalcException {
        throw new CalcException("Operation " + leftOperand + " * " + this + " impossible");
        //System.out.println("Var.mul Scalar " + leftOperand + " * " + this + " Не существует");
        //return null;
    }

    public Var mul(Vector leftOperand) throws CalcException {
        throw new CalcException("Operation " + leftOperand + " * " + this + " impossible");
        //System.out.println("Var.mul Vector " + leftOperand + " * " + this + " Не существует");
        //return null;
    }

    public Var mul(Matrix leftOperand) throws CalcException {
        throw new CalcException("Operation " + leftOperand + " * " + this + " impossible");
        //System.out.println("Var.mul Matrix " + leftOperand + " * " + this + " Не существует");
        //return null;
    }

    /////////// Methods for div operation
    @Override
    public Var div(Var rightOperand) throws CalcException {
        //System.out.println("Var.div var" + rightOperand);
        return null;
    }

    public Var div(Scalar leftOperand) throws CalcException {
        throw new CalcException("Operation " + leftOperand + " / " + this + " impossible");
/*        System.out.println("Var.div Scalar " + leftOperand + " / " + this + " Не существует");
        return null;*/
    }

    public Var div(Vector leftOperand) throws CalcException {
        throw new CalcException("Operation " + leftOperand + " / " + this + " impossible");
        /*
        System.out.println("Var.div Vector " + leftOperand + " / " + this + " Не существует");
        return null;
*/
    }

    public Var div(Matrix leftOperand) throws CalcException {
        throw new CalcException("Operation " + leftOperand + " / " + this + " impossible");
/*
        System.out.println("Var.div Matrix " + leftOperand + " / " + this + " Не существует");
        return null;*/
    }

    /**
     * save Var and value into HashMap mapVars
     *
     * @param key - var name. A, B, counter, superPuperVar etc
     */
    static void save(String key, Var value) throws CalcException {
        if (!key.matches(Patterns.VARNAME)) throw new CalcException("Invalid variable name: " + key);
        if (KeyWords.isKeyWord(key))
            throw new CalcException("Invalid variable name. Please don't use keywords: " + KeyWords.ALLKEYWORDS);
        mapVars.put(key, value);
        saveVarToFile();
    }
}
