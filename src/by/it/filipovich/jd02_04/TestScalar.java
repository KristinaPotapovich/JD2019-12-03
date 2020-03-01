package by.it.filipovich.jd02_04;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestScalar {

    @Test
    public void checkAdd() throws CalcException {
        Parser parser = new Parser();
        VarToFile.load();
        String expression = "A=12+9.6+1";
        double expected = 22.6;
        double actual = Double.parseDouble(parser.calc(expression).toString());
        assertEquals("Test have not been finished successfully",expected,actual,1E-5);
    }

    @Test
    public void checkSub() throws CalcException {
        Parser parser = new Parser();
        VarToFile.load();
        String expression = "B=A-8.1-1";
        double expected = 13.5;
        double actual = Double.parseDouble(parser.calc(expression).toString());
        assertEquals("Test have not been finished successfully",expected,actual,1E-5);

    }

    @Test
    public void checkMul() throws CalcException {
        Parser parser = new Parser();
        VarToFile.load();
        String expression = "C=B*0.3+2-1.1";
        double expected = 4.95;
        double actual = Double.parseDouble(parser.calc(expression).toString());
        assertEquals("Test have not been finished successfully",expected,actual,1E-5);

    }

    @Test
    public void checkDiv() throws CalcException {
        Parser parser = new Parser();
        VarToFile.load();
        String expression = "C1=C/0.1";
        double expected = 49.5;
        double actual = Double.parseDouble(parser.calc(expression).toString());
        assertEquals("Test have not been finished successfully",expected,actual,1E-5);
    }
}
