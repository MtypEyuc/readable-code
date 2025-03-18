package cleancode.minesweeper.tobe.minesweeper.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleOutputHandlerTest {

    private final ConsoleOutputHandler outputHandler = new ConsoleOutputHandler();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream)); // 콘솔 출력을 가로채기
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut); // 원래 콘솔 출력으로 복원
    }

    @Test
    @DisplayName("게임 승리 시 승리 메시지가 출력되어야 한다.")
    void showGameWinningComment_ShouldPrintWinningMessage() {

        // When
        outputHandler.showGameWinningComment();

        // Then
        assertThat(outputStream.toString().trim()).isEqualTo("지뢰를 모두 찾았습니다. GAME CLEAR!");
    }

    @Test
    @DisplayName("게임 패배 시 패배 메시지가 출력되어야 한다.")
    void showGameLosingComment_ShouldPrintLosingMessage() {

        // When
        outputHandler.showGameLosingComment();

        // Then
        assertThat(outputStream.toString().trim()).isEqualTo("지뢰를 밟았습니다. GAME OVER!");
    }
}
