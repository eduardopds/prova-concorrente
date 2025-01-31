package com.questions.questao2;

/*
	Utilizo a variáveis autorizaRemar, numAlunosUEPB, numAlunosUFCG e total para colocar as threads para
	"dormir". As 3 primeiras iniciando com 0 e a última como false.
	O notifyAll pra acordar todas as threads que estão aguardando o notify no objeto.
 */
public class Barco {

	private boolean autorizaRemar;

	private int numAlunosUEPB;

	private int numAlunosUFCG;

	private int total;

	public Barco() {

		this.autorizaRemar = false;
		this.numAlunosUEPB = 0;
		this.numAlunosUFCG = 0;
		this.total = 0;
	}

	/*
	Autoriza o embarque de um aluno depedendo das restrições
	 */
	public synchronized boolean autorizaEmbarque(String uni) {

		boolean pode = true;

		if (uni.equals("UFCG")) {

			if (this.total == 3) {

				pode =  (this.numAlunosUFCG == 2 || this.numAlunosUFCG == 0) ? false : true;

			} else if (this.total == 4) {
				pode = false;
			}

		}else if(uni.equals("UEPB")){

			if (this.total == 3) {

				pode = (this.numAlunosUEPB == 2 || this.numAlunosUEPB == 0) ? false : true;

			} else if (this.total == 4) {
				pode = false;
			}

		}

		return pode;

	}

	/*
	Se o aluno não está autorizado a remar ou a embarcar, fica esperando.
	 */
	public synchronized boolean embarcar(String uni, String nome) throws InterruptedException {

		if(uni.equals("UEPB")){

			while (!this.autorizaEmbarque(uni) || this.autorizaRemar) {
				System.out.println("O aluno " +nome + " da UEPB foi bloqueado");
				wait();
			}

			this.numAlunosUEPB += 1;

			System.out.println("O aluno " + nome + " da UEPB embarcou.");

		}else{

			while (!this.autorizaEmbarque(uni) || this.autorizaRemar) {

				System.out.println("O aluno " + nome + " da UFCG foi bloqueado");
				wait();
			}

			this.numAlunosUFCG += 1;

			System.out.println("O aluno " + nome + " da UFCG embarcou.");

		}

		// barco cheio
		while (this.total == 4) {
			wait();
		}

		this.total += 1;

		if (this.total == 4) {

			System.out.println("Barco cheio");
			this.autorizaRemar = true;
			this.rema(nome,uni);
		}

		return true;

	}

	/*
	Se o aluno não tem autorização para remar, espera.
	 */
	public synchronized void rema(String nome, String uni) throws InterruptedException {

		while (!this.autorizaRemar) {
			wait();
		}

		System.out.println("O aluno " + nome + " da " + uni +  " está remando");
		System.out.println("O barco saiu da origem");
		System.out.println("O barco chegou ao outro lado");

		this.autorizaRemar = false;
		this.total = 0;
		this.numAlunosUEPB = 0;
		this.numAlunosUFCG = 0;

		System.out.println("Iniciando nova viagem");
		notifyAll();
	}


}
