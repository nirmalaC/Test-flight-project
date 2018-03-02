package integrationtests;

import com.api.example.TestApplication;
import com.api.example.database.FlightFinder;
import com.api.example.database.example.models.ExampleFlightDbModel;
import com.api.example.fixture.invoke.queryparams.FlightQueryParams;
import com.api.example.fixture.invoke.queryparams.FlightQueryParamsFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by daniel on 24/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestApplication.class)
@DirtiesContext
public class FlightFinderTest {

    @Autowired
    private FlightFinder flightFinder;

    @Test
    public void getAListOfValidFlights() throws Throwable {
        Calendar fromDate = Calendar.getInstance(); // creates calendar
        fromDate.setTime(new Date()); // sets calendar time/date
        fromDate.add(Calendar.HOUR_OF_DAY, 2); // adds two hours

        Calendar toDate = Calendar.getInstance();
        toDate.setTime(new Date()); // Now use today date.
        toDate.add(Calendar.DATE, 60);

        List<ExampleFlightDbModel> flightsFound = flightFinder.findValidFlights(fromDate, toDate, 2, null, null, null);
        assertThat(flightsFound).size().isGreaterThan(0);
        for (ExampleFlightDbModel flight : flightsFound) {
            System.out.println(flight.toString());
            FlightQueryParams flightQueryParams =
                    FlightQueryParamsFactory.generateFlightSearchCriteria(flight).build();
        }
    }

    @Test
    public void testingListsplit() throws Throwable {

        List<String> allRetutnFlights = new ArrayList<String>();

        List<String> allFlights = new ArrayList<String>();
        allFlights.add("20170122LTNFAO2015");
        allFlights.add("20170229LTNFAO2015");
        allFlights.add("20170305LTNFAO2015");
        allFlights.add("20170422LTNFAO2015");
        allFlights.add("20170129FAOLTN2016");
        allFlights.add("20170305FAOLTN2016");
        allFlights.add("20170122FAOLTN2017");
        allFlights.add("20170129LTNGNY2016");
        allFlights.add("20170305LTNJKL2015");
        allFlights.add("20170122JKLLTN2017");
        allFlights.add("20170129ZHYFAO2015");
        allFlights.add("20170305FAOZHY2015");
        allFlights.add("20170122LTNGHK2015");
        allFlights.add("20170129LTNGHK2015");
        allFlights.add("20170305LTNFAO2015");


        for (String flight : allFlights) {
            String depAirport = flight.substring(8, 11);
            String arrAirport = flight.substring(11, 14);
            String returnFlightkey = arrAirport + depAirport;

            for (String comapareflight : allFlights) {
                if (comapareflight.contains(returnFlightkey)){
                    if(!allRetutnFlights.contains(flight))
                        allRetutnFlights.add(flight);
                }

            }
        }

        for (String flightreturn : allRetutnFlights) {
            System.out.println("Resultreturn flights " + flightreturn);
        }


    }

}
