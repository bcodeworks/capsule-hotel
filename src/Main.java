import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String[] capsules = null;
    public static int guestCount = 0;

    public static String successNotice = "Success :)";
    public static String errorNotice = "Error :(";
    public static String existFail = " does not exist.";
    public static String capNo = "Capsule #";

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        System.out.println("Welcome to CapsKeeper!");
        // Setup
        System.out.println("How many capsules are available today?");
        Scanner console = new Scanner(System.in);
        int choiceNum = Integer.parseInt(console.nextLine());
        capsules = new String[choiceNum];

        // Main Menu
        String choiceStr = "";
        boolean escapeMenu = false;
        boolean actionSuccess = true;
        while(!escapeMenu){
            // test choiceStr = getMenuOption(console);
            // test System.out.println("YOU CHOSE " + choiceStr);
            switch(getMenuOption(console)){
                case "1":
                    actionSuccess = handleCheckIn(console);
                    break;
                case "2":
                    actionSuccess = handleCheckOut(console);
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
                    // test System.out.println("which was " + choiceStr);
                    break;
            }

        }
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.

    }

    /**
    Method Name: getMenuOption
    The getMenuOption method is designed to display a simple menu for a guest system
    and prompt the user to choose an option.
    It takes a Scanner object as a parameter to read user input
    and returns the selected option as a String.
    @param console //Scanner console
    @return String
    */

    public static String getMenuOption(Scanner console){
        System.out.println("\nSelect an option:");
        System.out.println("1. Check in a guest");
        System.out.println("2. Check out a guest");
        System.out.println("3. View guest information");
        System.out.println("4. Exit program");
        return console.nextLine();
    }

    /**
     * Method Name: handleCheckIn
     * The handleCheckIn method is designed to facilitate the check-in process for guests into capsules.
     * It takes a Scanner object for user input and a String representing the guest's name.
     * The method returns a boolean value indicating the success or failure of the check-in process.
     * @param console //Scanner console
     * // @param guestName //String guestName
     * @return boolean
     * If the capsule number does not exist the user should see the following error message:
     * Error :(
     * Capsule #9 does not exist.
     * (9 is an example, should be replaced by the capsule number the user tries to input)
     * If the Guest is successfully booked the user should see the following success message:
     * Success :)
     * John is booked in capsule #3
     * (John and 3 are examples, they should be replaced by the user inputs)
     * If the capsule is occupied the user should see the following error message:
     * Error :(
     * Capsule #5 is occupied.
     * (5 is an example, should be replaced by the capsule number the user tries to input)
     */

    public static boolean handleCheckIn(Scanner console){
        String bookNotice = " is booked in capsule #";
        String occupiedNotice = " is occupied.";

        // Take input
        System.out.println("Enter guest name:");
        String guestName = console.nextLine();
        System.out.println("Enter room #:");
        int choiceNum = Integer.parseInt(console.nextLine())-1;

        if(choiceNum >= capsules.length) { // test to see if room number does not exist
            System.out.println(errorNotice);
            System.out.println(capNo + (choiceNum+1) + existFail);
            return false;
        }
        if(capsules[choiceNum] != null){ // test to see if unoccupied
            System.out.println(errorNotice);
            System.out.println(capNo + (choiceNum+1) + occupiedNotice);
            return false;
        }

        // Check in guest
        System.out.println(successNotice);
        System.out.println(guestName + bookNotice + (choiceNum+1));
        capsules[choiceNum] = guestName;
        guestCount++;
        return true;
    }

    /**
     * Method Name: handleCheckOut
     * The handleCheckOut method is designed to manage the check-out process for guests from capsules.
     * It takes a Scanner object for user input and returns a boolean value
     * indicating the success or failure of the check-out process.
     * @param console //Scanner console
     * @return boolean
     * If no guests are checked into the hotel the user should see the following error message:
     * Sorry... check out is only available if there's at least one guest.
     * If the capsule number does not exist the user should see the following error message:
     * Error :(
     * Capsule #9 does not exist.
     * (9 is an example, should be replaced by the capsule number the user tries to input)
     * If the Guest is successfully booked the user should see the following success message:
     * Success :)
     * John checked out from capsule #3
     * (John and 3 are examples, they should be replaced by the user inputs)
     * If the capsule is unoccupied the user should see the following error message:
     * Error :(
     * Capsule #5 is unoccupied.
     * (5 is an example, should be replaced by the capsule number the user tries to input)
     */

    public static boolean handleCheckOut(Scanner console){
        String sorryNotice = "Sorry... check out is only available if there's at least one guest.";
        String checkoutNotice = " checked out from capsule #";
        String vacantNotice = " is unoccupied";

        if(guestCount == 0) { // check if hotel is empty
            System.out.println(sorryNotice);
            return false;
        }

        // Take input
        System.out.println("Enter room #:");
        int choiceNum = Integer.parseInt(console.nextLine())-1;

        if(choiceNum >= capsules.length || choiceNum < 0) { // test to see if room number does not exist
            System.out.println(errorNotice);
            System.out.println(capNo + (choiceNum+1) + existFail);
            return false;
        }
        else if(capsules[choiceNum] == null){ // test to see if unoccupied
            System.out.println(errorNotice);
            System.out.println(capNo + (choiceNum+1) + vacantNotice);
            return false;
        }

        // Check out guest
        System.out.println(successNotice);
        System.out.println(capsules[choiceNum] + checkoutNotice + choiceNum);
        capsules[choiceNum] = null;
        guestCount--;
        return true;
    }

    /**
     * Method Name: viewGuests
     * The viewGuests method is designed to display information about the guests occupying capsules.
     * It takes a Scanner object for user input
     * and prints a list of guests in capsules along with their capsule numbers,
     * if the capsule is null [unoccupied] should be printed, otherwise the guest name should be printed.
     * @param console //Scanner console
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
     * 11 guests should always be displayed. If the user inputs a number at the end of the array the last 11 capsules should be displayed. If the user enters a number at the beginning of the array the first 11 capsules should be displayed. Otherwise the capsule number entered and the 5 below it and 5 above it should be displayed.
     * If the user enters a capsule number that does not exist the user should see the following error message:
     * Error :(
     * Capsule #51 does not exist. (51 is an example, this number should be replaced with the user input)
     */

    public static void viewGuests(Scanner console){
        String vacantStatus = "[unoccupied]";

        System.out.println("Enter room #:");
        int choiceNum = Integer.parseInt(console.nextLine())-1;
        System.out.println("Capsule: Guest");

        if(choiceNum >= capsules.length || choiceNum < 0) { // test to see if room number does not exist
            System.out.println(errorNotice);
            System.out.println(capNo + (choiceNum+1) + existFail);
            return;
        }

        // Print all capsules if 11 or less
        if(capsules.length <= 11){
            for(int i = 0; i < 11; i++){
                if(capsules[i] == null) {
                    System.out.println((i+1) + ": " + vacantStatus);
                }
                else {
                    System.out.println((i+1) + ": " + capsules[i]);
                }
            }
            return;
        }

        // Print only the 11 capsules around chosen capsule
        if(choiceNum < 5) {
            choiceNum = 5;
        }
        if(choiceNum > (capsules.length-6)) {
            choiceNum = capsules.length-6;
        }
        for(int i = choiceNum-5; i <= choiceNum+5; i++){
            if(capsules[i] == null) {
                System.out.println((i+1) + ": " + vacantStatus);
            }
            else {
                System.out.println((i+1) + ": " + capsules[i]);
            }
        }
    }

    /**
     * Method Name: confirmExit
     * The confirmExit method is designed to prompt the user for confirmation before exiting a program.
     * It takes a Scanner object for user input
     * and returns a boolean value indicating whether the user wants to proceed with the exit.
     * @param console //Scanner console
     * @return boolean
     * if the user enters y or Y the method should return true, otherwise it should return false.
     */

    public static boolean confirmExit(Scanner console){
        System.out.println("Are you sure you wish to exit CapsKeeper? (Enter Y to Exit)");
        return console.nextLine().equalsIgnoreCase("y");
    }
}