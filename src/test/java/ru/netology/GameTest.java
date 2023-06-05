package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Player artem = new Player(1, "Артем", 75);
        Player anton = new Player(2, "Антон", 100);
        Game game = new Game();

        game.register(artem);
        game.register(anton);
        int actual = game.round("Антон", "Артем");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player artem = new Player(1, "Артем", 75);
        Player anton = new Player(2, "Антон", 50);
        Game game = new Game();

        game.register(artem);
        game.register(anton);
        int actual = game.round("Антон", "Артем");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDraw() {
        Player artem = new Player(1, "Артем", 75);
        Player anton = new Player(2, "Антон", 75);
        Game game = new Game();

        game.register(artem);
        game.register(anton);
        int actual = game.round("Антон", "Артем");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenNotRegisteredFirstPlayer() {
        Game game = new Game();
        Player artem = new Player(1, "Артем", 75);
        Player anton = new Player(2, "Антон", 50);

        game.register(artem);
        game.register(anton);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> {
                    game.round("Андрей", "Антон");
                });
    }

    @Test
    public void testWhenNotRegisteredSecondPlayer() {
        Game game = new Game();
        Player artem = new Player(1, "Артем", 75);
        Player anton = new Player(2, "Антон", 50);
        game.register(artem);
        game.register(anton);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Артем", "Арсений")
        );
    }

    @Test
    public void testWhenNotRegisteredTwoPlayers() {
        Game game = new Game();
        Player artem = new Player(1, "Артем", 75);
        Player anton = new Player(2, "Антон", 50);
        game.register(artem);
        game.register(anton);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Андрей", "Арсений")
        );
    }
}