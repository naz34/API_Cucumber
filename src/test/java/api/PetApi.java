package api;

import io.restassured.response.Response;
import utils.ApiUtils;

public class PetApi {

  private static final String PET_ENDPOINT = "/pet";

  public static Response addPet(String petJson){
      return ApiUtils.postRequest(PET_ENDPOINT,petJson);
  }

  public static Response getPetById(int pettId){
      return ApiUtils.getRequest(PET_ENDPOINT+"/"+pettId);
  }

  public static Response deletePetById(int petId){
      return ApiUtils.deleteRequest(PET_ENDPOINT+"/"+petId);
  }
}
