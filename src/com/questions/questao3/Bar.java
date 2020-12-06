package com.questions.questao3;

// O notifyAll pra acordar todas as threads que estão aguardando o notify no objeto.
public class Bar {

    private int bebendo;
    private int naMesa;

    public Bar(){

        this.bebendo = 0;
        this.naMesa = 0;

    }

    public synchronized void entra(String nome) throws InterruptedException {

        this.naMesa += 1;

        //Thread.sleep(1000);
        System.out.println(nome + " sentou a mesa");
        //Thread.sleep(1000);
        System.out.println(nome + " está remediando - " + bebendo + " estao bebendo - " + naMesa + " estao na mesa");

        notifyAll();

    }

    public synchronized void bebe(String nome) throws InterruptedException {

        this.bebendo += 1;

        //Thread.sleep(1000);
        System.out.println(nome + " está bebendo...");
        //Thread.sleep(1000);
        System.out.println(nome + " está remediando - " + bebendo + " estao bebendo - " + naMesa + " estao na mesa");

        notifyAll();


    }

    /*
        Verifica se o aluno pode sair, caso contrário fica esperando.
     */
    public synchronized void sai(String nome) throws InterruptedException {

        while(this.naMesa < 3 && this.bebendo <= 2){
            //Thread.sleep(1000);
            System.out.println(nome + " não conseguiu sair");
            wait();
        }
        this.bebendo -= 1;
        this.naMesa -= 1;

        //Thread.sleep(1000);
        System.out.println(nome + " saiu da mesa - " + this.naMesa + " estao na mesa");
        notifyAll();

    }

}
