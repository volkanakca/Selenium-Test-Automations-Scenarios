package project.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; 

public class LoginPage extends BasePage {
	 private static String webUrl="https://www.n11.com/giris-yap";

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "loginButton")
	private WebElement loginButton;
	
	@FindBy(className = "user")
	private WebElement userName;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//Login formunu doldurmak için 
	public void enterLoginForm(String email, String password) {
		this.email.clear();
		this.email.sendKeys(email);

		this.password.clear();
		this.password.sendKeys(password);
	}

	//Login olmak için button click  
	public void submit() {
		loginButton.click(); 
		
	}
	 public String getUserName(){
			return userName.getText();
	 }
	 public String getUrl() {
		 return webUrl;
	 }
}