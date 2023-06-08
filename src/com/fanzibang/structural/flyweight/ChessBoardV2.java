package com.fanzibang.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 利用工厂类来缓存 ChessPieceUnit 信息（也就是 id、text、color）。通过工厂类获取到的 ChessPieceUnit 就是享元。
 * 所有的 ChessBoardV2 对象共享这 30 个 ChessPieceUnit 对象（因为象棋中只有 30 个棋子）。
 * 在使用享元模式之前，记录 1 万个棋局，我们要创建 30 万（30*1 万）个棋子的 ChessPieceUnit 对象。
 * 利用享元模式，我们只需要创建 30 个享元对象供所有棋局共享使用即可，大大节省了内存。
 */
public class ChessBoardV2 {

    private Map<Integer, ChessPieceV2> chessPieces = new HashMap<>();

    public ChessBoardV2() {
        init();
    }
    private void init() {
        chessPieces.put(1, new ChessPieceV2(
                ChessPieceUnitFactory.getChessPiece(1), 0,0));
        chessPieces.put(1, new ChessPieceV2(
                ChessPieceUnitFactory.getChessPiece(2), 1,0));
        //...省略摆放其他棋子的代码...
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) {
        //...省略...
    }
}
