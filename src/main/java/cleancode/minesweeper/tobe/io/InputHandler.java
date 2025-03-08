package cleancode.minesweeper.tobe.io;

import cleancode.minesweeper.tobe.position.CellPosition;

public interface InputHandler {

    String getUserInput();

   public CellPosition getCellPositionFromUser();

}
