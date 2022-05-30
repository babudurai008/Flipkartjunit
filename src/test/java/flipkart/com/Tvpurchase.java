package flipkart.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tvpurchase {
	static WebDriver driver;
	@BeforeClass
	 public static void Befourclass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\durai\\eclipse-workspace\\FlipkartJunit\\driver\\chromedriver.exe");
	 driver=new ChromeDriver();
driver.get("https://www.flipkart.com/");
driver.manage().window().maximize();
		 
	 }
	@AfterClass
	public static  void afterClass() throws InterruptedException {
	System.out.println("After Class");
	Thread.sleep(3000);
	 driver.quit();
	

}
	 static long starttime;
	@Before
	public void befourtest() {
		System.out.println("Befourtest");
		long starttime=System.currentTimeMillis();
		
	}
	@After
	public void Aftertest() {
		System.out.println("Aftertest");
		long endtime=System.currentTimeMillis();
		System.out.println("endtime-starttime");
	}	
	@Test
	public void method1() {
		WebElement clsbtn= driver.findElement(By.xpath("//button[text()='✕']"));
		clsbtn.click();
	}
	@Test
	public void method2() {
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("realmetv");	
		
	}
	@Test
	public void method3() throws IOException {
		 
		WebElement searchclk=driver.findElement(By.xpath("//button[@type='submit']"));
		searchclk.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement excelname=driver.findElement(By.xpath("(//div[contains(text(),'realme')])[10] "));
String name=excelname.getText();
File f =new File("C:\\Users\\durai\\eclipse-workspace\\FlipkartJunit\\Excelfile\\Book2.xlsx");
FileInputStream f1=new FileInputStream(f);
Workbook w=new XSSFWorkbook(f1);
    Sheet s=w.getSheet("realmetv");
    s.getRow(0).createCell(1).setCellValue(name);
    FileOutputStream f2=new FileOutputStream(f);
    w.write(f2);
    f2.close();
	}
	static String name;
	@Test
	public void method4() throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement clickbtn=driver.findElement(By.xpath("(//div[contains(text(),'realme')])[10] "));
		clickbtn.click();
	String text=	clickbtn.getText();
	Set<String> allwin=((WebDriver) driver).getWindowHandles();
	List<String> m=new ArrayList<String>();
	m.addAll(allwin);
	driver.switchTo().window(m.get(1));
	File f =new File("C:\\Users\\durai\\eclipse-workspace\\FlipkartJunit\\Excelfile\\Book2.xlsx");
	FileInputStream f1=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(f1);
	    Sheet s=w.getSheet("realmetv");
	   String value= s.getRow(0).getCell(1).getStringCellValue();
	   f1.close();
	   Assert.assertEquals(value, name);
	   
	
	}
	@Test
	public void method5() throws IOException {
		TakesScreenshot t=(TakesScreenshot)driver;
	File source= 	t.getScreenshotAs(OutputType.FILE);
	File target=new File("C:\\Users\\durai\\eclipse-workspace\\FlipkartJunit\\screenshot\\flipkart.png");
	FileUtils.copyFile(source, target);
	WebElement down=driver.findElement(By.xpath("(//div[contains(text(),'Highlights')])"));
	JavascriptExecutor j= (JavascriptExecutor)driver;
	j.executeScript("arguments[0].scrollIntoView(true)",down);

	TakesScreenshot t1=(TakesScreenshot)driver;
	File source1= 	t1.getScreenshotAs(OutputType.FILE);
	File target1=new File("C:\\Users\\durai\\eclipse-workspace\\FlipkartJunit\\screenshot\\flipkart1.png");
	FileUtils.copyFile(source1, target1);
	

	}
		
	
}