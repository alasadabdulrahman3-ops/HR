package TestHR;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFont   {
	
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
    public void login() throws InterruptedException{

        WebElement Username = driver.findElement(By.name("username"));
        WebElement Password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        Username.sendKeys("Admin");
        Password.sendKeys("admin123");
        Thread.sleep(1000);
        loginBtn.click();
    }
    @Test (priority = 2)
    public void PIM () {WebElement Pim = driver.findElement( By.xpath("//span[text()='PIM']"));
    		Pim.click();   }
    
     @Test (priority =3)
     public void AddEmployee() {

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

         driver.get(ADD);

         // 🔹 بيانات عشوائية
         String firstName = generateRandomName("FN");
         String middleName = generateRandomName("MN");
         String lastName = generateRandomName("LN");
         String empId = generateRandomNumber(4);

         // 🔹 First Name
         WebElement firstNameField = wait.until(
                 ExpectedConditions.visibilityOfElementLocated(
                         By.cssSelector(".oxd-input.oxd-input--active.orangehrm-firstname")
                 )
         );
         firstNameField.sendKeys(firstName);

         // 🔹 Middle Name
         WebElement middleNameField = driver.findElement(
                 By.cssSelector(".oxd-input.oxd-input--active.orangehrm-middlename")
         );
         middleNameField.sendKeys(middleName);

         // 🔹 Last Name
         WebElement lastNameField = driver.findElement(By.name("lastName"));
         lastNameField.sendKeys(lastName);

         // 🔹 Employee ID
         WebElement employeeIdField = driver.findElement(
                 By.xpath("//label[text()='Employee Id']/following::input[1]")
         );
         employeeIdField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
         employeeIdField.sendKeys(Keys.DELETE);
         employeeIdField.sendKeys(empId);

         // 🔹 Save
         WebElement saveBtn = wait.until(  ExpectedConditions.elementToBeClickable( By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"))
         );
         saveBtn.click();
     }

     public String generateRandomName(String prefix) {
         Random random = new Random();
         return prefix + random.nextInt(1000);
     }
     public String generateRandomNumber(int length) {
         Random random = new Random();
         StringBuilder number = new StringBuilder();
         for (int i = 0; i < length; i++) {
             number.append(random.nextInt(10));
         }
         return number.toString(); }

     	@Test (priority =4, enabled = false )
     public void Information() {

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    JavascriptExecutor js = (JavascriptExecutor) driver;
    	    // =============== Other Id ===============
    	    WebElement otherId = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//label[text()='Other Id']/following::input[1]")));
    	    otherId.click();
    	    otherId.clear();
    	    otherId.sendKeys("Ahmad156");

    	    // =============== Driver License ===============
    	    WebElement license = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//label[contains(text(),'Driver')]/following::input[1]")));
    	    license.click();
    	    license.clear();
    	    license.sendKeys("A15");

    	    // =============== License Expiry Date ===============
    	    WebElement licenseDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	            By.xpath("//label[contains(text(),'License Expiry Date')]/following::input[1]")));
    	    js.executeScript("arguments[0].removeAttribute('readonly')", licenseDate);
    	    licenseDate.click();
    	    licenseDate.sendKeys("2030-12-31");

    	    // =============== Nationality Dropdown ===============
    	    WebElement nationality = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//label[text()='Nationality']/following::div[contains(@class,'oxd-select-text')][1]")));
    	    nationality.click();
    	    WebElement jordan = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//span[text()='Jordanian']")));
    	    jordan.click();

    	    // =============== Marital Status Dropdown ===============
    	    WebElement marital = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//label[text()='Marital Status']/following::div[contains(@class,'oxd-select-text')][1]")));
    	    marital.click();
    	    WebElement single = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//span[text()='Single']")));
    	    single.click();

    	    // =============== Date of Birth ===============
    	    WebElement dob = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	            By.xpath("//label[text()='Date of Birth']/following::input[1]")));
    	    js.executeScript("arguments[0].removeAttribute('readonly')", dob);
    	    dob.click();
    	    dob.sendKeys("2000-05-10");

    	    // =============== Gender (Male) ===============
    	    WebElement maleLabel = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//label[text()='Male']")));
    	    maleLabel.click();


    	    // =============== Save Button ===============
    	    WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	            By.xpath("//button[contains(text(),'Save')]")));
    	    js.executeScript("arguments[0].scrollIntoView(true);", save);
    	    js.executeScript("arguments[0].click();", save); // اضغط باستخدام JS

    	}

     @Test (priority =5 , enabled = false)
     public void CustomFields() {

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	    JavascriptExecutor js = (JavascriptExecutor) driver;
    	    Actions actions = new Actions(driver);

    	    // فتح القائمة
    	    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//div[contains(@class,'oxd-select-text-input') and text()='-- Select --']")));
    	    dropdown.click();

    	    // اختيار قيمة "AB+"
    	    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//span[text()='AB+']")));
    	    option.click();

    	    // حقل Test_Field
    	    WebElement testField = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//label[text()='Test_Field']/following::input[1]")));
    	    testField.click();
    	    testField.clear();
    	    testField.sendKeys("18090");

    	    // زر Save الثاني
    	    WebElement secondSaveButton = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("(//button[contains(@class,'oxd-button--secondary')])[2]")));
    	    js.executeScript("arguments[0].scrollIntoView(true);", secondSaveButton);
    	    actions.moveToElement(secondSaveButton).click().perform();
    	}
     
     @Test (priority =6, enabled = false)
     public void uploadAttachment(WebDriver driver) throws InterruptedException {
    	    // زيادة مدة الانتظار لتجنب مشاكل العناصر البطيئة
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    	    // 🔹 مسار الملف داخل Downloads
    	    String filePath = System.getProperty("user.home") + "\\Downloads\\QA.pdf";
    	    File file = new File(filePath);

    	    if (!file.exists()) {
    	        throw new RuntimeException("❌ الملف غير موجود: " + filePath);
    	    }
    	    String fileName = file.getName();

    	    // 1️⃣ اضغط زر Add أولاً
    	    WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//button[contains(.,'Add')]")
    	    ));
    	    addBtn.click();
    	    System.out.println("🔹 تم الضغط على زر Add");

    	    // 2️⃣ انتظر ظهور input[type='file'] ورفع الملف
    	    WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(
    	            By.xpath("//input[@type='file']")
    	    ));
    	    fileInput.sendKeys(file.getAbsolutePath());
    	    System.out.println("🔹 تم رفع الملف: " + fileName);

    	    // 3️⃣ انتظر ظهور اسم الملف بعد الرفع للتأكد من نجاح العملية
    	    wait.until(ExpectedConditions.visibilityOfElementLocated(
    	            By.xpath("//*[contains(text(),'" + fileName + "')]")
    	    ));

    	    // 4️⃣ اضغط زر Save لإتمام رفع الملف
    	    WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//button[contains(.,'Save')]")
    	    ));
    	    saveBtn.click();
    	    System.out.println("✅ تم حفظ الملف بنجاح!");
    	}
	 @Test (priority = 7)
	 public void ContactDetails() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement contactTab = wait.until(
		     ExpectedConditions.elementToBeClickable(By.linkText("Contact Details"))
		 );
		 contactTab.click();}
		
