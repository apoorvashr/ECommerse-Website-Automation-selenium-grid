package org.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    LoginPage loginPage;
    @FindBy(xpath ="//footer//a[text()='My Account']")
    WebElement myAccountHyerLink;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    public void navTologin() {
        clickElement(myAccountHyerLink);
        loginPage = new LoginPage(driver);
        loginPage.loginUser();
    }

}
