
/*
 * Name: Michelle Olofsson 
 * Block: H
 * Lab: OOP Design 
 * Description: Use object-oriented programming to create a payroll for a company that contains the information of its employees. 
 */
import java.util.*;

public class OOPDesign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<HourlyEmployee> hourlyEmployees = new ArrayList<HourlyEmployee>();
		List<SalariedEmployee> salariedEmployees = new ArrayList<SalariedEmployee>();

		HourlyEmployee emp1 = new HourlyEmployee("Jane", "A1582", 28, 12.5);
		HourlyEmployee emp2 = new HourlyEmployee("Hunter", "C8924", 36, 12);
		HourlyEmployee emp3 = new HourlyEmployee("Mary", "F9002", 44, 15);
		hourlyEmployees.add(emp1);
		hourlyEmployees.add(emp2);
		hourlyEmployees.add(emp3);

		// System.out.println(emp1.findPaycheck()); // doesn't work when it is
		// .getPaycheck(), why not?
		// System.out.println(emp2.findPaycheck());
		// System.out.println(emp3.findPaycheck());

		SalariedEmployee emp4 = new SalariedEmployee("Sara", "K2343", 52000);
		SalariedEmployee emp5 = new SalariedEmployee("Paul", "G7765", 50000);
		SalariedEmployee emp6 = new SalariedEmployee("Ryan", "L8992", 49500);
		salariedEmployees.add(emp4);
		salariedEmployees.add(emp5);
		salariedEmployees.add(emp6);

		// System.out.println(emp4.findPaycheck());
		// System.out.println(emp5.findPaycheck());
		// System.out.println(emp6.findPaycheck());
		Scanner i = new Scanner(System.in);
		System.out.println("Options: ");
		System.out.println("1. Print payroll");
		System.out.println("2. Add an employee");
		System.out.println("3. Remove an employee");
		System.out.println("4. Access record with ID");
		System.out.println("5. Change employee hours");
		System.out.println("6. Give a raise");
		System.out.println("7. Change a name");
		System.out.println("8. Quit");

		Payroll companyPayroll = new Payroll(hourlyEmployees, salariedEmployees);
		
		int choice = 0; 
		do {
			System.out.print("\nWhat next? ");
			choice = i.nextInt();
			switch (choice) {
			case 1:
				companyPayroll.printInfo();
				break;
			case 2:
				System.out.println("\nYou will now enter the information of the employee you would like to add.");
				System.out.print("Type (hourly/salaried): ");
				String type = i.nextLine();
				type = i.nextLine();
				System.out.print("Name: ");
				String name = i.nextLine();
				System.out.print("ID: ");
				String ID = i.nextLine();
				if (type.equals("hourly")) {
					System.out.print("Hours worked: ");
					int hoursWorked = i.nextInt();
					System.out.print("Hourly rate: ");
					double hourlyRate = i.nextDouble();
					Employee t = new HourlyEmployee(name, ID, hoursWorked, hourlyRate);
					companyPayroll.addEmployee("hourly", t);
				} else { // salaried
					System.out.print("Yearly salary: ");
					double yearlySalary = i.nextDouble();
					Employee t = new SalariedEmployee(name, ID, yearlySalary);
					companyPayroll.addEmployee("salaried", t);
				}
				break;
			case 3:
				System.out.print("\nID of employee you would like to remove: ");
				String ID2 = i.next();
				companyPayroll.removeEmployee(ID2);
				break;
			case 4:
				System.out.print("\nID of employees record you would like to access: ");
				String ID3 = i.next();
				Employee found = companyPayroll.record(ID3);
				System.out.print(found.toString());
				break;
			case 5: 
				System.out.print("\nEnter the new hours for each designated employee below: \n");
				hourlyEmployees = companyPayroll.getHourlyEmployees(); 
				for(int k=0; k<hourlyEmployees.size(); k++) {
					String nameTemp = hourlyEmployees.get(k).getName();
					String IDTemp = hourlyEmployees.get(k).getID(); 
					System.out.print(nameTemp + ": ");
					int hoursTemp = i.nextInt();
					companyPayroll.updateHours(IDTemp, hoursTemp); 
				}
				break; 
			case 6: System.out.print("\nEnter the ID of the employee who will recieve a raise: ");
				String ID4 = i.next(); 
				Employee empRaise = companyPayroll.record(ID4); 
				System.out.print("\nWhat is their new rate? ");
				Double newRate = i.nextDouble();
				empRaise.recieveARaise(newRate);
				break; 
			case 7: System.out.print("\nEnter the ID of the employee whose name will change: ");
				String ID5 = i.nextLine();
				ID5 = i.nextLine();
				Employee nameChanged = companyPayroll.record(ID5); 
				System.out.print("\nWhat is their new name? ");
				String newName = i.nextLine(); 
				nameChanged.setName(newName); 
				break; 
			}

		}while (choice != 8); 

	}

}
