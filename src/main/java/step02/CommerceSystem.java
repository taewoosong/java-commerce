package step02;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private final List<Product> products;

    public CommerceSystem(List<Product> products) {
        this.products = products;
    }

    public void start() {
        int input = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            // 반복문 실행시켜 메뉴 출력
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + " , " + products.get(i).getInfo());
            }
            System.out.println("0. 종료      | 프로그램 종료");
            System.out.println("상품을 선택하세요 : ");

            // 예외처리
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요");
                continue;
            }

            // 메뉴가 언제 10~ 100 개될지모르니 switch 문보다 if문으로 메뉴선택.
            if (input == 0) {
                System.out.println("커머스 프로그램을 종료합니다.");
                break;
            } else if (input >= 1 && input <= products.size()) {
                Product selected = products.get(input - 1);
                System.out.println(selected.getInfo());
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
