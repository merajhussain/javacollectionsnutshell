import java.awt.desktop.SystemEventListener;
import java.util.*;
import java.util.stream.Collectors;

public class StreamsDemo {

    public void simpleTest()
    {
          List<String> fruits  = Arrays.asList("Mango","Apple","Banana");

          fruits.forEach(System.out::println);

          for(String fruit: fruits){
               System.out.println(fruit);
          }

          List<String> fruitFilter=fruits.stream().filter(fruit->fruit.contains("l")).toList();


        fruitFilter.forEach(System.out::println);

        List<String> words = List.of("six","sorrow","sad","seven","six","sad");

        //count of words that has ev in it
        System.out.println( words.stream().filter(s->s.contains("ev")).count());

        //print all the distinct words removing duplicates
        words.stream().distinct().forEach(System.out::println);

        words.stream().filter(s->{
            switch (s){
                case "one":return true;
                case "two":return true;
                case "three":return true;
                case "four":return true;
                case "five":return true;
                case "six":return true;
                case "seven":return true;
                case "eight":return true;
                case "nine":return true;
                case "ten":return true;
                default:return false;
            }
        }).map(s->"number ".concat(s)).map(String::toUpperCase).forEach(System.out::println);


    }

    void testHighestSalaryInDepartment()
    {
        Employee e1= new Employee(1,"meraj",10000,new Department(1,"HR"));
        Employee e2= new Employee(2,"atheeb",200000,new Department(2,"ENG"));
        Employee e3= new Employee(3,"afeef",200000,new Department(3,"ADMIN"));
        Employee e4= new Employee(4,"rafeeq",300000,new Department(2,"ENG"));
        Employee e5= new Employee(5,"fatima",400000,new Department(4,"IT"));
        Employee e6= new Employee(6,"irfani",5000,new Department(4,"IT"));


        HashMap<Integer,Employee> employeeHashMap = new HashMap<>();
        employeeHashMap.put(e1.getId(),e1);
        employeeHashMap.put(e2.getId(),e2);
        employeeHashMap.put(e3.getId(),e3);
        employeeHashMap.put(e4.getId(),e4);
        employeeHashMap.put(e5.getId(),e5);
        employeeHashMap.put(e6.getId(),e6);


        System.out.println("================Minimum salary in each department=========================");
        // Find and print the minimum salary in each department using Java Streams
        employeeHashMap.values().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.minBy(Comparator.comparingInt(Employee::getSalary))
                ))
                .forEach((dept, emp) -> emp.ifPresent(e ->
                        System.out.println("Department: " + dept.getName() + ", Employee ID: " + e.getId() + ", Salary: " + e.getSalary())
                ));

        System.out.println("================Maximum salary in each department=========================");
        // Find and print the maximum salary in each department using Java Streams
        employeeHashMap.values().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))
                ))
                .forEach((dept, emp) -> emp.ifPresent(e ->
                        System.out.println("Department: " + dept.getName() + ", Employee ID: " + e.getId() + ", Salary: " + e.getSalary())
                ));

        System.out.println("================Average salary in each department=========================");



        // Stream code to compute and print the average salary in each department
        employeeHashMap.values().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)
                ))
                .forEach((dept, avgSalary) ->
                        System.out.println("Department: " + dept.getName() + ", Average Salary: " + avgSalary)
                );

        System.out.println("===============Employees in ascending order=========================");

        employeeHashMap.values().stream().sorted(Employee::compareTo).forEach(System.out::println);
    }
}
