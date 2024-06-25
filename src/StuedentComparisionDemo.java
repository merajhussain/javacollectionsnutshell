import java.util.ArrayList;

public class StuedentComparisionDemo {


    void testComparators()
    {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1,5,6,"meraj"));
        students.add(new Student(2,6,8,"madhu"));
        students.add(new Student(3,4,5,"gopi"));

        students.sort(new StudentHeighComparator());
        students.sort(new StudentIdComparator());
        students.sort(new StudentNameComparator());
    }
}
