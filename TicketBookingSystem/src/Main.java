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
        System.out.println("Enter the option :1 - english  , 2 - tamil , 3 - 100 - exit the application");
        int languageChoice = sc.nextInt();
        switch(languageChoice)
        {
            case 1 : System.out.println("English language is chosen");
                System.out.println("Choose the screen based on below options :");
                System.out.println("Press 0 : Doctor Strange(S1)  , Press 1 : Black Panther(S2) , Press 4 - To return to main menu , Press 100 - To exit the application");
                int screenChoice = sc.nextInt();
                screendetails(screenChoice);



            case 2 : System.out.println("Tamil language is chosen");
                System.out.println("Choose the screen based on below options :");
                System.out.println("Press 2 : Don(S3) , Press 3 : Vikram(S4) , Press 4 - To return to main menu,Press 100 - To exit the application");
                screenChoice = sc.nextInt();
                screendetails(screenChoice);

            case 3:System.out.println();

            case 100 : System.out.println("Exiting the Application.");
                System.exit(0);

            case 4 : entryPoint();

        }
    }

    public void screendetails(int screennumber)
    {
        System.out.println("Enter 1 - To print available tickets ");
        System.out.println("2 - To Book and pay the tickets ");
        int internalChoice = sc.nextInt();
        BookingandPayment b = new BookingandPayment();
        while(internalChoice != 0)
        {
            switch (internalChoice) {
                case 1:
                    System.out.println("Printing available ticket count");
                    b.printAvailableSeats(screennumber,al);
                    break;

                case 2:
                    System.out.println("Opening Booking portal");
                    b.Booking(screennumber, al);
                    break;

                case 4 :
                    System.out.println("Returning to main menu");
                    entryPoint();
                    break;
            }
            System.out.println( "1 - To print available tickets ");
            System.out.println("2 - To Book and pay the tickets ");
            System.out.println("4- To return to main menu");
            System.out.println("5 - To exit the application ");
            internalChoice = sc.nextInt();
            if(internalChoice == 5)
            {
                System.exit(0);
            }
        }
    }
}