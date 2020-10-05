package seedu.trippie;

import java.util.Scanner;

public class Ui {

    private static final String SECTION_BREAK = "_______________________________________________";

    Scanner in = new Scanner(System.in);

    public void welcomeMessage() {
        logo();
        System.out.println("How can I help you?");
        System.out.println(SECTION_BREAK);
    }

    public void logo() {
        String logo = "  _            _   ____   ____   _            __T___T__   \n"
                + " _| |_   ____ |_| | __ \\ | __ \\ |_|   ____   /         \\ \n"
                + "|_   _| /  __\\ _  | |_| || |_| | _   / __ \\ | |_|   |_| |  \n"
                + "  | | _ | |   | | |  __/ |  __/ | | | |__|_||    ___    |\n"
                + "  | |/ || |   | | | |    | |    | | | \\____  \\  \\WWW/  /\n"
                + "   \\__/ |_|   |_| |_|    |_|    |_|  \\____/   \\_______/\n";
        System.out.println("Welcome to\n" + logo + "\n\t\t\t\t\t\t\tyour number one trip planner");
        System.out.println(SECTION_BREAK);
    }

    public void FarewellMessage() {
        System.out.println("Bye! See you again soon!");
    }

    public String readCommand() {
        System.out.print(">> ");
        return in.nextLine();
    }

}
