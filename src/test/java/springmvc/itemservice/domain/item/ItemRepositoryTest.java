package springmvc.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import springmvc.product_project.itemservice.domain.item.Item;
import springmvc.product_project.itemservice.domain.item.ItemRepository;

import java.util.List;

public class ItemRepositoryTest {
    private static final ItemRepository repository = new ItemRepository();
    @AfterEach
    void clearRepo(){
        repository.clearStore();
    }
    @Test
    void saveTest(){
        // arrange
        Item item = new Item("testItem", 1000, 10);


        // act
        Item savedItem = repository.save(item);
        Item findItem = repository.findById(savedItem.getId());

        // assert
        Assertions.assertEquals(findItem, savedItem);
    }

    @Test
    void findAllTest(){
        // arrange
        Item item = new Item("testItem", 1000, 10);
        Item item2 = new Item("testItem2", 10200, 120);

        Item savedItem = repository.save(item);
        Item savedItem2 = repository.save(item2);

        // act
        List<Item> findItems = repository.findAll();

        // assert
        Assertions.assertEquals(findItems.size(), 2);
        Assertions.assertEquals(findItems.get(0), savedItem);
        Assertions.assertEquals(findItems.get(1), savedItem2);
    }
}
