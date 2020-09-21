/*
 * Name: Michelle Olofsson 
 * Block: H
 * Lab: OOP Design 
 * Description: Use object-oriented programming to create a payroll for a company that contains the information of its employees. 
 */
public class HourlyEmployee extends Employee {
	private int hours;
	private double hourlyRate; 
	
	public HourlyEmployee(String name, String ID, int hours, double hourlyRate) {
		super(name, ID);
		this.hours = hours; 
		this.hourlyRate = hourlyRate;
		setPaycheck(findPaycheck()); 
		// TODO Auto-generated constructor stub
	}

	public Double findPaycheck() {
		double paycheck = 0; 
		if(hours>40) {
			double overtime = (hours-40) * (hourlyRate*1.5);
			paycheck = (40*hourlyRate) + overtime; 
		}
		else {
			paycheck = hours*hourlyRate; 
		}
		return paycheck; 
	}

	public String toString() {
		String toString2 = super.toString(); 
		return toString2 + ", hours = " + hours + ", hourly rate = " + hourlyRate;
	}
	
	public void setHours(int hours) {
		this.hours = hours; 
		setPaycheck(findPaycheck()); // update again 
	}
	
	public void recieveARaise(Double newRate) {
		hourlyRate = newRate; 
		setPaycheck(findPaycheck()); // update again 
	}
}
