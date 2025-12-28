package TestHR;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFont {

    WebDriver driver;
    String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
String ADD = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee";
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void login() {

        WebElement Username = driver.findElement(By.name("username"));
        WebElement Password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        Username.sendKeys("Admin");
        Password.sendKeys("admin123");
        loginBtn.click();
    }
    @Test (priority = 2)
    public void PIM () {
    	WebElement Pim = driver.findElement(
    		    By.xpath("//span[text()='PIM']")
    		);
    		Pim.click();

    }
    @Test (priority = 3, enabled = false )
    public void EmployeeInformation() {
    	
    	WebElement inputField = driver.findElement(
    		    By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input")
    		);
    		inputField.sendKeys("Abdelrhman");
    		
    		//
    		WebElement employeeId = driver.findElement(
    			    By.xpath("//label[text()='Employee Id']/following::input[1]")
    			);
    			employeeId.sendKeys("150");
    		//	WebElement dropdown = driver.findElement(
        			    By.xpath("//div[contains(@class,'oxd-select-text-input') and text()='-- Select --']");
        	//dropdown.click();  // يفتح القائمة
    }
     @Test (priority =4)
     public void AddEmployee() {
      driver.get(ADD);
      WebElement EmployeeFullName = driver.findElement(
    		    By.cssSelector(".oxd-input.oxd-input--active.orangehrm-firstname")
    		);
      EmployeeFullName.sendKeys("Abdul Rahman ");
      WebElement MiddleName = driver.findElement(
    		    By.cssSelector(".oxd-input.oxd-input--active.orangehrm-middlename")
    		);
    		MiddleName.sendKeys("Aqab");

    		WebElement lastName = driver.findElement(
    			    By.name("lastName")
    			);
    			lastName.sendKeys("Al-Asaad");

    			WebElement employeeId = driver.findElement(
    				    By.xpath("//label[text()='Employee Id']/following::input[1]")
    				);
    			employeeId.sendKeys(Keys.chord(Keys.CONTROL, "a")); // تحديد كل النص
    				employeeId.sendKeys(Keys.DELETE);                   // مسح النص
    				employeeId.sendKeys("151");                       // إدخال النص الجديد
    				WebElement Save = driver.findElement(
    					    By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    					);
    					Save.click();










    	
    }

}
