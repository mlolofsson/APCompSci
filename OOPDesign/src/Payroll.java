/*
 * Name: Michelle Olofsson 
 * Block: H
 * Lab: OOP Design 
 * Description: Use object-oriented programming to create a payroll for a company that contains the information of its employees. 
 */

import java.util.*;

public class Payroll {
	
	private List<HourlyEmployee> hourlyEmployees = new ArrayList<HourlyEmployee>();  // employees are being stored in a list because the payroll must be capable of adding or removing employees
	private List<SalariedEmployee> salariedEmployees = new ArrayList<SalariedEmployee>(); 
	//private List<Employee> allEmployees = new ArrayList<Employee>(); 
	private double payroll; 
	
	public Payroll(List<HourlyEmployee> hourlyEmployees2, List<SalariedEmployee> salariedEmployees2) {
		for(HourlyEmployee i : hourlyEmployees2) {
			hourlyEmployees.add(i); 
		}
		for(SalariedEmployee j : salariedEmployees2) {
			salariedEmployees.add(j); 
		}
	}
	
	public void updateHours(String ID, int hours) { // should hours be an integer?
		HourlyEmployee i = (HourlyEmployee) record(ID); 
		i.setHours(hours);
	}
	
	public List<HourlyEmployee> getHourlyEmployees(){
		return hourlyEmployees;
	}
	
	public void removeEmployee(String ID) {
		for(int i=0; i<hourlyEmployees.size(); i++) {
			if(hourlyEmployees.get(i).getID().equals(ID)) {
				hourlyEmployees.remove(i);
			}
		}
		for(int j=0; j<salariedEmployees.size(); j++) {
			if(salariedEmployees.get(j).getID().equals(ID)) {
				salariedEmployees.remove(j); 
			}
		}
	}
	
	public void addEmployee(String type, Employee one) {
		if(type.equals("hourly")) {
			hourlyEmployees.add((HourlyEmployee) one); // Can I do this thing with the type cast? 
		}
		else if(type.equals("salaried")) {
			salariedEmployees.add((SalariedEmployee) one);
		}
	}
	
	public Double calculatePayroll() {
		for(int i=0; i<hourlyEmployees.size(); i++) {
			payroll = payroll +  hourlyEmployees.get(i).findPaycheck();
		}
		for(int j=0; j<salariedEmployees.size(); j++) {
			payroll = payroll + salariedEmployees.get(j).findPaycheck(); 
		}
		return payroll; 
	}
	
	public void printInfo() { 
		// SORT AND PRINT HOURLY EMPLOYEES
		Collections.sort(hourlyEmployees, new HEmployeeComparatorByName());
		System.out.println("\n\nHourly Employees: ");
		for(HourlyEmployee i : hourlyEmployees) {
			System.out.print(i.toString() + "\n");
		}
		
		// SORT AND PRINT SALARIED EMPLOYEES 
		System.out.println("\n\nSalaried Employees: ");
		Collections.sort(salariedEmployees, new SEmployeeComparatorByName()); 
		for(SalariedEmployee j : salariedEmployees) {
			System.out.print(j.toString() + "\n");
		}
		
		System.out.println("\nTotal payroll = " + calculatePayroll());
		
	}
	
	public Employee record(String ID) {
		for(int i=0; i<hourlyEmployees.size(); i++) {
			if(hourlyEmployees.get(i).getID().equals(ID)) {
				return hourlyEmployees.get(i);
			}
		}
		for(int j=0; j<salariedEmployees.size(); j++) {
			if(salariedEmployees.get(j).getID().equals(ID)) {
				return salariedEmployees.get(j); 
			}
		}
		return null; // if ID doesn't match to any employees 
	}

}
