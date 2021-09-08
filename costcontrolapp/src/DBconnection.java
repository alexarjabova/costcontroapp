import java.sql.*;
import java.util.Scanner;

public class DBconnection {

    public static void main(String[] args) {

        try {

            String dbUrl = "jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\costcontroapp\\costcontrolapp.db";
            Connection conn = DriverManager.getConnection(dbUrl);

            if( conn != null ) {
                DatabaseMetaData databaseMetadata = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Connected to " + databaseMetadata.getDatabaseProductName() + " " + databaseMetadata.getDatabaseProductVersion());

                // CREATING A projects TABLE
                //createProject();

                // INSERT ROWS in PROJECTS TABLE
                //statement.execute("INSERT INTO projects (project_name,description, totalFinances) VALUES ('To be a MOM', 'To be a MOM is a project for moms and their children to create closer relations between them', '600')");
                //statement.execute("INSERT INTO projects (project_name,description, totalFinances) VALUES ('Hearts Melody', 'Hearts Melody is a project for expectant mothers and families with children', '400')");


                // CREATING events TABLE
                //createEvent();


                // CREATING bills TABLE
                //createBill();

                // CREATING categories TABLE
                Statement statement = conn.createStatement();
                String sqlStatement =
                        "CREATE TABLE IF NOT EXISTS categories"+
                                "(category_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "category_name TEXT NOT NULL)";
                statement.execute(sqlStatement);

                //SELECT * from
                //selectProjects();
                //selectEvents();
                //selectBills();


            }

        } catch( SQLException exception ) {
            System.out.println("An error has occurred" + exception.toString());
        }


    }
        //methods *6 create & select for projects, events, bills

    public void createProject(Project project) throws SQLException {
        //Scanner scan = new Scanner(System.in);

        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\costcontroapp\\costcontrolapp.db");
        Statement statement = conn.createStatement();
        String sqlStatement =
                "CREATE TABLE IF NOT EXISTS projects"+
                        " (project_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "project_name TEXT NOT NULL," +
                        "description TEXT NOT NULL," +
                        "totalFinances INT NOT NULL)";
        statement.execute(sqlStatement);

        /**System.out.println("Enter the Projects name: ");
        String projectName = scan.next();
        System.out.println("Enter the Projects description: ");
        String projectDescription = scan.next();
        System.out.println("Enter the Projects total Finances: ");
        int totalFinances = scan.nextInt();
         */
        statement.execute("INSERT INTO projects (project_name, description, totalFinances) VALUES ('" +  project.getProjectName() + "' , '" +  project.getDescription() + "' , '" +  project.getTotalFinances() + "')");

    }

    public static void selectProjects() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\costcontroapp\\costcontrolapp.db");
        Statement statement = conn.createStatement();
        String sqlStatement = "SELECT * FROM projects";
        ResultSet resultSet = statement.executeQuery(sqlStatement);

        while ( resultSet.next() ) {
            String projectID = resultSet.getString("project_id");
            String projectName = resultSet.getString("project_name");
            String description = resultSet.getString("description");
            int totalFinances = resultSet.getInt("totalFinances");

            System.out.println("Project ID:" + projectID + " Project name: " + projectName + " Description: " + description + " Budget:" + totalFinances);
        }

    }

    public static void createEvent(Event event) throws SQLException {
        Scanner scan = new Scanner(System.in);

        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\costcontroapp\\costcontrolapp.db");
        Statement statement = conn.createStatement();
        String sqlStatement = "CREATE TABLE IF NOT EXISTS events" +
                " (events_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "project_event TEXT NOT NULL," +
                "events_name TEXT NOT NULL," +
                "totalFinancesForEvent TEXT NOT NULL)";
        statement.execute(sqlStatement);

        /** events table data
        statement.execute("INSERT INTO events (project_event, events_name, totalFinancesForEvent) VALUES ('To be a MOM' , 'Seminar “Breastfeeding ABC”' , '130')");
        statement.execute("INSERT INTO events (project_event, events_name, totalFinancesForEvent) VALUES ('To be a MOM' , 'MOM School' , '115')");
        statement.execute("INSERT INTO events (project_event, events_name, totalFinancesForEvent) VALUES ('To be a MOM' , 'Workshop “Family miracles”' , '130')");
        statement.execute("INSERT INTO events (project_event, events_name, totalFinancesForEvent) VALUES ('Hearts Melody' , 'Christmas Evening' , '575')");
        statement.execute("INSERT INTO events (project_event, events_name, totalFinancesForEvent) VALUES ('Hearts Melody' , 'Photo exhibition “Be a Family”' , '160')");
        statement.execute("INSERT INTO events (project_event, events_name, totalFinancesForEvent) VALUES ('Hearts Melody' , 'Event for expectant mothers “Bebīšu lietus”' , '185')");
        */

        System.out.println("Enter the Project name: ");
        String projectName = scan.next();
        System.out.println("Enter the Event name: ");
        String eventName = scan.next();
        System.out.println("Enter the total Finances for Event: ");
        int totalFinancesForEvent = scan.nextInt();
        statement.execute("INSERT INTO events (project_event, events_name, totalFinancesForEvent) VALUES ('" +  projectName + "' , '" +  eventName + "' , '" +  totalFinancesForEvent + "')");

    }

    public void selectEvents() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\costcontroapp\\costcontrolapp.db");
        Statement statement = conn.createStatement();
        String sqlStatement = "SELECT * FROM events";
        ResultSet resultSet = statement.executeQuery(sqlStatement);

        while ( resultSet.next() ) {
            String eventsID = resultSet.getString("events_id");
            String projectName = resultSet.getString("project_event");
            String eventName = resultSet.getString("events_name");
            int totalFinancesForEvent = resultSet.getInt("totalFinancesForEvent");

            System.out.println("Event ID:" + eventsID + " Project name: " + projectName + " Event name: " + eventName + " Budget for Event:" + totalFinancesForEvent);
        }
    }

    public static void selectEventsToBeAMom() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\costcontroapp\\costcontrolapp.db");
        Statement statement = conn.createStatement();
        String sqlStatement = "SELECT * FROM events where project_event = 'To be a MOM'";
        ResultSet resultSet = statement.executeQuery(sqlStatement);

        while ( resultSet.next() ) {
            String eventsID = resultSet.getString("events_id");
            String projectName = resultSet.getString("project_event");
            String eventName = resultSet.getString("events_name");
            int totalFinancesForEvent = resultSet.getInt("totalFinancesForEvent");

            System.out.println("Event ID:" + eventsID + " Project name: " + projectName + " Event name: " + eventName + " Budget for Event:" + totalFinancesForEvent);
        }
    }

    public static void selectEventsHeartsMelody() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\costcontroapp\\costcontrolapp.db");
        Statement statement = conn.createStatement();
        String sqlStatement = "SELECT * FROM events where project_event = 'Hearts Melody' ";
        ResultSet resultSet = statement.executeQuery(sqlStatement);

        while ( resultSet.next() ) {
            String eventsID = resultSet.getString("events_id");
            String projectName = resultSet.getString("project_event");
            String eventName = resultSet.getString("events_name");
            int totalFinancesForEvent = resultSet.getInt("totalFinancesForEvent");

            System.out.println("Event ID:" + eventsID + " Project name: " + projectName + " Event name: " + eventName + " Budget for Event:" + totalFinancesForEvent);
        }
    }


    public void createBill(Bill bill) throws SQLException {
        //Scanner scan = new Scanner(System.in);

        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\costcontroapp\\costcontrolapp.db");
        Statement statement = conn.createStatement();
        String sqlStatement =
                "CREATE TABLE IF NOT EXISTS bills"+
                        " (bill_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "bill_number INTEGER NOT NULL," +
                        "company TEXT NOT NULL," +
                        "sum FLOAT NOT NULL," +
                        "project TEXT NOT NULL," +
                        "event TEXT NOT NULL,"  +
                        "category TEXT NOT NULL)";
        statement.execute(sqlStatement);

        /**System.out.println("Enter the Bill number: ");
        int billNumber = scan.nextInt();
        System.out.println("Enter the Companies name: ");
        String companyName = scan.next();
        System.out.println("Enter the total sum on Bil: ");
        float sumOfBill = scan.nextFloat();
        System.out.println("Enter the Projects name: ");
        String projectName = scan.next();
        System.out.println("Enter the Event name: ");
        String eventName = scan.next();
        System.out.println("Enter the Category: ");
        String category = scan.next();
         */
        statement.execute("INSERT INTO bills (bill_number, company, sum, project, event, category) VALUES ('" +  bill.getBillNumber() + "' , '" +  bill.getCompany() + "' , '" +  bill.getSum() + "' , '" + bill.getProjectName() + "' , '" +  bill.getEventName() + "' , '" +  bill.getCategory() + "')");

    }

    public static void selectBills() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\costcontroapp\\costcontrolapp.db");
        Statement statement = conn.createStatement();
        String sqlStatement = "SELECT * FROM bills";
        ResultSet resultSet = statement.executeQuery(sqlStatement);

        while ( resultSet.next() ) {
            //String billsID = resultSet.getString("bill_id");
            String billNumber = resultSet.getString("bill_number");
            String company = resultSet.getString("company");
            int sum = resultSet.getInt("sum");
            String category = resultSet.getString("category");

            System.out.println("Bill number:" + billNumber + " Company: " + company + " Event name: " + company + " Category: " + category + " Bills sum:" + sum);
        }
    }

    public void deleteBill() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\costcontroapp\\costcontrolapp.db");
        Statement statement = conn.createStatement();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Bills ID to delete: ");
        int billIDdelete = scan.nextInt();
        scan.nextLine();

        String sqlStatement = "DELETE FROM bills " +
                " WHERE bill_id = '" + billIDdelete + "'";
        statement.execute(sqlStatement);
    }

    }