package lotto.view;

public class OutputView {
    private static final String MESSAGE_PURCHASE_AMOUNT = "개를 구매했습니다.";
    private static final String MESSAGE_WINNING_RESULT = "\n당첨 통계\n---";
    private static final String MESSAGE_INCOME_RATE = "총 수익률은 ";

    public OutputView() {}

    public void printPurchaseAmount() {
        // TODO: 로또 구매 개수 출력
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
    }

    public void printWinningResult() {
        System.out.println(MESSAGE_WINNING_RESULT);
        // TODO: 당첨 통계 출력
    }

    public void printIncomeRate() {
        // TODO: 수익률 출력
    }

}
