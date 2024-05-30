package automationcodeonTiffenOrdersByRupavira;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Order
{

    public WebDriver driver;
    public ChromeOptions opt;
    public SoftAssert soft;
    public WebDriverWait wait;
    public static Select S;

@BeforeMethod
public void setup() 
{
        opt = new ChromeOptions();
        opt.addArguments("incognito");
        opt.addArguments("start-maximized");
        opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        opt.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
        driver = new ChromeDriver(opt);
        driver.get("https://tiffins.rupavira.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // order 	
        driver.findElement(By.xpath("//div[@id='page_wrapper']/header/div/div[2]/div/div/div/div[3]/div/a")).click();

 }

@Test(priority=1)
public void Soup() 
{
	
 // soup
driver.findElement(By.xpath("//div[@id='page_wrapper']/descendant::div[47]")).click();
wait= new WebDriverWait(driver, Duration.ofSeconds(45));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='pa_spice-level']")));
 // spice             
S = new Select(driver.findElement(By.xpath("//select[@id='pa_spice-level']")));
S.selectByVisibleText("Medium");

/** 
 * Allergic Sensititives
 */
 
//No Nuts
wait= new WebDriverWait(driver, Duration.ofSeconds(45));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-content']/descendant::div[7]/label[1]/input/following::span[1]")));
driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[7]/label[1]/input/following::span[1]")).click();

/**
 * Up Charge:No
 */
//Less Salt
wait= new WebDriverWait(driver, Duration.ofSeconds(45));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-content']/descendant::div[13]/label[4]/input/following::span[1]")));
driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[13]/label[4]/input/following::span[1]")).click();

//add
driver.findElement(By.id("add-product")).click();
//close
driver.findElement(By.xpath("//button[@class='modal-close']")).click();

 
}

// This doesnot have the option of Allergies, Upcharge.
@Test(priority=2)
public void Appetizer()
{	
	
 //Streetfood
driver.findElement(By.xpath("//div[@id='page_wrapper']/descendant::div[97]")).click();

/*
//Remove the comments only if item is noodles
wait=new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='pa_choose-size']")));
 //container
S= new Select(driver.findElement(By.xpath("//select[@id='pa_choose-size']")));
S.selectByVisibleText("Large (32oz Container)");
 //spice
S= new Select(driver.findElement(By.xpath("//select[@id='pa_spice-level']")));
S.selectByVisibleText("Spicy");
*/

//add
driver.findElement(By.id("add-product")).click();
//close
driver.findElement(By.xpath("//button[@class='modal-close']")).click();

 
}

@Test(priority=3)
public void VegEntre()
{
	
 //vegcurry
driver.findElement(By.xpath("//div[@id='page_wrapper']/descendant::div[225]")).click();
wait = new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='pa_choose-size']")));
 //container
S= new Select(driver.findElement(By.xpath("//select[@id='pa_choose-size']")));
S.selectByVisibleText("Large (32oz Container)");
 //spice
S= new Select(driver.findElement(By.xpath("//select[@id='pa_spice-level']")));
S.selectByVisibleText("Very Spicy");
/**
 *  Allergic sensitives
 *  No Onion/Garlic
 */
 
wait = new WebDriverWait(driver, Duration.ofSeconds(45));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-content']/descendant::div[7]/label[2]/input/following::span[1]")));
driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[7]/label[2]/input/following::span[1]")).click();

/**
 * Up Charge:Yes
 * No Onion/Garlic
 */
wait = new WebDriverWait(driver, Duration.ofSeconds(45));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-content']/descendant::div[13]/label[2]/input/following::span[1]")));
driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[13]/label[2]/input/following::span[1]")).click();

//add
driver.findElement(By.id("add-product")).click();
//close
driver.findElement(By.xpath("//button[@class='modal-close']")).click();

 
 }

@Test(priority=4)
public void NonvegEntre()
 {
	
 //Nonvegcurry
driver.findElement(By.xpath("//div[@id='page_wrapper']/descendant::div[304]")).click();
wait= new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='pa_choose-size']")));
 //container
S= new Select(driver.findElement(By.xpath("//select[@id='pa_choose-size']")));
S.selectByVisibleText("Large (32oz Container)");
 //spice
S= new Select(driver.findElement(By.xpath("//select[@id='pa_spice-level']")));
S.selectByVisibleText("Mild");

/**
 * Allergic Sensitives
 * Glutenfree
 */

