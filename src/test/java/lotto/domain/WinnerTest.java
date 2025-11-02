package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerTest {

    @DisplayName("당첨 로또 등수 계산 확인")
    @Test
    void 당첨_로또_등수_계산_확인() {
        Winner firstWinner = Winner.FIRST;
        Winner secondWinner = Winner.SECOND;
        Winner thirdWinner = Winner.THIRD;
        Winner forthWinner = Winner.FORTH;
        Winner fifthWinner = Winner.FIFTH;
        Winner loser = Winner.LOSE;

        assertThat(firstWinner).isEqualTo(Winner.findWinnerRank(6, true));
        assertThat(secondWinner).isEqualTo(Winner.findWinnerRank(5, true));
        assertThat(thirdWinner).isEqualTo(Winner.findWinnerRank(5, false));
        assertThat(forthWinner).isEqualTo(Winner.findWinnerRank(4, false));
        assertThat(fifthWinner).isEqualTo(Winner.findWinnerRank(3, false));
        assertThat(loser).isEqualTo(Winner.findWinnerRank(2, false));
    }
}
