import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ExpenseClass{

    private int expenseID;

    private String expenseName;

    private float expenseTotal;

    private String expenseDate;

    private String expenseType;

    public int getExpenseID() {
        return expenseID;
    }
    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }
    public String getExpenseName() {
        return expenseName;
    }
    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }
    public float getExpenseTotal() {
        return expenseTotal;
    }
    public void setExpenseTotal(float expenseTotal) {
        this.expenseTotal = expenseTotal;
    }
    public String getExpenseDate() {
        return expenseDate;
    }
    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }
    public String getExpenseType() {
        return expenseType;
    }
    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }
    
    static HashMap<Integer,ExpenseClass> expenseData = new HashMap<>();

    static int countExpense=1;
}

public class ExpenseTracker {
    private static void PrintMenu(){
        System.out.println("1. Create Expense Data");
        System.out.println("2. Remove An Expense Data");
        System.out.println("3. Update An Expense Data");
        System.out.println("4. Display An Expense Data");
        System.out.println("5. Search An Expense Data");
        System.out.println("6. Exit From Expense Tracker");
        System.out.println("\nEnter Your Choice Below:");
    }

    private static void toCreateExpenseData(){
        System.out.println("\t\t\t---------------------------------------");
        System.out.println("\n\t\t\tWelcome!! - To Create New Expense Data.\n");
        System.out.println("\t\t\t---------------------------------------");

        Scanner input = new Scanner(System.in);
        
        ExpenseClass obj = new ExpenseClass();
        obj.setExpenseID(ExpenseClass.countExpense);

        System.out.println("Expense Id :"+obj.getExpenseID());
        
        System.out.println("Enter Expense Name:");
        obj.setExpenseName(input.next());

        System.out.println("Enter Total Expense :");
        obj.setExpenseTotal(input.nextFloat());

        System.out.println("Enter Date of Expense :");
        System.out.println("Enter Date In ' dd/mm/yyyy ' Format");
        obj.setExpenseDate(input.next());

        System.out.println("\nExpense Type Options");
        System.out.println("1. Home Expenses");
        System.out.println("2. Personal Expenses");
        System.out.println("3. Travel Expenses");
        System.out.println("4. Food Expenses");
        System.out.println("Choose Type Of Expense:");
        int ch = input.nextInt();
         switch (ch) {
            case 1:
                    obj.setExpenseType("Home");
                    break;
            case 2:
                    obj.setExpenseType("Personal");
                    break;
            case 3:
                    obj.setExpenseType("Travel");
                    break; 
            case 4:
                    obj.setExpenseType("Food");
                    break; 
            default:
                    obj.setExpenseType("other");
                break;
         }

        ExpenseClass.expenseData.put(obj.getExpenseID(), obj);

        ExpenseClass.countExpense++;

        toDisplayExpenseData(); 
        System.out.println("\n\nExpense Creation is completed");  

    }
    private static void toRemoveExpenseData(){
        System.out.println("\t\t\t---------------------------------------");
        System.out.println("\n\t\t\tWelcome!! - To Remove Expense Data.\n");
        System.out.println("\t\t\t---------------------------------------");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Expense ID :");
        int id = input.nextInt();

        if (ExpenseClass.expenseData.containsKey(id)) {
            ExpenseClass.expenseData.remove(id);
            toDisplayExpenseData();
            System.out.println("\nExpense Record is Removed Successfully!");
        }
        else{
            System.err.println("Invalid Id \n Record Not Found");
        }
        
        


    }
    private static void toUpdateExpenseData(){
        System.out.println("\t\t\t---------------------------------------");
        System.out.println("\n\t\t\tWelcome!! - To Update Expense Data.\n");
        System.out.println("\t\t\t---------------------------------------\n");

        Scanner input = new Scanner(System.in);

        System.out.println("Enter id To update data");
        int id = input.nextInt();
        if(ExpenseClass.expenseData.containsKey(id)){

            System.out.println("1.Select To updated Name:");
            System.out.println("2.Select To updated Total:");
            System.out.println("3.Select To updated Date:");
            System.out.println("4.Select To updated Type:");
            System.out.println("\nEnter a Choice:");
            int choice = input.nextInt();
            

            switch (choice) {
                case 1:
                    System.out.println("Enter Updated Name:");
                    ExpenseClass.expenseData.get(id).setExpenseName(input.next()); 
                    break;
                case 2:
                    System.out.println("Enter Updated Total:");
                    ExpenseClass.expenseData.get(id).setExpenseTotal(input.nextFloat());
                    break;
                case 3:
                    System.out.println("Enter Updated Date:");
                    ExpenseClass.expenseData.get(id).setExpenseName(input.next()); 
                    break;
                case 4:
                    System.out.println("Enter Updated Type:");
                    ExpenseClass.expenseData.get(id).setExpenseName(input.next()); 
                    break;
            
                default:
                    break;
            }
            toDisplayExpenseData();
        }
        else{
            System.err.println("Invalid Id \n Record Not Found");
        }

    }
    private static void toDisplayExpenseData(){
        System.out.println("\t\t\t---------------------------------------");
        System.out.println("\n\t\t\tWelcome!! - To Display Expense Data.\n");
        System.out.println("\t\t\t---------------------------------------\n");

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Expense ID \t\t Expense Name \t\t Expense Total \t\t Expense Date \t\t Expense Type");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

        for(Map.Entry<Integer,ExpenseClass> obj :ExpenseClass.expenseData.entrySet()){
            System.out.print(obj.getKey()+"\t\t\t\t");
            System.out.print(obj.getValue().getExpenseName()+"\t\t\t");
            System.out.print(obj.getValue().getExpenseTotal()+"\t\t\t");
            System.out.print(obj.getValue().getExpenseDate()+"\t\t\t");
            System.out.println(obj.getValue().getExpenseType()+"\t\t\t");
        }
        
        

    }
    private static void toSearchExpenseData(){
        System.out.println("\t\t\t---------------------------------------");
        System.out.println("\n\t\t\tWelcome!! - To Search Expense Data.\n");
        System.out.println("\t\t\t---------------------------------------\n");
            Scanner input = new Scanner(System.in);

        System.out.println("Enter Expense Id :");
        int id = input.nextInt();

        if(ExpenseClass.expenseData.containsKey(id)){
            System.out.println("Expense Name : "+ExpenseClass.expenseData.get(id).getExpenseName());
            System.out.println("Expense Total : "+ExpenseClass.expenseData.get(id).getExpenseTotal());
            System.out.println("Expense Date : "+ExpenseClass.expenseData.get(id).getExpenseDate());
            System.out.println("Expense Type : "+ExpenseClass.expenseData.get(id).getExpenseType());
            
        }
        else{
            System.err.println("Invalid Id \n Record Not Found");
        }



    }
    public static void main(String[] args) {
        System.out.println("\t\t\t------------------------------");
        System.out.println(" \t\t\tAn Expense Tracker Application");
        System.out.println("\t\t\t------------------------------");
        boolean flag = true;
        while (flag) {
            PrintMenu();
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    toCreateExpenseData();
                    break;
                case 2:
                    toRemoveExpenseData();
                    break;
                case 3:
                    toUpdateExpenseData();
                    break;
                case 4:
                    toDisplayExpenseData();
                    break;
                case 5:
                    toSearchExpenseData();
                    break;
                case 6:
                    flag=false;
                    System.out.println("Thank you! See you Again!!!");
                    System.out.println("Have good day!!!");
                    break;
                default:
                        System.err.println("Invalid Choice!!!");
                    break;
            }
        }
    }

    
}