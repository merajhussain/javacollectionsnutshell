import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {

    public void testHashSet()
    {

        Set<String> names = new HashSet<>();

        names.add("meraj");
        names.add("meraj");
        names.add("Atheeb");
        names.add("afeef");
        names.add("irfani");
        names.add("afeef");

        Iterator<String> namesIterator = names.iterator();

        while(namesIterator.hasNext()){
             System.out.println(namesIterator.next());
        }

        for (String name : names) {
            System.out.println(name);
        }

        names.forEach(System.out::println);


        System.out.println(names.size());



    }

    void testLinkedHashSet()
    {
        Set<Integer> nums = new LinkedHashSet<>();

        nums.add(1);
        nums.add(2);
        nums.add(6);
        nums.add(8);
        nums.add(1);
        nums.add(11);

        System.out.println("============LinkedHashSet Demo==========");
        nums.forEach(System.out::println);
    }
}
