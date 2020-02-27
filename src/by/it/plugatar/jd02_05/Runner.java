package by.it.plugatar.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

import static by.it.plugatar.jd02_05.User.FIRST_NAME;

public class Runner {
    public static void main(String[] args) {
        ResMan res=ResMan.INSTANCE;
        Locale locale=new Locale("ru","RU");
        ResourceBundle rb=ResourceBundle.getBundle("by.it.plugatar.jd02_05.properties.messages",locale);
        String firstName=rb.getString("user.firstname");

        System.out.println(rb.getString(Messages.WELCOME));
    }
}
