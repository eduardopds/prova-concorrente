package com.questions.questao1;

/*
 Essa classe funciona como um buffer.
 O notifyAll pra acordar todas as threads que estão aguardando o notify no objeto.
 */
public class Controle {

	private int nVagas;

	private int vagasOcupadas;

	private boolean descarregando;

	private boolean carregando;

	private boolean embarque;

	public Controle() {

		this.embarque = true;
		this.vagasOcupadas = 0;
		this.nVagas = -1;
		this.descarregando = false;
		this.carregando = false;
	}

	/*
		Verifico se tá cheio ou se o desembarque não foi finalizado, logo esperam para começar a carregar.
	*/
	public synchronized void carregar(int nVagas) throws InterruptedException {


		while (this.vagasOcupadas == this.nVagas || !embarque || this.nVagas == 0) {
			wait();
		}

		this.nVagas = nVagas;
		this.carregando = true;
		this.descarregando = false;
		this.embarque = false;

		System.out.println("O carro pronto para carregar");

		notifyAll();
	}


	/*
		Caso esteja cheio ou não esteja sendo carregado é necessário esperar para o embarque. Caso contrário é
		inclementado o número de vagas ocupadas.
	 */
	public synchronized void embarcar(String nome) throws InterruptedException {


		while (!carregando || this.vagasOcupadas == this.nVagas) {
			wait();
		}

		this.vagasOcupadas += 1;

		System.out.println("Passageiro " + nome + " embarcou.");

		notifyAll();
	}

	public synchronized void correr() throws InterruptedException {

		// Não está cheio, ou seja ainda não é possível correr
		while (this.vagasOcupadas != this.nVagas) {
			wait();
		}

		this.carregando = false;

		System.out.println("O carro está correndo...... o~^^~o ... o~^^~o ... o~^^~o ..");

	}

	/*
		Se as vagas ocupadas = 0 então não é possível descarregar, logo fica esperando
	 */
	public synchronized void descarregar() throws InterruptedException {

		while (this.vagasOcupadas == 0) {
			wait();
		}

		System.out.println("O carro parou .. o~^^~o");

		this.descarregando = true;

		notifyAll();
	}

	/*
		Se o número de vagas ocupadas for igual a 0 e não estiverem descarregando, o passageiro não pode
		desembarcar, logo ele fica esperando.
	 */
	public synchronized void desembarcar(String nome) throws InterruptedException {

		while (!descarregando || this.vagasOcupadas == 0) {
			wait();
		}

		this.vagasOcupadas -= 1;

		System.out.println("O passageiro " + nome + " desembarcou.");

		if (this.vagasOcupadas == 0) this.embarque = true;

		notifyAll();
	}

}
