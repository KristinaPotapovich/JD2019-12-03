package by.it.popkov.calc;

import org.junit.*;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser = new Parser();

    /**
     * TEST SCALAR
     **/

    @Test
    public void a1() {
        System.out.println("Test A=2+5.3");
        try {
            Var calc = parser.calc("A=2+5.3");
            assertEquals("Wrong result for A=2+5.3", "7.3", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a2() {
        System.out.println("Test B=A*3.5");
        try {
            Var calc = parser.calc("B=A*3.5");
            assertEquals("Wrong result for B=A*3.5", "25.55", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a3() {
        System.out.println("Test B1=B+0.11*-5");
        try {
            Var calc = parser.calc("B1=B+0.11*-5");
            assertEquals("Wrong result for B1=B+0.11*-5", "25.0", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void a4() {
        System.out.println("Test B2=A/2-1");
        try {
            Var calc = parser.calc("B2=A/2-1");
            assertEquals("Wrong result for B2=A/2-1", "2.65", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    /**
     * TEST VECTOR
     **/
    @Test
    public void vectorAddScalarForTaskB() {
        System.out.println("Test {2, 3} + 2");
        try {
            Var calc = parser.calc("{2, 3} + 2");
            assertEquals("Wrong result for {2, 3} + 2", "{4.0, 5.0}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorAddVectorForTaskB() {
        System.out.println("Test {0, 1}+{2, 3}");
        try {
            Var calc = parser.calc("{0, 1}+{2, 3}");
            assertEquals("Wrong result for {0, 1}+{2, 3}", "{2.0, 4.0}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorSubScalarForTaskB() {
        System.out.println("Test {2, 3} - 2");
        try {
            Var calc = parser.calc("{2, 3} - 2");
            assertEquals("Wrong result for {2, 3} - 2", "{0.0, 1.0}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorSubVectorForTaskB() {
        System.out.println("Test {0, 1} - {2, 3}");
        try {
            Var calc = parser.calc("{0, 1} - {2, 3}");
            assertEquals("Wrong result for {0, 1} - {2, 3}", "{-2.0, -2.0}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorMulScalarForTaskB() {
        System.out.println("Test {{0, 1}, {2, 3}} * 3");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} * 3");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} * 3", "{{0.0, 3.0}, {6.0, 9.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorMulVectorForTaskB() {
        System.out.println("Test {0, 1} * {2, 3}");
        try {
            Var calc = parser.calc("{0, 1} * {2, 3}");
            assertEquals("Wrong result for {0, 1} * {2, 3}", "3.0", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorMulMatrixForTaskB() {
        System.out.println("Test {2,6} * {{0, 1}, {2, 3}}");
        try {
            Var calc = parser.calc("{2,6} * {{0, 1}, {2, 3}}");
            assertEquals("Wrong result for {2,6} * {{0, 1}, {2, 3}}", "{6.0, 22.0}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void vectorDivScalarForTaskB() {
        System.out.println("Test {2, 3} / 2");
        try {
            Var calc = parser.calc("{2, 3} / 2");
            assertEquals("Wrong result for {2, 3} / 2", "{1.0, 1.5}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }


    /**
     * TEST MATRIX
     **/

    @Test
    public void matrixAddScalarForTaskC() {
        System.out.println("Test {{0, 1}, {2, 3}} + 2");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} + 2");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} + 2", "{{2.0, 3.0}, {4.0, 5.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixAddMatrixForTaskC() {
        System.out.println("Test {{0, 1}, {2, 3}} + {{4, 5}, {6, 10}}");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} + {{4, 5}, {6, 10}}");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} + {{4, 5}, {6, 10}}",
                    "{{4.0, 6.0}, {8.0, 13.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixSubScalarForTaskC() {
        System.out.println("Test {{0, 1}, {2, 3}} - 3");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} - 3");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} - 3",
                    "{{-3.0, -2.0}, {-1.0, 0.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixSubMatrixForTaskC() {
        System.out.println("Test {{0, 1}, {2, 3}} - {{-4, 5}, {6, -10}}");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} - {{-4, 5}, {6, -10}}");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} - {{-4, 5}, {6, -10}}",
                    "{{4.0, -4.0}, {-4.0, 13.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixMulScalarForTaskC() {
        System.out.println("Test {{0, 1}, {2, 3}} * 3");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} * 3");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} * 3",
                    "{{0.0, 3.0}, {6.0, 9.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixMulVectorForTaskC() {
        System.out.println("Test {{0, 1}, {2, 3}} * {-4, 5}");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} * {-4, 5}");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} * {-4, 5}",
                    "{5.0, 7.0}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixMulMatrixForTaskC() {
        System.out.println("Test {{0, 1}, {2, 3}} * {{-4, 5}, {6, -10}}");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} * {{-4, 5}, {6, -10}}");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} * {{-4, 5}, {6, -10}}",
                    "{{6.0, -10.0}, {10.0, -20.0}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixDivScalarForTaskC() {
        System.out.println("Test {{0, 1}, {2, 3}} / 2.0");
        try {
            Var calc = parser.calc("{{0, 1}, {2, 3}} / 2.0");
            assertEquals("Wrong result for {{0, 1}, {2, 3}} / 2.0",
                    "{{0.0, 0.5}, {1.0, 1.5}}", calc.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    /**
     * TEST VARIABLE
     **/

    @Test
    public void varScalarForTaskC() {
        System.out.println("Test variable A=1.5");
        try {
            Var calc = parser.calc("A=1.5");
            Var var = parser.calc("A");
            assertEquals("Wrong result for A=1.5", "1.5", var.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void varVectorForTaskC() {
        System.out.println("Test variable B={1.5, 2.7}");
        try {
            Var calc = parser.calc("B={1.5, 2.7}");
            Var var = parser.calc("B");
            assertEquals("Wrong result for B={1.5, 2.7}", "{1.5, 2.7}", var.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void varMatrixForTaskC() {
        System.out.println("Test variable B={{1.5, 2.7}, {3, 5}}");
        try {
            Var calc = parser.calc("B={{1.5, 2.7}, {3, 5}}");
            Var var = parser.calc("B");
            assertEquals("Wrong result for B={{1.5, 2.7}, {3, 5}}", "{{1.5, 2.7}, {3.0, 5.0}}", var.toString());
            System.out.println(calc.toString());
            System.out.println("Test is successful, so you see this message");
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    /**
     * TEST NEW VAR
     **/

    @Test
    public void newScalarForTaskC() {
        System.out.println("Test new Scalar(\"1.5\")");
        Var scalar = new Scalar("1.5");
        assertEquals("Wrong result for new Scalar(\"1.5\")", "1.5", scalar.toString());
        System.out.println(scalar.toString());
        System.out.println("Test is successful, so you see this message");
    }

    @Test
    public void newVectorForTaskC() {
        System.out.println("Test new Vector(\"{1.5, 2.7}\")");
        Var vector = new Vector("{1.5, 2.7}");
        assertEquals("Wrong result for new Vector(\"{1.5, 2.7}\");", "{1.5, 2.7}", vector.toString());
        System.out.println(vector.toString());
        System.out.println("Test is successful, so you see this message");
    }

    @Test
    public void newMatrixForTaskC() {
        System.out.println("Test new Matrix(\"{{1.5, 2.7}, {3.0, 5.0}}\")");
        Var matrix = new Matrix("{{1.5, 2.7}, {3.0, 5.0}}");
        assertEquals("Wrong result for new Matrix(\"{{1.5, 2.7}, {3.0, 5.0}}\")",
                "{{1.5, 2.7}, {3.0, 5.0}}", matrix.toString());
        System.out.println(matrix.toString());
        System.out.println("Test is successful, so you see this message");
    }
}