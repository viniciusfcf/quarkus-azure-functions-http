package org.acme;

import io.quarkus.funqy.Funq;

public class FunqyResource {

    @Funq("funq")
    public String minhaFuncao() {
        return "Executou com Funq";
    }

}