wait= new WebDriverWait(driver, Duration.ofSeconds(45));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-content']/descendant::div[7]/label[4]/input/following::span[1]")));
soft= new SoftAssert();
soft.assertTrue(driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[7]/label[4]/input/following::span[1]")).isDisplayed());
driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[7]/label[4]/input/following::span[1]")).click();
/**
 * Up Charge:yes
 * Less Oil
 */

wait= new WebDriverWait(driver, Duration.ofSeconds(45));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-content']/descendant::div[13]/label[3]/input/following::span[1]")));
soft= new SoftAssert();
soft.assertTrue(driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[13]/label[3]/input/following::span[1]")).isDisplayed());
driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[13]/label[3]/input/following::span[1]")).click();
soft.assertAll();

//add
driver.findElement(By.id("add-product")).click();

//close
driver.findElement(By.xpath("//button[@class='modal-close']")).click();
  }

@Test(priority=5)
public void Specialorder()
{
	
 //side
driver.findElement(By.xpath("//div[@id='page_wrapper']/descendant::div[411]")).click();
wait = new WebDriverWait(driver,Duration.ofSeconds(30));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='pa_spice-level']")));
 //spice
S= new Select(driver.findElement(By.xpath("//select[@id='pa_spice-level']")));
S.selectByVisibleText("Very Mild");
//container
S= new Select(driver.findElement(By.xpath("//select[@id='pa_choose-size']")));
S.selectByVisibleText("Large (32oz Container)");
/*instructions only during Special Request
driver.findElement(By.xpath("//div[@id='page_wrapper']/descendant::div[411]/following::input[2]")).sendKeys("Lazanya");
*/

/*
 * Allergic Sensitives
 * Vegan
 */
wait = new WebDriverWait(driver,Duration.ofSeconds(40));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-content']/descendant::div[7]/label[3]/input/following::span[1]")));
driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[7]/label[3]/input/following::span[1]")).click();

/*
 * Up Charge:yes
 * Jain
 */
wait = new WebDriverWait(driver,Duration.ofSeconds(40));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-content']/descendant::div[13]/label[1]/input/following::span[1]")));
driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[13]/label[1]/input/following::span[1]")).click();

//add
driver.findElement(By.id("add-product")).click();
//close
driver.findElement(By.xpath("//button[@class='modal-close']")).click();

 
 }

@Test(priority=6)
public void BreadsPickup()

{
//Bread1
driver.findElement(By.xpath("//div[@id='page_wrapper']/descendant::div[418]")).click();
//quantity
driver.findElement(By.xpath("//input[@name='quantity']/following::button[1]")).click();

/**
 * Allergic sensitivties
 * Vegan
 */

wait = new WebDriverWait(driver,Duration.ofSeconds(45));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-content']/descendant::div[4]/label[3]/input/following::span[1]")));
driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[4]/label[3]/input/following::span[1]")).click();

//add
driver.findElement(By.id("add-product")).click();
//close
driver.findElement(By.xpath("//button[@class='modal-close']")).click();


//Bread2
driver.findElement(By.xpath("//div[@id='page_wrapper']/descendant::div[425]")).click();
//quantity
driver.findElement(By.xpath("//input[@name='quantity']/following::button[1]")).click();

/**
 * Up Charge:yes
 * Less Oil
 */

wait = new WebDriverWait(driver,Duration.ofSeconds(45));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-content']/descendant::div[10]/label[3]/input/following::span[1]")));
driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[10]/label[3]/input/following::span[1]")).click();

//add
driver.findElement(By.id("add-product")).click();
//close
driver.findElement(By.xpath("//button[@class='modal-close']")).click();

//cart
driver.findElement(By.xpath("//a[@id='mycartbtn']")).click();

//waiting for date
 wait= new WebDriverWait(driver,Duration.ofSeconds(10));
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='e_deliverydate_0']")));
 
//Date
 soft= new SoftAssert();
 soft.assertTrue(driver.findElement(By.xpath("//input[@id='e_deliverydate_0']")).isDisplayed());
 
//waiting for initial checkout
 wait= new WebDriverWait(driver, Duration.ofSeconds(10));
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart_totals ']/table/following::a[1]")));
 
//initial checkout
driver.findElement(By.xpath("//div[@class='cart_totals ']/table/following::a[1]")).click();

//paymentpage
soft.assertTrue(driver.findElement(By.xpath("//div[@id='customer_details']")).isDisplayed());

//billing details: firstname
driver.findElement(By.xpath("//input[@id='billing_first_name']")).sendKeys("nik");
//lastname
driver.findElement(By.xpath("//input[@id='billing_last_name']")).sendKeys("hil");
//Email
driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("nik8@gmail.com");
//Telephone
driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("7038051997");
//Street
driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("22699 High Haven Terrace");
//City
driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("Ashburn");
//State
S = new Select(driver.findElement(By.xpath("//select[@id='billing_state']")));
S.selectByVisibleText("Virginia");
//postalcode
driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("20148");
//Checkbox
driver.findElement(By.xpath("//input[@id='mailchimp_woocommerce_newsletter' and @value=1]"));
//Tip
driver.findElement(By.xpath("//div[@id='order_review']/div[1]/div[3]/a[text()= 'Add 10%  Tip']")).click();

//waiting for pickup location
wait= new WebDriverWait(driver,Duration.ofSeconds(30));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='orddd_locations_0']")));

