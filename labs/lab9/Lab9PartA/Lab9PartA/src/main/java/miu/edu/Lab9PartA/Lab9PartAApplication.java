
package miu.edu.Lab9PartA;

import miu.edu.Lab9PartA.domain.Book;
import miu.edu.Lab9PartA.domain.Books;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class Lab9PartAApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Lab9PartAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestClient restClient = RestClient.builder()
				.baseUrl("http://localhost:8080")
				.build();

		// Add a book
		Book javabook = restClient.post()
				.uri("/book")
				.contentType(MediaType.APPLICATION_JSON)
				.body(new Book("JavaBook","1234", "jdoe@acme.com", 23))
				.retrieve()
				.body(Book.class);
		System.out.println("Added book: " + javabook);
		// Add a book
		Book javabook2 = restClient.post()
				.uri("/book")
				.contentType(MediaType.APPLICATION_JSON)
				.body(new Book("JavaBook2","12345", "jdoe@acme.com", 23))
				.retrieve()
				.body(Book.class);
		System.out.println("Added book: " + javabook);

		// Get a book
		Book book = restClient.get()
				.uri("/book/1234")
				.retrieve()
				.body(Book.class);
				;
		System.out.println("Got book: " + book);

		// Update a book
		Book javaUpdate = restClient.put()
				.uri("/book")
				.contentType(MediaType.APPLICATION_JSON)
				.body(new Book("phpBook","1234","j",12))
				.retrieve()
				.body(Book.class);
//get all books
		Books books = restClient.get()
				.uri("/book")
				.retrieve()
				.body(Books.class);

		System.out.println("All books: " + books);


	}
}
