package org.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;
import java.util.Objects;

public class MyAccountPage extends BasePage {

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(css = "a.list-group-item")
    private List<WebElement> accountMenuItems;

    @FindBy(xpath = "//input[@type='text' and @name='firstname']")
    private  WebElement  editFirstName;

    @FindBy(xpath = "//input[@name='lastname']")
    private  WebElement  editLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement editInput;

    @FindBy(xpath = "input-telephone")
    private WebElement editInputTele;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement successMessage;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void verifyAccount() {
        waitforVisibility(logoutLink);
        clickElement(accountMenuItems.get(1));
        Assert.assertTrue((Objects.requireNonNull(driver.getCurrentUrl())).contains("account/edit"));
    }

    public void EditAccountDetails() {
        waitforVisibility(editFirstName);
        addTextInTextfield(editFirstName,"tester");
        addTextInTextfield(editLastName,"as");
        clickElement(buttonSubmit);
        waitforVisibility(editFirstName);
        Assert.assertTrue(successMessage.isDisplayed());
    }

}


//input-firstname