package com.metlife.bowling;

public class Game {
    private int[] score = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        score[currentRoll++] = pins;
    }

    public int score() {
        int result = 0;
        int frames = 10;
        int firstRollInFrame = 0;
        for (int i = 0; i < frames; i++) {
            if (isStrike(firstRollInFrame)) {
                result += 10 + scoresAfterStrike(firstRollInFrame);
                firstRollInFrame++;
            } else if (isSpare(firstRollInFrame)) {
                result += 10 + scoreAfterSpare(firstRollInFrame);
                firstRollInFrame += 2;
            } else {
                result += scoresInFrame(firstRollInFrame);
                firstRollInFrame += 2;
            }
        }

        return result;
    }

    private int scoresAfterStrike(int firstRollInFrame) {
        return score[firstRollInFrame + 1] + score[firstRollInFrame + 2];
    }

    private boolean isStrike(int firstRollInFrame) {
        return score[firstRollInFrame] == 10;
    }

    private int scoresInFrame(int firstInFrame) {
        return score[firstInFrame] + score[firstInFrame + 1];
    }

    private int scoreAfterSpare(int firstInFrame) {
        return score[firstInFrame + 2];
    }

    private boolean isSpare(int firstInFrame) {
        return scoresInFrame(firstInFrame) == 10;
    }
}
