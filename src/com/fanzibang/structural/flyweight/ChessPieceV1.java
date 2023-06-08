package com.fanzibang.structural.flyweight;

/**
 * 棋子
 */
public class ChessPieceV1 {

    private int id;
    private String text;
    private Color color;
    private int positionX;
    private int positionY;

    public ChessPieceV1(int id, String text, Color color, int positionX, int positionY) {
        this.id = id;
        this.text = text;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public static enum Color {
        RED, BLACK
    }
}
