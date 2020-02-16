package by.it.borodachev.jd01_12;

import java.util.*;

public class TaskB3 {
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

    static String processQ (Collection <String> peoples){
        ArrayDeque <String> q =new ArrayDeque<>(peoples);
        int cntRemove=1;
        while ((q.peek()!=null)&&(q.size()>1)) {
          if  (cntRemove%2==0) { q.poll(); cntRemove=1;}
          else { cntRemove++; q.addLast(q.poll()); }
         }
        return q.pollFirst();
    }

    public static void main(String[] args) {
        TaskB3 tst=new TaskB3();
        List<String> listQ=new ArrayList<>();
        List<String> listA=new ArrayList<>();
        List<String> listL=new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            listA.add("str"+i) ;
            listL.add("str"+i) ;
            listQ.add("str"+i) ;
        }
        Long t= System.nanoTime();
        System.out.println(tst.processList(listA)+"  время "+ (System.nanoTime()-t));
        t= System.nanoTime();
        System.out.println(tst.processList(listL)+"  время "+ (System.nanoTime()-t));
        t= System.nanoTime();
        System.out.println(tst.processQ(listQ)+"  время "+ (System.nanoTime()-t));

    }
}
