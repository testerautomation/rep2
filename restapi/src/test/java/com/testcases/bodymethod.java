package com.testcases;

public class bodymethod {


	public static String login()
	{
	
		return "{ \"username\": \"topaz.poornima\", \"password\": \"ka123456\" }";
	}
	
	public static String create_bug()
	{
		return "{\"fields\": {\n" + 
				"        \"project\": {\n" + 
				"          \"key\": \"PROJ\"\n" + 
				"        },\n" + 
				"        \"summary\": \"something great\",\n" + 
				"        \"description\": \"creating first issue via  REST Assured API\",\n" + 
				"        \"issuetype\": {\n" + 
				"          \"name\": \"Bug\"\n" + 
				"        }\n" + 
				"}\n" + 
				"}";
	}
	public static String add_comment()
	{
		return "{\"body\": \"This comment is added by Poornima by REST API automation.\",\n" + 
				"  \"visibility\": {\n" + 
				"    \"type\": \"role\",\n" + 
				"    \"value\": \"Administrators\"\n" + 
				"  }\n" + 
				"}";
	}
}
