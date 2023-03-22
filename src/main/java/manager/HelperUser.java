package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        //click(By.cssSelector("a[href^='/login']"));
        click(By.xpath("//a[text()=' Log in ']"));

    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);

    }


    public void submitLogin() {
        click(By.cssSelector("button[type='submit']"));
    }

    public String getMessage(){
        //wait
        // pause(2000); pause 2sek
       return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
        //WebElement element=wd.findElement(By.cssSelector(".dialog-container>h2"));
        //String text = element.getText();
        //return text;
    }

    public void closeWindow(){
        click(By.xpath("//button[text()='Ok']"));
    }
}
