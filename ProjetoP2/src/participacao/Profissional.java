package participacao;

import exception.ValidacaoException;

/**
 * Representa um Profissional no sistema.
 * @author Yuri Silva
 * @author Tiberio Gadelha
 * @author Matheus Henrique
 *
 */
public class Profissional extends Participacao {
	
	private Cargo cargo;
	
	private final static double BONUS_BOLSA_ADICIONAL = 100.0;
	

	public Profissional(String cargo, double valorHora, int qtdHoras) {
		super(valorHora, qtdHoras);
		this.setCargo(cargo);
	
	}
	
	/**
	 * O metodo vai definir o cargo do profissional.
	 * @param cargo A string do cargo que sera definido.
	 * @throws ValidacaoException Caso o cargo nao esteja definido no enum, uma excecao sera retornada.
	 */

	private boolean setCargo(String cargo) throws ValidacaoException {
		for(Cargo valorCargo: Cargo.values()) {
			if(cargo.equalsIgnoreCase(valorCargo.getCargo())) {
				this.cargo = valorCargo;
				return true;
			}
		}
		throw new ValidacaoException("Cargo nao cadastrado");
	}
	
	
	public String getCargo() {
		return cargo.getCargo();
	}
	
	
	// INCOMPLETO
	@Override
	
	public double geraGanhos(){
		
		if (getCargo().equals("pesquisador")){
			return super.geraGanhos() + BONUS_BOLSA_ADICIONAL;
		}
		
		return 0;
		
	}

	@Override
	public double geraPontuacaoParticipacao() {
		// TODO Auto-generated method stub
		return 0;
	}

}
