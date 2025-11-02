package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class OutputView {
    private static final String MESSAGE_PURCHASE_AMOUNT = "개를 구매했습니다.";
    private static final String MESSAGE_WINNING_RESULT = "\n당첨 통계\n---";
    private static final String MESSAGE_INCOME_RATE = "총 수익률은 ";

    public OutputView() {}

    public void printPurchaseAmount(int purchaseAmount) {
        System.out.println(String.valueOf(purchaseAmount) + MESSAGE_PURCHASE_AMOUNT);
    }

    public void printRandomLottos(Lottos randomLottos) {
        List<Lotto> randomLotto = randomLottos.getLottosNumbers();
        for (Lotto lotto : randomLotto) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResult() {
        System.out.println(MESSAGE_WINNING_RESULT);
        // TODO: 당첨 통계 출력
    }

    public void printIncomeRate() {
        // TODO: 수익률 출력
    }

}
