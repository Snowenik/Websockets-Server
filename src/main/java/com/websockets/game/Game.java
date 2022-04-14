package com.websockets.game;

public class Game {

    private String gameId;
    private String[] squares;
    private String firstPlayerID;
    private String secondPlayerID;
    private GameStatus gameStatus;
    private MoveType moveType;
    private String type;
    private boolean xNext;
    private boolean winner;
    private String currentPlayerID;
    private String firstPlayerName;
    private String secondPlayerName;
    private boolean draw;

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public String getFirstPlayerName() {
        return firstPlayerName;
    }

    public void setFirstPlayerName(String firstPlayerName) {
        this.firstPlayerName = firstPlayerName;
    }

    public String getSecondPlayerName() {
        return secondPlayerName;
    }

    public void setSecondPlayerName(String secondPlayerName) {
        this.secondPlayerName = secondPlayerName;
    }

    public String getCurrentPlayerID() {
        return currentPlayerID;
    }

    public void setCurrentPlayerID(String currentPlayerID) {
        this.currentPlayerID = currentPlayerID;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public String getType() {
        return type;
    }

    public boolean isxNext() {
        return xNext;
    }

    public void setxNext(boolean xNext) {
        this.xNext = xNext;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String[] getSquares() {
        return squares;
    }

    public void setSquares(String[] squares) {
        this.squares = squares;
    }

    public String getFirstPlayerID() {
        return firstPlayerID;
    }

    public void setFirstPlayerID(String firstPlayerID) {
        this.firstPlayerID = firstPlayerID;
    }

    public String getSecondPlayerID() {
        return secondPlayerID;
    }

    public void setSecondPlayerID(String secondPlayerID) {
        this.secondPlayerID = secondPlayerID;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }


}
