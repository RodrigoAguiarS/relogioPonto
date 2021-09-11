package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PontoEletronico {
    public static void main(String[] args) {
        PontoEletronico pontoeletronico = new PontoEletronico();
        List<Pessoa> lista = pontoeletronico.carregaPessoas();
        Scanner sc = new Scanner(System.in);
        Ponto ponto = new Ponto();

        Date data = Calendar.getInstance().getTime();
        SimpleDateFormat dft = new SimpleDateFormat("HH:mm");
        dft = new SimpleDateFormat("dd/MM/yyyy");
        String data_atual = dft.format(data);

        System.out.println("---- SISTEMA DE CONTROLE DE PONTO");
        System.out.println("DATA ATUAL:" + data_atual);

        dft = new SimpleDateFormat("HH");
        String hora_atual = dft.format(data);
        int h = Integer.parseInt(hora_atual);

        String cpf;
        for(int j = 0; j<= 3;j++){
            if (h >= 7 && h <= 8) {
                System.out.println("REGISTRO DE ENTRADA");
                do{
            }while (pontoeletronico.verificarCpf(cpf, lista) == false);
                ponto.setEntrada(data.getTime());
            }
        }
        if (h >8) {
            System.out.println("REGISTRO DA SAIDA");
            do{
                System.out.println("Informe o CPF:");
                cpf = sc.nextLine();
            }while (pontoeletronico.verificarCpf(cpf, lista) == false);

            if(data != null){
                ponto.setSaida(data.getTime());
            }else{
                System.out.println("Data Nula");
                //Date novadata = new Date(pt.getSaida());
            }
        }
    }
}