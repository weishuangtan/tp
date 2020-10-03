package seedu.trippie;

public class Ui {

    private static final String SECTION_BREAK = "_______________________________________________";

    public static void greetUser() {
        logo();
        System.out.println("How can I help you?");
        System.out.println(SECTION_BREAK);
    }

    public static void logo() {
        String logo = "  _            _   ____   ____   _            __T___T__   \n"
                + " _| |_   ____ |_| | __ \\ | __ \\ |_|   ____   /         \\ \n"
                + "|_   _| /  __\\ _  | |_| || |_| | _   / __ \\ | |_|   |_| |  \n"
                + "  | | _ | |   | | |  __/ |  __/ | | | |__|_||    ___    |\n"
                + "  | |/ || |   | | | |    | |    | | | \\____  \\  \\WWW/  /\n"
                + "   \\__/ |_|   |_| |_|    |_|    |_|  \\____/   \\_______/\n";
        System.out.println("Welcome to\n" + logo + "\n\t\t\t\t\t\t\tyour number one trip planner");
        System.out.println(SECTION_BREAK);
    }

}
