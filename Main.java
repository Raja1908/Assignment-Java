import java.util.*;

class Student {
	public String name;
	public double cgpa;
	public int token;

	// A parameterized student constructor
	public Student(String name, double cgpa, int token) {

		this.name = name;
		this.cgpa = cgpa;
		this.token = token;
	}

	public String getName() {
		return name;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		PriorityQueue<Student> pq = new PriorityQueue<Student>(new StudentComparator());
		while (n-- > 0) {
			String s = sc.nextLine();
			if (s.equals("SERVED")) {
				if (!pq.isEmpty())
					pq.poll();
			} else {
				String sx[] = s.split(" ");
				Student s1 = new Student(sx[1], Double.parseDouble(sx[2]), Integer.parseInt(sx[3]));
				pq.add(s1);
			}
		}
		if (pq.isEmpty())
			System.out.println("EMPTY");
		else {
			while (!pq.isEmpty()) {
				System.out.println(pq.poll().name);
			}
		}
	}
}

class StudentComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		if (s1.cgpa < s2.cgpa)
			return 1;
		else if (s1.cgpa > s2.cgpa)
			return -1;
		else {
			if (s1.name.compareTo(s2.name) < 0)
				return -1;
			else if (s1.name.compareTo(s2.name) > 0)
				return 1;
			else {
				if (s1.token > s2.token)
					return 1;
				else
					return -1;
			}

		}
	}
}
