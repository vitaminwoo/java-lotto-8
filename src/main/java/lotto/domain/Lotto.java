package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private static final int RANDOM_NUMBER_MIN = 1;
    private static final int RANDOM_NUMBER_MAX = 45;
    private static final int RANDOM_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static Lotto createRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX, RANDOM_NUMBER_COUNT
        );
        return new Lotto(randomNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
