package TestHR;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFont extends MYData{

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
    				employeeId.sendKeys(Keys.DELETE); 
    				employeeId.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    				employeeId.sendKeys(Keys.DELETE);
    				employeeId.sendKeys("988");
    				WebElement Save = driver.findElement(
    					    By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    					);
    					Save.click();}
    	/////////////////			
     @Test (priority =5)
     public void Informationa () {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 // Other Id
    	 WebElement otherId = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	         By.xpath("//label[text()='Other Id']/following::input[1]")));
    	 otherId.click();
    	 otherId.clear();
    	 otherId.sendKeys("AHMAD123");

    	 // Driver License
    	 WebElement license = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	         By.xpath("//label[contains(text(),'Driver')]/following::input[1]")));
    	 license.click();
    	 license.clear();
    	 license.sendKeys("D123456");

    	 // License Expiry Date
    	 WebElement licenseDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	         By.xpath("//label[contains(text(),'License Expiry Date')]/following::input[1]")));
    	 js.executeScript("arguments[0].removeAttribute('readonly')", licenseDate); // إزالة readonly
    	 licenseDate.click();
    	 licenseDate.clear();
    	 licenseDate.sendKeys("2028-12-31");

    	 // Nationality Dropdown
    	 WebElement nationality = wait.until(ExpectedConditions.elementToBeClickable(
    	         By.xpath("//label[text()='Nationality']/following::div[contains(@class,'oxd-select-text')][1]")));
    	 nationality.click();
    	 WebElement jordan = wait.until(ExpectedConditions.elementToBeClickable(
    	         By.xpath("//span[text()='Jordanian']")));
    	 jordan.click();

    	 // Marital Status Dropdown
    	 WebElement marital = wait.until(ExpectedConditions.elementToBeClickable(
    	         By.xpath("//label[text()='Marital Status']/following::div[contains(@class,'oxd-select-text')][1]")));
    	 marital.click();
    	 WebElement single = wait.until(ExpectedConditions.elementToBeClickable(
    	         By.xpath("//span[text()='Single']")));
    	 single.click();

    	 // Date of Birth
    	 WebElement dob = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	         By.xpath("//label[text()='Date of Birth']/following::input[1]")));
    	 js.executeScript("arguments[0].removeAttribute('readonly')", dob); // إزالة readonly
    	 dob.click();
    	 dob.clear();
    	 dob.sendKeys("2000-05-10");

    	 // Male Radio Button
    	 WebElement male = wait.until(ExpectedConditions.elementToBeClickable(
    	         By.xpath("//label[text()='Male']")));
    	 js.executeScript("arguments[0].click();", male); // استخدم JS click لتجنب مشاكل الاختفاء

    	 // Save Button
    	 WebElement save = wait.until(ExpectedConditions.elementToBeClickable(
    	         By.xpath("//button[.=' Save ']")));
    	 wait.until(ExpectedConditions.elementToBeClickable(save)).click();
    	 save.click();}
     @Test (priority =6)
     public void CustomFields() {
    	// فتح القائمة
WebElement dropdown = driver.findElement(By.xpath("//div[contains(@class,'oxd-select-text-input') and text()='-- Select --']"));
    	 dropdown.click();
    	 // اختيار قيمة، مثلا "A+"
  WebElement option = driver.findElement(By.xpath("//span[text()='AB+']"));
    	 option.click();
    	 WebElement testField = driver.findElement(By.xpath("//label[text()='Test_Field']/following::input[1]"));
    	 testField.sendKeys("18090");
    	 WebElement secondSaveButton = driver.findElement(By.xpath("(//button[contains(@class,'oxd-button--secondary')])[2]"));
    	 secondSaveButton.click();



    	 
     }
     
 
     
}
