import java.util.ArrayList;
import java.util.List;

public class Neighborhood {
    String name;
    List<ServiceRequest> service_requests = new ArrayList<>();

    public Neighborhood(String name, List<ServiceRequest> requests) {
        this.name = name;
        this.service_requests = requests;
    }
}
