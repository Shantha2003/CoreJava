//Java program to set up connection and get all data from table
import java.sql.*;
import java.util.Scanner;

public class GFG {
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter RollNo: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the name: ");
        String newName = sc.nextLine();

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/school",
                    "root", "root");

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from student");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int tempRNo = resultSet.getInt("roll_no");
                System.out.println("Name : " + name
                        + " RollNo : " + tempRNo);
            }

            PreparedStatement prepared = connection.prepareCall("UPDATE student set name = ? where roll_no = ?");
            prepared.setString(1, newName);
            prepared.setInt(2, rollNo);

            int rowUpdated = prepared.executeUpdate();

            if (rowUpdated > 0)
                System.out.println("Student name updated successfully.");
            else
                System.out.println("No student found with rollno: "+rollNo);
            resultSet.close();
            prepared.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    } // function ends
} // class ends
