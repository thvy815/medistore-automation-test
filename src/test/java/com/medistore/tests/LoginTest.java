package com.medistore.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import com.medistore.utils.ConfigReader;

public class LoginTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void testLoginWithPopup() {

        String baseUrl = ConfigReader.get("base.url");
        String homePath = ConfigReader.get("home.url");

        // 1. Open home page --> url từ config.properties
        driver.get(baseUrl + homePath);

        // 2. Click open login popup 
         wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[data-testid='open-login-btn']")
        )).click();

        // 3. Wait popup + email input
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-testid='email-input']")
        )).sendKeys("vynguyen8105@gmail.com");

        // 4. Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-testid='password-input']")
        )).sendKeys("123456789");

        // 5. Click login submit
        driver.findElement(By.cssSelector("[data-testid='login-submit']"))
          .click();

        // 6. Verify login success (hiển thị user menu)
        WebElement userMenu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-testid='user-menu-toggle']")
                )
        );

        Assertions.assertTrue(userMenu.isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}