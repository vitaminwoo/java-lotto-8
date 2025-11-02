package lotto;

import lotto.domain.Lottos;
import lotto.domain.Purchase;
import lotto.domain.WinningLotto;
import lotto.util.InputConverter;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

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
    }

    private Purchase createPurchase() {
        int purchasePriceInput = InputConverter.convertInput(inputView.readPurchasePrice());
        return new Purchase(purchasePriceInput);
    }

    private Lottos createLottos(int purchaseAmount) {
        outputView.printPurchaseAmount(purchaseAmount);
        Lottos randomLottos = Lottos.generateRandomLottos(purchaseAmount);
        outputView.printRandomLottos(randomLottos);

        return randomLottos;
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbersInput = Parser.splitInput(inputView.readWinningNumber()).stream()
                .map(InputConverter::convertInput)
                .toList();
        int winningBonusNumberInput = InputConverter.convertInput(inputView.readWinningBonusNumber());

        return WinningLotto.generateWinningLotto(winningNumbersInput, winningBonusNumberInput);
    }

}
