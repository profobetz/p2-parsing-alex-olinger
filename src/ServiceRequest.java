import java.time.LocalDate;
import java.time.Period;

public class ServiceRequest {
    private LocalDate date_opened;
    private LocalDate date_closed;
    private boolean is_on_time;
    private boolean is_closed;
    private String reason;
    private Neighborhood neighborhood;

    public ServiceRequest(Neighborhood neighborhood, LocalDate date_opened, LocalDate date_closed, boolean is_on_time, boolean is_closed, String reason_for_request) {
        this.neighborhood = neighborhood;
        this.date_opened = date_opened;
        this.date_closed = date_closed;
        this.is_on_time = is_on_time;
        this.is_closed = is_closed;
        this.reason = reason_for_request;
    }


        public double getDaysOpen() {
            if (date_closed == null) {
                return Period.between(date_opened, LocalDate.now()).getDays();
            }
            return Period.between(date_opened, date_closed).getDays();
        }

        public boolean bIsOnTime() {
            return this.is_on_time;
        }

        public boolean bIsClosed() {
            return this.is_closed;
        }





}
