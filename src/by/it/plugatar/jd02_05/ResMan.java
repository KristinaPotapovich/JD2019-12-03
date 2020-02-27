package by.it.plugatar.jd02_05;



import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private String locationRes="by.it.plugatar.jd02_05.properties.messages";
    private ResourceBundle resourceBundle;
    ResMan(){
    }
    void setLocale(Locale locale){
        resourceBundle= ResourceBundle.getBundle(locationRes,locale);
    }
}
