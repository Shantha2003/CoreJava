
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Student{
    int id;
    String name;
    int rollNo;
    int marks;

    Student(int id, String name, int rollNo, int marks){
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

}
class StudentDetail{
    Scanner sc = new Scanner(System.in);
    private ArrayList<Student> studentsList = new ArrayList<>();

    public void addStudent(){
        System.out.println("Enter the id of the student: ");
        int id = sc.nextInt();
        System.out.println("Enter the name of the student: ");
        String name = sc.next();
        System.out.println("Enter the roll number of the number: ");
        int rollNo = sc.nextInt();
        System.out.println("Enter the marks of the student: ");
        int marks = sc.nextInt();
        studentsList.add(new Student(id, name, rollNo, marks));
        System.out.println("Student added.");

    }

    public void deleteStudent(){
        System.out.println("Enter the parameter which you would like to remove: ");
        int rNo = sc.nextInt();
        List<Student> updatedList = studentsList.stream()
                .filter(student -> student.rollNo != rollNo).collect(Collectors.toList());
        if (updatedList.size() == studentsList.size()) {
            System.out.println("No student deleted");
        }
        else {
            studentsList = updatedList;
            System.out.println("Student deleted successfully.");
        }

    }
    public void readStudent(){
        if (studentsList.isEmpty()){
            System.out.println("No students to display.");
            return;
        }
        for(Student student: studentsList){
            System.out.println("ID:  " + student.id + ", Name: " + student.name + ", Roll No: " + student.rollNo + ", Marks: " + student.marks);


        }
    }
}

public class MenuDriven {
    public static void main(String[] args) {
        int option;
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentsList = new ArrayList<>();

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
