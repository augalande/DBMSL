import java.sql.*;
import java.util.Scanner;

public class Connectivity {
    private Connection databaseConnection;
    private String dbuser = "root";
    private String dbpwd = "aruaryan98";
    private String dburl = "jdbc:mysql://localhost:3306/asgmt08";

    public Connectivity() {
        try {
            databaseConnection = DriverManager.getConnection(dburl, dbuser, dbpwd);
            CRUDOperations();
            databaseConnection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void CRUDOperations() {
        try {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Choose Operation:");
                System.out.println("1. Create Table");
                System.out.println("2. Insert");
                System.out.println("3. Read");
                System.out.println("4. Update");
                System.out.println("5. Delete");
                System.out.println("6. Exit");
                System.out.println("Enter Choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        createTable();
                        break;
                    case 2:
                        insertRecords();
                        break;
                    case 3:
                        readRecords();
                        break;
                    case 4:
                        updateRecord();
                        break;
                    case 5:
                        deleteRecord();
                        break;  // You were missing 'break' here
                    case 6:
                        databaseConnection.close();  // Close the connection before returning
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTable() {
        try {
            Statement statement = databaseConnection.createStatement();
            String sqlString = "CREATE TABLE Student(Roll_No INT PRIMARY KEY, Name VARCHAR(50), Marks INT)";
            statement.execute(sqlString);
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void insertRecords() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Roll_No: ");
            int rno = sc.nextInt();
            sc.nextLine();  // Consume newline
            System.out.print("Enter Name: ");
            String name = sc.nextLine();  // Read the name as a string
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            String insertSQL = "INSERT INTO Student (Roll_No, Name, Marks) VALUES (?, ?, ?)";
            PreparedStatement prepStatement = databaseConnection.prepareStatement(insertSQL);
            prepStatement.setInt(1, rno);
            prepStatement.setString(2, name);
            prepStatement.setInt(3, marks);
            prepStatement.executeUpdate();
            prepStatement.close();
            System.out.println("Record inserted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void readRecords() {
        try {
            Statement statement = databaseConnection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Student");

            while (resultSet.next()) {
                int rno = resultSet.getInt("Roll_No");
                String name = resultSet.getString("Name");
                int marks = resultSet.getInt("Marks");
                System.out.println("RollNo: " + rno + " Name: " + name + " Marks: " + marks);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateRecord() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the Roll_No of the student whose marks you want to update: ");
            int rno = sc.nextInt();
            sc.nextLine();  // Consume newline
            System.out.print("Enter updated marks: ");
            int marks = sc.nextInt();

            String updateSQL = "UPDATE Student SET Marks = ? WHERE Roll_No = ?";
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateSQL);
            preparedStatement.setInt(1, marks);
            preparedStatement.setInt(2, rno);
            int rowsUpdated = preparedStatement.executeUpdate();
            preparedStatement.close();

            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record found with the specified ID.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteRecord() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Roll_No of the student you want to delete: ");
            int rno = sc.nextInt();

            String deleteSql = "DELETE FROM Student WHERE Roll_No = ?";
            PreparedStatement prepStatement = databaseConnection.prepareStatement(deleteSql);
            prepStatement.setInt(1, rno);
            int rowsDeleted = prepStatement.executeUpdate();
            prepStatement.close();

            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("No record found with the specified ID.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Connectivity c = new Connectivity();
    }
}