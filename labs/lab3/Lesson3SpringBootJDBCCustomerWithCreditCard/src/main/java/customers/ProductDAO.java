package customers;

//import customers.Supplier;
//import customers.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductDAO {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public void clearDB() {
		Map<String, Object> namedParameters = new HashMap<>();
		jdbcTemplate.update("DELETE FROM supplier", namedParameters);
		jdbcTemplate.update("DELETE FROM product", namedParameters);

	}

	public void save(Product product) {
		// Save product
		Map<String, Object> productParams = new HashMap<>();
		productParams.put("productNumber", product.getProductnumber());
		productParams.put("productName", product.getProductName());
		productParams.put("price", product.getPrice());
		jdbcTemplate.update("INSERT INTO product (productNumber, productName, price) VALUES (:productNumber, :productName, :price)", productParams);

		// Save supplier
		Map<String, Object> supplierParams = new HashMap<>();
		supplierParams.put("supplierNumber", product.getSupplier().getSupplierNumber());
		supplierParams.put("name", product.getSupplier().getName());
		supplierParams.put("phone", product.getSupplier().getPhone());
		supplierParams.put("productNumber", product.getProductnumber());
		jdbcTemplate.update("INSERT INTO supplier (supplierNumber, name, phone, productNumber) VALUES (:supplierNumber, :name, :phone, :productNumber)", supplierParams);
	}

	public Product getProduct(int productNumber) {
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("productNumber", productNumber);
		Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE productNumber = :productNumber",
				namedParameters,
				(rs, rowNum) -> new Product(rs.getInt("productNumber"),
						rs.getString("productName"),
						rs.getDouble("price")));

		Supplier supplier = getSupplierForProduct(product.getProductnumber());
		product.setSupplier(supplier);
		return product;
	}

	public List<Product> getAllProducts() {
		List<Product> products = jdbcTemplate.query("SELECT * FROM product",
				new HashMap<>(),
				(rs, rowNum) -> new Product(rs.getInt("productNumber"),
						rs.getString("productName"),
						rs.getDouble("price")));

		for (Product product : products) {
			Supplier supplier = getSupplierForProduct(product.getProductnumber());
			product.setSupplier(supplier);
		}
		return products;
	}

	Supplier getSupplierForProduct(int productNumber) {
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("productNumber", productNumber);
		return jdbcTemplate.queryForObject("SELECT * FROM supplier WHERE productNumber = :productNumber",
				namedParameters,
				(rs, rowNum) -> new Supplier(rs.getInt("supplierNumber"),
						rs.getString("name"),
						rs.getString("phone")));
	}
}
