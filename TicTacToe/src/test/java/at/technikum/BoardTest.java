package at.technikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.technikum.Board;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void clear_shouldEmptyAllCells() {
        board.place(1, 1, 'X');
        board.clear();
        assertTrue(board.isEmpty(1, 1));
    }

    @Test
    void clear_onAlreadyEmptyBoard_shouldStillBeEmpty() {
        board.clear();
        assertTrue(board.isEmpty(0, 0));
    }

    @Test
    void isEmpty_shouldReturnTrueForNewCell() {
        assertTrue(board.isEmpty(0, 0));
    }

    @Test
    void isEmpty_shouldReturnFalseAfterPlacingMarker() {
        board.place(2, 2, 'X');
        assertFalse(board.isEmpty(2, 2));
    }

    @Test
    void place_shouldSetMarkerCorrectly() {
        board.place(0, 1, 'O');
        assertFalse(board.isEmpty(0, 1));
    }

    @Test
    void place_shouldOverwriteMarker() {
        board.place(1, 0, 'X');
        board.place(1, 0, 'O');
        assertFalse(board.isEmpty(1, 0));
    }

    @Test
    void isFull_shouldReturnTrueWhenAllCellsAreFilled() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board.place(i, j, 'X');
        assertTrue(board.isFull());
    }

    @Test
    void isFull_shouldReturnFalseWhenOneCellEmpty() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (!(i == 2 && j == 2))
                    board.place(i, j, 'X');
        assertFalse(board.isFull());
    }

    @Test
    void hasWinner_shouldDetectHorizontalWin() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(board.hasWinner());
    }

    @Test
    void hasWinner_shouldReturnFalseWithoutWinningCombination() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        assertFalse(board.hasWinner());
    }

    @Test
    void print_shouldNotThrowErrorOnEmptyBoard() {
        assertDoesNotThrow(() -> board.print());
    }

    @Test
    void print_shouldNotThrowErrorAfterMoves() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        assertDoesNotThrow(() -> board.print());
    }
}
