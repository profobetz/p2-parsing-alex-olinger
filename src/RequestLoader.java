import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.*;


import java.util.ArrayList;
import java.util.HashSet;

public class RequestLoader {
    private File file;
    

    public RequestLoader(File fileToLoad) {
        this.file = fileToLoad;
    }


    public List<Neighborhood> load() throws IOException, DateTimeParseException { 
        
        
        List<String> duplicate_neighborhoods = new ArrayList<>();

        CSVFormat format = CSVFormat.DEFAULT.builder()
                                        .setHeader()
                                        .setDelimiter(',')
                                        .setQuote('"')
                                        .build();
        try {                               
        CSVParser parser = CSVParser.parse(file, StandardCharsets.UTF_8, format);
            for (CSVRecord next_row : parser.getRecords()) {
                String neighborhood_name = next_row.get("neighborhood");
                duplicate_neighborhoods.add(neighborhood_name);
            }
                String t = "t";
        } catch (IOException e) {
            System.out.println("Can't load file, IO Exception");
        } 

        // get rid of duplicate neighborhood names
        List<Neighborhood> neighborhoods = new ArrayList<>();
        Set<String> unique_neighborhoods = new HashSet<String>(duplicate_neighborhoods);

        for (String neighborhood_name : unique_neighborhoods) {
            neighborhoods.add(new Neighborhood(neighborhood_name));
        }

        // now can actually put service requests in proper neighborhood
        try {                               
            CSVParser parser = CSVParser.parse(file, StandardCharsets.UTF_8, format);
            String neighborhood_name = "";
            String open_dt_string  = "";
            String closed_dt_string = "";
            String reason = "";
            String on_time = "";

            for (CSVRecord next_row : parser.getRecords()) {

                neighborhood_name = next_row.get("neighborhood");
                open_dt_string  = next_row.get("open_dt");
                closed_dt_string = next_row.get("closed_dt");
                
                DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDate open_dt = LocalDate.parse(open_dt_string, date_formatter);
                LocalDate closed_dt = null;
                
                reason = next_row.get("reason");
                on_time = next_row.get("on_time");

                if ( !closed_dt_string.equals("")) {
                    closed_dt = LocalDate.parse(closed_dt_string, date_formatter);
                } else {
                    closed_dt = null;
                }
                

                String t = "t";        
            
                for (Neighborhood neighborhood : neighborhoods) {
                    if (neighborhood_name.equals(neighborhood.getName())) {
                        ServiceRequest request = new ServiceRequest(neighborhood_name, open_dt, closed_dt, on_time, reason);
                        neighborhood.addServiceRequest(request);
                        
                    }
                }
            }
                   
            } catch (IOException e) {
                System.out.println("Can't load file");
            } catch(DateTimeParseException e) {
                System.out.println("Can't parse open/close date");
            }

            for(Neighborhood neighborhood : neighborhoods) {
                neighborhood.createCasesListsByStatus();
            } 

        return neighborhoods;
    }



    
}


