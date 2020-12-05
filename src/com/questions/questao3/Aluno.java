package com.questions.questao3;

public class Aluno implements Runnable{

    private Bar bar;
    private String nome;

    public Aluno(String nome, Bar bar){

        this.nome = nome;
        this.bar = bar;
    }

    public void bebe(){
        try {

            this.bar.bebe(this.nome);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public void sai(){
        try {

            this.bar.sai(this.nome);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public void entra() {

        try {

            this.bar.entra(this.nome);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try{

            while(true){

                this.entra();
                this.bebe();
                this.sai();
            }

        }catch (Exception e){

            System.out.println(e.getMessage());

        }

    }

}
