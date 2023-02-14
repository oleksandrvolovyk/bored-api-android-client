package volovyk.bored.data;

public class Task {
    private final String name;
    private final String type;
    private final int availability;

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
