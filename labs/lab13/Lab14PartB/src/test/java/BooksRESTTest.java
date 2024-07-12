import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import books.domain.Book;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class BooksRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetOneBook() {
        // add the book to be fetched
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn", equalTo("878"))
                .body("title", equalTo("Book 123"))
                .body("price", equalTo(18.95f))
                .body("author", equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }


    @Test
    public void testDeleteBook() {
        // add the book to be deleted
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test deleting the book
        given()
                .when()
                .delete("books/878")
                .then()
                .statusCode(204);
        //already deleted so no cleanup needed
    }

    @Test
    public void testAddBook() {
        //add the book
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when()
                .post("/books")
                .then()
                .statusCode(200);
        //cleanup
        given()
                .when()
                .delete("books/878");

    }

    @Test
    public void testUpdateBook() {
        //add the book to be updated
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        //update the book
        Book updatedBook = new Book("878", "Book 123", 19.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(updatedBook)
                .when().put("/books/878").then()
                .statusCode(200);
        //test the update
        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn", equalTo("878"))
                .body("title", equalTo("Book 123"))
                .body("price", equalTo(19.95f))
                .body("author", equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }


    @Test
    public void testSearchBooksWithParams() {
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("books").then()
                .statusCode(200);

        given().params("author", "Joe Smith")
                .when()
                .get("/books")
                .then()
                .statusCode(200)
                .body("books.size()", equalTo(1))
                .body("books[0].isbn", equalTo("878"))
                .body("books[0].title", equalTo("Book 123"))
                .body("books[0].price", equalTo(18.95f))
                .body("books[0].author", equalTo("Joe Smith"));

        given()
                .when()
                .delete("books/878");
    }


    @Test
    public void testSearchBooksWithoutParams() {
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("books").then()
                .statusCode(200);
        //add another book
        Book book2 = new Book("879", "Book 124", 19.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book2)
                .when().post("books").then()
                .statusCode(200);


        //test getting all books
        given()
                .when()
                .get("/books")
                .then()
                .statusCode(200)
                .body("books.size()", equalTo(2))
                .body("books[0].isbn", equalTo("878"))
                .body("books[0].title", equalTo("Book 123"))
                .body("books[0].price", equalTo(18.95f))
                .body("books[0].author", equalTo("Joe Smith"))
                .body("books[1].isbn", equalTo("879"))
                .body("books[1].title", equalTo("Book 124"))
                .body("books[1].price", equalTo(19.95f))
                .body("books[1].author", equalTo("Joe Smith"));



        given()
                .when()
                .delete("books/878");
        given()
                .when()
                .delete("books/879");
    }
}

