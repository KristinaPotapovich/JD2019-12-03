package by.it.kuzmichalex.jd01_14;

import java.io.File;

public class FHelper {
    /**
     * get full (including path to package) file name
     *
     * @param sFileName short file name
     * @param cls       Any class in package
     * @return path + file name
     */
    public static String getFileName(String sFileName, Class<?> cls) {
        String sPathAndFile = System.getProperty("user.dir");
        sPathAndFile += File.separator + "src" + File.separator;
        sPathAndFile += cls.getName().replace(cls.getSimpleName(), "").replace(".", File.separator);
        sPathAndFile += sFileName;
        return sPathAndFile;
    }


}
