package student;
import java.util.*;
import java.time.LocalDate;
import java.util.List;
import java.util.function.*;
/**
 * Display reminders of students having a birthday soon.
 * @author you
 */
public class StudentApp {
//	private static int localDate = LocalDate.getMonthValue();
	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> filter, Consumer<Student> action, Comparator<Student> compare) {
		students.stream().filter(filter).sorted(compare).forEach(action);
	}
	
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		List<Student> students = Registrar.getInstance().getStudents();
		Predicate<Student> birthdayTest = (s) -> s.getBirthdate().getMonthValue() == localDate.getMonthValue();
		Predicate<Student> optionalTest = (s) -> s.getBirthdate().getDayOfYear() >= localDate.getDayOfYear()  && s.getBirthdate().getDayOfYear() <= localDate.getDayOfYear()+14;
		Consumer<Student> actionTest = (s) -> System.out.printf("%s %s will have birthday on %d %s.\n",s.getFirstname(), s.getLastname(), s.getBirthdate().getDayOfMonth(), s.getBirthdate().getMonth());
		Comparator<Student> byName = (a, b) -> a.getFirstname().charAt(0) - b.getFirstname().charAt(0);
		Comparator<Student> byBirthDay = (a, b) -> a.getBirthdate().getDayOfMonth() - b.getBirthdate().getDayOfMonth();
		StudentApp app = new StudentApp();
		System.out.println("Sort by Name");
		app.filterAndPrint(students, birthdayTest, actionTest, byName);
		System.out.println("\nSort by Day");
		app.filterAndPrint(students, birthdayTest, actionTest, byBirthDay);
		System.out.println("\nPeople who will have birthday in next 2 week");
		app.filterAndPrint(students, optionalTest, actionTest, byBirthDay);
	}
}
