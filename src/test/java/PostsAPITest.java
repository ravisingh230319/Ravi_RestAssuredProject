import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PostsAPITest {

    @Test
    public void testListAllUser() {
            given()
                .when()
                    .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                    .body("[0].id",equalTo(1))
                    .statusCode(200);
    }
}
