package associacao;

public class Professor extends Participacao {
	
	boolean coordenador;

	public Professor(double valorHora, int qtdHoras, boolean coordenador) {
		super(valorHora, qtdHoras);
		this.coordenador = coordenador;
	}

}
