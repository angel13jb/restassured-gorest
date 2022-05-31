package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostUserTest extends TestBase {

    @Test
    public void createUser(){

        UserPojo userPojo=new UserPojo();
        userPojo.setName("Tenali Ramakrishna");
        userPojo.setGender("male");
        userPojo.setEmail("tenali.ramakrishna@yahoo.co.uk");
        userPojo.setStatus("active");

        Response response=given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Authorization","Bearer e6ebf125eac9796e227b7599be7fb78f99d83ecfdd0c1ae353f1c5fbacac7908")

                .body(userPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();

    }
}
