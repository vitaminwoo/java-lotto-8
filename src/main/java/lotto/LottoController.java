package lotto;

import lotto.domain.*;
import lotto.util.InputConverter;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Purchase purchase = createPurchase();
        Lottos purchaseLottos = createLottos(purchase.getPurchaseAmount());
        WinningLotto winningLotto = createWinningLotto();

        WinnerResult winnerResult = createWinnerResult(purchaseLottos, winningLotto);
        printWinnerResult(winnerResult, purchase.getPurchasePrice());
    }


    private Purchase createPurchase() {
        while (true) {
            try {
                int purchasePriceInput = InputConverter.convertInput(inputView.readPurchasePrice());
                return new Purchase(purchasePriceInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos createLottos(int purchaseAmount) {
        outputView.printPurchaseAmount(purchaseAmount);
        Lottos randomLottos = Lottos.generateRandomLottos(purchaseAmount);
        outputView.printRandomLottos(randomLottos);

        return randomLottos;
    }

    private WinningLotto createWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbersInput = Parser.splitInput(inputView.readWinningNumber()).stream()
                        .map(InputConverter::convertInput)
                        .toList();
                Lotto winningLottoNumbers = new Lotto(winningNumbersInput);

                int winningBonusNumberInput = InputConverter.convertInput(inputView.readWinningBonusNumber());
                return new WinningLotto(winningLottoNumbers, winningBonusNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinnerResult createWinnerResult(Lottos purchaseLottos, WinningLotto winningLotto) {
        return purchaseLottos.calculateWinningLottosResult(winningLotto);
    }

    private void printWinnerResult(WinnerResult winnerResult, int purchasePrice) {
        outputView.printWinningResult(winnerResult);
        outputView.printIncomeRate(winnerResult, purchasePrice);
    }
}
