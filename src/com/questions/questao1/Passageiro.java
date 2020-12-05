package com.questoes.questao1;

public class Passageiro implements Runnable {

	private String nome;
	private Controle controle;

	public Passageiro(Controle controle, String nome) {

		this.controle = controle;
		this.nome = nome;
	}

	public void embarcar(){

		try {

			this.controle.embarcar(this.nome);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void desembarcar(){

		try {

			this.controle.desembarcar(this.nome);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		try {
			while(true) {

				this.embarcar();

				this.desembarcar();

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
