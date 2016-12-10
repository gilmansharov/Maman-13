import static org.junit.Assert.*;
import org.junit.Test;
 
public class StudentTester
{
   
    @Test
    public void testConstructor()
    {
        IsraelTour tour1 = new IsraelTour();
        assertEquals ("getNoOfTrips()", 0, tour1.getNoOfTrips());
    }
   
    @Test
    public void testAddTrip()
    {
        IsraelTour tour1 = new IsraelTour();
       
        Trip t1 = new Trip ("David", 1, 1, 2016, 2, 1, 2016, 5 ,20);
 
        assertEquals("addTrip()", true, tour1.addTrip (t1));
        assertEquals("getNoOfTrips()", 1, tour1.getNoOfTrips());
       
        for (int i = 1; i < 100; i ++)
        {
            tour1.addTrip(t1);
        }
       
        assertEquals("addTrip()", false, tour1.addTrip (t1)); // _data SHOULD BE FULL!
        assertEquals("getNoOfTrips()", 100, tour1.getNoOfTrips());
    }
   
    @Test
    public void testRemoveTrip()
    {
        IsraelTour tour1 = new IsraelTour();
       
        Trip t1 = new Trip ("David", 1, 1, 2016, 2, 1, 2016, 5 ,20);
       
        Trip t2 = new Trip ("Dana", 2, 1, 2016, 2, 1, 2016, 5, 20);
       
        assertEquals("removeTrip(t1)", false, tour1.removeTrip(t1));
       
        tour1.addTrip(t1);
       
        assertEquals("removeTrip(t2)", false, tour1.removeTrip(t2));
        assertEquals("removeTrip(t1)", true, tour1.removeTrip(t1));
        assertEquals("getNoOfTrips()", 0, tour1.getNoOfTrips());
    }
   
    @Test
    public void testHowManyTravellers()
    {
        IsraelTour tour1 = new IsraelTour();
       
        assertEquals("howManyTravellers()", 0, tour1.howManyTravellers());
       
        Trip t1 = new Trip ("David", 1, 1, 2016, 2, 1, 2016, 5 ,20);
        Trip t2 = new Trip ("Dana", 2, 1, 2016, 2, 1, 2016, 5, 20);
       
        tour1.addTrip(t1);
        tour1.addTrip(t2);
       
        assertEquals("howManyTravellers()", 40, tour1.howManyTravellers());
    }
   
    @Test
    public void testHowManyTripsDeparture()
    {
        IsraelTour tour1 = new IsraelTour();
       
        Trip t1 = new Trip ("David", 1, 1, 2016, 2, 1, 2016, 5 ,20);
        Trip t2 = new Trip ("Dana", 2, 1, 2016, 2, 1, 2016, 5, 20);
       
        Date d1 = new Date (1, 1, 2016);
        Date d2 = new Date (2, 1, 2016);
        Date d3 = new Date (2, 2, 2016);
       
        assertEquals("howManyTripsDeparture(d1)", 0, tour1.howManyTripsDeparture(d1));
       
        tour1.addTrip(t1);
        tour1.addTrip(t2);
       
        assertEquals("howManyTripsDeparture(d1)", 1, tour1.howManyTripsDeparture(d1));
        assertEquals("howManyTripsDeparture(d2)", 1, tour1.howManyTripsDeparture(d2));
        assertEquals("howManyTripsDeparture(d3)", 0, tour1.howManyTripsDeparture(d3));
    }
   
    @Test
    public void testHowManyCars()
    {
        IsraelTour tour1 = new IsraelTour();
       
        Trip t1 = new Trip ("David", 1, 1, 2016, 2, 1, 2016, 5 ,20);
        Trip t2 = new Trip ("Dana", 2, 1, 2016, 2, 1, 2016, 5, 21);
        Trip t3 = new Trip ("Avi", 3, 3, 2014, 2, 10, 2015, 3, 2);
        Trip t4 = new Trip ("Noa", 1, 2, 2000, 3, 4, 2001, 6, 7);
       
        tour1.addTrip(t1);
        tour1.addTrip(t2);
        tour1.addTrip(t3);
        tour1.addTrip(t4);
       
        Date d1 = new Date (1, 1, 2016);
        Date d2 = new Date (3, 3, 2014);
        Date d3 = new Date (1, 2, 2000);
       
        assertEquals("howManyCars(d1)", 2, tour1.howManyCars(d1));
        assertEquals("howManyCars(d2)", 1, tour1.howManyCars(d2));
       
        d1.setDay(2);
       
        assertEquals("howManyCars(d1)", 3, tour1.howManyCars(d1));
        assertEquals("howManyCars(d3)", 1, tour1.howManyCars(d3));
    }
   
