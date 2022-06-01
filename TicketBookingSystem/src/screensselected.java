import java.util.ArrayList;
import java.util.HashMap;

public class screensselected
{
   int seatCount ;
   String screenName;
    HashMap<Integer,Long> Booked = new HashMap<Integer,Long>();
ArrayList<Integer> seats= new ArrayList<Integer>();
    screensselected(String name)
    {
        this.screenName=name;
        seatCount = 64;
        int k = 64;
        for (int i = 0; i < 64; i++)
        {
            seats.add(k);
            k--;
        }
    }

    public void updateSeatCount(int ticketsBooked)
    {
        seatCount= seatCount-ticketsBooked;
    }

    public int printSeatCount()
    {
        return seatCount;
    }
}
