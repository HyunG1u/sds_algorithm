package Day02.P1806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,S;
    static int[] nums;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int startPoint=0, endPoint=0, sum=0, len=100001;
        while(true){
            if(sum>=S){
                len=Math.min(len,(endPoint-startPoint));
                sum -= nums[startPoint++];
            }else if(endPoint==N){
                break;
            }else{
                sum += nums[endPoint++];
            }

        }
        if(len==100001) System.out.println("0");
        else System.out.println(len);
    }
}
