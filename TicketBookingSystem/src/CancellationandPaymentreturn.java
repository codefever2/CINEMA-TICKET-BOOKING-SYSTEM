import java.util.LinkedHashMap;
import java.util.Scanner;

public class CancellationandPaymentreturn
{
    Scanner sc = new Scanner(System.in);
    public void Bookingcancellation(long mobileNumber, LinkedHashMap<Integer,screensselected> al)
    {
        System.out.println("choose the screen to cancel the ticket: 0 - screen 1,,1 - screen 2,2 - screen 3,3 - screen 4");
        int screenNumber = sc.nextInt();
        System.out.println("Enter number of tickets to be cancelled:");
        int noOfTicketsToCancel = sc.nextInt();
        for(int i=0;i<noOfTicketsToCancel;i++)
        {
            System.out.println("Enter the ticket number to be cancelled:");
                    int cancelTicket = sc.nextInt();
            if (al.get(screenNumber).Booked.get(cancelTicket) == mobileNumber)
            {
                System.out.println("Ticket no : "+cancelTicket+" is cancelled ");
                al.get(screenNumber).Booked.remove(cancelTicket,mobileNumber);
                int index = 64-cancelTicket;
                al.get(screenNumber).seats.set(index,cancelTicket);
            }
        }
        al.get(screenNumber).seatCount -= noOfTicketsToCancel;
        System.out.println("Ticket cancellation done successfully");
        System.out.println("Amount will be refunded within 3 working days");
    }
}
