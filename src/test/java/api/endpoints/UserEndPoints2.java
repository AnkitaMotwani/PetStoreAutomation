package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	//Method created for getting URL's from Properties file
	
	public static ResourceBundle resourceBundleGetURL() {
		
		ResourceBundle routes = ResourceBundle.getBundle("routes"); //Loads Properties file //under double quotes we have given properties file name
		
		//routes is representing Properties file
		
		return routes; //using this object we can get all the URL's from Properties file
	}
	
	public static Response createUser(User payload) {
		
		String postUrl = resourceBundleGetURL().getString("post_url"); //post_url is key to get value (url)  //this method will return the rout
		
		Response response =given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(postUrl);
		
		return response;
		
	}
	
public static Response getUer(String userName) {
	
	String getUrl = resourceBundleGetURL().getString("get_url");
		
		Response response =given()
			.pathParam("username", userName) //first one is pathparam name, second pathparam value
		.when()
			.get(getUrl);
		
		return response;
		
	}
public static Response updateUser(String userName,User payload) {
	
	String updateUrl = resourceBundleGetURL().getString("update_url");
	
	Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
	.when()
		.put(updateUrl);
	
	return response;
	
}

public static Response deleteUer(String userName) {
	
	String deleteUrl =resourceBundleGetURL().getString("delete_url");
	
	Response response =given()
		.pathParam("username", userName) //first one is pathparam name, second pathparam value
	.when()
		.delete(deleteUrl);
	
	return response;
	
}

}
