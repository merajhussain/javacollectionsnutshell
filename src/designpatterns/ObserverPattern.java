package designpatterns;

import java.util.ArrayList;
import java.util.List;

interface Observer{
        void update(int state);
        void subscribe();
        void unsubscribe();
}

interface Publisher{
     void addObserver(Observer observer);
     void removeObserver(Observer observer);
     void notifySubscribers();
     void updateState(int state);

}

class Subscriber implements Observer{

    Publisher p;
    Subscriber(Publisher p){
        this.p=p;
    }
    @Override
    public void update(int state) {

         System.out.println("Subject state changed to:"+state);
    }

    @Override
    public void subscribe() {
        p.addObserver(this);

    }

    @Override
    public void unsubscribe() {
         p.removeObserver(this);
    }
}

class NewsAgency implements Publisher{

    private int state;

    private List<Observer> observers;

    NewsAgency(){
        this.observers= new ArrayList<>();
        this.state=-1;
    }
    @Override
    public void addObserver(Observer observer) {
          this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

        observers.remove(observer);

    }


    @Override
    public void notifySubscribers() {

         observers.stream().forEach(e->e.update(state));
    }

    @Override
    public void updateState(int state) {

         this.state = state;
         notifySubscribers();
    }


}

public class ObserverPattern {

    public  static void main(String args[]){

          Publisher p= new NewsAgency();
          Observer observer1= new Subscriber(p);
          Observer observer2= new Subscriber(p);

           observer1.subscribe();
           observer2.subscribe();
          p.updateState(2);
          observer1.unsubscribe();
          p.updateState(3);


    }
}

