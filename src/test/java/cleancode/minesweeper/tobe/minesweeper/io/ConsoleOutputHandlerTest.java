package cleancode.minesweeper.tobe.minesweeper.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    void showGameWinningComment_ShouldPrintWinningMessage() {

        outputHandler.showGameWinningComment();

        assertThat(outputStream.toString().trim()).isEqualTo("지뢰를 모두 찾았습니다. GAME CLEAR!");
    }

    @Test
    void showGameLosingComment_ShouldPrintLosingMessage() {

        outputHandler.showGameLosingComment();

        assertThat(outputStream.toString().trim()).isEqualTo("지뢰를 밟았습니다. GAME OVER!");
    }
}
