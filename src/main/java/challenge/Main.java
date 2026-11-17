package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        List<Product> electronicsProducts = new ArrayList<>();
        List<Product> clothingProducts = new ArrayList<>();
        List<Product> foodProducts = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();


        // 카테고리별 상품 목록 생성 (전자제품, 의류, 식품)
        electronicsProducts.add(new Product("GalaxyS25" , 1200000 , "최신 안드로이드 스마트폰" , 1));
        electronicsProducts.add(new Product("iPhone" , 1350000 , "Apple의 최신 스마트폰" , 30));
        electronicsProducts.add(new Product("MacBook Pro" , 2400000 ,"M3 칩셋이 탑재된 노트북", 15));
        electronicsProducts.add(new Product("AirPods Pro" , 350000 , "노이즈 캔슬링 무선 이어폰" , 50));

        clothingProducts.add(new Product("유니클로 반팔티" , 19900 , "시원한 면 소재 반팔 티셔츠" , 40));
        clothingProducts.add(new Product("유니클로 반바지" , 29900 , "여름용 가벼운 반바지" , 35));
        clothingProducts.add(new Product("유니클로 긴팔티" , 24900 , "데일리로 입기 좋은 긴팔 티셔츠" , 20));
        clothingProducts.add(new Product("유니클로 긴바지" , 39900 , "신축성 좋은 슬림핏 바지" , 10));

        foodProducts.add(new Product("신라면 5개입",4500,"국물 라면" , 100));
        foodProducts.add(new Product("팔도 비빔면 5개입",5000,"비빔 라면" , 100));
        foodProducts.add(new Product("햇반 12개입",15900,"갓 지은 듯한 즉석밥" , 60));
        foodProducts.add(new Product("서울우유 1L",2900,"신선한 1등급 우유" , 50));

        categoryList.add(new Category("전자제품" ,electronicsProducts));
        categoryList.add(new Category("의류" ,clothingProducts));
        categoryList.add(new Category("식품" ,foodProducts));

        CommerceSystem system = new CommerceSystem(categoryList);

        // CommerceSystem 시작
        system.start();
    }
}
