public class PersonalTask extends Task {
    public PersonalTask(String title, String description) {
        super(title, description);
    }
    public String getDetails() {
        return "[Personal Task]\n" + super.getDetails();
    }
}
