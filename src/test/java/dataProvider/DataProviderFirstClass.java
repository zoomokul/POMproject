package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import paketler.utilities.Driver;

public class DataProviderFirstClass {

    @DataProvider
    public static Object [][] dataProviderMethod(){
                String [][] searchWord={
                        {"java"}, // if there is two variable in here, in method you can use two parameter
                        {"python"},
                        {"csharp"},
                        {"javascript"}};

        return searchWord;
    }
    @Test(dataProvider = "dataProviderMethod")
    public void searchGoogle(String word){  // if there is two variable in here, in method you can use two parameter
        Driver.getDriver().get("https://www.google.com.tr/");
       WebElement searchBox= Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
       searchBox.sendKeys(word+ Keys.ENTER);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(word));

        System.out.println(word+" ile alakalı "+Driver.getDriver().findElement(By.cssSelector("div#result-stats")).getText());


        Driver.getDriver().navigate().back();
    }


}
