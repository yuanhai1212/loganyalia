import org.openqa.selenium.json.JsonOutput;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class es {
    public static String getPipelineName(Long mdId) {
        return String.format("eoi_itoa_dragonfly_%s", mdId);
    }

    public static  String getIndexName(Long mdId) {
        return String.format(".eoi-dragonfly_%s", mdId);
    }
    public static void main(String[] args) {
        int [] a ={22,11,31,987};
        String b="";
        for (int i = 0; i <a.length ; i++) {
            b+=a[i];
        }
        List list=new ArrayList();


        System.out.println();


    }


}
