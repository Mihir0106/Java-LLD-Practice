package JavaPractice.VendingMachine;

import JavaPractice.VendingMachine.Entity.Product;
import JavaPractice.VendingMachine.Interface.IRestocking;

import java.util.*;

public class ProductInventoryManager implements IRestocking {
    List<Product> productList;
    Map<Long, Product> productMap;

    ProductInventoryManager(){
        productList = new LinkedList<>();
        productMap = new HashMap<>();
    }

    public Product getProduct(long productId){
        return productMap.get(productId);
    }

    public void showProducts(){
        System.out.println("ProductList");
        for(Product product : productList){
            product.printDetails();
        }
    }

    public Product dispenseProduct(long productId,int quantity){
        Product product = getProduct(productId);
        if(product.getQuantity() >= quantity){
            product.UpdateQuantity(-quantity);
            return product;
        }
        throw new NoSuchElementException();
    }

    long id = 0;

    @Override
    public void addNewProduct(String name, int price, int quantity) {
        long productid = ++id;
        Product product = new Product(name,productid,price,quantity);
        productMap.put(productid,product);
        productList.add(product);
    }

    @Override
    public void UpdateQuantity(long productId,int price, int quantity) {
        productMap.get(productId).UpdateQuantity(quantity);
    }
}
