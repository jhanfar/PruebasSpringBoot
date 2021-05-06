package com.empresa.prod.service_prod;

import com.empresa.prod.service_prod.Repository.ProductRepository;
import com.empresa.prod.service_prod.entity.Category;
import com.empresa.prod.service_prod.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByCategory_thenResturnListProduct()
    {
        Product product01 = Product.builder()
                           .name("computer")
                           .category(Category.builder().id(1L).build())
                           .description("")
                           .stock(Double.parseDouble("10"))
                           .price(Double.parseDouble("120.99"))
                           .status("Created")
                           .createAt(new Date()).build();
        productRepository.save(product01);
        List<Product> founds = productRepository.findByCategory(product01.getCategory());

        Assertions.assertThat(founds.size()).isEqualTo(3);

    }
}