    @Test
    public void testLongestTrip()
    {
        IsraelTour tour1 = new IsraelTour();
       
        assertEquals("longestTrip()", null, tour1.longestTrip());
       
        Trip t1 = new Trip ("David", 1, 1, 2016, 10, 1, 2016, 5 ,20);
        Trip t2 = new Trip ("Dana", 2, 1, 2016, 25, 1, 2016, 5, 21);
        Trip t3 = new Trip ("Avi", 3, 3, 2014, 2, 10, 2015, 3, 2);
        Trip t4 = new Trip ("Noa", 1, 2, 2000, 3, 4, 2001, 6, 7);
       
        tour1.addTrip(t1);
        tour1.addTrip(t2);
        tour1.addTrip(t3);
        tour1.addTrip(t4);
       
        assertEquals("longestTrip()", t3.toString(), tour1.longestTrip().toString());
    }
   
    @Test
    public void testMostPopularGuide()
    {
        IsraelTour tour1 = new IsraelTour();
       
        assertEquals("mostPopularGuide()", null, tour1.mostPopularGuide());
       
        Trip t1 = new Trip ("David", 1, 1, 2016, 10, 1, 2016, 5 ,20);
        Trip t2 = new Trip ("Dana", 2, 1, 2016, 25, 1, 2016, 5, 21);
        Trip t3 = new Trip ("David", 3, 3, 2014, 2, 10, 2015, 3, 2);
        Trip t4 = new Trip ("Noa", 1, 2, 2000, 3, 4, 2001, 6, 7);
       
        tour1.addTrip(t1);
        tour1.addTrip(t2);
        tour1.addTrip(t3);
        tour1.addTrip(t4);
       
        assertEquals("mostPopularGuide()", "David", tour1.mostPopularGuide());
    }
   
    @Test
    public void testMostExpensiveTrip()
    {
        IsraelTour tour1 = new IsraelTour();
       
        assertEquals("mostExpensiveTrip()", null, tour1.mostExpensiveTrip());
       
        Trip t1 = new Trip ("David", 1, 1, 2016, 10, 1, 2016, 5 ,20);
        Trip t2 = new Trip ("Dana", 2, 1, 2016, 25, 1, 2016, 5, 21);
        Trip t3 = new Trip ("David", 3, 3, 2014, 2, 7, 2015, 3, 2);
        Trip t4 = new Trip ("Noa", 6, 6, 2000, 3, 4, 2001, 9, 7);
       
        tour1.addTrip(t1);
        tour1.addTrip(t2);
        tour1.addTrip(t3);
        tour1.addTrip(t4);
       
        assertEquals("mostExpensiveTrip()", t3.toString(), tour1.mostExpensiveTrip().toString());
    }
   
    @Test
    public void testEarliestTrip()
    {
        IsraelTour tour1 = new IsraelTour();
       
        assertEquals("earliestTrip()", null, tour1.earliestTrip());
       
        Trip t1 = new Trip ("David", 1, 1, 2016, 10, 1, 2016, 5 ,20);
        Trip t2 = new Trip ("Dana", 2, 1, 2016, 25, 1, 2016, 5, 21);
        Trip t3 = new Trip ("David", 3, 3, 2014, 2, 7, 2015, 3, 2);
        Trip t4 = new Trip ("Noa", 6, 6, 2000, 3, 4, 2001, 9, 7);
       
        tour1.addTrip(t1);
        tour1.addTrip(t2);
        tour1.addTrip(t3);
        tour1.addTrip(t4);
       
        assertEquals("earliestTrip()", t4.getDepartureDate().toString(), tour1.earliestTrip().toString());
    }
}