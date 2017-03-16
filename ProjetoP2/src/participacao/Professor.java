package participacao;

import projetos.Monitoria;

/**
 * Representa um Professor no sistema, que pode ser coordenador..
 * 
 * @author Yuri Silva
 * @author Tiberio Gadelha
 * @author Matheus Henrique
 */

public class Professor extends Participacao {

	boolean coordenador;

	public Professor(double valorHora, int qtdHoras, boolean coordenador) {
		super(valorHora, qtdHoras);
		this.coordenador = coordenador;
	}

	public boolean getCoordenador() {
		return coordenador;
	}

	@Override
	
	public double geraGanhos() {

		return calculaAdicional() + super.geraGanhos();

	}

	private double calculaAdicional() {

		double adicional = super.getValorHora();
		if (coordenador) {
			adicional += super.getValorHora() * 0.4;
			return adicional;
		}
		return super.getValorHora();
	}

	/**
	 * Gera a pontuacao de participacao de um professor.
	 */
	@Override
	public double geraPontuacaoParticipacao() {
		double pontuacao = 0.0;
		pontuacao += 4 * (super.getProjeto().getDuracao()/12);
		
		if(!(super.getProjeto() instanceof Monitoria)) {
			pontuacao += super.getProjeto().getQtdAlunosNoProjeto();
			
		}
		
		return pontuacao;
		
	}

}