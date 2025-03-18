package cleancode.minesweeper.tobe.minesweeper.io.sign;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// 필드를 표현하는 메서드
class EmptyCellSignProviderTest {

    private final EmptyCellSignProvider provider = new EmptyCellSignProvider();

    @Test
    void supports_ShouldReturnTrue_WhenCellSnapshotIsEmpty() {

        CellSnapshot emptyCell = CellSnapshot.ofEmpty();

        boolean result = provider.supports(emptyCell);

        assertThat(result).isTrue();
    }

    @Test
    void provide_ShouldReturnEmptySign() {

        CellSnapshot emptyCell = CellSnapshot.ofEmpty();

        String sign = provider.provide(emptyCell);

        assertThat(sign).isEqualTo("■");
    }
}
