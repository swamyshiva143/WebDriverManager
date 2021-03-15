package com.util;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.v89.network.model.Response;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class NetworkConditions {

	@DataProvider(name="networkBandwidths")
	public Object[][] networkConditions(){
		return new Object[][] {
			{5000, 5000},
			{10000, 7000},
			{15000, 9000},
			{20000, 10000},
			{30000, 20000},
			{50000, 20000},
			{70000, 20000},
			{100000, 100000},
			{0, 0},
			};
		
	}
	@Test(dataProvider="networkBandwidths")
	public void test(int downloadSpeed, int uploadSpeed) {
		System.setProperty("webdriver.chrome.driver", "D:\\Swamyshiva\\swamyshiva\\chromedriver\\chromedriver.exe"); 
		WebDriver driver= new ChromeDriver();
		
		if(downloadSpeed>0 && uploadSpeed>0) {
			CommandExecutor executor= ((RemoteWebDriver) driver).getCommandExecutor();
			Map map= new HashMap();
			map.put("offline", false);
			map.put("latency", 5);
			map.put("download_throughput", downloadSpeed);
			map.put("upload_throughput", uploadSpeed);
			
		//	Response response= executor.execute(new Command(RemoteWebDriver) driver).getSessionId(), 
		//			"setNetworkConditions", ImmutableMap.of("newtwork_conditions", ImmutableMap.copyOf(map))));
			
		}
		driver.get("http://www.facebook.com");
		driver.quit();
		
	}
	
}
