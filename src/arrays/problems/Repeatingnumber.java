package arrays.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Repeatingnumber {

    public static void main(String[] args) {
//          Sample code to perform I/O:
//         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrsize = 0;                // Reading input from STDIN
        try {
            arrsize = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Hi, " + arrsize + ".");    // Writing output to STDOUT

//        //Scanner
        //Scanner s = new Scanner(System.in);
//        String name1 = s.nextLine();                 // Reading input from STDIN
//        System.out.println("Hi, " + name1 + ".");    // Writing output to STDOUT
        try {
            String test = br.readLine();
            String[] testarr= test.split(" ");
            HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();

            for (int i = 0; i < testarr.length; i++) {
                int number = Integer.parseInt(testarr[i]);
                if(!frequency.containsKey(number)){
                    frequency.put(number,1);
                }else {
                    int count = frequency.get(number);
                    frequency.put(number,count+1);
                }
            }

            int largeVal = 0;
            int largeKey = 0;
            for (Map.Entry<Integer,Integer> entry : frequency.entrySet()){
                if(largeVal<=entry.getValue()){
                    largeVal = entry.getValue();
                    largeKey = entry.getKey();
                }
            }
            System.out.println(largeKey);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
