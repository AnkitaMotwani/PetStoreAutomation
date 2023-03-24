package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTests {
	
	Faker fake; // Created Global variable 
	public Logger logger; //for logs
	User userPayload;
	@BeforeClass
	public void setUp() {
		
		fake = new Faker(); //object creation
		
		userPayload = new User();
		
		userPayload.setId(fake.idNumber().hashCode());
		userPayload.setUsername(fake.name().username());
		userPayload.setFirstName(fake.name().firstName());
		userPayload.setLastName(fake.name().lastName());
		userPayload.setEmail(fake.internet().safeEmailAddress());
		userPayload.setPassword(fake.internet().password(5, 10));
		userPayload.setPhone(fake.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	
	public void testPostUser() {
		
		logger.info("*********Creating User ***************");
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*************User is Created*************");
			
	}
	@Test(priority=2)
	public void testGetuserByName() {
		
		logger.info("*********Fetch User Details ***************");
		
		Response response = UserEndPoints.getUer(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("*********User Info is displaced ***************");
	}
	
	@Test(priority=3)
	public void testUpdateUserByName() {
		
		//update data using payload
		logger.info("*********Updating User ***************");
		
		userPayload.setFirstName(fake.name().firstName());
		userPayload.setLastName(fake.name().lastName());
		userPayload.setEmail(fake.internet().safeEmailAddress());
		
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*********User is Updated ***************");
		
		//checking the data after update
		
		Response responseAfterUpdate = UserEndPoints.getUer(this.userPayload.getUsername());
		responseAfterUpdate.then().log().body();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
		
			
	}
	
	@Test(priority=4)
	public void testDeleteByName() {
		logger.info("*********Deleting User ***************");
		Response response = UserEndPoints.deleteUer(this.userPayload.getUsername());
		response.then().log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("********* User Deleted ***************");
	}

}
