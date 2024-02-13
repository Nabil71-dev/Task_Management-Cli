package taskController;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskStructure {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String name;
    private String description;
    private Date dueDate;
    private boolean completed;

    public TaskStructure(String taskName, String desc, Date due, boolean taskStatus){
        this.name=taskName;
        this.description=desc;
        this.dueDate=due;
        this.completed=taskStatus;
    }
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean taskCompleted) {
        this.completed = taskCompleted;
    }

    @Override
    public String toString() {
        return "Task: " + name + ", Description: " + description + ", Due Date: " + dateFormat.format(dueDate) + ", Status: " + (completed ? "Completed" : "Pending");
    }
}
