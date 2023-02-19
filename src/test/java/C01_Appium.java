import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C01_Appium {

    @Test
    public void app() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("platformVersion","11.0");
        desiredCapabilities.setCapability("deviceName","PIXEL");
        desiredCapabilities.setCapability("automationName","UIAutomator2");
        desiredCapabilities.setCapability("app","C:\\Users\\AIVISIONTECH\\IdeaProjects\\Appium\\src\\Apps\\Calculator.apk");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http:localhost:4723/wd/hub"),desiredCapabilities);

        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();

        int expectedResult = 45;
        //(Integer.parseInt(driver.findElement(By.id("com.google.android.calculator:id/digit_9")).getText()))*(Integer.parseInt(driver.findElement(By.id("com.google.android.calculator:id/digit_5")).getText()));
        int actualResult = Integer.parseInt(driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText());

        System.out.println("expected: " + expectedResult);
        System.out.println("actual: " + actualResult);
        Assert.assertEquals(actualResult,expectedResult);





    }
}
