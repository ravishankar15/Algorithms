import java.util.ArrayList; 
import java.util.List; 

interface Employee {
  public void showEmployeeDetails();
}

class Developer implements Employee {

  private String name;
  private long empId;
  private String position;

  public Developer(long empId, String name, String position) {
    this.empId = empId;
    this.name = name;
    this.position = position;
  }

  public void showEmployeeDetails() {
    System.out.println("Devloper: " + empId + "-" + name);
  }
}

class Manager implements Employee {
  private String name;
  private long empId;
  private String position;

  public Manager(long empId, String name, String position) {
    this.empId = empId;
    this.name = name;
    this.position = position;
  }

  public void showEmployeeDetails(){
    System.out.println("Manager : " + empId + "-" + name);
  }
}


class CompanyDirectory implements Employee {

  private List<Employee> empList = new ArrayList<Employee>();

  public void showEmployeeDetails() {
    for(Employee emp: empList){
      emp.showEmployeeDetails();
    }
  }

  public void addEmployee(Employee emp) {
    empList.add(emp);
  }

  public void removeEmployee(Employee emp) {
    empList.remove(emp);
  }
}

public class Company {
  public static void main(String[] args) {
    Developer d1 = new Developer(100, "Ravi", "Frontend developer");
    Developer d2 = new Developer(101, "Hari", "Backend developer");
    CompanyDirectory engCd  = new CompanyDirectory();
    engCd.addEmployee(d1);
    engCd.addEmployee(d2);

    Manager mg1 = new Manager(200, "Deepak", "Manager");
    Manager mg2 = new Manager(201, "Mani", "Senior Manager");
    CompanyDirectory accCd = new CompanyDirectory();
    accCd.addEmployee(mg1);
    accCd.addEmployee(mg2);

    CompanyDirectory cd = new CompanyDirectory();
    cd.addEmployee(engCd);
    cd.addEmployee(accCd);
    cd.showEmployeeDetails();

  }
}