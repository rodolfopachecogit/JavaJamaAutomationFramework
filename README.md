# Java Jama Test Automation Framework

A Test Automation Framework built using Java, Maven, Selenium, and Cucumber to automate web application testing efficiently.

## 📂 Project Structure

```plaintext
JamaTestAutomationFramework/
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── com.jamaautomation.framework/
│   │   │   │   ├── pages/
│   │   │   │   │   ├── BasePage.java
│   │   │   │   │   ├── HomePage.java
│   │   │   │   │   ├── LoginPage.java
│   │   │   │   │   ├── StreamPage.java
│   │   │   │   ├── runner/
│   │   │   │   │   ├── TestRunner.java
│   │   │   │   ├── steps/
│   │   │   │   │   ├── HomeStepsDefinitions.java
│   │   │   │   │   ├── Hooks.java
│   │   │   │   │   ├── LoginStepDefinitions.java
│   │   │   │   │   ├── StreamStepDefinitions.java
│   │   │   │   ├── utils/
│   │   │   │   │   ├── ConfigReader.java
│   │   │   │   │   ├── StringUtils.java
│   │   │   │   │   ├── WaitHelper.java
│   ├── resources/
│   │   ├── config/
│   │   │   ├── config.properties
│   │   ├── features/
│   │   │   ├── login.feature
│   │   │   ├── stream.feature
```

## 🛠️ Technologies Used
- Java 11+ – Programming Language
- Maven – Build & Dependency Management
- Selenium WebDriver – Web Automation
- Cucumber – BDD Testing
- JUnit 5 – Test Execution
- WebDriverManager – Driver Management

## 📌 Prerequisites
Before running the framework, ensure you have the following installed:
- Java JDK 11+
- Maven (check with `mvn -version`)
- Chrome WebDriver (Managed via WebDriverManager)

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
   ```
   git clone https://github.com/your-repo/JavaJamaTestAutomationFramework.git
   cd JavaJamaTestAutomationFramework
   ```

### 2️⃣ Install Dependencies
   ```
   mvn clean install
   ```
### 3️⃣ Configure Test Settings
   Modify `config.properties` (src/test/resources/config/config.properties):

   ```
   baseUrl=https://qareplicated-kotsdm-nginx-1.jamasoftware.net/login.req
   browser=chrome
   timeout=10
   username=USERNAME (Your username)
   password=PASSWORD (Your password)
   ```

## 🚀 Running the Tests
- Run All Tests:
  `mvn clean test`

- Run Tests in a Specific Browser:
  `mvn clean test -Dbrowser=firefox`

## 📝 Writing Test Cases
Example Cucumber Feature File (`login.feature`):
```
Feature: Login Functionality

  Scenario: User logs in with valid credentials
    Given the user is on the login page
    Then I validate version text is displayed
```

Example Step Definitions (`LoginStepDefinitions.java`):

```
  @Given("the user is on the login page")
  public void theUserIsOnTheLoginPage() {
      loginPage = new LoginPage(Hooks.driver);
      Hooks.driver.get(ConfigReader.getProperty("baseUrl"));
  }
```
## 📂 Page Object Model (POM)
Example Login Page (`LoginPage.java`):

```
 public class LoginPage extends BasePage{

    // Locators
    private final By usernameField = By.id("j_username");
    private final By passwordField = By.id("j_password");
    private final By loginButton = By.id("loginButton");
    private final By loginVersionNumber = By.xpath("//span[@class='j-login-version-number']");

    // Methods
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Login method
    public void login(){
        enterText(usernameField, ConfigReader.getProperty("username"));
        enterText(passwordField, ConfigReader.getProperty("password"));
        clickElement(loginButton);
    }

    public String getLoginVersionNumberText(){
        return getElementText(loginVersionNumber);
    }
```
## 🔄 Hooks for Setup & Teardown (`Hooks.java`)

    @Before
    public void setUp() {
        System.out.println("Initializing WebDriver...");

        String browser = System.getProperty("browser", "chrome"); // Default to Chrome

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("timeout"))));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            System.out.println("Closing WebDriver...");
            driver.quit();
        }
    }

Run tests:
  `mvn clean test`
or run individual tests via feature files in IntelliJ IDEA

## 📜 Need Help?
For any issues, feel free to raise a ticket in the GitHub Issues section.
