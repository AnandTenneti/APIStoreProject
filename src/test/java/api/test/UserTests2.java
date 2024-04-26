package api.test;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests2 {
    Faker faker;
    User userPayload;

    @BeforeClass
    public void setupData() {
        faker = new Faker();
        userPayload = new User();
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

    }

    @Test(priority = 1)
    public void test_postUser() {
        Response response = UserEndPoints2.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2)
    public void test_getUserByName() {
        Response response = UserEndPoints2.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 3)
    public void test_updateUser() {
        //Update data using payload
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(), userPayload);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);

        // Checking data after updation
        Response responseAfterUpdate = UserEndPoints2.readUser(this.userPayload.getUsername());
        responseAfterUpdate.then().log().all();
    }

    @Test(priority = 4)
    public void test_deleteUserByName() {
        Response response = UserEndPoints2.deleteUser(this.userPayload.getUsername());
        Assert.assertEquals(response.statusCode(), 200);
    }

}
