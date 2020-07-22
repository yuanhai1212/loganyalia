package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class Dataaccess extends BasePage {

    public Dataaccess(RemoteWebDriver driver) {
        super(driver);
    }
    public Dataaccess AccessStd() {

        return this;
    }

    public Dataaccess dataAccessFull() {
        return this;
    }

    public Dataaccess analysisTemplatelist() {
        return this;
    }

    public Dataaccess dictionaryManageList() {
        return this;
    }

    public Dataaccess CreateSensitiveWord(String name, String describe, String datarange,String sensitiveword,String datasource) throws Exception {
        driver.switchTo().frame(0);
        click(By.xpath("//a[contains(.,'脱敏规则')]"));
        click(By.cssSelector(".el-button:nth-child(1)"));
        sendKeys(By.cssSelector(".long > .el-input__inner"), name);
        sendKeys(By.cssSelector(".el-textarea__inner"), describe);
            if (datarange.equals("全局")) {
                click(By.cssSelector(".el-radio:nth-child(2) .el-radio__inner"));
                sendKeys(By.cssSelector(".el-form-item__content:nth-child(1) .el-input__inner"),sensitiveword);
            } else if (datarange.equals("指定数据流")) {
                click(By.cssSelector(".el-radio:nth-child(1) .el-radio__inner"));
                sendKeys(By.cssSelector(".el-select__input"),datasource);
                click(By.xpath("//li[39]/span"));
                sendKeys(By.cssSelector(".el-form-item__content:nth-child(1) .el-input__inner"),sensitiveword);
            } else {
               throw new Exception("datarange 请输入‘全局’或者‘指定数据流’");
            }
        click(By.cssSelector(".el-button--primary"));
        return this;
    }

    public Dataaccess deleteSensitiveWord(String name){
        int index=0;
//        driver.switchTo().frame(0);
        click(By.xpath("//a[contains(.,'脱敏规则')]"));
        List<WebElement> listname = driver.findElements(By.xpath("//tbody/tr/td/div/a"));
        for (WebElement a: listname) {
            index++;
            if(a.getText().equals(name)){
                click(By.xpath((String.format("(//a[contains(text(),'删除')])[%d]",index))));
                click(By.cssSelector(".el-button--primary"));
                return this;
            }
            System.out.println(a.getText());
        }
        return this;
    }
}
