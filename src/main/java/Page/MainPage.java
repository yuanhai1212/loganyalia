package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Get_Cookie;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class MainPage extends BasePage {
    public MainPage() {
        super();
        driver.get("http://192.168.21.46:9090/logAnalysis/overview");
        sendKeys(By.xpath("//*[@placeholder='请输入账号']"),"yh");
        sendKeys(By.cssSelector("[placeholder='请输入密码']"),"12qw#$ER5");
        click(By.xpath("//*[@type='submit']"));
        click(By.xpath("//*[text()='日志精析中心']"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public Dataaccess toDataaccess () throws InterruptedException {
        //tudo：
        click(By.cssSelector("li:nth-child(1) .title"));
        return new Dataaccess(driver);
    }

    public SpacePage toSpacePage(){
        return  new SpacePage(driver);
    }

    public CollectionPage toCollectionPage(){
        click(By.cssSelector("li:nth-child(2) .title"));
        click(By.linkText("采集器管理"));
        return  new CollectionPage(driver);
    }
}
