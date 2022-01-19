package Day02.P2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long m;
    static int[] tree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int min=0,max=0;
        tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i]=Integer.parseInt(st.nextToken());

            if(max<tree[i]){
                max=tree[i];
            }
        }
        while(min<max){
            int mid=(min+max)/2;
            long sum=0;
            for(int length: tree){
                if(length-mid>0){
                    sum += length-mid;
                }
            }
            if(sum<m){
                max=mid;
            }
            else{
                min=mid+1;
            }
        }
        System.out.println(min-1);
    }
}
