package at.technikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void constructor_shouldSetMarkerToX() {
        at.technikum.Player player = new at.technikum.Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    void constructor_shouldSetMarkerToO() {
        at.technikum.Player player = new at.technikum.Player('O');
        assertEquals('O', player.getMarker());
    }

    @Test
    void getMarker_shouldReturnX() {
        at.technikum.Player player = new at.technikum.Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    void getMarker_shouldReturnO() {
        at.technikum.Player player = new at.technikum.Player('O');
        assertEquals('O', player.getMarker());
    }
}
