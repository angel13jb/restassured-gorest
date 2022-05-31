package in.co.gorest.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/";
        response = given()
                .when()
                .get("/public/v2/users")
                .then().statusCode(200);

    }


    // 1) Extract the value of limit
    @Test
    public void test001() {
        List<Integer> totalRecord = response.extract().path("findAll");
        System.out.println("The total record are : " + totalRecord.size());

    }

    // 2) Get id 3255 has name = "Adityanandana Shah"
    @Test
    public void test002() {
        String name = response.extract().path("find{it.id==3255}.name");
        System.out.println("Id 3255 has name : " + name);

    }

    // 3) Get id 3252 has email = "dhanesh_ii_marar@mayert.io"
    @Test
    public void test003() {
        String email = response.extract().path("find{it.id==3252}.email");
        System.out.println("Id 3252 has email : " + email);

    }

    // 4) Get All ID has status = "active"
    @Test
    public void test004() {
        List<String> allStatus = response.extract().path("findAll{it.status=='active'}");
        System.out.println("All status are : " + allStatus);


    }

    // 5) Get id 3263 has gender = "female"
    @Test
    public void test005() {
        String gender = response.extract().path("find{it.id==3263}.gender");
        System.out.println("Id 3263 gender is: "+gender);

    }

    // 6) Get id 3260 has gender = "male"
    @Test
    public void test006() {
        String gender = response.extract().path("find{it.id==3260}.gender");
        System.out.println("Id 3260 gender is: "+gender);

    }
}
