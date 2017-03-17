package generics;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	
	public static boolean switchBrowser(WebDriver driver,String eURL){
		
		String currentWH=driver.getWindowHandle();
		Set<String> allWH=driver.getWindowHandles();
		for(String wh:allWH){
			String aURL=driver.switchTo().window(wh).getCurrentUrl();
			if(aURL.contains(eURL)){
				System.out.println("Browser Found");
				return true;
			}
		}
		driver.switchTo().window(currentWH);
		System.out.println("Browser not found");
		return false;
		
	}
	
	public static boolean switchBrowser(String eTitle,WebDriver driver){
		
		String currentWH=driver.getWindowHandle();
		Set<String> allWH=driver.getWindowHandles();
		for(String wh:allWH){
			String aTitle=driver.switchTo().window(wh).getCurrentUrl();
			if(aTitle.contains(eTitle)){
				System.out.println("Browser Found");
				return true;
			}
		}
		driver.switchTo().window(currentWH);
		System.out.println("Browser not found");
		return false;
		
	}

	public static void moveToElement(WebDriver driver, WebElement element){
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
		
	}
	
	public static boolean checkListHasDuplicate(ArrayList<String> allText){
		HashSet<String> clone=new HashSet<String>(allText);
		return allText.size()!=clone.size();
		//true->duplicate; false->No duplicate
	}
	
	public static ArrayList<String> getAllTextFromListBox(WebElement listBox){
		Select select=new Select(listBox);
		List<WebElement> allOptions = select.getOptions();
		ArrayList<String> allText=new ArrayList<String>();
		for(int i=0;i<allOptions.size();i++){
			String text=allOptions.get(i).getText();
			allText.add(text);
		}
				
		return allText;
	}
	
	public static boolean isListSorted(ArrayList<String> allText){
		ArrayList<String> clone=new ArrayList<String>(allText);
		Collections.sort(clone);
		
		return allText.equals(clone);
	}
	
	
	public static String getFormatedDateTime(){
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return simpleDate.format(new Date());
	}
	
	public static String getScreenShot(WebDriver driver, String imageFolderPath){
		String imagePath=imageFolderPath+"/"+getFormatedDateTime()+".png";
		TakesScreenshot page=(TakesScreenshot) driver;
		try{
			FileUtils.copyFile(page.getScreenshotAs(OutputType.FILE), new File(imagePath));
		}catch(Exception e){
			
		}
		return imagePath;
		
	}
	
	public static String getScreenShot(String imageFolderPath){
		String imagePath=imageFolderPath+"/"+getFormatedDateTime()+".png";
		
		try{
			Dimension desktopSize=Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(desktopSize));
			ImageIO.write(image, "png", new File(imagePath));
		}
		catch(Exception e){
		}

		return imagePath;
		
	}
	public static String getPropertyValue(String filePath,String key)
	{
		String value="";
		Properties ppt=new Properties();
		try{
			ppt.load(new FileInputStream(filePath));
			value=ppt.getProperty(key);
		}
		catch(Exception e){
		}
		return value;
	}
	
	public static void clickUsingJS(WebDriver driver,WebElement element){
		  JavascriptExecutor j=(JavascriptExecutor) driver;
		  j.executeScript("arguments[0].click();", element);
		  }
	
}
	