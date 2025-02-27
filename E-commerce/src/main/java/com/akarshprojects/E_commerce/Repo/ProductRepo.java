package com.akarshprojects.E_commerce.Repo;
import java.util.*;
import com.akarshprojects.E_commerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>
{
    @Query("SELECT p from Product p WHERE "+
            "LOWER (p.name) LIKE LOWER (CONCAT('%', :keyword, '%')) OR "+
            "LOWER (p.description) LIKE LOWER (CONCAT('%', :keyword, '%')) OR "+
            "LOWER (p.brand) LIKE LOWER (CONCAT('%', :keyword, '%')) OR "+
            "LOWER (p.category) LIKE LOWER (CONCAT('%', :keyword, '%'))")
    List<Product> searchProduct(String keyword);
}