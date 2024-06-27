import java.util.HashMap;

public class MapDemo {

    public void testHashMap()
    {
        HashMap<Integer,Student> map = new HashMap<>();

        map.put(1,new Student(1,4,6,"meraj"));
        map.put(2,new Student(2,5,7,"afeef"));
        map.put(3,new Student(3,6,8,"atheeb"));

       for(Integer key : map.keySet()){
           System.out.println(key);
       }

        for(Student value : map.values()){
            System.out.println(value.getName());
        }

        for(var entry: map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue().getName());

        }


        map.forEach((key,value)->System.out.println(value.getName()));


    }
}
