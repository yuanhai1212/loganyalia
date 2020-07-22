package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SpacePage extends BasePage{
    public SpacePage(RemoteWebDriver driver) {
        super(driver);
    }

    public SpacePage getspaceName(String name){
        click(By.xpath("//span[contains(.,"+name+")]"));
        return this;
    }
}
