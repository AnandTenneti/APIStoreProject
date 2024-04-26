package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserEndPoints {

    public static Response createUser(User payload) {
        Response response = given().
                when().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
                .when().post(Routes.post_url);
        return response;
    }

    public static Response readUser(String Username) {
        Response response = given().pathParam("username", Username)
                .when().get(Routes.get_url);
        return response;

    }

    public static Response updateUser(String Username, User payload) {
        Response response = given().
                pathParam("username", Username).
                when().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
                .when().post(Routes.update_url);
        return response;
    }

    public static Response deleteUser(String Username) {
        Response response = given().pathParam("username", Username)
                .when().delete(Routes.delete_url);
        return response;

    }

}
