interface a{
    default void display(){
        System.out.println("A display");
    }
}

interface  b{

    default  void display(){
        System.out.println("B display");
    }
}


class C implements  a,b{

    @Override
    public void display() {
        b.super.display();
    }
}

public class Java8DimaondInterfaces {

    public static void main(String args[]){

        C cobj = new C();
        cobj.display();

    }
}
