package Project1;

import java.util.Set;
import java.util.Iterator;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NeutrionsForgotCancle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://goneutrinos.com/");
		driver.findElement(By.linkText("Login")).click();
		//Move to the next window
		String parent = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();	
		Iterator <String> I1 = s1.iterator();
		while(I1.hasNext()) {
			String child = I1.next();
			
			if(!parent.equals(child)) {
				driver.switchTo().window(child);
				}
			System.out.println(driver.switchTo().window(child).getTitle());
			
		}
		
		Thread.sleep(2000);
		//Enter the username
		driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("Nandini");
		//Clcik on Forget password 
		driver.findElement(By.id("forgot-pwd")).click();
		//Enter the username
		driver.findElement(By.id("forgotPasswordEmail")).sendKeys("Nandini");
		//Click on cancel
		driver.findElement(By.linkText("Cancel")).click();
		//driver.switchTo().defaultContent();
	}}