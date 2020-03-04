package by.it.kuzmichalex.calc_jd02_06;

abstract class ReportBuilder {
    abstract String buildHeaderString();

    abstract String buildBodyString(String msg, CalcException e);
}

class ReportBuilderFull extends ReportBuilder {

    @Override
    String buildHeaderString() {
        return "Заголовок Полный отчёт";
    }

    @Override
    String buildBodyString(String message, CalcException e) {
        StringBuilder retStr = new StringBuilder();
        retStr.append(LanguageManager.getLocaleDate());
        retStr.append(" ");
        retStr.append(LanguageManager.getLocaleTime());
        retStr.append(" ");
        if (e != null) {
            retStr.append(LanguageManager.get(Messages.error)).append(" ");
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                if (stackTrace[i].getClassName().contains("by.it.")) {
                    retStr.append("class: ").append(stackTrace[i].getClassName()).append(": ");
                    break;
                }
            }
        }

        retStr.append(message);
        return retStr.toString();
    }
}


class ReportBuilderShort extends ReportBuilder {

    @Override
    String buildHeaderString() {
        return "Заголовок Сокращённый отчёт";
    }

    @Override
    String buildBodyString(String message, CalcException e) {
        StringBuilder retStr = new StringBuilder();
        retStr.append(LanguageManager.getLocaleDate());
        retStr.append(" ");
        retStr.append(LanguageManager.getLocaleTime());
        retStr.append(" ");
        retStr.append(message);
        return retStr.toString();
    }
}

class Report {

}

