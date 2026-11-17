package challenge;

public enum Grade {
    BRONZE(0),
    SILVER(5),
    GOLD(10),
    PLATINUM(15);

    private final int discountRate;

    Grade(int discountRate){
        this.discountRate = discountRate;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public int calculateDiscount(int price){
        return price * discountRate / 100;
    }
}


