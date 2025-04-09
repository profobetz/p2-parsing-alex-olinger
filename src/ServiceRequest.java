import java.time.LocalDate;
import java.time.Period;

public class ServiceRequest {
    private LocalDate date_opened;
    private LocalDate date_closed;
    private boolean on_time;
    private String reason;
    private String neighborhood;

    public ServiceRequest(String neighborhood, LocalDate date_opened, LocalDate date_closed, String on_time, String reason_for_request) {
        this.date_opened = date_opened;
        this.date_closed = date_closed;
        this.reason = reason_for_request;
        this.neighborhood = neighborhood;

        if (on_time.equals("ONTIME")) {
            this.on_time = true;  
        } else {
            this.on_time = false;
        }
    }


        public double getDaysOpen() {
            double days = 0.00;
            if (date_closed == null) {
                days = 0.00;
                return days;
            }
            Period period = Period.between(date_opened, date_closed);
            days = period.getDays();
            return days;
        }

        public boolean getIsOnTime() {
            return this.on_time;
        }





}
