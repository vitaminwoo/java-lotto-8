package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int winningBonusNumber;

    public WinningLotto(Lotto winningLotto, int winningBonusNumber) {
        this.winningLotto = winningLotto;
        this.winningBonusNumber = winningBonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getWinningBonusNumber() {
        return winningBonusNumber;
    }
}
