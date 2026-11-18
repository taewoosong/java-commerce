package challenge;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private final List<Category> categories;
    private final Scanner sc = new Scanner(System.in);
    private final Cart cart = new Cart();

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    public void start() {
        int input = 0;
        while (true) {

            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            // 반복문 실행시켜 메뉴 출력
            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + " , " + categories.get(i).getName());
            }
            System.out.println("0. 종료      | 프로그램 종료");
            if (!cart.isEmpty()) {
                System.out.println("[ 주문 관리 ]");
                System.out.println("4. 장바구니 확인");
                System.out.println("5. 주문 취소");
            }
            System.out.println("카테고리를(을) 선택하세요 : ");

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
            } else if (input >= 1 && input <= categories.size()) {
                Category selected = categories.get(input - 1);
                System.out.println(selected.getName());
                showCategoryMenu(selected);
            } else if (input == 4) {
                showCart();
            } else if (input == 5) {
                cancelOrder();
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void showCart() {
        int input = 0;
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어져 있습니다.");
            return;
        }
        for (int i = 0; i < cart.getItems().size(); i++) {
            CartItem item = cart.getItems().get(i);
            System.out.println(item.getProduct().getInfo() + " | 수량: " + item.getQuantity() + "개");
        }
        System.out.println("[ 총 주문 금액 ]");
        System.out.println(String.format("%,d원", cart.getTotalPrice()));

        while (true) {
            System.out.println("1. 주문 확정 , 2. 메인으로 돌아가기 , 3. 상품 제거");
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요");
                continue;
            }
            if (input == 1) {
                placeOrder();
                return;
            } else if (input == 2) {
                System.out.println("메인으로 돌아갑니다.");
                return;
            } else if (input == 3){
                System.out.println("제거할 상품명을 입력하세요 : ");
                String name = sc.nextLine();
                if(cart.removeItem(name)){
                    System.out.println("장바구니에서 제거되었습니다.");
                }else{
                    System.out.println("해당 상품이 장바구니에 없습니다.");
                }
                return;
            }
            else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void cancelOrder() {
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어져 있습니다.");
            return;
        }
        cart.clear();
        System.out.println("주문이 취소 되었습니다.");
    }

    private void showProducts(String title, List<Product> products) {
        int input = 0;

        while (true) {

            System.out.println("[ " + title + " ]");
            // 반복문 실행시켜 메뉴 출력
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + " , " + products.get(i).getInfo());
            }
            System.out.println("0. 뒤로가기      | 뒤로가기");
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
                System.out.println("메뉴선택으로 되돌아 갑니다.");
                return;
            } else if (input >= 1 && input <= products.size()) {
                Product selected = products.get(input - 1);
                System.out.println("선택한 상품: " + selected.getInfo() + " | 재고: " + selected.getStock() + "개");
                askAddToCart(selected);
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void askAddToCart(Product product) {
        int input = 0;
        System.out.println(product.getInfo());
        System.out.println("이 상품을 장바구니에 담으시겠습니까? :  (1.담기 , 2.취소)");

        while (true) {
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요");
                continue;
            }

            if (input == 2) {
                System.out.println("이전메뉴로 돌아갑니다.");
                return;
            } else if (input == 1) {
                if (cart.getQuantity(product) + 1 > product.getStock()) {
                    System.out.println("재고가 부족합니다.");
                    return;
                }
                cart.addItem(product, 1);
                System.out.println(product.getName() + "상품이 추가되었습니다.");
                return;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private Grade selectGrade() {
        int input = 0;
        System.out.println("고객 등급을 입력해 주세요 : ");
        for (int i = 0; i < Grade.values().length; i++) {
            Grade grade = Grade.values()[i];
            System.out.println((i + 1 + ". " + grade.name() + " : " + grade.getDiscountRate() + "% 할인"));
        }

        while (true) {

            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            if (input >= 1 && input <= Grade.values().length) {
                return Grade.values()[input - 1];
            }
            System.out.println("잘못된 입력입니다.");
        }
    }

    private void placeOrder() {
        Grade grade = selectGrade();
        int total = cart.getTotalPrice();
        int discount = grade.calculateDiscount(total);
        int finalPrice = total - discount;

        System.out.println("주문이 완료되었습니다!");
        System.out.println("할인 전 금액: " + String.format("%,d원", total));
        System.out.println(grade.name() + " 등급 할인(" + grade.getDiscountRate() + "%): -" + String.format("%,d원", discount));
        System.out.println("최종 결제 금액: " + String.format("%,d원", finalPrice));

        for (int i = 0; i < cart.getItems().size(); i++) {
            CartItem item = cart.getItems().get(i);
            Product product = item.getProduct();
            int before = product.getStock();
            product.decreaseStock(item.getQuantity());
            System.out.println(item.getProduct().getName() + "재고가 " + before + " 개-> "
                    + product.getStock() + " 로 업데이트 되었습니다.");
        }
        cart.clear();
    }

    private void showCategoryMenu(Category category){
        int input = 0;

        while (true) {
            System.out.println("[ " + category.getName() + " 카테고리 ]");
            System.out.println("1. 전체 상품 보기");
            System.out.println("2. 가격대별 필터링 (100만원 이하)");
            System.out.println("3. 가격대별 필터링 (100만원 초과)");
            System.out.println("0. 뒤로가기");

            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요");
                continue;
            }

            if(input == 0){
                return;
            }else if(input == 1){
                showProducts(category.getName() + " 전체 상품", category.getProducts());
            }else if(input == 2){
                showProducts("100만원 이하 상품" ,category.getProductsUnder(1000000));
            }else if(input == 3){
                showProducts( "100만원 초과 상품" ,category.getProductsOver(1000000));
            }else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
