package ObserverDesignPattern.Weather.Observable;

import ObserverDesignPattern.Weather.Observer.Observer;

public interface Observable {
    public void add(Observer obj);
    public void remove(Observer obj);
    public void notifyObserver();
    public void setData(double val);
    public double getData();
}
