package steps;

import api.PetApi;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ApiUtils;

import java.util.Map;

public class PetSteps {

    private Response response;


    @Given("send a POST request to add a pet with the following details:")
    public void addPet(DataTable table) {
        // DataTable'ı Map'e çevir
        Map<String, String> petDetails = table.asMap(String.class, String.class);

        // JSON formatında body oluştur
        String petJson = String.format(
                "{ \"id\": %s, \"name\": \"%s\", \"status\": \"%s\" }",
                petDetails.get("id"), petDetails.get("name"), petDetails.get("status")
        );

        // API çağrısını yap
        response = ApiUtils.postRequest("/pet", petJson);
    }

    @Given("send a GET request to retrieve pet with ID {int}")
    public void getPetById(int petId) {
        response = ApiUtils.getRequest("/pet/" + petId);

    }


    @Given("send a DELETE request to delete pet with ID {int}")
    public void sendADELETERequestToDeletePetWithID(int petId) {
        response = ApiUtils.deleteRequest("/pet/"+ petId);

        System.out.println("DELETE Response: " + response.statusCode());
        System.out.println("DELETE Response Body: " + response.asString());
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());
    }

    @Then("the response body should contain {string}")
    public void verifyResponseBody(String expectedValue) {
        Assert.assertTrue(response.body().asString().contains(expectedValue));
    }


}
