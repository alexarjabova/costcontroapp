public class Bill extends DBconnection {
    protected int billID;
    protected int billNumber;
    protected String company;
    protected float sum;
    protected String projectName;
    protected String eventsName;
    protected String category;

    public Bill() {
    }

    public Bill(int billID, int billNumber, String company, float sum, String projectName, String eventsName, String category) {
        this.billID = billID;
        this.billNumber = billNumber;
        this.company = company;
        this.sum = sum;
        this.projectName = projectName;
        this.eventsName = eventsName;
        this.category = category;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getEventsName() {
        return eventsName;
    }

    public void setEventsName(String eventsName) {
        this.eventsName = eventsName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
