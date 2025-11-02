package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generateRandomLottos(int amount) {
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto randomLotto = Lotto.createRandomLotto();
            randomLottos.add(randomLotto);
        }
        return new Lottos(randomLottos);
    }

    public List<Lotto> getLottosNumbers() {
        return lottos;
    }

/*
    private List<Lotto> generateRandomLottos2(int amount) {
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto randomLotto = Lotto.createRandomLotto();
            randomLottos.add(randomLotto);
        }
        return randomLottos;
    }*/


}