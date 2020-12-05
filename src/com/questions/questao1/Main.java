package com.questoes.questao1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		Controle controle = new Controle();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Carro carro = new Carro(controle, 6);

		Passageiro passageiro1 = new Passageiro(controle, "1");
		Passageiro passageiro2 = new Passageiro(controle, "2");
		Passageiro passageiro3 = new Passageiro(controle, "3");
		Passageiro passageiro4 = new Passageiro(controle, "4");
		Passageiro passageiro5 = new Passageiro(controle, "5");
		Passageiro passageiro6 = new Passageiro(controle, "6");
		Passageiro passageiro7 = new Passageiro(controle, "7");
		Passageiro passageiro8 = new Passageiro(controle, "8");
		Passageiro passageiro9 = new Passageiro(controle, "9");

		
		executor.execute(carro);
		executor.execute(passageiro3);
		executor.execute(passageiro4);
		executor.execute(passageiro5);
		executor.execute(passageiro6);
		executor.execute(passageiro1);
		executor.execute(passageiro2);
		executor.execute(passageiro7);
		executor.execute(passageiro8);
		executor.execute(passageiro9);
	
	}

}
