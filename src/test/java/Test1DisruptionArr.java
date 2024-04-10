import java.util.Arrays;
import java.util.Random;
/**
 * @author ax
 * @description 一维数组打乱后赋值给二维数组的练习
 * @date 2024/4/9 下午4:54
 */
public class Test1DisruptionArr {
    public static void main(String[] args) {
        int[] tempArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        Random rd = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = rd.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        int[][] arr = new int[4][4];
        for (int i = 0; i < tempArr.length; i++) {
            arr[i / 4][i % 4] = tempArr[i];
        }
        System.out.println(Arrays.deepToString(arr));
    }
}

