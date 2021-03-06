package cdp.projetos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cdp.comparator.ParticipacaoPeloNomeComparator;
import cdp.exception.CadastroException;
import cdp.exception.DataException;
import cdp.exception.ValidacaoException;
import cdp.participacao.AlunoGraduando;
import cdp.participacao.AlunoPosGraduando;
import cdp.participacao.Cargo;
import cdp.participacao.Participacao;
import cdp.participacao.Professor;
import cdp.participacao.Profissional;

/**
 * Classe que representa um Projeto no sistema.
 * 
 * @author Yuri Silva
 * @author Tiberio Gadelha
 * @author Matheus Henrique
 * @author Gustavo Victor
 */

public abstract class Projeto implements Serializable, Comparable<Projeto>, Contribuicao {

	private String nomeDoProjeto;
	private String objetivoDoProjeto;
	private int duracao;
	private int codigo;
	
	private Despesa despesas;
	private LocalDate dataInicio;

	protected List<Participacao> participacoes;
	private boolean projetoConcluido;
	
	public Projeto(String nomeDoProjeto, String objetivoDoProjeto, String dataInicio, int duracao, int codigo) throws DataException {
		this.nomeDoProjeto = nomeDoProjeto;
		this.objetivoDoProjeto = objetivoDoProjeto;
		this.setDataInicio(dataInicio);
		this.duracao = duracao;
		this.despesas = new Despesa();
		this.participacoes = new ArrayList<>();
		this.codigo = codigo;
		this.projetoConcluido = false;
		
	}
	
	
	public String getNome(){
		return this.nomeDoProjeto;
	}
	
	public void setNome(String nomeNovo){
		this.nomeDoProjeto = nomeNovo;
	}
	
	public String getObjetivo(){
		return this.objetivoDoProjeto;
	}
	
	public void setObjetivo(String novoObjetivo){
		this.objetivoDoProjeto = novoObjetivo;
	}
	
	public String getDataInicio(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return formatter.format(this.dataInicio);
	}
	
	public LocalDate getDate() {
		return this.dataInicio;
	}
	
	public void setDataInicio(String novaData) throws DataException{
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataInicio = LocalDate.parse(novaData ,formatter);
	}
	
	public int getDuracao(){
		return this.duracao;
	}
	
