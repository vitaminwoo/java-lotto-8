# java-lotto-precourse

로또 발매기를 구현하는 미션.

로또는 숫자 범위 1 ~ 45의 숫자 6개를 가지며,

로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행하고 당첨 여부를 판별하여 

사용자는 당첨 통계를 보고 당첨된 로또 개수와 수익률을 알 수 있다.

당첨 번호는 중복되지 않는 숫자 6개와 보너스 번호 1개를 가지며, 당첨 기준과 금액은 아래와 같다.

- 1등: 6개 번호 일치 / 2,000,000,000원
- 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
- 3등: 5개 번호 일치 / 1,500,000원
- 4등: 4개 번호 일치 / 50,000원
- 5등: 3개 번호 일치 / 5,000원



## 구현할 기능 목록

### 1. 구입 금액을 통해 구입 개수 계산

- 로또 한 장의 금액을 1,000원으로 설정
- 입력 받은 구입 금액을 통해 개수를 계산

### 2. 구매한 로또 번호 자동 생성

- 계산된 구입 개수만큼 로또 번호를 생성

### 3. 당첨 로또 번호 지정

- 6개의 당첨 번호를 지정
- 1개의 보너스 번호를 추가

### 4. 당첨 여부 계산

- 당첨 로또 번호와 각각의 구매된 로또 번호를 비교하여 일치하는 번호 개수를 셈
- 일치 번호 개수에 따라 당첨 여부를 계산

### 5. 당첨 통계 계산

- 당첨 개수를 셈
- 총 당첨 금액을 통해 수익률을 계산

### 6. 컨트롤러 구현

1. 로또 구입 금액, 구입 개수 만들기
2. 구입 개수만큼 로또 번호 자동 생성
3. 당첨 로또 번호 지정
4. 당첨 통계 계산

### 예외 발생 상황

- Purchase에서 purchasePrice가 1000원 단위가 아닐 때
- InputConverter가 parseInt를 못할 때. (숫자가 아닐 때) - purchasePrice
- 생성한 로또의 List<Integer>의 크기가 6이 아닐 때
- 생성한 로또의 List<Integer>에 중복 숫자가 있을 때
- Parser가 splitInput을 못할 때. String이 비어있어서. - 당첨번호
- InputConverter가 parseInt를 못할 때. (숫자가 아닐 때) - 당첨번호
- InputConverter가 parseInt를 못할 때. (숫자가 아닐 때) - 보너스번호
- WinningLotto(당첨 번호)의 번호의 범위가 1 ~ 45가 아닐 때
- WinningLotto(당첨 번호)의 번호들의 크기가 6이 아닐 때
- WinningLotto(당첨 번호)의 번호들에 중복 숫자가 있을 때
- WinningLotto(당첨 번호)의 보너스 번호가 당첨 번호에 존재할 때


## 프로젝트 파일 구조

```text
├── main
│   └── java
│       └── lotto
│           ├── Application.java
│           ├── LottoController.java
│           ├── domain
│           │   ├── Lotto.java
│           │   ├── Lottos.java
│           │   ├── Purchase.java
│           │   ├── Winner.java
│           │   ├── WinnerResult.java
│           │   └── WinningLotto.java
│           ├── util
│           │   ├── InputConverter.java
│           │   └── Parser.java
│           └── view
│               ├── InputView.java
│               └── OutputView.java
└── test
    └── java
        └── lotto
            ├── ApplicationTest.java
            ├── domain
            │   ├── LottoTest.java
            │   ├── LottosTest.java
            │   ├── PurchaseTest.java
            │   ├── WinnerResultTest.java
            │   └── WinnerTest.java
            └── view