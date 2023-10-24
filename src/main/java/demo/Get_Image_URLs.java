package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class Get_Image_URLs{
    ChromeDriver driver;

    public Get_Image_URLs(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void  testCase01(){
//        Navigate to URL  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
//        Get the count of all the links present on the page Using Locator "XPath" //a[@href]
        List <WebElement> linksPresent = driver.findElements(By.xpath("//a[@href]"));

//        Print the count  print size()
        System.out.println("Count of the Links on the page : " + linksPresent.size());
//        Print the URL's  by iteratting through list
        for (WebElement link : linksPresent)
        {
            System.out.println("URL : " + link.getAttribute("href"));
        }
//        Print the 1 and 2nd movie names from Premieres Using Locator "XPath" //h2[text() = 'Premieres']/ancestor :: div[contains(@class, 'dOuCBq')]/div/div/div[contains(@class, 'dDgeSF')]/a/div/div/h3 | iterate and print 1 and 2nd movie name
        List <WebElement> premieres = driver.findElements(By.xpath("//h2[text() = 'Premieres']/ancestor :: div[contains(@class, 'dOuCBq')]/div/div/div[contains(@class, 'dDgeSF')]/a/div/div/h3"));
        int count = 1;
        for (WebElement premiere : premieres){
            if(count < 3){
                System.out.println("premiere : "+ premiere.getText());
                count++;
            }
        }
    }
}