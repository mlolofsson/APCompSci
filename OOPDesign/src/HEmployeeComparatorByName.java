/*
 * Name: Michelle Olofsson 
 * Block: H
 * Lab: OOP Design 
 * Description: Use object-oriented programming to create a payroll for a company that contains the information of its employees. 
 */
import java.util.Comparator;

public class HEmployeeComparatorByName implements Comparator<HourlyEmployee>{
	public int compare(HourlyEmployee one, HourlyEmployee two) {
		return one.getName().compareTo(two.getName());
	}
}
