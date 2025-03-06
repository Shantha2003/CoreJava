
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Student{
    String name;
    int rollNo;
    int marks;
    int branchid;

    Student(String name, int rollNo, int marks, int branhid){
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        this.branchid = branchid;
    }

}

class StudentDetail{
    Scanner sc = new Scanner(System.in);
    private List<Student> studentsList = new ArrayList<>();
    Connection con = null;

    StudentDetail(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
            } catch (Exception e) {
                System.out.println("Failed to create connection.");
            }
        } catch (Exception e) {
            System.out.println("Driver not found.");
        }
    }

    public void addStudent() throws SQLException {
        try{
            System.out.println("Enter the name of the student: ");
            String name = sc.next();
            System.out.println("Enter the roll number of the number: ");
            int roll_no = sc.nextInt();
            System.out.println("Enter the marks of the student: ");
            int marks = sc.nextInt();
            System.out.println("Enter the branch id: ");
            int branchId = sc.nextInt();

            PreparedStatement prepared = con.prepareCall("insert into school.student(Name, roll_no, Marks, branchid)values(?, ?, ?, ?);");
            prepared.setString(1, name);
            prepared.setInt(2, roll_no);
            prepared.setInt(3, marks);
            prepared.setInt(4, branchId);
            int rows = prepared.executeUpdate();
        }catch (Exception e){
            System.out.println("Error in adding student: "+e.getMessage());
        }
    }

    public void deleteStudent() throws SQLException {
        try{
            System.out.println("Enter the parameter which you would like to remove: ");
            int rNo = sc.nextInt();
            PreparedStatement pr = con.prepareStatement("delete from student where roll_no = ?;");
            pr.setInt(1, rNo);
            int updatedList = pr.executeUpdate();
            if (updatedList > 0) {
                System.out.println("No student deleted");
            }
            else {
                System.out.println("Student deleted successfully.");
            }
        }
        catch (Exception e){
            System.out.println("Error in deleting: "+e.getMessage());
        }
    }

    public void readStudent() throws SQLException {
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            System.out.println("\nStudent Records:");

            while (rs.next()) {
                System.out.println("ID :"+ rs.getInt("ID") + " Name :" + rs.getString("Name") +
                        " RollNo :" + rs.getInt("roll_no") +" Marks :"+ rs.getInt("Marks") +
                        " Branchid :"+rs.getInt("branchid"));
            }
        }
        catch (Exception e){
            System.out.println("Error in retriving students." +e.getMessage());
        }

    }
}

public class MenuDriven {
    public static void main(String[] args) throws SQLException {
        int option;
        Scanner sc = new Scanner(System.in);
        List<Student> studentsList = new ArrayList<>();

        StudentDetail stud = new StudentDetail();
        do {
            System.out.println("Enter your choice\n 1. Add student\n 2. Read student\n 3. Remove student\n 4. Exit");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    stud.addStudent();
                    break;
                case 2:
                    stud.readStudent();
                    break;
                case 3:
                    stud.deleteStudent();
                    break;
                case 4:
                    System.out.println("Exited");
                    return;
                default:
                    System.out.println("Invalid.");
            }
        }while(option != 4);
    }
}
