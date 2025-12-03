package JavaPractice;


import ObserverDesignPattern.Weather.Observable.Observable;
import ObserverDesignPattern.Weather.Observable.WeatherObservableImpl;
import ObserverDesignPattern.Weather.Observer.EmailAlertObserver;
import ObserverDesignPattern.Weather.Observer.Observer;

public class practice {
    public static void main(String[] args){

        // Declare Observable
        Observable observable = new WeatherObservableImpl();

        // declare Observer
        EmailAlertObserver observer = new EmailAlertObserver(observable,"mjmihir@gmail.com");

        observable.add(observer);
        observable.setData(observable.getData() + 4);

    }
}
