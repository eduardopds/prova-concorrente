package com.questions.questao2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(8);
		Barco barco = new Barco();

		AlunoUFCG ufcg1 = new AlunoUFCG(barco, "fulano");
		AlunoUFCG ufcg2 = new AlunoUFCG(barco, "ciclano");
		AlunoUFCG ufcg3 = new AlunoUFCG(barco, "beltrano");
		AlunoUFCG ufcg4 = new AlunoUFCG(barco, "fulano2");
		AlunoUEPB uepb1 = new AlunoUEPB(barco, "ciclano2");
		AlunoUEPB uepb2 = new AlunoUEPB(barco, "beltrano2");
		AlunoUEPB uepb3 = new AlunoUEPB(barco, "fulano3");
		AlunoUEPB uepb4 = new AlunoUEPB(barco, "ciclano3");

		executor.execute(ufcg1);
		executor.execute(uepb2);
		executor.execute(uepb3);
		executor.execute(uepb4);
		executor.execute(uepb1);
		executor.execute(ufcg2);
		executor.execute(ufcg3);
		executor.execute(ufcg4);
		
		
	}
}
