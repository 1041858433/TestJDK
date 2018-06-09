import java.util.ArrayList;
import java.util.List;

/**
 * @author DingYin
 * 2018/4/11 17:25
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        try{
            int i;
            i =0/0;
        }
        catch (Exception e){
            System.out.print("eeeeeeee");
            e.printStackTrace();
        }
        System.out.print("xxxxx");
    }

}
