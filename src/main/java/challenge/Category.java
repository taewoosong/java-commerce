package challenge;


import java.util.List;

// 카테고리 이름과 해당 카테고리의 상품 목록을 관리하는 클래스
public class Category{
    private final String name;
    private final List<Product> products;

    public Category(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProductsUnder(int price){
        return products.stream()
                .filter(product ->  product.getPrice() <= price)
                .toList();
    }

    public List<Product> getProductsOver(int price){
        return products.stream()
                .filter(product -> product.getPrice() > price)
                .toList();
    }

    public void addProduct(Product product){
        products.add(product);
    }


    public boolean hasProduct(String name){
        for(int i =0 ; i < products.size(); i++){
            if(products.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
