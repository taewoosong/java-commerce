package step01;

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


        int input;

        while(true){
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            // 반복문 실행시켜 메뉴 출력
            for(int i =0 ; i< productList.size(); i++){
                System.out.println((i+1) + " , " + productList.get(i).getInfo());
            }
            System.out.println("0. 종료      | 프로그램 종료");
            System.out.println("상품을 선택하세요 : ");

            // 예외처리
            try {
                input = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("숫자만 입력하세요");
                continue;
            }

            // 메뉴가 언제 10~ 100 개될지모르니 switch 문보다 if문으로 메뉴선택.
            if(input == 0){
                System.out.println("커머스 프로그램을 종료합니다.");
                break;
            }
            else if(input >= 1 && input <= productList.size()){
                Product selected = productList.get(input - 1);
                System.out.println(selected.getInfo());
            }else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
