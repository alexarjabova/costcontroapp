import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DBconnection db = new DBconnection();

        //Menu for User
        Scanner scan = new Scanner(System.in);
        int menuEntry;
            do {
                System.out.println();
                System.out.println("Hello in Cost Control Application! Please, select an option:");
                //System.out.println("1 - I want to see all the bills/receipts");
                System.out.println("1 - I want to add a new project");
                System.out.println("2 - I want to see all the Projects and Description");
                System.out.println("3 - I want to see all the Events by Project name");
                System.out.println("4 - I want to see a spent amount by year");
                System.out.println("5 - I want to add a new bill");
                System.out.println("6 - I want to delete a bill"); //using bill_number
                System.out.println("0 - Exit, please.");
                menuEntry = scan.nextInt();

                switch (menuEntry) {

                    case 1:
                        try {
                            Project project = new Project();
                            System.out.println("Please enter the Project name:");
                            project.setProjectName(scan.next());
                            System.out.println("Please enter the Project description:");
                            project.setDescription(scan.next());
                            System.out.println("Please enter the Project total Budget:");
                            project.setTotalFinances(scan.nextInt());
                            db.createProject(project);

                        } catch (SQLException exception) {
                            System.out.println("An error has occurred" + exception.toString());
                        }
                    break;

                    case 2:
                        try {
                            db.selectProject

                        } catch (SQLException exception) {
                            System.out.println("An error has occurred" + exception.toString());
                        }
                        break;

                    default:

                    }
                }
            while (menuEntry != 0);
    }
}
