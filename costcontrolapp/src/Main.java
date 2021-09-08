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
                System.out.println("1 - I want to add a new project");
                System.out.println("2 - I want to see all the Projects and Description");
                //System.out.println("3 - I want to see all the Events by Project name"); // nav gatavs
                System.out.println("4 - I want to see all the Events by Project name");
                System.out.println("5 - I want to add a new bill");
                System.out.println("6 - I want to see all the bills/receipts");
                System.out.println("7 - I want to delete a bill"); //using bill_number
                System.out.println("8 - How much money is spent at all?");
                System.out.println("0 - Exit, please.");
                menuEntry = scan.nextInt();
                scan.nextLine();

                switch (menuEntry) {

                    case 1:
                        try {
                            Project project = new Project();
                            System.out.println("Please enter the Project name:");
                            project.setProjectName(scan.nextLine());
                            System.out.println("Please enter the Project description:");
                            project.setDescription(scan.nextLine());
                            System.out.println("Please enter the Project total Budget:");
                            project.setTotalFinances(scan.nextInt());
                            scan.nextLine();
                            db.createProject(project);

                        } catch (SQLException exception) {
                            System.out.println("An error has occurred" + exception.toString());
                        }
                    break;

                    case 2:
                        try {
                            db.selectProjects();
                        } catch (SQLException exception) {
                            System.out.println("An error has occurred" + exception.toString());
                        }
                        break;

                    case 3:
                        try {
                            db.selectEventsToBeAMom();
                        } catch (SQLException exception) {
                            System.out.println("An error has occurred" + exception.toString());
                        }
                        break;

                    case 4:
                        try {
                           //Event event = new Event("To be a MOM", "Easter", 200);
                           //db.createEvent(event);

                           //if (event.getProjectName().equalsIgnoreCase("To be a MOM")) {
                               //System.out.println(event.toString());}

                            System.out.println("Please enter the Project name to find all Events:");
                            String projectNamebyUser = scan.nextLine();

                            //assertTrue(src.matches("(?i)." + dest + ".")); ARTJOMS! SOS

                            if (projectNamebyUser.equalsIgnoreCase("To be a mom")) {
                                db.selectEventsToBeAMom();
                            } else if (projectNamebyUser.equalsIgnoreCase("Hearts Melody")) {
                                db.selectEventsHeartsMelody();
                            } else {
                                System.out.println("Check the Project name, please!");
                            }

                        } catch (SQLException exception) {
                            System.out.println("An error has occurred" + exception.toString());
                        }
                        break;

                    case 5:
                        try {
                            Bill bill = new Bill();
                            System.out.println("Please enter the Bill number:");
                            bill.setBillNumber(scan.nextInt());
                            scan.nextLine();
                            System.out.println("Please enter the company name:");
                            bill.setCompany(scan.nextLine());
                            System.out.println("Please enter the Bills sum:");
                            bill.setSum(scan.nextFloat());
                            scan.nextLine();
                            System.out.println("Please enter the Project name:");
                            bill.setProjectName(scan.nextLine());
                            System.out.println("Please enter the Event name:");
                            bill.setEventsName(scan.nextLine());
                            System.out.println("Please enter the Bills category:");
                            bill.setCategory(scan.nextLine());
                            db.createBill(bill);

                        } catch (SQLException exception) {
                            System.out.println("An error has occurred" + exception.toString());
                        }
                        break;

                    case 6:
                        try {
                            db.selectBills();
                        } catch (SQLException exception) {
                            System.out.println("An error has occurred" + exception.toString());
                        }
                        break;

                    case 7:
                        try {

                            /** System.out.println("Enter Bills ID to delete: ");
                            int billIDdelete = scan.nextInt();
                            scan.nextLine();
                            db.deleteBill(); */
                            db.deleteBill();
                        } catch (SQLException exception) {
                            System.out.println("An error has occurred" + exception.toString());
                        }
                        break;

                    case 8:

                        break;

                    default:

                    }
                }
            while (menuEntry != 0);
    }
}
