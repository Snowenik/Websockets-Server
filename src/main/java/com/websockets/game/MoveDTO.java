package com.websockets.game;

public class MoveDTO {

    private int squareIndex;
    private String gameId;
    private String currentPlayerID;

    public int getSquareIndex() {
        return squareIndex;
    }

    public String getGameId() {
        return gameId;
    }

    public String getCurrentPlayerID() {
        return currentPlayerID;
    }
}
