package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "EMPOLOYEE_ID")
    private String id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "SALARY")
    private double salary;

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName, String role, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newName) {
        this.firstName = newName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setlastName(String newLastName) {
        this.lastName = newLastName;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String newRole) {
        this.role = newRole;
    }
    
    public double getSalary() {
        return salary;
    }

    public void setSalary(String newSalary) {
        this.firstName = newSalary;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long salaryBits = Double.doubleToLongBits(salary);
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + (int) (salaryBits ^ (salaryBits >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
    	boolean bandera = false;
    	try {
    	   Employee objeto = (Employee) obj;
    	   if(id.equals(objeto.getId()) && firstName.equals(objeto.getFirstName()) && lastName.equals(objeto.getLastName())
    			   && role.equals(objeto.getRole()) && salary == objeto.getSalary()) bandera = true;
    	   return bandera;
       }catch(Exception e) {
    	   return bandera;
       }
    }

    @Override
    public String toString() {
        return "Employee[ID = " + id + ", First Name = " + firstName + ", Last Name = " + lastName 
        		+ ", Role = " + role + ", Saraly = " + salary + "]";
    }
}