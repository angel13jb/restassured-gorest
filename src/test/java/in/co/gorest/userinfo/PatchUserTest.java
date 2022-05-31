package in.co.gorest.userinfo;


import in.co.gorest.model.PatchUserPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchUserTest extends TestBase {

    @Test
    public void updateUserData() {

        PatchUserPojo patchUserPojo = new PatchUserPojo();
        patchUserPojo.setName("Allasani Peddana");
        patchUserPojo.setEmail("allasani.peddana@gmail.co.uk");
        patchUserPojo.setStatus("active");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Authorization", "Bearer e6ebf125eac9796e227b7599be7fb78f99d83ecfdd0c1ae353f1c5fbacac7908")

                .pathParam("id", 4050)
                .body(patchUserPojo)
                .when()
                .patch("/users/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}