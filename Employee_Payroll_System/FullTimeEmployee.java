package Employee_Payroll_System;

public class FullTimeEmployee extends Employee{

    private double monthlysalary;

    public FullTimeEmployee(String name,int id,double monthlysalary){
        super(name,id);
        this.monthlysalary=monthlysalary;
    }

    @Override
    public double calculateSalary(){
        return monthlysalary;
    }
}
  

