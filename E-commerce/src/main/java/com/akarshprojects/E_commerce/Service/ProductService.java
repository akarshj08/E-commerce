package com.akarshprojects.E_commerce.Service;
import java.io.IOException;
import java.util.*;
import com.akarshprojects.E_commerce.Model.Product;
import com.akarshprojects.E_commerce.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService
{
    @Autowired
    ProductRepo repo;

    public List<Product> getProduct()
    {
        return repo.findAll();
    }

    public Product getProductById(int id)
    {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile)throws IOException
    {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());
        return repo.save(product);
    }

    public Product updateProduct(int prodId, Product product, MultipartFile imageFile) throws IOException
    {
        product.setImageDate(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repo.save(product);
    }

    public void deleteProduct(int prodId)
    {
        repo.deleteById(prodId);
    }

    public List<Product> searchProduct(String keyword)
    {
        return repo.searchProduct(keyword);
    }
}