package lotto.domain;

import java.util.List;

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

    public static WinningLotto generateWinningLotto(List<Integer> winningNumbers, int winningBonusNumber) {
        Lotto winningLottoInput = new Lotto(winningNumbers);
        return new WinningLotto(winningLottoInput, winningBonusNumber);
    }
}
