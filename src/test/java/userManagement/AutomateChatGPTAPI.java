package userManagement;

import core.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class AutomateChatGPTAPI {

    @Test(description = "Validate status code for GET list models")
    public void getListModels() {
        Response resp = given().
                header("Authorization", "Bearer "+ OpenApiKey).
                when().get("https://api.openai.com/v1/models");
        assertEquals(resp.statusCode(), StatusCode.SUCCESS.code);
        System.out.println(resp.getBody().asString());
        System.out.println("TestCase getListModels executed successfully");
    }

    @Test(description = "Validate status code for GET retrieve models")
    public void getRerieveModel() {
        Response resp = given().
                header("Authorization", "Bearer "+ OpenApiKey).
                pathParam("model_id","babbage").
                when().get("https://api.openai.com/v1/models/:model_id");
        assertEquals(resp.statusCode(), StatusCode.SUCCESS.code);
        System.out.println(resp.getBody().asString());
        System.out.println("TestCase getRerieveModel executed successfully");
    }
}
