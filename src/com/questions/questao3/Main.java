package com.questions.questao3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Bar auri = new Bar();
        Aluno al1 = new Aluno("fulano", auri);
        Aluno al2 = new Aluno("ciclano", auri);
        Aluno al3 = new Aluno("beltrano", auri);

        executorService.execute(al1);
        executorService.execute(al2);
        executorService.execute(al3);

    }
}
