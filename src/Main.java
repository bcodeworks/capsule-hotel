import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // public String successNotice = "Success :)";
    // public String errorNotice = "Error :(";
    // public String existFail = " does not exist.";

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Welcome to CapsKeeper!");
        System.out.println("How many capsules are available today?");
        Scanner console = new Scanner(System.in);
        int choiceNum = Integer.getInteger(console.nextLine());
        String[] capsules = new String[choiceNum]; // placeholder

        // Main Menu

        boolean escapeMenu = false;
        while(!escapeMenu){
            switch(getMenuOption(console)){
                case "1":
                    handleCheckIn(console, "Placeholder Name");
                    break;
                case "2":
                    handleCheckOut(console);
                    break;
                case "3":
                    viewGuests(console);
                    break;
                case "4":
                    if(confirmExit(console)){
                        escapeMenu = true;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid selection");
                    break;
            }

        }

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    /*
    Method Name: getMenuOption
    The getMenuOption method is designed to display a simple menu for a guest system and prompt the user to choose an option. It takes a Scanner object as a parameter to read user input and returns the selected option as a String.
    @param Scanner console
    @return String
    */

    public static String getMenuOption(Scanner console){
        System.out.println("Select an option:");
        System.out.println("1. Check in a guest");
        System.out.println("2. Check out a guest");
        System.out.println("3. View guest information");
        System.out.println("4. Exit program");
        return console.nextLine(); // placeholder
    }

    /**
     * Method Name: handleCheckIn
     * The handleCheckIn method is designed to facilitate the check-in process for guests into capsules. It takes a Scanner object for user input and a String representing the guest's name. The method returns a boolean value indicating the success or failure of the check-in process.
     * @param Scanner console
     * @param String guestName
     * @return boolean
     * If the capsule number does not exist the user should see the following error message:
     * Error :(
     * Capsule #9 does not exist. (9 is an example, should be replaced by the capsule number the user tries to input)
     * If the Guest is successfully booked the user should see the following success message:
     * Success :)
     * John is booked in capsule #3 (John and 3 are examples, they should be replaced by the user inputs)
     * If the capsule is occupied the user should see the following error message:
     * Error :(
     * Capsule #5 is occupied. (5 is an example, should be replaced by the capsule number the user tries to input)
     */

    public static boolean handleCheckIn(Scanner console, String guestName){
        // successNotice
        // errorNotice
        // existFail
        String bookNotice = " is booked in capsule #";
        String occupiedNotice = " is occupied.";

        System.out.println("Enter guest name:");
        String guestName2 = console.nextLine();
        System.out.println("Enter room #:");
        int choiceNum = Integer.getInteger(console.nextLine());
        System.out.println("Capsule: Guest");
        if(false) { // test to see if room number exists
            System.out.println("Error :(");
            System.out.println("Capsule #" + choiceNum + " does not exist.");
            return false;
        }
        if(false){ // test to see if occupied
            System.out.println("Error :(");
            System.out.println("Capsule #" + choiceNum + occupiedNotice);
        }

        return true;
    }

    /**
     * Method Name: handleCheckOut
     * The handleCheckOut method is designed to manage the check-out process for guests from capsules. It takes a Scanner object for user input and returns a boolean value indicating the success or failure of the check-out process.
     * @param Scanner console
     * @return boolean
     * If no guests are checked into the hotel the user should see the following error message:
     * Sorry... check out is only available if there's at least one guest.
     * If the capsule number does not exist the user should see the following error message:
     * Error :(
     * Capsule #9 does not exist. (9 is an example, should be replaced by the capsule number the user tries to input)
     * If the Guest is successfully booked the user should see the following success message:
     * Success :)
     * John checked out from capsule #3 (John and 3 are examples, they should be replaced by the user inputs)
     * If the capsule is unoccupied the user should see the following error message:
     * Error :(
     * Capsule #5 is unoccupied. (5 is an example, should be replaced by the capsule number the user tries to input)
     */

    public static boolean handleCheckOut(Scanner console){
        String sorryNotice = "Sorry... check out is only available if there's at least one guest.";
        String checkoutNotice = " checked out from capsule #";
        String vacantNotice = " is unoccupied";
        // successNotice
        // errorNotice

        if(false) { // check if hotel is empty
            System.out.println(sorryNotice);
            return false;
        }
        System.out.println("Enter room #:");
        int choiceNum = Integer.getInteger(console.nextLine());
        System.out.println("Capsule: Guest");
        if(false) { // test to see if room number exists
            System.out.println("Error :(");
            System.out.println("Capsule #" + choiceNum + " does not exist.");
            return false;
        }
        if(false){ // test to see if unoccupied
            System.out.println("Error :(");
            System.out.println("Capsule #" + choiceNum + vacantNotice);
        }

        return true; // placeholder
    }

    /**
     * Method Name: viewGuests
     * The viewGuests method is designed to display information about the guests occupying capsules. It takes a Scanner object for user input and prints a list of guests in capsules along with their capsule numbers, if the capsule is null [unoccupied] should be printed, otherwise the guest name should be printed.
     * @param Scanner console
     * Example Output:
     * Capsule: Guest
     * 1: John
     * 2: [unoccupied]
     * 3: [unoccupied]
     * 4: [unoccupied]
     * 5: [unoccupied]
     * 6: [unoccupied]
     * 7: [unoccupied]
     * 8: [unoccupied]
     * 9: [unoccupied]
     * 10: [unoccupied]
     * 11: [unoccupied]
     *
     * 11 guests should always be displayed. If the user inputs a number at the end of the array the last 11 capsules should be displayed. If the user enters a number at the beginning of the array the first 11 capsules should be displayed. Otherwise the capsule number entered and the 5 below it and 5 above it should be displayed.
     *
     * If the user enters a capsule number that does not exist the user should see the following error message:
     * Error :(
     * Capsule #51 does not exist. (51 is an example, this number should be replaced with the user input)
     */

    public static void viewGuests(Scanner console){
        String vacantStatus = "[unoccupied]";
        // errorNotice

        System.out.println("Enter room #:");
        int choiceNum = Integer.getInteger(console.nextLine());
        System.out.println("Capsule: Guest");
        if(false) { // test to see if room number exists
            System.out.println("Error :(");
            System.out.println("Capsule #" + choiceNum + " does not exist.");
            return;
        }
        if(choiceNum < 6) {
            choiceNum = 6;
        }
        /*if(choiceNum > (max-5)) { // what is max?
            choiceNum = max;
        }*/
        for(int i = choiceNum-10; i <= choiceNum+10; i++){
            System.out.println(i);
        }
    }

    /**
     * Method Name: confirmExit
     * The confirmExit method is designed to prompt the user for confirmation before exiting a program. It takes a Scanner object for user input and returns a boolean value indicating whether the user wants to proceed with the exit.
     * @param Scanner console
     * @return boolean
     * if the user enters y or Y the method should return true, otherwise it should return false.
     */

    public static boolean confirmExit(Scanner console){
        System.out.println("Are you sure you wish to exit CapsKeeper? (Enter Y to Exit)");
        if(console.nextLine().equalsIgnoreCase("y")) {
            return true; // placeholder
        }
        else{
            return false;
        }
    }
}