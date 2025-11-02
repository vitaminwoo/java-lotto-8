package lotto.domain;

import java.util.List;

public class WinnerResult {

    private final List<Winner> winnerResult;

    public WinnerResult(List<Winner> winnerResult) {
        this.winnerResult = winnerResult;
    }

    public List<Winner> getWinnerResult() {
        return winnerResult;
    }

    public String calculateEarnRate(int purchasePrice){
        long earnSum = 0L;
        for (Winner winner : winnerResult) {
            earnSum += winner.getWinnerPrice();
        }
        return String.format("%.1f", (double) earnSum /  purchasePrice * 100);
    }
}
