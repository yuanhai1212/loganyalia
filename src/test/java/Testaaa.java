import Page.MainPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import util.Get_Cookie;


import static java.lang.Thread.sleep;
@TestMethodOrder(OrderAnnotation.class)
public class Testaaa {
    static MainPage main ;

//    @Test
//    void get_cookie() throws InterruptedException {
//        Get_Cookie get_cookie=new Get_Cookie();
//        get_cookie.saveCookie();
//    }

    @BeforeAll
    static void beforeAll(){
        main=new MainPage();
    }


//    @Test
//    @Order(1)
//    void testa() throws Exception {
//        main.toDataaccess().CreateSensitiveWord("bb","bbbb","指定数据流","@id","aaa").deleteSensitiveWord("bb");
//    }

//    @Test
//    @Order(2)
//    void test() throws InterruptedException {
//        main.toDataaccess().deleteSensitiveWord("bb");
//    }
    @Test
    void testcreate() throws InterruptedException {
        main.toCollectionPage().CreateSign("1");
    }
    @Test
    void test(){
        main.toSpacePage().getspaceName("全局");
    }
    @AfterAll
    static void afterAll() throws InterruptedException {
        sleep(15000);
        main.quit();
    }

}
