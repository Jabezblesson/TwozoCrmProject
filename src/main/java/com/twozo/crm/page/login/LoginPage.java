package com.twozo.crm.page.login;

import com.twozo.crm.base.BasePage;
import com.twozo.crm.model.LoginData;
import com.twozo.crm.page.dealspage.DealsPage;
import com.twozo.crm.page.signup.SignUpPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By email = By.cssSelector("input[name='email']");
    private final By password = By.cssSelector("input[name='password']");
    private final By login = By.xpath("//button[text()='Sign In']");
    private final By signup = By.xpath("//p[text()='Sign Up']");

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    public void enterEmailId(final String username) {
        type(email,username);
    }

    public void enterPassword(final String password) {
        type(this.password,password);
    }

    public void clickSignIn() {
        click(login);
    }

    public SignUpPage ClickSignUp() {
       click(signup);

        return new SignUpPage(driver);
    }

    public DealsPage loginToCRM(final LoginData data) {
        enterEmailId(data.getUsername());
        enterPassword(data.getPassword());
        clickSignIn();

        return new DealsPage(driver);
    }
}
