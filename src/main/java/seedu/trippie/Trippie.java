package seedu.trippie;

public class Trippie {
    //private final Storage storage;
    private final Ui ui;

    public Trippie(String filePath) {
        ui = new Ui();
    }

    public static void main(String[] args) {
        new Trippie("data/duke.txt").run();
    }

    public void run() {
        ui.welcomeMessage();
        boolean isExit = false;
        //String fullCommand = ui.readCommand();
        //Parser.parse(fullCommand);
        /*
        while (!isExit) {
            try {
                storage.save(tasks.getList());
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                if (c != null) {
                    c.execute(tasks, ui, storage);
                    isExit = c.isExit();
                }
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
        */
    }
}
