package step02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("GalaxyS25" , 1200000 , "최신 안드로이드 스마트폰" , 25));
        productList.add(new Product("iPhone" , 1350000 , "Apple의 최신 스마트폰" , 30));
        productList.add(new Product("MacBook Pro" , 2400000 ,"M3 칩셋이 탑재된 노트북", 15));
        productList.add(new Product("AirPods Pro" , 350000 , "노이즈 캔슬링 무선 이어폰" , 50));
        CommerceSystem system = new CommerceSystem(productList);

        // CommerceSystem 시작
        system.start();
    }
}
