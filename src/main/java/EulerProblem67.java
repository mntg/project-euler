import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by Mike on 2014-07-02.
 */
public class EulerProblem67 {

    public static void main(String[] args) {
        EulerProblem67 e = new EulerProblem67();
        e.run();
    }

    public void run() {
        System.out.println(getLengthOfMaxPath(101,"C:\\Users\\Mike\\Code\\project-euler\\files\\triangle.txt"));
    }

    public int getLengthOfMaxPath(int height,String path) {
        HashMap<Integer,int[]> triangle = parseTriangle(path);
        HashMap<Integer,int[]> longestSubPaths = new HashMap<Integer, int[]>();
        int[] first = new int[1];
        first[0] = 0;
        longestSubPaths.put(1,first);
        //System.out.println(triangle.get(2)[1]);
        for (int i = 2; i <= height; i++) {
            int[] subPath = longestSubPaths.get(i-1);
            //System.out.println(Arrays.toString(subPath));
            int[] level = triangle.get(i-1);
            int[] nextSubPathLevel = new int[i];
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    nextSubPathLevel[j] = level[0] + subPath[0];
                } else if (j == i - 1) {
                    //System.out.println(level[level.length - 1]);
                    //System.out.println(subPath[subPath.length - 1]);
                    nextSubPathLevel[j] = level[level.length - 1] + subPath[subPath.length - 1];
                } else if (level[j - 1] + subPath[j - 1] > level[j] + subPath[j]) {
                    nextSubPathLevel[j] = level[j - 1] + subPath[j - 1];
                } else {
                    nextSubPathLevel[j] = level[j] + subPath[j];
                }
            }
            longestSubPaths.put(i,nextSubPathLevel);
        }
        return(Collections.max(Arrays.asList(ArrayUtils.toObject(longestSubPaths.get(height)))));
    }

    public HashMap<Integer,int[]> parseTriangle(String path) {
        HashMap<Integer,int[]> triangle = new HashMap<Integer,int[]>();
        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                count++;
                String[] temp = line.split(" ");
                int[] level = new int[count];
                for (int i = 0; i < temp.length; i++) {
                    level[i] = Integer.parseInt(temp[i]);
                }
                triangle.put(count,level);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        int[] testArray = triangle.get(5);
        for (int i = 0; i < testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
        */
        return triangle;
    }
}
