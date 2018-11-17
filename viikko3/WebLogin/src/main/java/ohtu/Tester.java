package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.Random;

public class Tester {

    public static void main(String[] args) {

        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");
        Random r = new Random();

        System.out.println("Current page: \n" + driver.getPageSource());

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println("Current page: \n" + driver.getPageSource());

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");

        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");

        element = driver.findElement(By.name("login"));
        element.submit();

        System.out.println("Logging out...");

        element = driver.findElement(By.linkText("logout"));
        element.click();

        System.out.println("Current page: \n" + driver.getPageSource());

        sleep(2);

        System.out.println("Logging in with an invalid password...");

        element = driver.findElement(By.linkText("login"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");

        element = driver.findElement(By.name("password"));
        element.sendKeys("vaaraSalasana");

        element = driver.findElement(By.name("login"));
        element.submit();

        sleep(1);

        System.out.println("Logging in with a nonexistent username...");

        element = driver.findElement(By.name("username"));
        element.sendKeys("eliza"+r.nextInt(100000));

        element = driver.findElement(By.name("password"));
        element.sendKeys("betty");

        element = driver.findElement(By.name("login"));
        element.submit();

        sleep(1);

        System.out.println("Returning to home");

        element = driver.findElement(By.linkText("back to home"));
        element.click();

        sleep(1);

        System.out.println("Registering a new user...");

        element = driver.findElement(By.linkText("register new user"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("eliza"+r.nextInt(100000));

        element = driver.findElement(By.name("password"));
        element.sendKeys("betty");

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("betty");

        element = driver.findElement(By.name("signup"));
        element.submit();

        sleep(1);

        System.out.println("Logging out");

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        element = driver.findElement(By.linkText("logout"));
        element.click();

        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
