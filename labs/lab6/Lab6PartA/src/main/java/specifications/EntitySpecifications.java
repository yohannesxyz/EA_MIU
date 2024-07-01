package specifications;

import domain.CD;
import domain.Customer;
import domain.Order;
import org.springframework.data.jpa.domain.Specification;

public class EntitySpecifications {

    public static Specification<Order> orderStatusIsClosed() {
        return (root, query, builder) -> builder.equal(root.get("status"), "closed");
    }

    public static Specification<Customer> customerLivesInAmsterdam() {
        return (root, query, builder) -> builder.equal(root.get("address").get("city"), "Amsterdam");
    }

    public static Specification<CD> cdsFromArtistWithPriceGreaterThan(String artist, double price) {
        return (root, query, builder) -> builder.and(
                builder.equal(root.get("artist"), artist),
                builder.greaterThan(root.get("price"), price)
        );
    }
}
