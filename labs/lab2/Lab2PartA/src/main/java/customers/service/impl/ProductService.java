package customers.service.impl;

import customers.domain.Product;
import customers.integration.IEmailSender;
import customers.integration.ILogger;
import customers.repository.IProductDAO;
import customers.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    IProductDAO productDAO;
    IEmailSender emailSender;
    ILogger logger;
   @Autowired
    public void setProductDAO(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    @Autowired
    public void setEmailSender(IEmailSender emailSender) {
        this.emailSender = emailSender;
    }
    @Autowired
    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void addProduct(String email, String name) {
        Product product = new Product(name);
        productDAO.save(product);
        emailSender.sendEmail(email, "Product is added: name= " + name);
        logger.log("Product is added: name= " + name);
    }
}