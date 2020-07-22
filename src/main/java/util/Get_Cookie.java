package util;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

import static java.lang.Thread.sleep;

public class Get_Cookie {
    WebDriver webDriver;

//    public void initCookie() throws InterruptedException {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
//        webDriver = new ChromeDriver(chromeOptions);
//        saveCookie(webDriver);
//        webDriver.get("http://192.168.21.46:9090/logAnalysis/overview");
//        takecookie(webDriver);
//        webDriver.get("http://192.168.21.46:9090/logAnalysis/overview");
//    }

    public void takecookie(WebDriver webDriver){
        try {
            FileReader reader = new FileReader("cookie.txt");
            BufferedReader bufferedReader=new BufferedReader(reader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                StringTokenizer tokenizer = new StringTokenizer(line,";");
                String Path=tokenizer.nextToken();
                String Value=tokenizer.nextToken();
                String Name=tokenizer.nextToken();
                Date Expiry=null;
                String date=tokenizer.nextToken();
                if(!date.equals("null")){
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    Expiry=simpleDateFormat.parse(date);
                }
                String Domain=tokenizer.nextToken();
                Boolean isSecure=Boolean.getBoolean(tokenizer.nextToken());
                Cookie cookie =new Cookie(Name,Value,Domain,Path,Expiry,isSecure);
                webDriver.manage().addCookie(cookie);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void saveCookie() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        ChromeDriver webDriver = new ChromeDriver(chromeOptions);
        sleep(50000);
        try {
            FileWriter fileWriter = new FileWriter("cookie.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cookie cookie : webDriver.manage().getCookies()) {
                bufferedWriter.write(
                            cookie.getPath() + ";" +
                                cookie.getValue() + ";" +
                                cookie.getName() + ";" +
                                cookie.getExpiry() + ";" +
                                cookie.getDomain() + ";" +
                                cookie.isSecure()
                );
                bufferedWriter.newLine();

            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
