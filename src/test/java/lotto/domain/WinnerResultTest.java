package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerResultTest {
    @DisplayName("수익률 계산 확인")
    @Test
    void 수익률_계산_확인() {
        List<Winner> winners = List.of(
                Winner.LOSE, Winner.LOSE, Winner.LOSE, Winner.LOSE,
                Winner.LOSE, Winner.LOSE, Winner.LOSE, Winner.FIFTH
        );

        WinnerResult winnerResult = new WinnerResult(winners);

        assertThat(winnerResult.calculateEarnRate(8000))
                .isEqualTo("62.5");
    }
}
