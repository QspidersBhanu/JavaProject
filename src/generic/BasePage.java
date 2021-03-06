package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	public void wait(int i) {
		try {
			Thread.sleep(i*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void verifyPageIsDisplayed(WebDriver driver,String eResult) {
		String sETO = AutoUtil.getProperty(IAutoConst.CONFIG_PATH,"ETO");
		long ETO=Long.parseLong(sETO);
		WebDriverWait wait=new WebDriverWait(driver,ETO);
		try {
			wait.until(ExpectedConditions.titleIs(eResult));
			Reporter.log("PASS:Expected Page is Displayed",true);
		}
		catch (Exception e) {
			Reporter.log("FAIL:Expected Page is NOT Displayed",true);
			Assert.fail();
		}
	}
	
	public void verifyText(WebElement e,String eText) {
		String aText=e.getText();
		Assert.assertEquals(aText, eText);
	}
}











