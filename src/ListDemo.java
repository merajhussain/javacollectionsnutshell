import java.awt.*;
import java.util.*;
import java.util.List;

public class ListDemo
{

    ArrayList<Integer> mList;

    public  ListDemo(){
          mList = new ArrayList<>();

    }



    public void test()
    {

        //List interface
        List<Integer> al = new ArrayList<>();
        List<Integer> ll = new LinkedList<>();

        for(int i=0;i<10;i++)
        {
            al.add(i);
            ll.add(i);
        }

        System.out.println("==============Array List===========");
        for(int i=0;i<al.size();i++)
        {
            System.out.println(al.get(i));
        }

        System.out.println("==============Linked List===========");
        for(int i=0;i<ll.size();i++)
        {
            System.out.println(ll.get(i));
        }


       Iterator<Integer> it= al.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
           
        }

        al.forEach(System.out::println);

    }

    void testStudents()
    {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(3));
        students.add(new Student(1));
        students.add(new Student(2));

        Collections.sort(students);

    }


}
