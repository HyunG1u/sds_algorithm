package Practice.P1854;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {
    static class info implements Comparable<info>{
        int node;
        int distance;

        public info(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(info o){ return Integer.compare(distance,o.distance); }
    }
    static int N,M,K;
    static ArrayList<info>[] Map;
    static PriorityQueue<Integer>[] Distance;

    public static void main(String[] args) throws Exception{
        StringTokenizer st;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        Map=new ArrayList[N+1];
        Distance=new PriorityQueue[N+1];
        for (int i = 1; i <= N; i++) {
            Map[i]=new ArrayList<>();
            Distance[i]=new PriorityQueue<>(Collections.reverseOrder());
        }

        int a,b,c;
        for (int i = 1; i <= M; i++) {
            st=new StringTokenizer(st.nextToken());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());

            Map[a].add(new info(b,c));
        }

        dijkstra(1);

        for (int i = 1; i <= N; i++) {
            if(Distance[i].size()==K){
                bw.write(Distance[i].peek()+"\n");
            }else{
                bw.write("-1"+"\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void dijkstra(int start){
        PriorityQueue<info> pq=new PriorityQueue<>();
        Distance[start].add(0);
        pq.add(new info(start,0));

        while (pq.isEmpty() == false) {
            info now=pq.poll();

            if (now.distance > Distance[now.node].peek()) {
                continue;
            }

            for(info next: Map[now.node]){
                if(Distance[next.node])
            }

        }
    }
}
