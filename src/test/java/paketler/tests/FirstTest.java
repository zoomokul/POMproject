package paketler.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import paketler.pages.FirstPage;
import paketler.utilities.ConfigReader;
import paketler.utilities.Driver;

public class FirstTest {
    FirstPage firstPage=new FirstPage();
 @Test
    public  void test01(){

     // Driver.getDriver()==> driver
     Driver.getDriver().get(ConfigReader.getProperty("google_url"));
     firstPage.googleSearchBox.sendKeys("selenium");
     Driver.getDriver().navigate().to(ConfigReader.getProperty("yandex_url"));
     firstPage.yandexSearchBox.sendKeys("selenium");
     Driver.getDriver().navigate().to(ConfigReader.getProperty("bing_url"));
     firstPage.bingSearchBox.sendKeys("selenium");

     Driver.closeDriver();


 }
}
