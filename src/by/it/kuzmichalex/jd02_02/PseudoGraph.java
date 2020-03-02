package by.it.kuzmichalex.jd02_02;

import java.util.ArrayList;
import java.util.List;

class PseudoGraph {
    private List<Integer> graphList = new ArrayList<>(120);
    private int maxValue = 0;

    /**
     * Очистка
     * */
    void reset(){graphList.clear();
        maxValue=0;
    }

    /**
     * Запоминаем значения и запоминаем максимальные значения
     */
    void add(int value) {
        this.graphList.add(value);
        if (value > maxValue) maxValue = value;
    }

    /**
     * Формирование текста, который на самом деле график.
     */
    public String toString() {
        StringBuilder retValue = new StringBuilder();
        if (graphList.size() < 1) return ("graph is null");

        for (int y = 2 * (maxValue / 2); y >=0; y-=2) {
            retValue.append(String.format("%3d ",y));
            for (int x = 0; x <graphList.size() ; x++) {
                if(graphList.get(x)<(y-1))retValue.append(' ');
                else
                if(graphList.get(x)>=y)retValue.append("█");
                else
                    retValue.append("▄");
            }
            retValue.append("\n");
        }
        retValue.append("    ");
        for(int x=0; x<graphList.size(); x+=10)retValue.append(String.format("%-10d",x));


        return retValue.toString();
    }
}
