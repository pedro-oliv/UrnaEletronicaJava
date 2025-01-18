public class Candidato {
    private String _nome;
    private int _numero, _votos;
    
    public Candidato(int numero, String nome, int votos){
        this._numero = numero;
        this._nome = nome;
        this._votos = votos;

    }

    public String getNome(){
        return _nome;
    }

    public int getNumero(){
        return _numero;
    }

    public int getVotos(){
        return _votos;
    }

    public void incrementarVotos(){
        this._votos++;
    }
}
