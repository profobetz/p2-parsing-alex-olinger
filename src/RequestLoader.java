import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Provider.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

import org.apache.commons.csv.*;


import java.util.ArrayList;

public class RequestLoader {
    private File file;

    public RequestLoader(File fileToLoad) {
        this.file = fileToLoad;
    }


    public List<Neighborhood> load() throws IOException, DateTimeParseException { 
        List<Neighborhood> neighborhoods = new ArrayList<>();

        CSVFormat format = CSVFormat.DEFAULT.builder()
                                        .setHeader()
                                        .setDelimiter(',')
                                        .setQuote('"')
                                        .build();
        try {                               
        CSVParser parser = CSVParser.parse(file, StandardCharsets.UTF_8, format);
           
           
          


            for (CSVRecord next_row : parser.getRecords()) {

                
                String neighborhood_name = next_row.get("neighborhood");
                List<ServiceRequest> blank_request = new ArrayList<>();
                neighborhoods.add(new Neighborhood(neighborhood_name, blank_request));
   
                String temp = "t";
            }
                String t = "t";
        } catch (IOException e) {
            System.out.println("Can't load file");
        } 
        

        return neighborhoods;
    }



    
}


