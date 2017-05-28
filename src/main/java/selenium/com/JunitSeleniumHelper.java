package selenium.com;

/**
 * Created by aloni on 27/05/17.
 */
public class JunitSeleniumHelper extends WebDriversImpl {

    public long calcTime(long start){
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        return totalTime;
    }
}
