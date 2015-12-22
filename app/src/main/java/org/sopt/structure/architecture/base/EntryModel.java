package org.sopt.structure.architecture.base;

import org.sopt.structure.domain.Data;

public class EntryModel {

    private static int COUNTER = 1;

    public Data query() {

        return new Data(COUNTER++, "신동헌", "SOPT");
    }
}
