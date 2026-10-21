package Selenium_2026;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.swing.text.TabableView;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
       WebDriver driver = new ChromeDriver();
       
       driver.get("https://www.makemytrip.com/");
       String parentWindow = driver.getWindowHandle();
       
       driver.manage().window().maximize();
       
       System.out.println(driver.getTitle());
       driver.switchTo().newWindow(WindowType.TAB);
       driver.get("https://www.selenium.dev");
       driver.switchTo().window(parentWindow);
       Actions action = new Actions(driver);
       //action.
     
       
       List<WebElement> ls = driver.findElements(By.tagName("a"));
       System.out.println("List Size is:"+ ls.size());
       for(WebElement link: ls) {
    	   String url = link.getAttribute("href");
    	   //System.out.println("URL>"+url);   	   
    	   verifyLink(url);
       }
       
       driver.quit();
       
    }
    
    static void verifyLink(String url) {
 	  
    	URL linkURL;
    	try {
    		
    		linkURL = new URL(url);
    	HttpURLConnection con = (HttpURLConnection) linkURL.openConnection();
    	con.setConnectTimeout(5000);
    	con.connect();
    	
    	if(con.getResponseCode()>=400) {
    		System.out.println("Link:"+ url + "is Broken");
    	}
    	else {
    		System.out.println("Link:"+ url + "is Fine");
    	}
    			
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
