package main.java.at.technikum;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        board.clear();

        while (true) {
            System.out.println("Current Player: " + currentPlayer.getMarker());
            board.print();

            int row, col;
            do {
                System.out.print("row (0-2): ");
                row = scanner.nextInt();
                System.out.print("column (0-2): ");
                col = scanner.nextInt();
            } while (!isValidMove(row, col));

            board.place(row, col, currentPlayer.getMarker());

            if (board.hasWinner()) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                break;
            }

            if (board.isFull()) {
                board.print();
                System.out.println("Draw!");
                break;
            }

            switchCurrentPlayer();
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board.isEmpty(row, col);
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public static void main(String[] args) {
        new TicTacToe().start();
    }
}
