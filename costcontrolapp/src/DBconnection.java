import java.sql.*;

public class DBconnection {

    public static void main(String[] args) {

        try {

            String dbUrl = "jdbc:sqlite:costcontrolapp.db";
            Connection conn = DriverManager.getConnection(dbUrl);

            if( conn != null ) {
                DatabaseMetaData databaseMetadata = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Connected to " + databaseMetadata.getDatabaseProductName() + " " + databaseMetadata.getDatabaseProductVersion());

                // CREATING A projects TABLE
                Statement statement = conn.createStatement();
                String sqlStatement =
                        "CREATE TABLE IF NOT EXISTS projects"+
                                " (project_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "project_name TEXT NOT NULL," +
                                "description TEXT NOT NULL," +
                                "totalFinances INT NOT NULL)";
                statement.execute(sqlStatement);

                // INSERT ROWS in PROJECTS TABLE
                sqlStatement = "INSERT INTO projects (project_name, description)" +
                        "values ( ' ' + 'To Be a Mom' + 'Project Description' + 600 )";
                statement.execute(sqlStatement);

                sqlStatement = "INSERT INTO projects (project_name, description)" +
                        "values ( ' ' + 'Heart's Melody' + 'Project Description 2' + 400 )";
                statement.execute(sqlStatement);


                // CREATING events TABLE
                statement = conn.createStatement();
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS events"+
                                " (events_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "project_event TEXT NOT NULL," +
                                "events_name TEXT NOT NULL," +
                                "totalFinancesForEvent TEXT NOT NULL)";
                statement.execute(sqlStatement);

                // INSERT ROWS in PROJECTS TABLE

                // CREATING bills TABLE
                statement = conn.createStatement();
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS bills"+
                                " (bill_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "bill_number INTEGER NOT NULL," +
                                "company TEXT NOT NULL," +
                                "sum FLOAT NOT NULL," +
                                "project TEXT NOT NULL," +
                                "event TEXT NOT NULL,"  +
                                "category TEXT NOT NULL)";
                statement.execute(sqlStatement);

                // CREATING categories TABLE
                statement = conn.createStatement();
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS categories"+
                                " (category_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "category_name INTEGER NOT NULL)";
                statement.execute(sqlStatement);

            }

        } catch( SQLException exception ) {
            System.out.println("An error has occurred" + exception.toString());
        }


    }
        //methods *6 create & select for projects, events, bills



}