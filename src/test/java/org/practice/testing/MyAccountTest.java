package org.practice.testing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practice.MyAccountPage;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(MyAccountTest.class);
    MyAccountPage myAccountPage;

    @Test(/*dependsOnMethods = "verifyLogin"*/)
    public void verifyAccountLoggedIn(){
        myAccountPage = new MyAccountPage(this.getDriver());
        myAccountPage.verifyLoggedin();
    }
}
