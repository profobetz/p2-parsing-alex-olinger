import java.util.ArrayList;
import java.util.List;

public class Neighborhood {
    private String name;
    private List<ServiceRequest> service_requests = new ArrayList<>();
    private List<ServiceRequest> open_cases = new ArrayList<>();
    private List<ServiceRequest> overdue_cases = new ArrayList<>();

    public Neighborhood(String name) {
        this.name = name;
        
        //createCasesListsByStatus();
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

    public void createCasesListsByStatus() {
        for (ServiceRequest service_request : this.service_requests) {
            if (service_request.getIsOnTime() == true) {
                this.open_cases.add(service_request);
            } else if (service_request.getIsOnTime() == false) {
                this.overdue_cases.add(service_request);
            }
        }
    }

    public int getOpenCasesCount() {
        return this.open_cases.size();
    }

    public int getOverdueCasesCount() {
        return this.overdue_cases.size();
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
