public class projects extends DBconnection {
    protected  int projectID;
    protected String projectName;
    protected String description;
    protected int totalFinances;

    public projects(int projectID, String projectName, String description, int totalFinances) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.description = description;
        this.totalFinances = totalFinances;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalFinances() {
        return totalFinances;
    }

    public void setTotalFinances(int totalFinances) {
        this.totalFinances = totalFinances;
    }
}
