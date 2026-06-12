import java.util.PriorityQueue;

class Student {
    int roll;
    String name;
    float cgpa;

    Student(int roll, String name, float cgpa) {
        this.roll = roll;
        this.name = name;
        this.cgpa = cgpa;
    }
}

public class CustomPriority {
    public static void main(String[] args) {
        PriorityQueue<Student> pqc = new PriorityQueue<>(
            //(Student s1, Student s2)-> s1.name.compareTo(s2.name)
            //(Student s1, Student s2)-> s1.roll-s2.roll
            //(Student s1, Student s2)-> Float.compare(s1.cgpa, s2.cgpa)

            (Student s1, Student s2) -> {   //multiple custom priority
                if(!(s1.name.equals(s2.name)))
                    return s1.name.compareTo(s2.name);
                return s1.roll - s2.roll;
            }
        );   
        
        pqc.offer(new Student(2001, "qwerty", 8.35f));
        pqc.offer(new Student(2004, "uiop", 7.5f));
        pqc.offer(new Student(2005, "asdfg", 9.25f));
        pqc.offer(new Student(2003, "qwerty", 6.24f));
        pqc.offer(new Student(2002, "zxcvb", 8.0f));

        while (!pqc.isEmpty()) {
            //System.out.println(pqc.poll().roll+" "+pqc.poll().name+" "+pqc.poll().cgpa); INCORRECT for every poll() new ele is removed

            Student s = pqc.poll();
            System.out.println(s.roll+" "+s.name+" "+s.cgpa);
        }
    }
}
