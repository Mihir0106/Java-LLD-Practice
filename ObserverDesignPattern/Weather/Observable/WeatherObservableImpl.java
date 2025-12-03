package ObserverDesignPattern.Weather.Observable;

import ObserverDesignPattern.Weather.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherObservableImpl implements Observable {

    List<Observer> observerList = new ArrayList<>();
    double temperature = 100;

    @Override
    public void add(Observer obj) {
        observerList.add(obj);
    }

    @Override
    public void remove(Observer obj) {
        observerList.remove(obj);
    }

    @Override
    public void notifyObserver() {
        for(Observer obj : observerList){
            obj.update();
        }
    }

    @Override
    public void setData(double val) {
        if(Math.abs(temperature - val) > 5){
            notifyObserver();
        }

        temperature = val;
    }

    @Override
    public double getData(){
        return temperature;
    }
}
