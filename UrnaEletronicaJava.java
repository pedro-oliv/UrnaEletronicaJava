
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class UrnaEletronicaJava {
    static Processos processo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        startData();
    
        System.out.println("Bem-vindo à Urna Eletrônica!");
        System.out.println("Candidatos:");
        System.out.println("01 - Ada Lovelace");
        System.out.println("02 - Alan Turing");
        System.out.println("03 - Marie Curie");
        System.out.println("04 - Albert Eistein");
        System.out.println("05 - Ludwig van Beethoven");

        int votosRecebidos=0;
        while (votosRecebidos<10){
            System.out.println("Digite o número do seu candidato (No formato certo: 01, 02, etc.):");
            String numerostring = sc.nextLine();

            boolean entradaAceita = processo.receberVoto(numerostring);

            if(entradaAceita){
                votosRecebidos++;
            }
        }
        processo.exibirResultados();
        sc.close();
    }

        public static void startData(){
        List<Candidato> candidatos = new ArrayList<>();
        Candidato candidato1 = new Candidato(1,"Ada Lovelace",0);
        Candidato candidato2 = new Candidato(2, "Alan Turing", 0);
        Candidato candidato3 = new Candidato(3, "Marie Curie", 0);
        Candidato candidato4 = new Candidato(4, "Albert Einstein", 0);
        Candidato candidato5 = new Candidato(5, "Ludwig van Beethoven", 0);
        candidatos.add(candidato1);
        candidatos.add(candidato2);
        candidatos.add(candidato3);
        candidatos.add(candidato4);
        candidatos.add(candidato5);
        processo = new Processos(candidatos,0);
    }
}
