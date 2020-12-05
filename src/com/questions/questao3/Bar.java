package com.questions.questao3;

public class Bar {

    private int bebendo;
    private int naMesa;

    public Bar(){

        this.bebendo = 0;
        this.naMesa=0;

    }

    public synchronized void bebe(String nome) throws InterruptedException {

        this.bebendo = this.bebendo + 1;

        Thread.sleep(1500);
        System.out.println(nome + " está bebendo...");
        Thread.sleep(1500);
        System.out.println(nome + " está remediando - " + bebendo + " estao bebendo - " + naMesa + " estao na mesa");


        notifyAll();


    }

    public synchronized void entra(String nome) throws InterruptedException {

        this.naMesa = this.naMesa + 1;

        Thread.sleep(1500);

        System.out.println(nome + " sentou a mesa");

        Thread.sleep(1500);
        System.out.println(nome + " está remediando - " + bebendo + " estao bebendo - " + naMesa + " estao na mesa");

        notifyAll();

    }

    public synchronized void sai(String nome) throws InterruptedException {

        while(this.naMesa < 3 && this.bebendo <= 2){
            Thread.sleep(1000);
            System.out.println(nome + " não conseguiu sair");
            wait();
        }
        this.bebendo = this.bebendo - 1;
        this.naMesa = this.naMesa - 1;

        System.out.println(nome + " saiu da mesa - " + this.naMesa + " estao na mesa");
        Thread.sleep(1000);
        notifyAll();

    }

}