//Pickup Location
S = new Select(driver.findElement(By.xpath("//select[@id='orddd_locations_0']")));
S.selectByVisibleText("FAIRFAX -, 4121 Meadow Hill Lane, Fairfax, VA, 22033, USA");
//S.selectByVisibleText("ASHBURN -, 21760 Beaumeade Circle, Unit 120, Ashburn, VA, 20147, USA");

//waiting for date
wait= new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='e_deliverydate_0']")));

//Date
soft.assertTrue(driver.findElement(By.xpath("//input[@id='e_deliverydate_0']")).isDisplayed());
soft.assertAll();


}

@Test(priority=7)
public void RiceDelivery() 
{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    SoftAssert soft = new SoftAssert();
	
	    // Fried Rice
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='page_wrapper']/descendant::div[484]")));
	    driver.findElement(By.xpath("//div[@id='page_wrapper']/descendant::div[484]")).click();
	    
	    // Container
	    Select S = new Select(driver.findElement(By.xpath("//select[@id='pa_choose-size']")));
	    S.selectByVisibleText("Large (32oz Container)");
	    
	    // Spice level
	    S = new Select(driver.findElement(By.xpath("//select[@id='pa_spice-level']")));
	    S.selectByVisibleText("Very Spicy");
	    
	    // Quantity
	    driver.findElement(By.xpath("//span[@class='quantity']/button[2]")).click();

	    /**
	     * UpCharge: No
	     *  Less salt
	     */
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-content']/descendant::div[12]/label[4]/input/following::span[1]")));
	    driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[12]/label[4]/input/following::span[1]")).click();
	    
	    // Add to cart
	    driver.findElement(By.id("add-product")).click();
	    
	    // Close model
	    driver.findElement(By.xpath("//button[@class='modal-close']")).click();
	   
	    // Biryani
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='page_wrapper']/descendant::div[498]")));
	    driver.findElement(By.xpath("//div[@id='page_wrapper']/descendant::div[498]")).click();
	    
	    // Container
	    S = new Select(driver.findElement(By.xpath("//select[@id='pa_choose-size']")));
	    S.selectByVisibleText("Large (32oz Container)");
	    
	    // Spice level
	    S = new Select(driver.findElement(By.xpath("//select[@id='pa_spice-level']")));
	    S.selectByVisibleText("Very Spicy");
	    
	    // Quantity
	    driver.findElement(By.xpath("//span[@class='quantity']/button[2]")).click();
	    
	    /**
	     * Up Charge: Yes
	     * No onion/garlic
	     */
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-content']/descendant::div[7]/label[2]/input/following::span[1]")));
	    driver.findElement(By.xpath("//div[@class='product-content']/descendant::div[7]/label[2]/input/following::span[1]")).click();
	    
	    // Add to cart
	    driver.findElement(By.id("add-product")).click();
	    
	    // Close modal
	    driver.findElement(By.xpath("//button[@class='modal-close']")).click();
	  
	    // Go to cart
	    driver.findElement(By.xpath("//a[@id='mycartbtn']")).click();
	    
	    // Wait for date input
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='e_deliverydate_0']")));
	    
	    // Assert date input is displayed
	    
	    soft.assertTrue(driver.findElement(By.xpath("//input[@id='e_deliverydate_0']")).isDisplayed());
	    
	    // Wait for checkout button
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart_totals ']/table/following::a[1]")));
	    
	    // Checkout
	    driver.findElement(By.xpath("//div[@class='cart_totals ']/table/following::a[1]")).click();
	    
	    // Assert payment page is displayed
	    soft.assertTrue(driver.findElement(By.xpath("//div[@id='customer_details']")).isDisplayed());
	    
	    // Billing details
	    driver.findElement(By.xpath("//input[@id='billing_first_name']")).sendKeys("Ak");
	    driver.findElement(By.xpath("//input[@id='billing_last_name']")).sendKeys("hil");
	    driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("ak@gmail.com");
	    driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("7031331995");
	    driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("4108 Middle Ridge");
	    driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("Fairfax");
	    S = new Select(driver.findElement(By.xpath("//select[@id='billing_state']")));
	    S.selectByVisibleText("Virginia");
	    driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("22033");
	    
	    // Checkbox
	    driver.findElement(By.xpath("//input[@id='mailchimp_woocommerce_newsletter' and @value=1]")).click();
	    
	    // Add 10% Tip
	    driver.findElement(By.xpath("//div[@id='order_review']/div[1]/div[3]/a[text()='Add 10%  Tip']")).click();
	    
	    // Wait for date input on payment page
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='e_deliverydate_0']")));
	    
	    // Assert date input is displayed on payment page
	    soft.assertTrue(driver.findElement(By.xpath("//input[@id='e_deliverydate_0']")).isDisplayed());
	   
	    // Assert all
	    soft.assertAll();
	}
 
    
@AfterMethod
public void close() 
{
    //quit the application
    driver.quit();
}

}
