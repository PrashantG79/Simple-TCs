package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FilterOrderDetails {
private WebDriver driver; 
	
	public FilterOrderDetails(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='parent']//i[@class='fa fa-shopping-cart fw']")
	private WebElement cart; 
	
	@FindBy(partialLinkText="Orders")
	private WebElement order;
	
	@FindBy(id="input-order-id")
	private WebElement orderId; 
	
	@FindBy(xpath="//button[@id='button-filter']")
	private WebElement filter; 
	
	@FindBy(xpath="//input[@id='input-customer']")
	private WebElement inputCust;
	
	public void cartSelect() {
		this.cart.click();
	}
	
	public void orderSelect() {
		this.order.click();
	}
	
	public void sendOrderId(String orderId) {
		this.orderId.clear();
		this.orderId.sendKeys(orderId);
	}
	
	public void filterClick() {
		this.filter.click();
	}
	
	public void tryCheck() {
		try {
			String expectedOrderID="188";
			String actualOrderID=driver.findElement(By.xpath("//td[contains(text(),'188')]")).getText();
			Assert.assertEquals(actualOrderID, expectedOrderID);
			System.out.println("Given Order ID and Order details are matching");
			}
			catch (NoSuchElementException e) {
				System.out.println("Given Order ID and Order details are not matching");
			}
	}
	
	public void custData(String inputCust) {
		this.inputCust.clear();
		this.inputCust.sendKeys(inputCust);
	}
	
	public void filterByCustName () {
		
			
		String before="//div[@id='container']//tbody/tr[";
		String after ="]/td[3]";
		
		String customerName = "";		
		String custName ="manzoor mehadi";
		int count = driver.findElements(By.xpath("//div[@id='container']//tbody/tr")).size();
		System.out.println(count);
		
		int i=1;
		for(i=1;i<=count;i++) {
			customerName=driver.findElement(By.xpath("//div[@id='container']//tbody/tr[1]/td[3]")).getText();
			//String customerName=driver.findElement(By.xpath("before + i + after")).getText();
			//System.out.println(customerName);
		}
			if(customerName.equalsIgnoreCase(custName)) {
				System.out.println("List is matching with the given Customer Name " +customerName);
			}else {
				System.out.println("List is not matching with the given Customer Name");
			}
		
			
		
	}
	
	
}
