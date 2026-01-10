package org.practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage  {

     @FindBy(linkText = "Qafox.com")
     WebElement title;

     @FindBy(id = "input-email")
     WebElement inputEmail;

     @FindBy(id = "input-password")
     WebElement inputPassword;

     @FindBy (xpath = "//input[@value='Login']")
     WebElement submitBtn;

     MyAccountPage myAccountPage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginUser(){
        waitforVisibility(inputEmail);
        addTextInTextfield(inputEmail,"tt@test.com");
        addTextInTextfield(inputPassword,"12345");
        clickElement(submitBtn);
    }


}
