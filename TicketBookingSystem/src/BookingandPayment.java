import java.util.*;

public class BookingandPayment
{
    Scanner sc = new Scanner(System.in);
    public void printAvailableSeats(int screennumber,LinkedHashMap<Integer,screensselected> al)
    {
        if(al.get(screennumber).seatCount == 0)
        {
            System.out.println("All the seats are booked,Kindly try booking other screens");
        }
        else {
            System.out.println(al.get(screennumber).seatCount);
            seatingArrangement(al,screennumber);
        }
    }
    public void seatingArrangement(LinkedHashMap<Integer,screensselected> al,int screennumber)
    {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < 64; i++) {
            if (al.get(screennumber).seats.get(i) <= 9) {
                System.out.print("| " + al.get(screennumber).seats.get(i) + "   ");
            } else {
                System.out.print("| " + al.get(screennumber).seats.get(i) + "  ");
            }
            if (((i + 1) % 8) == 0) {
                System.out.print("|");
                System.out.print("\n");
                System.out.println("------------------------------------------------");
            }
        }
    }
    public void Booking(int screennumber,LinkedHashMap<Integer,screensselected> al)
    {
        System.out.println("Enter the mobileNumber to proceed with registration");
        long mobileNumber = sc.nextLong();
        int finalPayment=0;
        System.out.println("Enter the number of tickets to book");
        int noOfTickets = sc.nextInt();
        if(noOfTickets > (al.get(screennumber).seatCount))
        {
            System.out.println("Available tickets are lesser than user needed tickets");
        }
        else
        {
            for(int i=0;i<noOfTickets;i++)
            {
                System.out.println("Enter the Seat number to Book :");
                int userseatchoice = sc.nextInt();
                if( (userseatchoice <= 0) || (userseatchoice > 64) )
                {
                    System.out.println("seat number should be between 1 to 64");
                    System.out.println("Please enter again");
                    i-=1;
                }
                else if ((!al.get(screennumber).seats.contains(userseatchoice)) )
                {
                    System.out.println("The seat number you have entered is already booked");
                    System.out.println("To check seat availability , press 1");
                    if(sc.nextInt() == 1)
                    {
                        seatingArrangement(al,screennumber);
                    }
                    System.out.println("Please enter again");
                    i-=1;
                }
                else
                {
                    int seatIndex =  al.get(screennumber).seats.indexOf(userseatchoice);
                    al.get(screennumber).seats.set(seatIndex,0);
                    if( (userseatchoice <= 16) && (userseatchoice > 0))
                    {
                        finalPayment += 50; //50 rupees ticket
                    }
                    else if((userseatchoice > 16) && (userseatchoice <= 40))
                    {
                        finalPayment += 120; //120 rupees ticket
                    }
                    else if ((userseatchoice <= 64) && (userseatchoice > 40))
                    {
                        finalPayment += 220; //220 rupees ticket
                    }
                    al.get(screennumber).Booked.put(userseatchoice,mobileNumber);
//                    System.out.println("seatIndex :"+seatIndex);
                }
            }
            paymentOptions(screennumber,al,noOfTickets,finalPayment);
        }
    }
    public void paymentOptions(int screenumber,LinkedHashMap<Integer,screensselected> al,int noOfTickets,int finalPayment)
    {
        System.out.println("Total amount to be paid : Rs."+finalPayment);
        System.out.println("Choose one of the below Payment option 1 . GPAY 2.CASH 3.NET BANKING");
        int paymentChoice = sc.nextInt();
       String paymentResult =  ((paymentChoice >= 1) && (paymentChoice <= 3))?"Payment Completed ,Ticked Booked Successfully":"Payment terminated";
        System.out.println(paymentResult);
        al.get(screenumber).seatCount -= noOfTickets;
    }
}
