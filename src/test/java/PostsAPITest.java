import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PostsAPITest {

    @Test
    public void testListAllPosts() {
            given()
                .when()
                    .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                    .body("[0].id",equalTo(1))
                    .statusCode(200);
    }

    @Test
    public void testCreateNewPost() {
        baseURI = "https://jsonplaceholder.typicode.com/posts";
        String newPost = "{"+     "\"userId\":"+ "1,"+
                "\"title\":"+ "Felling happy,"+
                "\"body\":"+ "Extreme joy and happiness"+
    "}";
        given().body(newPost)
                .when()
                    .post()
                .then().log().all()
                    .assertThat()
                    .statusCode(201);
    }
    @Test
    public void testUpdatePost() {
        baseURI = "https://jsonplaceholder.typicode.com/posts/2";
        String updatePost = "{"+     "\"userId\":"+ "1,"+
                "\"title\":"+ "Moving to new office,"+
                "\"body\":"+ "Extreme new office"+
                "}";
        given()
                .body(updatePost)
                .when()
                .put()
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}
