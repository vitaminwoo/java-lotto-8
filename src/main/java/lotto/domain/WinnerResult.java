package lotto.domain;

import java.util.List;

public class WinnerResult {

    private final List<Winner> winnerResult;

    public WinnerResult(List<Winner> winnerResult) {
        this.winnerResult = winnerResult;
    }

    public int getCountOfRank(Winner rank) {
        int count = 0;
        for (Winner winner : winnerResult) {
            if (winner == rank) {
                count++;
            }
        }
        return count;
    }

    public String calculateEarnRate(int purchasePrice){
        long earnSum = 0L;
        for (Winner winner : winnerResult) {
            earnSum += winner.getWinnerPrice();
        }
        return String.format("%.1f", (double) earnSum /  purchasePrice * 100);
    }
}
