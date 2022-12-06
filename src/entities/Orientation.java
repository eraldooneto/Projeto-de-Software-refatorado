package entities;

public class Orientation extends AcademicProduction{
    private String description;
    private int numberOfTasks;
    private String [] tasks = new String[numberOfTasks];
    
    public Orientation() {

    }

    public Orientation(String title, String description, Integer year, int numberOfTasks, String [] tasks) {
        super(title, year);
        this.description = description;
        this.numberOfTasks = numberOfTasks;
        this.tasks = tasks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public String[] getTasks() {
        return tasks;
    }

    public void setTasks(String [] tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Orientation Title: " + title + 
        "\nOrientation Description: " + description + 
        "\nYear of Orientation: " + year;
    }
}