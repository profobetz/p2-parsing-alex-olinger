import java.util.ArrayList;
import java.util.List;

public class Neighborhood {
    private String name;
    private List<ServiceRequest> service_requests = new ArrayList<>();

    public Neighborhood(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<ServiceRequest> getServiceRequests() {
        return this.service_requests;
    }

    public void addServiceRequest(ServiceRequest request) {
        this.service_requests.add(request);
    }

    public List<ServiceRequest> getOpenCases() {
        List<ServiceRequest> open_cases = new ArrayList<>();
        for (ServiceRequest request: this.service_requests) {
            if (request.bIsOnTime()) {
                open_cases.add(request);
            }
        }
        return open_cases;
    }

    public List<ServiceRequest> getClosedCases() {
        List<ServiceRequest> closed_cases = new ArrayList<>();
        for (ServiceRequest request: this.service_requests) {
            if (request.bIsClosed()) {
                closed_cases.add(request);
            }
        }
        return closed_cases;
    }

    public List<ServiceRequest> getOverdueCases() {
        List<ServiceRequest> overdue_cases = new ArrayList<>();
        for (ServiceRequest request: this.service_requests) {
            if (!request.bIsClosed()) {
                overdue_cases.add(request);
            }
        }
        return overdue_cases;
    }


    public int getOpenCasesCount() {
        return getOpenCases().size();
    }

    public int getOverdueCasesCount() {
        return getOverdueCases().size();
    }

    public int getClosedCasesCount() {
        return getClosedCases().size();
    }


    public int getTotalRequestCount() {
        return this.service_requests.size();
    }

    public double getAverageDaysOpen() {
        int num_of_service_requests = service_requests.size();
        double days_open_accum = 0;

        for (ServiceRequest service_request : this.service_requests) {
            days_open_accum += service_request.getDaysOpen();
        }

        double average_days_open = days_open_accum / num_of_service_requests;
        return average_days_open;
    }

    
    public double getOverdueRate() {
        double num_cases = this.getTotalRequestCount();
        double num_overdue_cases = this.getOverdueCasesCount();

        double overdue_percent = (num_overdue_cases / num_cases) * 100;
        return overdue_percent;


    }
}
