import org.junit.Assert;
import ru.smirnov.Main;

public class Test {
    @org.junit.Test
    public void testSortArray(){
        int[] array = {2,54,7,2,6,96,6,4,9,0,1,4,54};
        int[] sortArray = {0,1,2,2,4,4,6,6,7,9,54,54,96};
        Assert.assertArrayEquals(sortArray, Main.sortArray(array));
    }
}
