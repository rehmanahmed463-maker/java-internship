import java.util.*;

public class FailFastDemo{
    public static void main(String[] args){
        ArrayList<String>names=new ArrayList<>();
        names.add("Rehman");
        names.add("Taufique");
        names.add("Sohail");

        Iterator<String> itr= names.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());

            names.add("New Student");
        }

    }
}