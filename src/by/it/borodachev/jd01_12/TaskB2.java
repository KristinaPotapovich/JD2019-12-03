package by.it.borodachev.jd01_12;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.*;

public class TaskB2 {
    static String process (ArrayList<String> peoples) {
      return  processList(peoples) ;
    }
    static String process (LinkedList<String> peoples) {
          return  processList(peoples) ;
    }
    static String processList (List<String> peoples) {
        int cntRemove=0;
        while (peoples.size() > 1) {
            cntRemove=cntRemove % 2;
            if (peoples.size() ==2) {
                if (cntRemove % 2 == 0) {
                    peoples.remove(1);
                } else {
                    peoples.remove(0);
                }
            }
                else {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                  iterator.next();
                  cntRemove++;
                if (cntRemove%2==0) iterator.remove();
              }
            }
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
      TaskB2 tst=new TaskB2();
        List<String> list=new ArrayList<>(Arrays.asList("n1","n2","n3"));
        System.out.println(tst.processList(list));
    }
}
