package exam.s0923_1_O;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] board = {
                            {0,0,0,0,0},
                            {0,0,1,0,3},
                            {0,2,5,0,1},
                            {4,2,4,4,2},
                            {3,5,1,3,1}
                        };

                        // 4,3,1,1,3,2,4;

        int[] moves = {1,5,3,5,1,2,1,4};
        int result = 4;

        int expect = sol.solution(board, moves);
        if(result == expect){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }


    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> result = new ArrayList<Integer>();

        for(int i = 0 ; i < moves.length; i++){
            for(int j = 0; j < board.length; j++){
                int row = j;
                int col = moves[i]-1;
                int block = board[row][col];
                
                if(block == 0){
                    continue;
                }else{
                    board[j][moves[i]-1] = 0;
                    result.add(block);

                    int end = result.size() - 1;

                    if(result.size() > 1){
                        if(result.get(end) == result.get(end - 1)){
                            result.remove(end);
                            result.remove(end-1);
                            answer +=2;
                        }
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
