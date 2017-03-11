package projetos;

import java.util.HashSet;

import exception.CadastroException;
import exception.ValidacaoException;
import participacao.AlunoGraduando;
import participacao.Participacao;
import participacao.Professor;

public class PET extends Projeto {
	
	private int rendimento;
	private ImpactoSocial impactoSocial;
	private HashSet<Produtividade> produtividades;
	
	private boolean temTutor;
	

	
	public PET(String nomeDoProjeto, String objetivoDoProjeto, int impactoSocial, int rendimento,  String dataInicio, int duracao, int codigo) {
		super(nomeDoProjeto, objetivoDoProjeto, dataInicio, duracao, codigo);
		this.setImpacto(impactoSocial);
		this.rendimento = rendimento;
		produtividades = new HashSet<>();
		
	}
	
	
	public boolean setImpacto(int impacto) throws ValidacaoException {
		for (ImpactoSocial impac : ImpactoSocial.values()) {
			if(impac.getValorImpactoSocial() == impacto) {
				this.impactoSocial = impac;
				return true;
			}
		}
		
		throw new ValidacaoException("Impacto social invalido");
	}
	
	public String getProdutividades() {
		return produtividades.toString();
	}
	
	public String getProdutividade(String produtividade) {
		for(Produtividade p: produtividades) {
			if (p.getProdutividade().equalsIgnoreCase(produtividade)) {
				return String.valueOf(p.getQuantidade());
			}
		}
		return null;
	}
	
	
	
	public void adicionaProdutividade(String produtividade, int quantidade) {
		Produtividade p = new Produtividade(produtividade, quantidade);
		produtividades.add(p);
	}
	
	public int getRendimento(){
		return rendimento;
	}
	
	public String getImpactoSocial() {
		return impactoSocial.getImpactoSocial();
	}
	
	public void setBolsa(double valor) throws ValidacaoException, CadastroException {
		this.setDespesa("bolsa", valor);
	}
	
	public void setCusteio(double valor) throws ValidacaoException, CadastroException {
		this.setDespesa("custeio", valor);
	}
	
	public String getRepresentacaoRendimento() {
		return Integer.toString(this.getRendimento());
	}

	@Override
	public void adicionaParticipacao(Participacao participacaoASerAdicionada) throws CadastroException {
		if(super.ehProfessor(participacaoASerAdicionada)) {
			Professor prof = (Professor) participacaoASerAdicionada;
			if(prof.getCoordenador() && this.temTutor == false) {
				super.participacoes.add(participacaoASerAdicionada);
			} else {
				throw new CadastroException("Projetos PET nao podem ter mais de um coordenador");
			}
		} else if(participacaoASerAdicionada instanceof AlunoGraduando) {
			if(super.participacoes.contains(participacaoASerAdicionada)) {
				throw new CadastroException("Aluno ja esta cadastrado nesse projeto");
			}
			super.participacoes.add(participacaoASerAdicionada);
		}
		
	}
	
	public String getRepresentacaoProdutividade(String descricao) throws ValidacaoException {
		for(Produtividade produtividade: this.produtividades) {
			if(produtividade.getProdutividade().equals(descricao)) {
				return Integer.toString(produtividade.getQuantidade());
			}
		}
		
		throw new ValidacaoException("Projeto nao tem essa produtividade");
	}

}
