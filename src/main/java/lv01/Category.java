package lv01;


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
}
