import java.util.*;

public class Iterato {
    public static void main(String[] args){
        List<String> names=new ArrayList<>();
        names.add("Rehman");
        names.add("Arman");
        names.add("Sohail");
        names.add("Taufique");

        System.out.println("Using Iterator");
        Iterator<String> it=names.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("\nUsing for-each loop");
        for(String n:names){
            System.out.println(n);
        }
        System.out.println("\nUsing ListIterator(reverse order");
        ListIterator<String> itr=names.listIterator(names.size());
        while (itr.hasPrevious()){
            System.out.println(itr.previous());
        }
    }
}