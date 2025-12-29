package org.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  BasePage {

	/*@FindBy(id = "input-firstname")
    WebElement firstName;

    @FindBy(id = "input-lastname")
    WebElement lastName;

    @FindBy(id = "input-email")
    WebElement emailID;

    @FindBy(tagName = "telephone")
    WebElement telePhone;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitBtn;*/

    @FindBy(id = "input-email")
    WebElement emailEt;

    @FindBy( xpath = "//*[@type='password']")
    WebElement password;

     @FindBy(className = "btn btn-primary")
    WebElement loginBtn;


   @FindBy(linkText = "My Account")
   WebElement textTyper;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateLogin() {
        textTyper.click();
    }


}
