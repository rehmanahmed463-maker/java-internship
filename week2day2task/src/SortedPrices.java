import java.util.*;
public class SortedPrices {
    public static void main(String[]args){
        TreeSet<Integer> prices=new TreeSet<>();
        prices.add(1200);
        prices.add(1100);
        prices.add(900);
        prices.add(2000);
        prices.add(500);
        System.out.println("Sorted price after TreeSet:");
        System.out.println(prices);

    }
}
