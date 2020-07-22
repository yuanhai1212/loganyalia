package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import static java.lang.Thread.sleep;

public class CollectionPage extends BasePage{
    public CollectionPage(RemoteWebDriver driver) {
        super(driver);
    }

    public CollectionPage CreateSign(String name) throws InterruptedException {
        driver.switchTo().frame(0);
        click(By.linkText("标签管理"));
        for (Integer i = 0; i <84 ; i++) {
            click(By.cssSelector(".is-required .el-input__inner"));
            sendKeys(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div/form/div[1]/div/div/input"),i.toString());
            click(By.cssSelector(".el-button"));
            sleep(1000);
        }

        return this;
    }
}
