package lv01;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(Product product , int quantity){

        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getProduct() == product){
                items.get(i).addQuantity(quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public int getTotalPrice(){
        int total = 0;
        for(int i = 0; i < items.size(); i++){
            total += items.get(i).getTotalPrice();
        }
        return total;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public List<CartItem> getItems(){
        return items;
    }

    public void clear(){
        items.clear();
    }
}

