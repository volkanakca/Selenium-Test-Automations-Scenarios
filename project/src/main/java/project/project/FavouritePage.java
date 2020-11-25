package project.project;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FavouritePage extends BasePage {

	// 3.ürünün favori ekle buttonu
	@FindBy(xpath = "//*[@class='myAccountMenu hOpenMenu']/div[1]/a[2]")
	private WebElement favoriPopupButton;

	// My Favorite link to list
	@FindBy(xpath = "//*[@class='wishGroupListItem favorites']/div[1]/a[1]")
	private WebElement linkToList;

	// My Favorite ürünlerinin listeleri için
	@FindBy(xpath = "//* [@id='view']/ul/li/div/div/a/h3")
	private List<WebElement> productTitles;

	// Ürün sil buttonu için
	@FindBy(xpath = "//*[@id='view']/ul/li/div/div[3]/span")
	private WebElement linkDeleteProduct;

	@FindBy(className = "message")
	private WebElement message;
	
	@FindBy(className = "closeBtn")
	private WebElement closeBtn;
	
	public FavouritePage(WebDriver driver) {
		super(driver);
	}

	// 3.Pop-up kısmından favorileri seç
	public void clickPopupMyFavorite() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", favoriPopupButton);
		waitForPageLoad();
	}

	// Sayfanın üstündeki favorilere tıklayarak favoriler listeleniyor.
	public void myFavoriteListShow() {
		linkToList.click();
		waitForPageLoad();
	}

	// Sayfanın üstündeki favorilere tıklayarak favoriler listeleniyor.
	public List<WebElement> myFavoriteList() {
		return productTitles;
	}

	// Sayfanın üstündeki favorilere tıklayarak favoriler listeleniyor.
	public void clickLinkDeleteProduct() {
		linkDeleteProduct.click();
	}

	public String getMessage() {
		return message.getText();
	}

	// Sayfanın üstündeki favorilere tıklayarak favoriler listeleniyor.
	public void closeContent() {
		closeBtn.click();
		waitForPageLoad();
	}
}