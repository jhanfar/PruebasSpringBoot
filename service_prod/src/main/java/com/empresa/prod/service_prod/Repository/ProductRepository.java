package com.empresa.prod.service_prod.Repository;

import com.empresa.prod.service_prod.entity.Category;
import com.empresa.prod.service_prod.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>{

    public List<Product> findByCategory(Category category);
}
