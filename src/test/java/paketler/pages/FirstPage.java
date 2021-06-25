package paketler.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import paketler.utilities.Driver;

public class FirstPage {
    public FirstPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//input[@id='sb_form_q']")
    public WebElement bingSearchBox;

    @FindBy(css = "input#text")
    public  WebElement yandexSearchBox;

    @FindBy(xpath = "//input[@name='q']")
    public WebElement googleSearchBox;
}
