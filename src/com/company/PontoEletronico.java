package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

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
                    System.out.println("Informe o CPF:");
                    cpf = sc.nextLine();
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
    private List<Pessoa> carregaPessoas() {
        List<Pessoa> lista = new ArrayList<Pessoa>();
        String nomes[] = { "Maria silva", "Jose soares", "Joao das neves",
                "Juvenal mendes" };
        String cpfs[] = { "1234", "4321", "5678", "8765" };
        for (int i = 0; i < cpfs.length; i++) {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nomes[i]);
            pessoa.setCpf(cpfs[i]);
            lista.add(pessoa);
        }
        return lista;
    }
    private boolean verificarCpf(String cpf, List<Pessoa> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCpf().equals(cpf)) {
                return true;
            }
        }
        System.out.println("CPF INCORRETO");
        return false;


    }
    private void imprimir(Ponto pt){

    }
    private void MaiorMenor(){

    }
}