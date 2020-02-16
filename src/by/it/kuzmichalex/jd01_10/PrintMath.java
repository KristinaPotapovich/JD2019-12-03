package by.it.kuzmichalex.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * prints public methods of Math class
 * */
public class PrintMath {
    public static void main(String[] args) {
        Class<?> mathClass = Math.class;
        Parameter[] methodParameters;
        Method[] mathMethods;

        StringBuilder outString;
        //printing static methods of math class
        mathMethods=mathClass.getDeclaredMethods();
        for (int i = 0; i < mathMethods.length; i++) {
            int modifiers=mathMethods[i].getModifiers();
            if(Modifier.isPublic(modifiers)){
                outString = new StringBuilder("public");
                if(Modifier.isStatic(modifiers)){
                    outString.append(" static");
                }
                outString.append(" ").append(mathMethods[i].getReturnType().getName());     //return type
                outString.append(" ").append(mathMethods[i].getName()).append("(");                     //method name
                methodParameters=mathMethods[i].getParameters();
                for (int idxParam = 0; idxParam <methodParameters.length ; idxParam++) {
                    outString.append(methodParameters[idxParam].getType().getName() );
                    if(idxParam<(methodParameters.length-1))outString.append(",");
                }
                //if(methodParameters.length<1)outString.append("void");
                outString.append(")");
                System.out.println(outString);
            }
        }
        //print static fields of math class
        Field[] declaredFields = mathClass.getDeclaredFields();
        for (int i = 0; i <declaredFields.length ; i++) {
            int modifiers = declaredFields[i].getModifiers();
            if(Modifier.isPublic(modifiers)) {
                outString = new StringBuilder(declaredFields[i].getType().getName()).append(" ");
                outString.append(declaredFields[i].getName());
                System.out.println(outString);
            }
        }
    }
}
