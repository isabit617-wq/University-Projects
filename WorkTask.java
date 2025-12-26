public class WorkTask extends Task {
    public WorkTask(String title, String description) {
        super(title, description);
    }

    @Override
    public String getDetails() {
        return "[Work Task]\n" + super.getDetails();
    }
}
