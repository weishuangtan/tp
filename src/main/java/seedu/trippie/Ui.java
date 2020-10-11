package seedu.trippie;

import java.util.Scanner;

public class Ui {

    Scanner in = new Scanner(System.in);

    public void greetUser() {
        printLogo();
        printLine();
        System.out.println("How can I help you?");
        printLine();
    }

    private void printLogo() {
        String logo = "  _            _   ____   ____   _            __T___T__   \n"
                + " _| |_   ____ |_| | __ \\ | __ \\ |_|   ____   /         \\ \n"
                + "|_   _| /  __\\ _  | |_| || |_| | _   / __ \\ | |_|   |_| |  \n"
                + "  | | _ | |   | | |  __/ |  __/ | | | |__|_||    ___    |\n"
                + "  | |/ || |   | | | |    | |    | | | \\____  \\  \\WWW/  /\n"
                + "   \\__/ |_|   |_| |_|    |_|    |_|  \\____/   \\_______/\n";
        System.out.println("Welcome to\n" + logo +
                "\n\t\t\t\t\t\t\t" + "Travel made easy");
    }

    public void printLine() {
        System.out.println("____________________________________________________");
    }

    public String readCommand() {
        System.out.print(">> ");
        return in.nextLine();
    }
}
