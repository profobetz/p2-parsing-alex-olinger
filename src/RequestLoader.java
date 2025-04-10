import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;


import org.apache.commons.csv.*;


import java.util.ArrayList;


public class RequestLoader {
    private File file;
    

    public RequestLoader(File fileToLoad) {
        this.file = fileToLoad;
    }


    public List<Neighborhood> load() throws IOException, DateTimeParseException { 
        
        // make list of neighborhoods for us to fill
        List<Neighborhood> neighborhoods = new ArrayList<>();

        // set pattern we want to match to in CSV
        CSVFormat format = CSVFormat.DEFAULT.builder()
                                        .setHeader()
                                        .setDelimiter(',')
                                        .setQuote('"')
                                        .build();

        // actually load the file, with pattern
        try {                               
            CSVParser parser = CSVParser.parse(file, StandardCharsets.UTF_8, format);

            // go through each row
            for (CSVRecord next_row : parser.getRecords()) {
                String neighborhood_name = next_row.get("neighborhood");
               
                
                Neighborhood destination = null;

                // go through neighborhoods we already have
                // skips on first run with no neighborhoods
                for ( Neighborhood prior_neighborhood : neighborhoods) {
                    // check if row 'name' entry matches
                    if (prior_neighborhood.getName().equals(neighborhood_name)) {
                        // then we don't need to make a new Neighborhood, just point to the one we got
                        destination = prior_neighborhood;
                    }
                }


                // when we don't have a prior name match
                if (destination == null) {
                    destination = new Neighborhood(neighborhood_name);
                    neighborhoods.add(destination);
                }

                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDate open_date = LocalDate.parse(next_row.get("open_dt").split(" ")[0]);
                boolean b_is_on_time = next_row.get("on_time").equals("ONTIME");
                boolean b_is_closed = next_row.get("case_status").equals("Closed");
                String reason = next_row.get("reason");
                
                LocalDate closed_date = null;
                if ( !next_row.get("closed_dt").trim().equals("")) {
                       closed_date = LocalDate.parse(next_row.get("closed_dt").split(" ")[0]); 
                }

                ServiceRequest request = new ServiceRequest(destination, open_date, closed_date, b_is_on_time, b_is_closed, reason);
                destination.addServiceRequest(request);
                
            }
              
        } catch (IOException e) {
            System.err.println("Can't load file");
        } catch (DateTimeParseException e) {
            System.err.println("Can't parse date of your data");
        }

        return neighborhoods;
    }



    
}


