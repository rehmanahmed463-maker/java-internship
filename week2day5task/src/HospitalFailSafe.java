import java.util.concurrent.CopyOnWriteArrayList;

public class HospitalFailSafe {
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> doctorUpdates = new CopyOnWriteArrayList<>();
        doctorUpdates.add("Dr. Ahmed");
        doctorUpdates.add("Dr. Khan");
        doctorUpdates.add("Dr. Patel");

        for(String doc : doctorUpdates){
            System.out.println("Serving: " + doc);
            doctorUpdates.add("New Emergency Doctor");
        }

        System.out.println("\nFinal Doctor List: " + doctorUpdates);
    }
}
