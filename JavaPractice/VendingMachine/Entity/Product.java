package JavaPractice.VendingMachine.Entity;

public class Product {
    long productId;
    String productName;
    int price;
    int quantity;

    public Product(String productName, long productId, int price, int quantity){
        this.productName = productName;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public long getProductId(){
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice(){
        return price;
    }

    public void UpdateQuantity(int count){
        quantity += count;
    }

    public void printDetails(){
        System.out.println("ProductId : "+ productId + " | Product Name : " + productName + " | its Price : " + price);
    }

}