	public void setDuracao(int novaDuracao){
		this.duracao = novaDuracao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * O metodo vai calcular as despesas totais de um projeto.
	 * @return Retorna um double com o total das despesas.
	 */
	
	public double getDespesasTotal(){
		return this.despesas.getDespesaTotal();
		
	}
	
	/**
	 * Adiciona um valor a um tipo de despesa. Apos ter adicionado esse valor em um tipo de despesa,
	 * nao ha mais como mudar.
	 * @param descricao O tipo de despesa
	 * @param valor O valor da despesa
	 * @throws ValidacaoException Caso o valor da despesa seja invalida.
	 * @throws CadastroException Caso a despesa seja invalida.
	 */
	
	public void setDespesa(String descricao, double valor) throws ValidacaoException, CadastroException{
		despesas.setDespesa(descricao, valor);
	}
	
	/**
	 * Cadastra o orcamento do projeto.
	 * 
	 * @param montanteBolsas Montante destinado a bolsas.
	 * @param montanteCusteio Montante destinado a custeio.
	 * @param montanteCapital Montante destinado a capital.
	 * @throws ValidacaoException 
	 * @throws CadastroException
	 */
	
	public abstract void atualizaDespesasProjeto(double montanteBolsas, double montanteCusteio, double montanteCapital) throws ValidacaoException, CadastroException;
	
	public double getDespesa(String descricao) throws ValidacaoException {
		return despesas.getDespesa(descricao);
	}
	
	/**
	 * O metodo vai adicionar uma participacao ao projeto, ou seja, adicionar um novo contribuidor ao projeto.
	 * @param participacaoASerAdicionada
	 * @throws CadastroException
	 */
	
	public abstract void adicionaParticipacao(Participacao participacaoASerAdicionada) throws CadastroException, ValidacaoException;
	
	/**
	 * O metodo vai remover um participante do projeto.
	 * @param participacaoASerRemovida A participacao que sera removida.
	 * @throws ValidacaoException
	 */
	public abstract void removeParticipacao(Participacao participacaoASerRemovida) throws CadastroException, ValidacaoException;
	
	/**
	 * Verifica se determinada participacao ja esta no projeto, recebendo a propria participacao.
	 * @param participacaoASerVerificada 
	 * @return Retorna true, se a participacao estiver, e false, se nao estiver no projeto.
	 */
	
	public boolean verificaParticipacao(Participacao participacaoASerVerificada){
		return this.participacoes.contains(participacaoASerVerificada);
	}
	
	/**
	 * Verifica se uma pessoa ja tem uma participacao neste projeto como outra funcao.
	 * @param cpf Cpf da pessoa
	 * @param codigoProjeto Codigo do projeto
	 * @return False caso a pessoa nao esteja em outra funcao no projeto
	 * @throws ValidacaoException 
	 * @throws CadastroException Caso a pessoa esteja ja cadastrada no projeto.
	 */
	public boolean verificaParticipacao(String cpf, int codigoProjeto) throws ValidacaoException {
		for(Participacao participacao: this.participacoes) {
			if(participacao.getPessoa().getCpf().equals(cpf) && participacao.getProjeto().getCodigo() == codigoProjeto) {
				throw new ValidacaoException("Pessoa ja esta cadastrada neste projeto com outra funcao.");
			}
		}
		
		return false;
	}
	
	/**
	 * Verifica se o participante eh um professor.
	 * @param participante
	 * @return Retorna true, se for um professor, e false, se nao for.
	 */
	protected boolean ehProfessor(Participacao participante) {
		if(participante instanceof Professor) { return true; }
		return false;
	}
	
	
	public String representacao() {

		return this.getNome();
	}
	
	public String getRepresentacaoDuracao() {
		return Integer.toString(this.getDuracao());
	}
	
	public String getData() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return formatter.format(this.getDate());
	}
	
	public int getQtdAlunosNoProjeto() {
		int qtd = 0;
		for(Participacao participacao: this.participacoes) {
			if(participacao instanceof AlunoGraduando || participacao instanceof AlunoPosGraduando) {
				qtd += 1;
			}
		}
		return qtd;
	}
	
	public int getQtdParticipantesSemGerente() {
		int qtd = 0;
		for(Participacao participacao: this.participacoes) {
			if(participacao instanceof Profissional) {
				
				if(((Profissional) participacao).getCargo() == Cargo.GERENTE){

					qtd --;
				}
			}
			
			qtd ++;
				
		}
		return qtd;
	}
	
	public int getTotalParticipantes(String participante) {
		int alunoGraduando = 0;
		int alunoPosGraduando = 0;
		int profissionais = 0;
		
		for(Participacao participacao: this.participacoes) {
			if(participacao instanceof AlunoGraduando) {
				alunoGraduando ++;
			} else if(participacao instanceof AlunoPosGraduando) {
				alunoPosGraduando ++;
			}else if(participacao instanceof Profissional) {
				profissionais ++;
			}
		}
		
		if(participante.equals("Aluno Graduando")) {
			return alunoGraduando;
		} else if(participante.equals("Aluno Pos Graduando")) {
			return alunoPosGraduando;
		} else if(participante.equals("Profissional")) {
			return profissionais;
		}
		return 0;
	}
	
	public int getTotalParticipantes() {
		int participantes = 0;
		for(Participacao participacao: this.participacoes) {
			if(!(participacao instanceof Professor)) {
				participantes ++;
			}
		}
		return participantes;
	}
	
