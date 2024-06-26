package customers.repository;

import customers.domain.Product;

public interface IProductDAO {
    void save(Product product);
}
