package com.metlife.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void 모두_1_점인_경기() {
        rollMany(20, 1);
        Assertions.assertEquals(20, game.score());
    }

    @Test
    void 스페어_경기() {
        spare();
        game.roll(5);
        rollMany(17, 0);
        Assertions.assertEquals(20, game.score());
    }

    @Test
    void 스트라이크_경기() {
        game.roll(10);
        game.roll(2);
        game.roll(4);
        rollMany(18, 0);
        Assertions.assertEquals(22, game.score());
    }

    @Test
    void 퍼팩트_게임() {
        rollMany(12, 10);
        Assertions.assertEquals(300, game.score());
    }

    private void spare() {
        game.roll(5);
        game.roll(5);    // spare
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

}