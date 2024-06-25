import java.util.Arrays;

public class ArrayDemo {

    public void test()
    {

          int [] a = new int[20];

        Arrays.fill(a,10);

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

        int []dup = Arrays.copyOf(a,a.length);


    }
}
