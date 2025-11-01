package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PurchaseTest {

    @DisplayName("로또 구입 금액에 따른 구입 개수 계산 정상동작 확인")
    @Test
    void 로또_구입_금액에_따른_구입_개수_계산() {
        assertThatCode(() -> new Purchase(14000))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아닐 때 예외 처리")
    @Test
    void 로또_구입_금액이_1000원_단위가_아닐_때_예외() {
        assertThatThrownBy(() -> new Purchase(14400))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다");
    }

}
