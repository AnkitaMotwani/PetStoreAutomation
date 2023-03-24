package api.test;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DataDrivenTests {
	
	
	@Test(priority=1,dataProvider = "Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String id, String userName, String frstNm, String lstNm,String email,String password, String phnNo) {
		
		User payload = new User();
		payload.setId(Integer.parseInt(id));
		payload.setUsername(userName);
		payload.setFirstName(frstNm);
		payload.setLastName(lstNm);
		payload.setEmail(email);
		payload.setPassword(password);
		payload.setPhone(phnNo);
		
		Response response = UserEndPoints.createUser(payload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=2,dataProvider = "UserNames",dataProviderClass= DataProviders.class)
	public void testDeleteByUserName(String userName) {
		
		Response response= UserEndPoints.deleteUer(userName);
		
//		Response response = UserEndPoints.deleteUer(userNm);
		Assert.assertEquals(response.getStatusCode(),200);
//		
		
	}

}
