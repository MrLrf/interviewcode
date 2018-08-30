package pinduoduo;

import java.util.Scanner;

/**
 * Created by lirf on 2018/8/30.
 */
public class ChessBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        char[][] chessBoard = new char[N][M];
        for (int i = 0; i < N; i++) {
            String ss = sc.nextLine();
            char[] temp = ss.toCharArray();
            for (int j = 0; j < temp.length; j++) {
                chessBoard[i][j] = temp[j];
            }
        }

        for(int i = N - 1; i >= 0; i--){
            for (int j = 0; j < M; j++){
                if (chessBoard[i][j] == 'x' || chessBoard[i][j] == '.'){
                    continue;
                }else {
                    int tmp = i + 1;
                    while(tmp < N - 1 && chessBoard[tmp][j] == '.'){
                        chessBoard[tmp - 1][j] = '.';
                        chessBoard[tmp++][j] = 'o';
                    }
                    if (tmp == N - 1){
                        if(chessBoard[tmp][j] == '.' && chessBoard[tmp - 1][j] == 'o') {
                            chessBoard[tmp - 1][j] = '.';
                        }
                        if(chessBoard[tmp][j] == 'o')
                            chessBoard[tmp][j] ='.';
                    }
                }
                if(chessBoard[N - 1][j] == 'o'){
                    chessBoard[N - 1][j] = '.';
                }
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                System.out.print(chessBoard[i][j]);
            }
            System.out.print('\n');
        }
    }
}