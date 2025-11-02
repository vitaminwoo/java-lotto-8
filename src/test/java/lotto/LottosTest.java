package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {


    @DisplayName("구입 개수만큼 로또 생성")
    @Test
    void 구입_개수만큼_로또_생성() {
        int purchaseAmount = 5;
        Lottos randomLottos = Lottos.generateRandomLottos(purchaseAmount);
        List<Lotto> getLottos = randomLottos.getLottosNumbers();

        assertThat(getLottos.size()).isEqualTo(purchaseAmount);
    }
}
