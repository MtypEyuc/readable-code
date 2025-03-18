package cleancode.minesweeper.tobe.minesweeper.gamelevel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//게임 실행을 위한 레벨 선택 메서드

class BeginnerTest {

    private final GameLevel beginner = new Beginner();

    @Test
    void getRowSize_ShouldReturn8() {

        int rowSize = beginner.getRowSize();

        assertThat(rowSize).isEqualTo(8);
    }

    @Test
    void getColSize_ShouldReturn10() {

        int colSize = beginner.getColSize();

        assertThat(colSize).isEqualTo(10);
    }

    @Test
    void getLandMineCount_ShouldReturn10() {

        int landMineCount = beginner.getLandMineCount();

        assertThat(landMineCount).isEqualTo(10);
    }
}
