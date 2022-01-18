package Day01.P1759;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Password {
    static int L,C;
    static char data[];
    static List<String> result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Day01/P1759/input.txt"));
        Scanner sc = new Scanner(System.in);

        L=sc.nextInt();
        C=sc.nextInt();
        data=new char[C];
        result = new LinkedList<>();

        for(int i=0;i<C;i++){
            data[i]=sc.next().charAt(0);
        }

        Arrays.sort(data);


        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }

        dfs(0,0,0,-1,"");
        for(int i=0;i< result.size();i++){
            System.out.println(result.get(i));
        }

    }
    static void dfs(int length, int ja, int mo, int current, String pwd){
        //1.체크인 - 생략가능(sort)
        //2.목적지인가 - 길이 + 자음,모음 개수
        if(length == L){
            if(ja>=2 && mo >=1){
                result.add(pwd);
            }
        }

        else{
            //3.연결된 곳을 순회 - 나보다 높은 알파벳
            for (int nextIndex = current + 1; nextIndex < data.length; nextIndex++) {
                char nextData = data[nextIndex];
                //4.갈 수 있는가 - 생략 가능
                if(nextData=='a'||nextData=='e' ||nextData=='i'||nextData=='o'||nextData=='u') {//모음
                    //5.간다 - dfs(nextData) -> 모음
                    dfs(length+1,ja,mo+1,nextIndex,pwd+nextData);
                }else{
                    //5.간다 - dfs(nextData) -> 자음
                    dfs(length+1,ja+1,mo,nextIndex,pwd+nextData);
                }
            }
        }
        //6.체크아웃 - 생략가능

    }
}
