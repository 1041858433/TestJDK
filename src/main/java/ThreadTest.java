/**
 * @author DingYin
 * 2018/4/6 16:37
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        ThreadA a = new ThreadA(lock);
        a.start();

        //NotifyThread notifyThread = new NotifyThread(lock);
        // notifyThread.start();

        SynNotifyMethodThread c = new SynNotifyMethodThread(lock);
        c.start();
    }
}
