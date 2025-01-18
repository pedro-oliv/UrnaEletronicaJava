
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Processos {
    private int _votosNulos;
    private List<Candidato> _candidatos;

    public Processos(List<Candidato> candidatos, int votosNulos){
        this._candidatos = candidatos;
        this._votosNulos = votosNulos;
    }

    public boolean confirmarVoto(String mensagemConfirmacao){
        @SuppressWarnings("resource") //gambiarra, provavelmente tem uma maneira melhor de fazer mas vai ficar assim mesmo, tá funcionando
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println(mensagemConfirmacao + " (S para sim, N para não)");
            char resposta = sc.next().toUpperCase().charAt(0);
            if(resposta == 'S'){
                return true;
            }
            else if(resposta == 'N'){
                return false;
            }
            else{
                System.out.println("Entrada inválida. Digite 'S' para sim ou 'N' para não.");
            }
        }
    }

    public boolean receberVoto(String numeroVoto){

        if(numeroVoto.matches("\\d{2}")){
            int numero = Integer.parseInt(numeroVoto);
            boolean votoValido = false;

        for(Candidato candidato : _candidatos){
            if(candidato.getNumero() == numero){
                String mensagem = "Seu voto vai para: " + candidato.getNome() + ", confirmar?";
                if(confirmarVoto(mensagem)){
                    candidato.incrementarVotos();
                    votoValido = true;
                }
                else{
                    System.out.println("Voto cancelado. Digite novamente");
                }
                return votoValido;

            }
        }
        String mensagem = "Número inválido, seu voto será nulo, confirmar?";
        if(confirmarVoto(mensagem)){
            System.out.println("Voto nulo registrado.");
            _votosNulos++;
            return true;
        }
        else{
            System.out.println("Voto cancelado. Digite novamente.");
            return false;
        }

    }
        else if(numeroVoto.matches("\\d{3,}")){
            System.out.println("Entrada recusada. Por favor digite um número válido no formato 01, 02, etc.");
            return false;
        }
        else{
            System.out.println("Entrada recusada. Por favor digite um número válido no formato 01, 02, etc.");
            return false;
        }
        

    }


    public void apurarResultados(){
        int totalVotosValidos =0;
        for(Candidato candidato : _candidatos){
            totalVotosValidos += candidato.getVotos();
        }

        double maxVotos=0;
        List<Candidato> vencedores = new ArrayList<>();

        for(Candidato candidato : _candidatos){
            double percentual = totalVotosValidos > 0 ? (candidato.getVotos() * 100) / totalVotosValidos:0;
            System.out.printf("%s: %d votos (%.1f%%)%n", candidato.getNome(), candidato.getVotos(), percentual);

            if(candidato.getVotos()>maxVotos){
                maxVotos = candidato.getVotos();
                vencedores.clear();
                vencedores.add(candidato);
            }
            else if(candidato.getVotos() == maxVotos){
                vencedores.add(candidato);
            }
        }
        System.out.printf("Votos Nulos: %d%n", _votosNulos);

        if(vencedores.size() == 1){
            System.out.printf("Vencedor: %s%n", vencedores.get(0).getNome());
        }
        else{
            System.out.println("Houve um empate entre os seguntes candidatos: ");
            for(Candidato vencedor : vencedores){
                System.out.printf("%s%n", vencedor.getNome());
            }
        }
    }

    public void exibirResultados(){
        System.out.println("Resultado da Votação:");
        apurarResultados();
    }

}