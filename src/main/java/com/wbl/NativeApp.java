package com.wbl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class NativeApp {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
//Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("VERSION", "9.0");
        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
//.apk for Android
//.app or .ipa for iOS

        capabilities.setCapability("appPackage", "com.android.calculator2");
// This package name of your app (you can get it from apk info app)
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
//It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testCal() throws Exception {
        //locate the Text on the calculator by using By.id() and click
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[2]")).click();
         ////android.widget.LinearLayout[@content-desc="Numbers and basic operations"]/android.view.ViewGroup[1]/android.widget.Button[2]

        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\'plus\']")).click();
        ////android.widget.Button[@content-desc="plus"]
        driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Numbers and basic operations\"]/android.view.ViewGroup[1]/android.widget.Button[4]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\'equals\']")).click();
        //locate the edit box of the calculator by using By.id() and get value
        String actualNumber = (driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText());
        System.out.println(actualNumber);
//verify the calculated value on the edit box
        assert actualNumber.equals("6") : "Actual value is : " + actualNumber + " did not match with expected value: 6";

    }
}