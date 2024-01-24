import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class StudentCLass
{
    private int studID;

    private String studName;

    private char studGrade;

    private long studNumber;
    
    private String studEmail;
    
    public int getStudID() {
        return studID;
    }
    public void setStudID(int studID) {
        this.studID = studID;
    }
    public String getStudName() {
        return studName;
    }
    public void setStudName(String studName) {
        this.studName = studName;
    }
    public char getStudGrade() {
        return studGrade;
    }
    public void setStudGrade(char studGrade) {
        this.studGrade = studGrade;
    }
    public long getStudNumber() {
        return studNumber;
    }
    public void setStudNumber(long studNumber) {
        this.studNumber = studNumber;
    }
   

   public String getStudEmail() {
        return studEmail;
    }
    public void setStudEmail(String studEmail) {
        this.studEmail = studEmail;
    }
static HashMap<Integer,StudentCLass> studentData = new HashMap<>();

    static int countStudent =1; //with is going to give id value
}

public class CRUDApplication {

        private static void printMenu(){
            
            System.out.println("1. To Create a new student :");
            System.out.println("2. To Remove a student :");
            System.out.println("3. To Update a student :");
            System.out.println("4. To Display a student :");
            System.out.println("5. To Search a student :");
            System.out.println("6. To Exit Application :");
            System.out.println("Enter a choice");

        }
        private static void toCreateAnewStudent(){
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome - Creating a new student");
            StudentCLass obj = new StudentCLass();
            obj.setStudID(StudentCLass.countStudent);

            System.out.println("Student Id: "+ obj.getStudID());
            System.out.println("Enter student name: ");

            obj.setStudName(input.next());

            System.out.println("Enter student Email: ");
            obj.setStudEmail(input.next());

            System.out.println("Enter student Grade: ");
            obj.setStudGrade(input.next().charAt(0));

            System.out.println("Enter student Number: ");
            obj.setStudNumber(input.nextLong());

            StudentCLass.studentData.put(obj.getStudID(), obj);

            StudentCLass.countStudent++;

            System.out.println("Thank you - Student data Created Successfully");

            toDisplayAStudent();

    
        }
        private static void toRemoveAStudent(){
            System.out.println("Welcome - Remove a Student");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the ID of the student to be removed: ");
            int id = input.nextInt();

            if (StudentCLass.studentData.containsKey(id)) {
                StudentCLass.studentData.remove(id);
                toDisplayAStudent();
                System.out.println("Student is removed successfully");
            }
            else{
                System.err.println("Student does not exist with this id !!!");
            }
    
        }
        private static void toUpdateAStudent(){ 

            Scanner input = new Scanner(System.in);
            System.out.println("Welcome - Update a student");

            System.out.println("Enter the ID of the student to be updated: ");
            int id = input.nextInt();
            if (StudentCLass.studentData.containsKey(id)) {
                System.out.println("1. Update Name");
                System.out.println("2. Update Email");
                System.out.println("3. Update Grade");
                System.out.println("4. Update Number");
                System.out.println("Enter Choice :");

                int choice=input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the updated Name: ");
                        String name =input.next();
                        StudentCLass.studentData.get(id).setStudName(name);
                        break;
                    case 2:
                        System.out.println("Enter the updated Email: ");
                        String email =input.next();
                        StudentCLass.studentData.get(id).setStudEmail(email);
                        break;
                    case 3:
                        System.out.println("Enter the updated Grade: ");
                        char grade =input.next().charAt(0);
                        StudentCLass.studentData.get(id).setStudGrade(grade);
                        break;
                    case 4:
                        System.out.println("Enter the updated Number: ");
                        long num =input.nextLong();
                        StudentCLass.studentData.get(id).setStudNumber(num);
                        break;
                    default:
                    System.err.println("Invalid Choice !!!");
                        return;
                }

                System.out.println("Student data updated successfully!!!\n");
                toDisplayAStudent();

                
            }
            else{

                System.err.println("Student does not exist with this id !!!\n");
            }
            
        }
        private static void toDisplayAStudent(){

            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("Student ID \t\t Student Name \t\t Student Email \t\t Student Grade \t\t Student Number");
            System.out.println("--------------------------------------------------------------------------------------------------------");

            for (Map.Entry<Integer,StudentCLass> studentData: StudentCLass.studentData.entrySet()){
                System.out.print(studentData.getKey()+"\t\t\t");
                System.out.print(studentData.getValue().getStudName()+"\t\t\t");
                System.out.print(studentData.getValue().getStudEmail()+"\t\t\t");
                System.out.print(studentData.getValue().getStudGrade()+"\t\t\t");
                System.out.println(studentData.getValue().getStudNumber()+"\t\t\t");
            }
            System.out.println("------------------------------------------------------------------------------------------------------------");

            System.out.println("Printed Student Data Successfully");
        }
        private static void toSearchAStudent(){
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome - Search a student");

            System.out.println("Enter the ID of the student to be Search: ");
            int id = input.nextInt();
            if (StudentCLass.studentData.containsKey(id)) {
               System.out.println("Student Name : "+ StudentCLass.studentData.get(id).getStudName());
               System.out.println("Student Email : "+ StudentCLass.studentData.get(id).getStudEmail());
               System.out.println("Student Grade : "+ StudentCLass.studentData.get(id).getStudGrade());
               System.out.println("Student Number : "+ StudentCLass.studentData.get(id).getStudNumber());
               System.out.println("Student data is displayed successfully\n");   
            }
            else{

                System.err.println("Student does not exist with this id !!!\n");
            }  
        }

        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                Boolean flag = true;
                System.out.println("\t\t\t Student Database Application\n");

                while (flag) {
                    printMenu();
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            toCreateAnewStudent();
                            break;
                        case 2:
                            toRemoveAStudent();
                            break;
                        case 3:
                            toUpdateAStudent();
                            break;
                        case 4:
                            toDisplayAStudent();
                            break;
                        case 5:
                            toSearchAStudent();
                            break;
                        case 6:
                            flag= false;
                            System.out.println("Application is exited");
                            System.out.println("Have a good day!!!");
                            break;
                        default:
                            System.out.println("Invalid Choice. !!!");
                            break;
                    }
                    
                }
            }
}
