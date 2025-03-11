package cleancode.minesweeper.tobe.minesweeper.board.cell;

public interface Cell {


    String FLAG_SIGN = "⚑";
    String UNCHECKED_SIGN = "□";

   boolean isLandMine();

    boolean hasLandMineCount();

    CellSnapshot getSnapshot();

    String getSign() ;

    void flag();

    void open();

    boolean isChecked();

    boolean isOpened();


}
