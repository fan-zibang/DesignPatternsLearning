package com.fanzibang.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 棋局
 *
 * 为了记录每个房间当前的棋局情况，我们需要给每个房间都创建一个 ChessBoard 棋局对象。
 * 因为游戏大厅中有成千上万的房间（实际上，百万人同时在线的游戏大厅也有很多），那保存这么多棋局对象就会消耗大量的内存。
 *
 * 解决办法：在内存中会有大量的相似对象。这些相似对象的 id、text、color 都是相同的，唯独 positionX、positionY 不同。
 * 将棋子的 id、text、color 属性拆分出来，设计成独立的类，并且作为享元供多个棋盘复用。
 */
public class ChessBoardV1 {
    private Map<Integer, ChessPieceV1> chessPieces = new HashMap<>();

    public ChessBoardV1() {
        init();
    }
    private void init() {
        chessPieces.put(1, new ChessPieceV1(1, "車", ChessPieceV1.Color.BLACK, 0, 0));
        chessPieces.put(2, new ChessPieceV1(2,"馬", ChessPieceV1.Color.BLACK, 0, 1));
        //...省略摆放其他棋子的代码...
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //...省略...
    }
}
