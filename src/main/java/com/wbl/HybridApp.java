
package com.wbl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class HybridApp {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
//Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("VERSION", "6.0");
        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", "/Users/madhu/Library/Android/sdk/build-tools/29.0.2/walmart.apk");//
        capabilities.setCapability("appActivity", "com.walmart.android.app.main.MainActivity");
        capabilities.setCapability("appPackage", "com.walmart.android");
        capabilities.setCapability("appWaitDuration", "30000");
//
//
//AndroidDriver driver= new AndroidDriver(url,dc);
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

}
