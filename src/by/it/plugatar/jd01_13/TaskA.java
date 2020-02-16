package by.it.plugatar.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
      try {
          if (Math.random() > 0.5)
              new HashMap<String, String>(null);
          else Integer.parseInt("привет");
          }
      catch  ( NumberFormatException | NullPointerException e){//      catch  ((|| NumberFormatException e) ){//
            //Class <? extends RuntimeException>
          String name=e.getClass().getName();
            StackTraceElement[] stackTrace = e.getStackTrace();//getStackTrace - дает массив ошибок
            //String message = e.getMessage();
            for (StackTraceElement element :stackTrace) {
                String fromStackTraceClassName = element.getClassName();
                int linenumber = element.getLineNumber();
                String myClassName=TaskA.class.getName();
                if (myClassName.equals(fromStackTraceClassName)){
                    //System.out.println(name);
                    System.out.printf(  " name: %s\n"+
                                        "class: %s\n"+
                                        " line: %s\n",
                            name,fromStackTraceClassName,linenumber
                                        );
                    break;
                }


            }
      }
    }
}
