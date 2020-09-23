package exam.s0923;

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
        Stack<Integer> stack = new Stack<Integer>();
        int answer = 0;

        for(int i = 0 ; i < moves.length; i++){
            for(int j = 0; j < board.length; j++){
                int temp = board[j][moves[i]];
                if(temp == 0){
                    continue;
                }else{
                    board[j][moves[i]] = 0;
                    stack.add(temp);
                    break;
                }
            }
        }
        
        return answer;
    }
}
