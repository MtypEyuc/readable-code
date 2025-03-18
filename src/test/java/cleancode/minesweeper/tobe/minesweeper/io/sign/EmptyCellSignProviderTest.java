package cleancode.minesweeper.tobe.minesweeper.io.sign;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 필드를 표현하는 메서드
class EmptyCellSignProviderTest {

    private final EmptyCellSignProvider provider = new EmptyCellSignProvider();

    @Test
    @DisplayName("supports()가 빈 셀일 경우 true를 반환해야 한다.")
    void supports_ShouldReturnTrue_WhenCellSnapshotIsEmpty() {

        // Given
        CellSnapshot emptyCell = CellSnapshot.ofEmpty();

        // When
        boolean result = provider.supports(emptyCell);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("provide()가 빈 셀일 경우 '■'을 반환해야 한다.")
    void provide_ShouldReturnEmptySign() {

        // Given
        CellSnapshot emptyCell = CellSnapshot.ofEmpty();

        // When
        String sign = provider.provide(emptyCell);

        // Then
        assertThat(sign).isEqualTo("■");
    }
}