@Test (priority = 8)
public static void fillAddress(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Random random = new Random();

    // 🔹 بيانات واقعية
    String[] streets = {
        "King Abdullah Street", "Rainbow Street", "Al-Wehdat Street",
        "Al-Madina Street", "Al-Quds Street", "Al-Hussein Street"
    };

    String[] cities = {
        "Amman", "Zarqa", "Irbid", "Aqaba", "Madaba", "Salt", "Jerash"
    };

    String[] states = {
        "Amman", "Balqa", "Irbid", "Aqaba", "Mafraq", "Karak", "Tafilah"
    };

    // 🔹 Street 1
    WebElement street1 = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//label[text()='Street 1']/../following-sibling::div//input")
    ));
    street1.clear();
    street1.sendKeys(streets[random.nextInt(streets.length)]);

    // 🔹 Street 2
    WebElement street2 = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("(//label[text()='Street 2']/../following-sibling::div//input)[2]")
    ));
    street2.clear();
    street2.sendKeys("Apt " + (random.nextInt(500) + 1));

    // 🔹 City
    WebElement city = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//label[text()='City']/../following-sibling::div//input")
    ));
    city.clear();
    city.sendKeys(cities[random.nextInt(cities.length)]);

    // 🔹 State/Province
    WebElement state = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//label[text()='State/Province']/../following-sibling::div//input")
    ));
    state.clear();
    state.sendKeys(states[random.nextInt(states.length)]);

    // 🔹 Zip/Postal Code
    WebElement zip = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//label[text()='Zip/Postal Code']/../following-sibling::div//input")
    ));
    zip.clear();
    zip.sendKeys(String.format("%05d", random.nextInt(99999)));

    // 🔹 Country dropdown
    WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//label[text()='Country']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
    ));
    countryDropdown.click();

    // ⚡ انتظر ظهور العناصر
    List<WebElement> countries = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
        By.xpath("//div[@role='option']")
    ));

    // ⚡ scroll واختيار عنصر عشوائي
    WebElement randomCountry = countries.get(random.nextInt(countries.size()));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomCountry);
    randomCountry.click();

    System.out.println("✅ Contact Details form filled successfully!");
}
}
    

