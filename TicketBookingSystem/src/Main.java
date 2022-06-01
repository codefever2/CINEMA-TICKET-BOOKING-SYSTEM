import java.util.*;
public class Main {
    Scanner sc = new Scanner(System.in);
    LinkedHashMap<Integer,screensselected> al = new LinkedHashMap<Integer,screensselected>();
        Main()
        {
            screensselected s = new screensselected("Screen1 -ENGLISH");
            al.put(0,s);
            s = new screensselected("Screen2 -ENGLISH");
            al.put(1,s);
            s = new screensselected("Screen1 - TAMIL");
            al.put(2,s);
            s = new screensselected("Screen2 -TAMIL");
            al.put(3,s);
        }
    public static void main(String[] args)
    {
        System.out.println("Welcome to INOX Multiplex :");
        Main m = new Main();
        m.entryPoint();
    }

    public void entryPoint()
    {
        System.out.println("Enter the option :1 - To book english movies   , 2 - To book tamil movies , 3 - To cancel the tickets booked ,6 -To print booked tickets100 - exit the application");
        int languageChoice = sc.nextInt();
        switch(languageChoice)
        {
            case 1 : System.out.println("English language is chosen");
                System.out.println("Choose the screen based on below options :");
                System.out.println("Press 0 : Doctor Strange(S1) , Press 1 : Black Panther(S2) , Press 100 - To exit the application");
                int screenChoice = sc.nextInt();
                screendetails(screenChoice);
                break;



            case 2 : System.out.println("Tamil language is chosen");
                System.out.println("Choose the screen based on below options :");
                System.out.println("Press 2 : Don(S3) , Press 3 : Vikram(S4) ,Press 100 - To exit the application");
                screenChoice = sc.nextInt();
                screendetails(screenChoice);
                break;

            case 3:System.out.println("Cancelling portal opened");
                CancellationandPaymentreturn  c = new CancellationandPaymentreturn();
                System.out.println("Enter the registered mobile number to cancel the tickets");
                long mobileNumber = sc.nextLong();
                c.Bookingcancellation(mobileNumber,al);
                break;

            case 6 : BookingandPayment b = new BookingandPayment();
                    b.printBookedTickets(al);
                    break;

            case 100 : System.out.println("Exiting the Application.");
                        System.exit(0);

        }
    }

    public void screendetails(int screennumber) {
        if ((screennumber > 3) && (screennumber < 0)) {
            System.out.println("Wrong screen value entered");
            entryPoint();
        }
        else {
            System.out.println("Enter 1 - To print available tickets ");
            System.out.println("2 - To Book and pay the tickets ");
            int internalChoice = sc.nextInt();
            BookingandPayment b = new BookingandPayment();
            while (internalChoice != 0) {
                switch (internalChoice) {
                    case 1:
                        System.out.println("Printing available ticket count");
                        b.printAvailableSeats(screennumber, al);
                        break;

                    case 2:
                        System.out.println("Opening Booking portal");
                        b.Booking(screennumber, al);
                        break;

                    case 4:
                        System.out.println("Returning to main menu");
                        entryPoint();
                        break;
                }
                System.out.println("1 - To print available tickets ");
                System.out.println("2 - To Book and pay the tickets ");
                System.out.println("4- To return to main menu");
                System.out.println("5 - To exit the application ");
                internalChoice = sc.nextInt();
                if (internalChoice == 5) {
                    System.exit(0);
                }
            }
        }
    }
}