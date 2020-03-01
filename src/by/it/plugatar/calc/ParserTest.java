package by.it.plugatar.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    @Before
    public static void main(String[] args) {
        System.out.println("Start");
    }

@Test
    public void calc() throws Exception{
    Parser parser=new Parser();
    String expression = "1+2*2";
    //String exp="6.0";
    //parser.calc ("1+2*2");
    double expected =6.0;
    Scalar scalar =(Scalar) parser.calc(expression);
    double actual=Double.parseDouble(scalar.toString());
    assertEquals(" Incorect" +expression,expected,actual,1e-5);
}
}