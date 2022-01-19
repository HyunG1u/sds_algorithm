package Day02.P2143;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static long T;
    static int n;
    static int[] A;
    static int m;
    static int[] B;
    static List<Integer> listA = new ArrayList<>();
    static List<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        A=new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        B=new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i]=Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                listA.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                listB.add(sum);
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        int pa=0, pb=listB.size()-1;
        long cnt=0;

        while(pa< listA.size() && pb >=0){
            long sum = listA.get(pa) + listB.get(pb);

            if (sum==T){
                int aCnt=0, bCnt=0;
                int aTmp = listA.get(pa);
                int bTmp = listB.get(pb);

                while(pa<listA.size() && listA.get(pa)==aTmp){
                    aCnt++;
                    pa++;
                }
                while(pb>=0 && listB.get(pb)==bTmp){
                    bCnt++;
                    pb--;
                }
                cnt += aCnt*bCnt;
            }
            else if(sum<T){
                pa++;
            }
            else{
                pb--;
            }
        }
        System.out.println(cnt);
    }
}
