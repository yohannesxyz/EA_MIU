package customers.repository.impl;

import customers.domain.Product;
import customers.repository.IProductDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO implements IProductDAO {

    List<Product> products=new ArrayList<>();
    public void save(Product product) {
       products.add(product);
    }
    public List<Product> list() {
        return products;
    }
}
