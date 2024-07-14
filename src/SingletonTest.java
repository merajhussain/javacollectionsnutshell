import java.lang.reflect.Constructor;

class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


public class SingletonTest {

    public static void main(String args[]){
        try {
            Singleton instanceOne = Singleton.getInstance();
            Singleton instanceTwo = null;

            Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                // Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (Singleton) constructor.newInstance();
                break;
            }

            System.out.println("Instance One HashCode: " + instanceOne.hashCode());
            System.out.println("Instance Two HashCode: " + instanceTwo.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
