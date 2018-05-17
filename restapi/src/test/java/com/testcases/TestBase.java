package com.testcases;
//added by Poornima
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.reusable.conversions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestBase {

	// public static ExcelReader excel = new ExcelReader(
	// System.getProperty("user.dir")
	// + "\\src\\test\\resources\\excel\\testdata.xlsx");
	// public static Logger log = Logger.getLogger("devpinoyLogger");
	

	public static Properties Config = new Properties();
	public static FileInputStream fis;

	@BeforeSuite
	public void set_up() {

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			Config.load(fis);
			// log.debug("Config properties loaded !!!");
		} catch (IOException e) {

			e.printStackTrace();
		}

		RestAssured.baseURI = Config.getProperty("URI");

	}

	public String get_session_id() {
		Response res = given().header("Content-Type", "application/json").body(bodymethod.login()).when()
				.post(Config.getProperty("res_login")).then().statusCode(200).extract().response();

		JsonPath js = conversions.rawToJson(res);// use static and avoid using
		System.out.println("The session value is" + js.get("session.value"));
		return js.get("session.value");
	}


}
