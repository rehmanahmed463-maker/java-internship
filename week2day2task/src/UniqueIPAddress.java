import java.util.*;

public class UniqueIPAddress {

    public static void main(String[] args) {

        List<String> ipList = new ArrayList<>();

        ipList.add("192.168.1.1");
        ipList.add("10.0.0.1");
        ipList.add("192.168.1.1");
        ipList.add("172.16.0.1");
        ipList.add("10.0.0.1");
        ipList.add("192.168.1.2");
        ipList.add("192.168.1.3");
        ipList.add("172.16.0.1");
        ipList.add("10.0.0.2");
        ipList.add("192.168.1.4");

        System.out.println("Before HashSet:");
        System.out.println(ipList);

        Set<String> uniqueIPs = new HashSet<>(ipList);

        System.out.println("\nAfter HashSet:");
        System.out.println(uniqueIPs);
    }
}
