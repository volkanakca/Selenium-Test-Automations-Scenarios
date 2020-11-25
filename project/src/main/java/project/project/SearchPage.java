package project.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage  extends BasePage{

	@FindBy(id = "searchData")
	private WebElement searchData;
	
	@FindBy(className = "searchBtn")
	private WebElement searchBtn;
	
	//Arama sonucu
	@FindBy(xpath = "//*[@class='resultText ']/strong")
	private WebElement countResult;
	
	//Arama sayfasındaki 2.button
	@FindBy(xpath = "//*[@class='pagination']/a[2]")
	private WebElement secondButton;
	
	//Arama sonuçlarından listedeki 3. ürün
	@FindBy(xpath = "//li[3]/div/div[2]/span[2]")
	private WebElement thirdProductInList;
	
	//3.ürün isimi
	@FindBy(xpath = "//li[3]/div/div/a/h3")
	private WebElement thirdProductName;

	//3.ürünün favori ekle buttonu
	@FindBy(xpath = "//li[3]/div/div[2]/span[2]")
	private WebElement favoriAddButton;
			
	public SearchPage(WebDriver driver) {
		super(driver); 
	}
	
	//Arama kısmına veri girmek için
	public void enterDataForSearch(String data) {
		this.searchData.clear();
		this.searchData.sendKeys(data);
	}
	
	//Arama yapmak için
	public void submitForSearch() {
		searchBtn.click(); 
	}
	
	//Arama sonucu
	public String getCountResult()
	{
		return countResult.getText();
	}
	
	//Arama sayfasının 2. butonuna tıklanması
	public void clickSecondButton() {
		secondButton.click(); 
	}
	
	//3.Ürünü seç 
	 public void selectThirdProduct(){
		 wait.until(elementClickableByXpad(thirdProductInList));
		 setSelectedFavoriteProduct(thirdProductName.getText()); 
		 favoriAddButton.click(); 
	 }
	
	//Favorilere ekle
	 public void addFavoriteProduct(){ 
		 favoriAddButton.click(); 
	 }
}