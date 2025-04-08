import java.util.ArrayList;
import java.util.List;

public class Neighborhood {
    private String name;
    private List<ServiceRequest> service_requests = new ArrayList<>();
    private List<ServiceRequest> open_cases = new ArrayList<>();
    private List<ServiceRequest> overdue_cases = new ArrayList<>();

    public Neighborhood(String name, List<ServiceRequest> requests) {
        this.name = name;
        this.service_requests = requests;
        //createCasesListsByStatus();
    }

    public String getName() {
        return this.name;
    }

    public List<ServiceRequest> getServiceRequests() {
        return this.service_requests;
    }

    // public void createCasesListsByStatus() {
    //     for (ServiceRequest service_request : service_requests) {
    //         if (service_request.getCaseStatus() == true) {
    //             this.open_cases.add(service_request);
    //         } else if (service_request.getIsOnTime() == false) {
    //             this.overdue_cases.add(service_request);
    //         }
    //     }
    // }

    public double getOpenCases() {
        return this.open_cases.size();
    }

    public double getOverdueCases() {
        return this.overdue_cases.size();
    }





    // public double getNumServiceRequests() {
    //     return this.service_requests.size();
    // }

    // public double getAvgDaysRequestIsOpen() {
    //     int num_of_service_requests = service_requests.size();
    //     double days_open_accum = 0;

    //     for (ServiceRequest service_request : this.service_requests) {
    //         days_open_accum += service_request.getDaysOpen();
    //     }

    //     double average_days_open = days_open_accum / num_of_service_requests;
    //     return average_days_open;
    // }

    // public int getOpenCount() {
    //     int num_open_cases = 0;
    //     for (ServiceRequest service_request : this.service_requests) {
    //         boolean is_open = service_request.getCaseStatus();
    //         if (is_open == true) {
    //             num_open_cases++;
    //         }
    //     }
    //     return num_open_cases;
    // }

    // public int getOverdueCount() {
    //     int num_overdue = 0;
    //     for (ServiceRequest service_request : this.service_requests) {
    //         boolean is_on_time = service_request.getIsOnTime();
    //         if (is_on_time == false) {
    //             num_overdue++;
    //         }
    //     }
    //         return num_overdue;
    // }

    // public double getOverduePercent() {
    //     double num_cases = this.getNumServiceRequests();
    //     double num_overdue_cases = this.getOverdueCount();

    //     double overdue_percent = (num_overdue_cases / num_cases) * 100;
    //     return overdue_percent;


    // }
}
