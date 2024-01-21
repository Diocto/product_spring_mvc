package springmvc.product_project.itemservice.domain.item;

import lombok.Data;

@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(String testItem, int price, int quantity) {
        this.itemName = testItem;
        this.price = price;
        this.quantity = quantity;
    }
}
