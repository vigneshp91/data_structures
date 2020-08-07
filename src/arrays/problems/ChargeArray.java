package arrays.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ChargeArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            long[] A = new long[N];
            ArrayList<Long> input = new ArrayList<>();
            for (int i = 0; i < arr_A.length; i++) {
                input.add(Long.parseLong(arr_A[i]));
            }
//            for(int i_A=0; i_A<arr_A.length; i_A++)
//            {
//                A[i_A] = Long.parseLong(arr_A[i_A]);
//            }

            int out_ = solve(input,N);
            System.out.println(out_);
            System.out.println("");
        }

        wr.close();
        br.close();
    }
    static int solve(ArrayList<Long> A,int N){
        // Write your code here
        ArrayList<ArrayList<Long>> subsets = getSubSets(A);
        int totalCharge = 0;
        for (Long aLong : A) {
            int count = getSubSetPresentCount(aLong, subsets);
            if (aLong >= count) {
                totalCharge += aLong;
            }
        }
        return totalCharge;

    }

    private static int getSubSetPresentCount(Long a, ArrayList<ArrayList<Long>> subsets) {
        int count =0;
        for (ArrayList<Long> subset : subsets) {
            if (subset.contains(a)) {
                count += 1;
            }

        }
        return count;
    }

    private static ArrayList<ArrayList<Long>> getSubSets(ArrayList<Long> input) {
        ArrayList<ArrayList<Long>> result = new ArrayList<>();
        //String arr[] = new String[len*(len+1)/2];
        int totalCharge = 0;
        int count = 0;
        //This loop maintains the starting character
//        if(input.size()>2) {
//            ArrayList<Long> initial = new ArrayList<>();
//            initial.add(input.get(0));
//            initial.add(input.get(input.size() - 1));
//            result.add(initial);
//        }
        for(int i = 0; i < input.size(); i++) {
            //This loop adds the next character every iteration for the subset to form and add it to the array
            for(int j = i; j < input.size(); j++) {
                ArrayList<Long> subset = new ArrayList<>(input.subList(i, j + 1));
//                if (subset.contains(input.get(i))) {
//                    count += 1;
//                }
                result.add(subset);


            }
            if(i==input.size()-1 && input.size()>2){
                ArrayList<Long> initial = new ArrayList<>();
                initial.add(input.get(0));
                initial.add(input.get(i));
//                if (initial.contains(input.get(i))) {
//                    count += 1;
//                }
                result.add(initial);
            }
//            System.out.println("for "+input.get(i)+" the count is "+count);
//            count = 0;
//            if (subset.contains(a)) {
//                count += 1;
//            }
//            if (input.get(i) >= count) {
//                totalCharge += aLong;
//            }
        }
        return  result;

    }
}
