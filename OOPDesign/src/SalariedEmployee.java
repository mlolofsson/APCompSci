/*
 * Name: Michelle Olofsson 
 * Block: H
 * Lab: OOP Design 
 * Description: Use object-oriented programming to create a payroll for a company that contains the information of its employees. 
 */
public class SalariedEmployee extends Employee {
	private double yearlySalary; 
	
	public SalariedEmployee(String name, String ID, double yearlySalary) {
		super(name, ID);
		this.yearlySalary = yearlySalary; 
		setPaycheck(findPaycheck()); 
	}
	
	public Double findPaycheck() {
		Double paycheck = yearlySalary/52; 
		return paycheck; 
	}
	
	public String toString() { // do we need to override anything?
		String toString3 = super.toString();
		return toString3 + ", yearly salary = " + yearlySalary; 
	}
	
	public void recieveARaise(Double newRate) {
		yearlySalary = newRate; 
		setPaycheck(findPaycheck()); 
	}
	
	
}
