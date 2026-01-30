import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeDemo {
    public static void main(String[] args){
        CopyOnWriteArrayList<Integer>Numbers=new CopyOnWriteArrayList<>();

        Numbers.add(1);
        Numbers.add(2);
        Numbers.add(3);

        for(Integer n:Numbers){
            System.out.println(n);
            Numbers.add(4);
        }
        System.out.println("\nFinal List"+Numbers);
    }
}
