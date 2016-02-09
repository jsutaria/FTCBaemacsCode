package com.qualcomm.ftcrobotcontroller.opmodes;

public enum GamePadLocation {
    NEGTEN(-560, -10), NEGNINE(-504, -9), NEGEIGHT(-448, -8), NEGSEVEN(-392, -7), NEGSIX(-336, -6), NEGFIVE(-280, -5), NEGFOUR(-224, -4), NEGTHREE(-168, -3), NEGTWO(-112, -2), NEGONE(-56, -1),
    ZERO(0, 0),
    ONE(56, 1), TWO(112, 2), THREE(168, 3), FOUR(224, 4), FIVE(280, 5), SIX(336, 6), SEVEN(392, 7), EIGHT(448, 8), NINE(504, 9), TEN(560, 10);

    private final int index;
    private final int factor;
    private GamePadLocation(int factor, int index) {
        this.index = index;
        this.factor = factor;
    }

    public int getFactor() {
        return factor;
    }

    public static GamePadLocation getLocation(int index) {
        for (GamePadLocation o : GamePadLocation.values()) {
            if (o.index == index) {
                return o;
            }
        }
        return GamePadLocation.ZERO;
    }
}

