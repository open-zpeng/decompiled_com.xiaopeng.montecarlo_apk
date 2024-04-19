package com.xiaopeng.montecarlo.navcore.sr;
/* loaded from: classes3.dex */
public enum TrafficLightState {
    NONE,
    TURN_LEFT_GREEN,
    TURN_LEFT_YELLOW,
    TURN_LEFT_RED,
    TURN_LEFT_BLACK,
    STRAIGHT_GREEN,
    STRAIGHT_YELLOW,
    STRAIGHT_RED,
    STRAIGHT_BLACK,
    TURN_RIGHT_GREEN,
    TURN_RIGHT_YELLOW,
    TURN_RIGHT_RED,
    TURN_RIGHT_BLACK,
    TURNAROUND_GREEN,
    TURNAROUND_YELLOW,
    TURNAROUND_RED,
    TURNAROUND_BLACK;

    public static TrafficLightState parse(int i) {
        if (i == 0) {
            return NONE;
        }
        if (i == 1) {
            return TURN_LEFT_GREEN;
        }
        if (i == 2) {
            return TURN_LEFT_YELLOW;
        }
        if (i == 3) {
            return TURN_LEFT_RED;
        }
        if (i == 4) {
            return TURN_LEFT_BLACK;
        }
        if (i == 5) {
            return STRAIGHT_GREEN;
        }
        if (i == 6) {
            return STRAIGHT_YELLOW;
        }
        if (i == 7) {
            return STRAIGHT_RED;
        }
        if (i == 8) {
            return STRAIGHT_BLACK;
        }
        if (i == 9) {
            return TURN_RIGHT_GREEN;
        }
        if (i == 10) {
            return TURN_RIGHT_YELLOW;
        }
        if (i == 11) {
            return TURN_RIGHT_RED;
        }
        if (i == 12) {
            return TURN_RIGHT_BLACK;
        }
        if (i == 13) {
            return TURNAROUND_GREEN;
        }
        if (i == 14) {
            return TURNAROUND_YELLOW;
        }
        if (i == 15) {
            return TURNAROUND_RED;
        }
        if (i == 16) {
            return TURNAROUND_BLACK;
        }
        return NONE;
    }
}
