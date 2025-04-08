import java.time.LocalDate;
import java.time.Period;

public class ServiceRequest {
    private LocalDate date_opened;
    private LocalDate date_closed;
    private String on_time;
    private String reason_for_request;
    private String neighborhood;

    public ServiceRequest(String neighborhood, LocalDate date_opened, LocalDate date_closed, String on_time, String reason_for_request) {
        this.date_opened = date_opened;
        this.date_closed = date_closed;
        this.reason_for_request = reason_for_request;
        this.neighborhood = neighborhood;
        this.on_time = on_time;
    }


    // public double getDaysOpen() {
    //     Period period = Period.between(date_opened, date_closed);
    //     double days = period.getDays();
    //     return days;
    // }

    // public boolean getCaseStatus() {
    //     return this.is_open;
    // }

    // public boolean getIsOnTime() {
    //     return this.on_time;
    // }





}
