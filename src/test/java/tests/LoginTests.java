package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import javax.jws.soap.SOAPBinding;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void loginSuccess1(){

        User user = new User().setEmail("hotdog@mail.com").setPassword("hotDog$123");
//        user.setEmail("hotdog@mail.com");
//        user.setPassword("hotDog$123");
        logger.info("Test start with test data --->" + user.toString());
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");


    }

    @Test
    public void loginSuccess(){
        logger.info("Test start with test data --->/n" + "email : 'hotdog@mail.com' & password : 'hotDog$123'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("hotdog@mail.com","hotDog$123");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }
    @Test
    public void loginSuccessModel(){
        logger.info("Test start with test data --->/n" + "email : 'hotdog@mail.com' & password : 'hotDog$123'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("hotdog@mail.com","hotDog$123");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }
    @Test
    public void loginWrongEmail(){
        logger.info("Test negative check if it possible to login with wrong format email ");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("","hotDog$123");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test negative check if it possible to login with wrong format password ");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("hotdog@mail.com","hotDog123");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }
    @Test
    public void loginUnregistered(){
        logger.info("Test negative check if it possible to login with valid format data unregistered user ");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("luck@gmail.com","luck12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().closeWindow();
    }
}
