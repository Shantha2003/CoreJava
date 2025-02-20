package exceptionHandling;

import java.util.Scanner;

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
    private Student[] studentsList;


    public void addStudent(Student[] studentsList){
        try{
            if(size(studentsList) >= studentsList.length){
                throw new CustomException("Array is full and can't add another student's details");
            }
            System.out.println("Enter the id of the student: ");
        int id = sc.nextInt();
        System.out.println("Enter the name of the student: ");
        String name = sc.next();
        System.out.println("Enter the roll number of the number: ");
        int rollNo = sc.nextInt();
        System.out.println("Enter the marks of the student: ");
        int marks = sc.nextInt();
        studentsList[size(studentsList)] = new Student(id, name, rollNo, marks);
        System.out.println("Student added.");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public int size(Student[] studentsList){
        int count = 0;
        for(int i =0; i < studentsList.length; i++){
            if(studentsList[i] != null){
                count++;
            }
        }
        return count;
    }
    public void deleteStudent(Student[] studentsList){
        System.out.println("Enter the parameter which you would like to remove: ");
        int rNo = sc.nextInt();
        boolean flag = false;
        for(int i = 0; i < size(studentsList); i++) {
            if(studentsList[i].rollNo == rNo){
                for(int j = i; j < size(studentsList); j++){
                    flag = true;
                    studentsList[j] = studentsList[j + 1];
                    studentsList[j+1] = null;
                    System.out.println("Student deleted");
                }
            }

        }
    }
    public void readStudent(Student[] studentsList){
        if (size(studentsList) == 0){
            System.out.println("No students to display.");
        }
        for(int i = 0 ; i < size(studentsList); i++){
            System.out.println("ID: " + studentsList[i].id + ", Name: " + studentsList[i].name + ", Roll No: " + studentsList[i].rollNo + ", Marks: " + studentsList[i].marks);


        }
    }
}
class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }
}


public class MenuDriven {
    public static void main(String[] args) {
        int option;
        Scanner sc = new Scanner(System.in);
        Student[] studentsList = new Student[3];
        StudentDetail stud = new StudentDetail();
        do {
            System.out.println("Enter your choice\n 1. Add student\n 2. Read student\n 3. Remove student\n 4. Exit");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    stud.addStudent(studentsList);
                    break;
                case 2:
                    stud.readStudent(studentsList);
                    break;
                case 3:
                    stud.deleteStudent(studentsList);
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