	public String getSituacao() {
		
		String situacao = "em andamento";
		
		int duracaoMeses = this.getDuracao();
		int ano = this.getDate().getYear();
		int dias = this.getDate().getDayOfMonth();
		int duracaoM = this.getDate().getMonthValue();
		
		if(duracaoMeses > 12) {
			ano += duracaoMeses / 12;
			duracaoMeses = ((duracaoMeses % 12) > 0) ? duracaoMeses % 12: duracaoM;
		}
		
		
		LocalDate dataTermino = LocalDate.of(ano, duracaoMeses, dias);
		LocalDate dataAtual = LocalDate.now();
		
		if(dataAtual.isAfter(dataTermino)) {
			situacao = "finalizado";
			this.projetoConcluido();
		}
		
		return situacao;
		
		
	}
	
	private void projetoConcluido() {
		this.projetoConcluido = true;
		
	}
	
	public boolean getProjetoConcluido() {
		return this.projetoConcluido;
	}


	/**
	 * Retorna todas as pessoas associadas ao projeto, atraves de uma string.
	 * @return
	 */
	public String mostraPessoasAssociadas() {
		String pessoas = "";
		int contador = 0;
		ParticipacaoPeloNomeComparator nomeParticipacaoComparator = new ParticipacaoPeloNomeComparator();
		Collections.sort(participacoes, nomeParticipacaoComparator);
		for(Participacao participacao: participacoes) {
		
			if(contador >= 1) {
				pessoas += ", " + participacao.getPessoa().getNome();
			}else {
				pessoas += participacao.getPessoa().getNome();
			}
			
			contador ++;
		}
		
		return pessoas;
	}
	
	public int compareTo(Projeto outroProjeto) {
		
		LocalDate date = this.getDate();
		LocalDate otherDate = outroProjeto.getDate();
		
		int compare = date.compareTo(otherDate);
		if(compare > 0) {
			return 1;
		} else if(compare == 0) {
			boolean igual = false;
			
			if(this.hashCode() == outroProjeto.hashCode() && this.equals(outroProjeto)) {
				igual = true;
			}
			
			if(igual) {
				return 0;
			}
			
			return -1;
			
		} else {
			return -1;
		}
	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getDataInicio() == null) ? 0 : this.getDataInicio().hashCode());
		result = prime * result + this.getDuracao();
		result = prime * result + ((this.getNome() == null) ? 0 : this.getNome().hashCode());
		result = prime * result + ((this.getObjetivo() == null) ? 0 : this.getObjetivo().hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (this.getDataInicio() == null) {
			if (other.getDataInicio() != null)
				return false;
		} else if (!this.getDataInicio().equals(other.getDataInicio()))
			return false;
		if (this.getDuracao() != other.getDuracao())
			return false;
		if (this.getNome() == null) {
			if (other.getNome() != null)
				return false;
		} else if (!this.getNome().equals(other.getNome()))
			return false;
		if (this.getObjetivo() == null) {
			if (other.getObjetivo() != null)
				return false;
		} else if (!this.getObjetivo().equals(other.getObjetivo()))
			return false;
		return true;
	}


	@Override
	public String toString() {
		String FIM_DE_LINHA = System.lineSeparator();
		
		String projeto = "Nome: " + this.getNome() + FIM_DE_LINHA +
								"Data de inicio: " + this.getData() + FIM_DE_LINHA;
		
		boolean temCoordenador = false;
		
		for(Participacao participacao: this.participacoes) {
			if(participacao instanceof Professor) {
				if(((Professor) participacao).getCoordenador()) {
					projeto += "Coordenador: " + participacao.getPessoa() + FIM_DE_LINHA;
					temCoordenador = true;
				}
			}
		}
		
		if(temCoordenador == false) {
			projeto += "Coordenador: No momento nao tem coordenador." + FIM_DE_LINHA; 
		}
		
		
		projeto += "Situacao: " + this.getSituacao(); 
		
		return projeto;
	}
	
	
	



}