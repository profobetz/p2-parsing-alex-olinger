import java.time.LocalDate;
import java.time.Period;

public class ServiceRequest {
    LocalDate date_opened;
    LocalDate date_closed;
    boolean was_closed_on_time;
    String reason_for_request;
    String neighborhood;

    public ServiceRequest(LocalDate date_opened, LocalDate date_closed, String reason_for_request, String neighborhood) {
        this.date_opened = date_opened;
        this.date_closed = date_closed;
        this.reason_for_request = reason_for_request;
        this.neighborhood = neighborhood;
    }

    public int getDaysOpen() {
        Period period = Period.between(date_opened, date_closed);
        int days = period.getDays();
        return days;
    }



}
