package Day01.P3055;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 위치 class / x좌표, y좌표
class Point {
    int y, x; // y가 R(행) / x가 C(열)
    char type;
    public Point(int y, int x, char type) {
        super();
        this.y = y;
        this.x = x;
        this.type=type;
    }

    @Override
    public String toString() { return "[y=" + y + ", x=" + x + ", type=" +type+"]"; }
}

public class Main {
    static final String FAIL = "KAKTUS";    // 실패시 출력 문구
    static int R, C;                            // 지도 크기 R : 행, C : 열
    static int time;                        // 최종 걸린 시간 (답)
    static char[][] map;                    // 지도정보
    static int[] MY = {-1, 1, 0, 0};            // direction Row    행 이동 방향
    static int[] MX = {0, 0, -1, 1};            // direction Column 열 이동 방향

    static int[][] visit;          // visit 확인 지도
    static Queue<Point> queue; // 위치 BFS용 queue
    static boolean foundAnswer;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Day01/P3055/input.txt"));
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        visit = new int[R][C];
        queue = new LinkedList<>();

        Point st = null;

        for (int r = 0; r < R; r++) {
            String line = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if(map[r][c] == 'S'){
                    st = new Point(r,c,'S');
                }else if(map[r][c] =='*'){
                    queue.add(new Point(r,c,'*'));
                }
            }
        }
        queue.add(st);

        while (!queue.isEmpty()) {
            //1.큐에서 꺼내옴 -> S, ., D, *,
            Point p = queue.poll();
            //2.목적지인가? -> D
            if(p.type=='D'){
                System.out.println(visit[p.y][p.x]);
                foundAnswer=true;
                break;
            }
            //3.연결된 곳을 순회 -> 좌, 우, 위, 아래
            for (int i = 0; i < 4; i++) {
                int ty=p.y+MY[i];
                int tx=p.x+MX[i];
                //4.갈수있는가? ( 고슴도치 ) -> 맵을 벗어나지 않고, . or D, 방문하지 않은 곳
                //4.갈수있는가? ( 물 ) -> 맵을 벗어나지 않고, .
                if(0<=ty && ty<R && 0<=tx && tx<C){
                    if(p.type== '.' || p.type=='S'){
                        //4.갈수있는가? ( 고슴도치 ) -> . or D, 방문하지 않은 곳
                        if((map[ty][tx] == '.' || map[ty][tx]=='D') && visit[ty][tx]==0) {
                            //5.체크인 -> visit에 현재 + 1을 기록
                            visit[ty][tx] = visit[p.y][p.x] + 1;
                            //6.큐에 넣음
                            queue.add(new Point(ty, tx, map[ty][tx]));
                        }
                    }else if(p.type=='*'){
                        //4.갈수있는가? ( 물 ) ->  .
                        if(map[ty][tx]=='.' || map[ty][tx]=='S'){
                            //5.체크인 -> 지도에 * 표기
                            map[ty][tx] = '*';
                            //6.큐에 넣음
                            queue.add(new Point(ty,tx,'*'));
                        }

                    }
                }
            }
        }

        if(foundAnswer==false){
            System.out.println("KAKTUS");
        }
    }

}