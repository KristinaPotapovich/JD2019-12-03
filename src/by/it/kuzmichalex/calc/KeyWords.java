package by.it.kuzmichalex.calc;
public class KeyWords {
    static final String EXIT="exit";
    static final String QUIT="quit";
    static final String END="end";
    static final String PRINTVAR="printvar";
    static final String SORTVAR="sortvar";
    static final String ALLKEYWORDS=","+EXIT+","+QUIT+","+END+","+PRINTVAR+","+SORTVAR+",";

    /**
     * @param strExpression - string parameter
     * @return true when string parameter is keyword
     * */
    static boolean isKeyWord(String strExpression){
        return ALLKEYWORDS.contains(","+strExpression.toLowerCase()+",");
    }
}
