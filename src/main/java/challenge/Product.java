package challenge;

// 개별 상품 정보(상품명, 가격, 설명, 재고)를 관리하는 클래스
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

    // 주문 수량만큼 재고 차감. 재고보다 많이 주문하면 차감하지 않음
    public void decreaseStock(int quantity){
        if(quantity > stock){
            System.out.println("재고가 부족합니다.");
        }else {
            this.stock -= quantity;
        }
    }

    public void updatePrice(int price){
        if(price <= 0){
            System.out.println("상품가격은 0원보다 커야 합니다.");
            return;
        }
        this.price = price;
    }

    public void updateDescription(String description){
        this.description = description;
    }

    public void updateStock(int stock){
        if(stock < 0){
            System.out.println("재고는 0개 이상이어야 합니다.");
            return;
        }
        this.stock = stock;
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

    // 목록, 장바구니 등에서 공통으로 쓰는 상품 정보 한 줄 (가격은 세 자리 콤마)
    public String getInfo(){
        return name + " | " + String.format("%,d",price) + "원 | " + description;
    }
}
