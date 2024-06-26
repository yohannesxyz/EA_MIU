package customers;

import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDAO implements IProductDAO{

    List<Product> products=new ArrayList<>();
    public void save(Product product) {
       products.add(product);
    }
    public List<Product> list() {
        return products;
    }
}
