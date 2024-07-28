import java.util.ArrayList;
import java.util.List;

interface Command{
    public void execute();
}

class Television{
    public void playChannelA(){
        System.out.println("Playing Channel A");
    }
    public  void playChannelB(){
        System.out.println("Playing Channel B");
    }
}
class ChannelA implements  Command{

    private final Television television;

    ChannelA(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.playChannelA();
    }
}

class ChannelB implements  Command{

    private  final Television television;

    ChannelB(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
       television.playChannelB();
    }
}

class Remote{

    private List<Command> commands;

    Remote(){
        commands = new ArrayList<>();
    }

    public  void addCommand(Command command){
         commands.add(command);
    }

    public void executeCommand(int commandIndex){
         if(commandIndex < commands.size()){
               commands.get(commandIndex).execute();
         }
    }

}

public class CommandPattern {

    public  static void main(String args[]){

           Television tv = new Television();
           Command c1= new ChannelA(tv);
           Command c2 = new ChannelB(tv);

           Remote remote = new Remote();
           remote.addCommand(c1);
           remote.addCommand(c2);
            remote.executeCommand(0);
            remote.executeCommand(1);

    }
}
