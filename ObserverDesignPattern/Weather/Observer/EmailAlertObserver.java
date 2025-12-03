package ObserverDesignPattern.Weather.Observer;

import ObserverDesignPattern.Weather.Observable.Observable;

public class EmailAlertObserver implements  Observer{

    Observable observable;
    String email;

    public EmailAlertObserver(Observable observable, String email){
        this.observable = observable;
        this.email = email;
    }

    @Override
    public void update() {
        // Update or notify
        sendMail(email, "temperature changes");
    }

    private void sendMail(String email, String msg){
        System.out.println("mail sent to : " + email + "with msg : " + msg);
    }
}
