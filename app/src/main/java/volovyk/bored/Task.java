package volovyk.bored;

public class Task {
    private String name;
    private String type;
    private int availability;

    public Task(String name, String type, int availability) {
        this.name = name;
        this.type = type;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAvailability() {
        return availability;
    }
}
