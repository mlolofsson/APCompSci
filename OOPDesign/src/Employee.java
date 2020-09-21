/*
 * Name: Michelle Olofsson 
 * Block: H
 * Lab: OOP Design 
 * Description: Use object-oriented programming to create a payroll for a company that contains the information of its employees. 
 */
public abstract class Employee{
	private String name; 
	private String ID; 
	private Double paycheck; 
	
	public Employee(String name, String ID){
		this.name = name; 
		this.ID = ID; 
		// set paycheck in specific constructors 
	}
	
	public String toString() {
		return "name = " + name + ", ID = " + ID + ", paycheck = " + getPaycheck();
	}
	
	public abstract Double findPaycheck();
	
	public Double getPaycheck() {
		return this.paycheck; 
	}
	
	public String getName() {
		return this.name; 
	}
	
	public String getID() {
		return this.ID; 
	}
	
	public void setPaycheck(double paycheck) {
		this.paycheck = paycheck; 
	}
	
	public abstract void recieveARaise(Double newRate);
	
	public void setName(String newName) {
		name = newName; 
	}
	
}


