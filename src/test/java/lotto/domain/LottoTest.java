package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤으로 생성한 로또가 원하는 범위의 6개 숫자를 가지는지 확인")
    @Test
    void 랜덤_숫자_로또_생성() {
        Lotto randomLotto = Lotto.createRandomLotto();
        List<Integer> randomLottoNumbers = randomLotto.getNumbers();

        assertThat(randomLottoNumbers.size()).isEqualTo(6);
        assertThat(randomLottoNumbers.stream()
                .allMatch(number -> number >= 1 && number <= 45))
                .isTrue();
    }
}
