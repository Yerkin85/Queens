package yerkin.com;
import java.sql.SQLException;
import java.util.Scanner;


public class Queens {
    final static int[] board = new int[8];

    public static void main(String[] args) throws SQLException {
        solution();
    }
    public static void solution () throws SQLException {
        int row = 0;
        board[0] = -1;
        System.out.println("Укажите позицию первого ферзя от 0 до 7");
        Scanner sc = new Scanner(System.in);
        int value = 0;
        boolean exe = false;
        while(!exe) {
            try {
                value = Integer.parseInt(sc.next());
                if (value < 8) {
                    System.out.println("Позиция 8 ферзей:");
                    exe = true;
                } else {
                    System.out.println("Укажите номер позиции первого ферзя от 0 до 7");
                }
            } catch (NumberFormatException e) {
                System.out.println("Не правильный ввод данных");
                System.out.println("Укажите позицию первого ферзя");
            }
        }
        while (row >= 0) {
            do {
                board[row]++;
            } while ((board[row] < 8) && unsafe(row));
            if (board[row] < 8) {
                if (row < 7) {
                    board[++row] = -1;
                } else if(board[row]==value){
                    displayBoard();
                }
            } else {
                row--;
            }
        }
    }
    public static boolean unsafe(int row) {
        int column = board[row];
        for (int i = 1; i <= row; i++) {
            int temp = board[row - i];
            if (temp == column || temp == column - i || temp == column + i) {
                return true;
            }
        }
        return false;
    }
    public static void displayBoard() {
        System.out.println(" ----------------------");
        System.out.print(" 0|" + " 1|" + " 2|" + " 3|" + " 4|" + " 5|" + " 6|" + " 7|" + "\n");

        for (int value : board) {
            System.out.print(" " + value + "|");
        }
        System.out.println("\n");

        for (int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i]==j) {
                    System.out.print(" Q ");
                }
                else System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println(" ----------------------");
    }
}
