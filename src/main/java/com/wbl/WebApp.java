package com.wbl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class WebApp {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Chrome");
        capabilities.setCapability("VERSION", "9.0");
        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
// capabilities.setCapability("app",
// "/Users/vedangwhitebox/Library/Android/sdk/build-tools/29.0.2/wallmart.apk");
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        capabilities.setCapability("appPackage", "com.android.chrome");

        capabilities.setCapability("appWaitDuration", "30000");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }}
