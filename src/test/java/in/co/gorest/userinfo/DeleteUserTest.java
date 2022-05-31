package in.co.gorest.userinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTest extends TestBase {
    @Test
    public void deleteUserData(){
        Response response=given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Authorization","Bearer e6ebf125eac9796e227b7599be7fb78f99d83ecfdd0c1ae353f1c5fbacac7908")

                .when().delete("/users/4054");
        response.then().statusCode(204);
        response.prettyPrint();
    }
}
