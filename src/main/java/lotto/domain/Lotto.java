package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> numbersCopy = new ArrayList<>(numbers);
        numbersCopy.sort(null);
        validate(numbersCopy);
        validateDuplicate(numbersCopy);
        for (int number : numbersCopy) {
            validateNumber(number);
        }
        this.numbers = numbersCopy;
    }

    public static void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 다른 숫자여야 합니다.");
        }
    }

    public static Lotto createRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                1, 45, 6
        );
        return new Lotto(randomNumbers);
    }

    public Winner matchWinningLotto(WinningLotto winningLotto) {
        int matchCount = checkWinningLottoNumbers(winningLotto.getWinningLotto());
        boolean bonusCheck = checkWinningLottoBonusNumber(winningLotto.getWinningBonusNumber());

        return Winner.findWinnerRank(matchCount, bonusCheck);
    }

    public int checkWinningLottoNumbers(Lotto winningLottoNumbers) {
        int count = 0;
        for (int winningNumber : winningLottoNumbers.getNumbers()) {
            if (this.numbers.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkWinningLottoBonusNumber(int winningLottoBonusNumber) {
        return this.numbers.contains(winningLottoBonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
