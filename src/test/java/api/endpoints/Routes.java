package api.endpoints;
/* Swagger URI ---> https://petstore.swagger.io
 
 Create User (post) : https://petstore.swagger.io/v2/user
 Get User (Get) : https://petstore.swagger.io/v2/user/{username}
 Update User (Put): https://petstore.swagger.io/v2/user/{username}
 Delete User (Delete) : https://petstore.swagger.io/v2/user/{username}
  
  static ---> no need of creating object if variable is static , can be directly call with class name
  public ----> access anywhere
  
 */

//Routes contain only URLs
public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Module 
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	//Store Module 
		
		//Here we will create store module urls
	
	//Pet Module 
	
		//Here we will create store module urls
	
	//All the end urls of modules in single file
		
}
