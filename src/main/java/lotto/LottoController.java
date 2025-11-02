package lotto;

import lotto.domain.Purchase;
import lotto.util.InputConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Purchase purchase = createPurchase();
    }

    private Purchase createPurchase() {
        int purchasePrice = InputConverter.convertInput(inputView.readPurchasePrice());
        return new Purchase(purchasePrice);
    }

//    private
}
