package at.technikum;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void switchCurrentPlayer_shouldChangeFromPlayer1ToPlayer2() throws Exception {
        at.technikum.TicTacToe game = new at.technikum.TicTacToe();
        char before = getCurrentPlayerMarker(game);
        game.switchCurrentPlayer();
        char after = getCurrentPlayerMarker(game);
        assertNotEquals(before, after);
    }

    @Test
    void switchCurrentPlayer_shouldToggleBackToPlayer1() throws Exception {
        at.technikum.TicTacToe game = new at.technikum.TicTacToe();
        char original = getCurrentPlayerMarker(game);
        game.switchCurrentPlayer();
        game.switchCurrentPlayer();
        char back = getCurrentPlayerMarker(game);
        assertEquals(original, back);
    }

    // 🔍 Hilfsmethode mit Reflection
    private char getCurrentPlayerMarker(at.technikum.TicTacToe game) throws Exception {
        Field field = at.technikum.TicTacToe.class.getDeclaredField("currentPlayer");
        field.setAccessible(true);
        at.technikum.Player current = (at.technikum.Player) field.get(game);
        return current.getMarker();
    }
}
