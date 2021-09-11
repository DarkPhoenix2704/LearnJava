package tictactoe;
import java.util.Scanner;
public class TicTacToe {
    private static int empty;
    private static boolean finished = false;
    private static boolean xNext = true;
    public static void main(String[] args) {

        char[][] ticTac = new char[3][3];
        for(char[] row : ticTac){
            for (int i = 0; i < 3; i++){
                row[i] = '_';
            }
        }
        TicTacToe.printGame(ticTac);
        while(!finished){
            Coordinates cord = getCoordinates(ticTac);
            if (xNext){
                ticTac[cord.getY()][cord.getX()] = 'X';
                xNext = false;
            }else {
                ticTac[cord.getY()][cord.getX()] = 'O';
                xNext = true;
            }
            TicTacToe.printGame(ticTac);
            if (isXWins(ticTac)){
                System.out.print("X wins");
                finished = true;
                return;
            }
            if (isOWins(ticTac)){
                System.out.print("O wins");
                finished = true;
                return;
            }
            if (isDraw()){
                System.out.print("Draw");
                finished = true;
                return;
            }
        }
    }

    private static boolean isDraw() {
        return empty == 0;
    }
    private static Coordinates getCoordinates(char[][] ticTac){
        System.out.println("Enter the coordinates:");
        Scanner scanner = new Scanner(System.in);
        int y =  scanner.nextInt();
        int x = scanner.nextInt();
        if (x > 3 || x < 1 || y < 1 || y > 3){
            System.out.println("Coordinates should be from 1 to 3!");
            return getCoordinates(ticTac);
        } else if (ticTac[y-1][x-1] != '_'){
            System.out.println("This cell is occupied! Choose another one!");
            return getCoordinates(ticTac);
        }
        return new Coordinates(y - 1, x - 1);
    }

    public static void printGame(char[][] ticTac){
        empty = 0;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + ticTac[i][j]);
                if(ticTac[i][j] == '_'){
                    empty++;
                }
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    public static boolean isOWins(char[][] mat){
        final char o = 'O';
        return checkRepeat(mat, o);

    }

    public static boolean isXWins(char[][] mat){
        final char x = 'X';
        return checkRepeat(mat, x);

    }
    private static boolean checkRepeat(char[][] mat, char ch) {
        return mat[0][0] == mat[0][1] && mat[0][0] == mat[0][2] && mat[0][0] == ch ||
                mat[1][0] == mat[1][1] && mat[1][0] == mat[1][2] && mat[1][0] == ch ||
                mat[2][0] == mat[2][1] && mat[2][0] == mat[2][2] && mat[2][0] == ch ||
                mat[0][0] == mat[1][0] && mat[0][0] == mat[2][0] && mat[0][0] == ch ||
                mat[0][1] == mat[1][1] && mat[0][1] == mat[2][1] && mat[0][1] == ch ||
                mat[0][2] == mat[1][2] && mat[0][2] == mat[2][2] && mat[0][2] == ch ||
                mat[0][0] == mat[1][1] && mat[0][0] == mat[2][2] && mat[0][0] == ch ||
                mat[0][2] == mat[1][1] && mat[0][2] == mat[2][0] && mat[0][2] == ch;
    }
}
class Coordinates{
    private final int x;
    private final int y;
    public Coordinates(int _y, int _x){
        this.x = _x;
        this.y = _y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}