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

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void verifyLoggedin() {
       waitforVisibility(logoutLink);
      // waitforVisibility(accountMenuItems.get(1));
       Assert.assertTrue((Objects.requireNonNull(driver.getCurrentUrl())).contains("route=account/account"));
    }
}
