package lv01;

public class Product {
    private String name;
    private int price;
    private String description;
    private int stock;

    public Product(String name , int price , String description , int stock){
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public void decreaseStock(int quantity){
        if(quantity > stock){
            System.out.println("재고가 부족합니다.");
        }else {
            this.stock -= quantity;
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public String getInfo(){
        return name + " | " + String.format("%,d",price) + "원 | " + description;
    }
}
