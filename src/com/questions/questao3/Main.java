package com.questions.questao3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Bar auri = new Bar();
        Aluno a1 = new Aluno("fulano", auri);
        Aluno a2 = new Aluno("ciclano", auri);
        Aluno a3 = new Aluno("beltrano", auri);
        //Aluno a4 = new Aluno("fulano1", auri);

        ExecutorService execute = Executors.newFixedThreadPool(4);

        execute.execute(a1);
        execute.execute(a2);
        execute.execute(a3);
        //execute.execute(a4);

    }
}
