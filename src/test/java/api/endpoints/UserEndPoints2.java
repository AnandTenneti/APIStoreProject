package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoints2 {

    static ResourceBundle getURL() {
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes;


    }

    public static Response createUser(User payload) {
        String post_url = getURL().getString("post_url");
        Response response = given().
                when().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
                .when().post(post_url);
        return response;
    }

    public static Response readUser(String Username) {
        String get_url = getURL().getString("modify_url");
        Response response = given().pathParam("username", Username)
                .when().get(get_url);
        return response;

    }

    public static Response updateUser(String Username, User payload) {
        String update_url = getURL().getString("modify_url");
        Response response = given().
                pathParam("username", Username).
                when().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
                .when().put(update_url);
        return response;
    }

    public static Response deleteUser(String Username) {
        String delete_url = getURL().getString("modify_url");
        Response response = given().pathParam("username", Username)
                .when().delete(delete_url);
        return response;

    }

}
