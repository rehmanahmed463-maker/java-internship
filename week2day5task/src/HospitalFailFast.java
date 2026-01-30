import java.util.*;

public class HospitalFailFast {
    public static void main(String[] args) {

        ArrayList<String> doctors = new ArrayList<>();
        doctors.add("Dr. Ahmed");
        doctors.add("Dr. Khan");
        doctors.add("Dr. Patel");

        Iterator<String> itr = doctors.iterator();

        while(itr.hasNext()){
            System.out.println("Serving: " + itr.next());
            doctors.add("New Emergency Doctor"); // modification causes crash
        }
    }
}
