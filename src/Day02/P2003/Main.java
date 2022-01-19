package Day02.P2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i]=Integer.parseInt(st.nextToken());
        }

        int startPoint=0, endPoint=0, sum=0, cnt=0;
        while(true){
            if(sum==M){
                cnt++;
                sum -= A[startPoint++];
            }
            else if(sum>M){
                sum -= A[startPoint++];
            }
            else{
                sum += A[++endPoint];
            }

            if (endPoint == N){
                break;
            }
        }
        System.out.println(cnt);
    }
}
