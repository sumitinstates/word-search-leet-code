package com.sumit;

public class Solution {
	
    public boolean exist(char[][] board, String word) 
    {
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0) && wordSearch(board, word, 0, i, j))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean wordSearch(char[][] board, String word, int count, int i, int j)
    {
            
            if(count == word.length())
            {
                return true;
            }
            
            if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]!=word.charAt(count)){
                return false;
            }
            
            char temp = board[i][j];
            board[i][j] = ' ';
            
            boolean found = (wordSearch(board,word,count+1,i+1,j) || wordSearch(board,word,count+1,i-1,j) ||
            wordSearch(board,word,count+1,i,j+1) || wordSearch(board,word,count+1,i,j-1));
            
            board[i][j] = temp;
            return found;
     }

}
