import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        RequestLoader loader = new RequestLoader(new File("resources/sample.csv"));

        List<Neighborhood> neighborhoods = loader.load();
  
        for ( Neighborhood n : neighborhoods ) {
            String summary = String.format("%s - %d open / %d total, %d overdue (%.2f%%), %.2f avg. days to closure", 
                    n.getName(),
                    n.getOpenCasesCount(),
                    n.getTotalRequestCount(),
                    n.getOverdueCasesCount(),
                    n.getOverdueRate(),
                    n.getAverageDaysOpen()
            );

            System.out.println(summary);
        }

    }
}