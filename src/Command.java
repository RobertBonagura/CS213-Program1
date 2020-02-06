public class Command {

    private char cmd;
    private String name;
    private String date;

    public Command(char cmd, String name, String date) {
        this.cmd = cmd;
        this.name = name;
        this.date = date;
    }

    public char getCmd() {
        return cmd;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
