package cleancode.minesweeper.tobe.minesweeper.gamelevel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BeginnerTest {

    private final GameLevel beginner = new Beginner();

    @Test
    @DisplayName("초기 레벨의 행 크기는 8이어야 한다.")
    void getRowSize_ShouldReturn8() {

        // When
        int rowSize = beginner.getRowSize();

        // Then
        assertThat(rowSize).isEqualTo(8);
    }

    @Test
    @DisplayName("초기 레벨의 열 크기는 10이어야 한다.")
    void getColSize_ShouldReturn10() {

        // When
        int colSize = beginner.getColSize();

        // Then
        assertThat(colSize).isEqualTo(10);
    }

    @Test
    @DisplayName("초기 레벨의 지뢰 개수는 10이어야 한다.")
    void getLandMineCount_ShouldReturn10() {

        // When
        int landMineCount = beginner.getLandMineCount();

        // Then
        assertThat(landMineCount).isEqualTo(10);
    }
}
