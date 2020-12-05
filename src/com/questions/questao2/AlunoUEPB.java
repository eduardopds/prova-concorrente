package com.questions.questao2;

public class AlunoUEPB implements Runnable {

	private Barco barco;
	private String nome;

	public AlunoUEPB(Barco barco, String nome) {
		this.barco = barco;
		this.nome = nome;
	}

	public void embarcar() throws InterruptedException {
		this.barco.embarcar("UEPB", this.nome);
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
