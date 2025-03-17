package Employee_Payrool_System;

import java.util.ArrayList;

public class PayrollSystem {
    
    private ArrayList<Employee> employeelist;

    public PayrollSystem(){
       employeelist=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeelist.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee :employeelist){
            if(employee.getId()==id){
                employeeToRemove=employee;
            }
        }
      if(employeeToRemove!=null){
         employeelist.remove(employeeToRemove);
      }
    }

    public void displayEmployees(){
        for(Employee employee:employeelist){
            System.out.println(employee);
        }
    }

    }



