package JavaPractice.VendingMachine.Interface;

public interface IRestocking {

    void addNewProduct(String name, int price, int quantity);

    void UpdateQuantity(long name,int price, int quantity);
}
