package com.questoes.questao1;

public class Carro implements Runnable {
	
	private Controle controle;
	private int nVagas;
	
	public Carro(Controle controle, int nVagas) {
		super();
		this.controle = controle;
		this.nVagas = nVagas;
	}

	private void carregar() {

		try {

			this.controle.carregar(nVagas);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void correr() {

		try {

			this.controle.correr();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void descarregar() {

		try {

			this.controle.descarregar();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
				
				this.carregar();
				
				this.correr();
				
				this.descarregar();
				
			}	
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		
	}
		
}
