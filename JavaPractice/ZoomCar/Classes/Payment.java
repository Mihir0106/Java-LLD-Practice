package JavaPractice.ZoomCar.Classes;

public class Payment {
    Bill bill;

    public  Payment(Bill bill){
        this.bill = bill;
    }

    public void triggerPayment(){
        // After Payment Successful not going there currently
        bill.isPaid = true;
    }

}
