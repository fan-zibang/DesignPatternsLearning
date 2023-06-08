package com.fanzibang.structural.flyweight;

public class ChessPieceV2 {

    private ChessPieceUnit chessPieceUnit;
    private int positionX;
    private int positionY;
    public ChessPieceV2(ChessPieceUnit unit, int positionX, int positionY) {
        this.chessPieceUnit = unit;
        this.positionX = positionX;
        this.positionY = positionY;
    }

}
