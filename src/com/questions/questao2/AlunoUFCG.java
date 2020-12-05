package com.questions.questao2;


public class AlunoUFCG implements Runnable {

	private Barco barco;
	private String nome;

	public AlunoUFCG(Barco barco, String nome) {

		this.barco = barco;
		this.nome = nome;
	}

	public void embarcar() throws InterruptedException {

		this.barco.embarcar("UFCG", this.nome);

	}

	@Override
	public void run() {
		try {

			this.embarcar();


		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}


}
