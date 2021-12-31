import java.awt.*;
import java.util.ArrayList;

public class QueenPuzzleSolver {


    ArrayList<Tile[][]> seq = new ArrayList<>();
    public static void main(String[] args) {
        int x = 4;
        int y = 4;

        for (int i = 0; i < 8; i++)
        {
            Tile [][] board = newBoard(0);
            solve(board,0,0);
        }
    }



    public static void printBoard(Tile[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].isQueen)
                {
                    System.out.print("Q ");
                }
                else if (board[i][j].isDangerZone())
                {
                    System.out.print("| ");
                }
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static Tile[][] newBoard(int location)
    {
        Tile[][] board= new Tile[8][8];
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j] = new Tile(false,false);
            }
        }
        return board;
    }

    public static boolean addQueen(Tile[][] board,int x,int y )
    {
        if (board[y][x].placeable())
        {
            board[y][x].setQueen(true);
            return true;
        }

        return false;
    }
    public static Point nextPlaceable(Tile[][]board,int x,int y)
    {
        for (int i = y; i < board.length; i++)
        {
            for (int j = x; j < board[i].length; j++)
            {
                if (board[i][j].placeable())
                {
                    return new Point(j,i);
                }

            }
            x= 0;
        }
        return null;
    }

    public static void setDangerZone(Tile[][]board,int x, int y)
    {
        int min = Math.min(x,y);
        int s = y;
        for (int i = 0; i < board.length; i++) //i is the y value
        {

            for (int j = 0; j < board[i].length; j++) // is x value
            {

                //columns
                if (i == y)
                {
                    board[i][j].setDangerZone(true);
                }

                //rows
                if (j == x)
                {
                    board[i][j].setDangerZone(true);
                }

                //odd diag
                if (i == j)
                {
                    int valX = x-min+i;
                    int valY = y-min+j;
                    if (valX < 8 && valY < 8)
                    {
                        board[valY][valX].setDangerZone(true);
                    }
                }
            }
            int valX = x+s-i;
            int valY = i;
            if (valX < 8 && valX >= 0 && valY < 8)
            {
                board[valY][valX].setDangerZone(true);
            }
        }

    }

    public static void solve(Tile[][] board,int x,int y)
    {

    }



}
