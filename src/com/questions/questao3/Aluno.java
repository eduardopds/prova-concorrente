package com.questions.questao3;

public class Aluno implements Runnable{

    private String nome;
    private Bar auri;

    public Aluno(String nome, Bar auri){

        this.nome = nome;
        this.auri = auri;
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

        }

    }

    public void entra() {

        try {
            this.auri.entra(this.nome);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sai(){
        try {
            this.auri.sai(this.nome);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void bebe(){
        try {
            this.auri.bebe(this.nome);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
