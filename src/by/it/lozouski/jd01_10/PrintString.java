package by.it.lozouski.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methodsString = stringClass.getDeclaredMethods();
        StringBuilder myText = new StringBuilder();
        for (Method elem : methodsString) {
            int mod = elem.getModifiers();
            if (!Modifier.isStatic(mod)){
                myText.append(elem.getName()).append('\n');
            }
        }
        System.out.println(myText);
    }
}
