package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa60.NotFoundException;
import ru.netology.javaqa60.Product;
public class ShopRepositoryTest {
    Product item1 = new Product(11, "Хлеб", 111);
    Product item2 = new Product(12, "Сыр", 222);
    Product item3 = new Product(13, "Мясо", 333);

    @Test
    public void shouldRemoveById() {
        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.remove(12);

        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveById() {
        ShopRepository repo = new ShopRepository();

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(14);
        });
    }
}
