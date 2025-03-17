package Employee_Payroll_System;

public class Main {
    public static void main(String[] args) {
        PayrollSystem prs=new PayrollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("sonu", 1, 50000.0);
        PartTimeEmployee emp2= new PartTimeEmployee("john", 2, 40, 1000);

        prs.addEmployee(emp1);
        prs.addEmployee(emp2);

        System.out.println("Initial Employee Details");
        prs.displayEmployees();
        System.out.println("Remove Employess");
        prs.removeEmployee(2);

        System.out.println("Remaining Employess Details:");
        prs.displayEmployees();
    }
    
}
