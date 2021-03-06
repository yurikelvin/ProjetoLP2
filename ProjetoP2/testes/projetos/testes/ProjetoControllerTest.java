package projetos.testes;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cdp.controllers.ProjetoController;
import cdp.exception.CadastroException;
import cdp.exception.DataException;
import cdp.exception.ValidacaoException;
import cdp.projetos.Monitoria;

public class ProjetoControllerTest {


	private ProjetoController projetoController;
	
	@Before
	public void setUP() throws ValidacaoException, ParseException, CadastroException, DataException{
		projetoController = new ProjetoController();
		
		projetoController.adicionaMonitoria("Monitoria Calculo 2", "Calculo", 20, "Ajudar os Alunos", "Segundo", "20/02/2017", 5);
		projetoController.adicionaPET("Projeto PET", "objetivo muito legal", 2, 50, 2,6,3, "21/02/2017", 5);
		projetoController.adicionaExtensao("Projeto Extensao","Ficar monstro",1,"22/02/2017",5);
		projetoController.adicionaPED("Projeto PED", "pibic", 1, 2, 3, "objetivo e ficar monstro", "25/02/2017", 5);
	}
	
	@Test
	public void testAdicionaMonitoria() {
		
		//Adicionando Monitoria com o nome Nulo
			try {
				projetoController.adicionaMonitoria(null, "Calculo", 20, "Ajudar os Alunos", "Segundo", "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Nome de monitoria nulo");
			} catch (Exception e) {
				Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
			}
		
		//Adicionando Monitoria com  o Nome Vazio
			try {
				projetoController.adicionaMonitoria("", "Calculo", 20, "Ajudar os Alunos", "Segundo", "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Nome de monitoria Vazio");				
				} catch (Exception e) {
					Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
				}
		
			
		//Adicionando Monitoria com apenas o Disciplina Nula
			try {
				projetoController.adicionaMonitoria("Monitoria Calculo 2", null, 20, "Ajudar os Alunos", "Segundo", "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Disciplina de monitoria nulo");
			} catch (Exception e) {
				Assert.assertEquals("Disciplina nulo ou vazio", e.getMessage());
			}
			
			
		//Adicionando Monitoria com apenas o Disciplina Vazio
			try {
				projetoController.adicionaMonitoria("Monitoria Calculo 2", "", 20, "Ajudar os Alunos", "Segundo", "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Disciplina de monitoria Vazio");
			} catch (Exception e) {
				Assert.assertEquals("Disciplina nulo ou vazio", e.getMessage());
			}
			
		//Adicionando Monitoria com apenas o Rendimento Negativo
			try {
				projetoController.adicionaMonitoria("Monitoria Calculo 2", "Calculo", -5, "Ajudar os Alunos", "Segundo", "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Rendimento de monitoria negativo");
			} catch (Exception e) {
				Assert.assertEquals("Rendimento invalido", e.getMessage());
			}
			
		//Adicionando Monitoria com apenas o Objetivo nulo
			try {
				projetoController.adicionaMonitoria("Monitoria Calculo 2", "Calculo", 5, null, "Segundo", "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Objetivo de monitoria Nulo");
			} catch (Exception e) {
				Assert.assertEquals("Objetivo nulo ou vazio", e.getMessage());
			}
			
		//Adicionando Monitoria com apenas o Objetivo Vazio
			try {
				projetoController.adicionaMonitoria("Monitoria Calculo 2", "Calculo", 5, "", "Segundo", "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Objetivo de monitoria Vazio");
			} catch (Exception e) {
				Assert.assertEquals("Objetivo nulo ou vazio", e.getMessage());
			}
			
		//Adicionando Monitoria com apenas o Perido nulo
			try {
				projetoController.adicionaMonitoria("Monitoria Calculo 2", "Calculo", 5, "Ajudar os alunos", null, "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Periodo de monitoria Nulo");
			} catch (Exception e) {
				Assert.assertEquals("Periodo nulo ou vazio", e.getMessage());
			}
			
		//Adicionando Monitoria com apenas o Perido Vazio
			try {
				projetoController.adicionaMonitoria("Monitoria Calculo 2", "Calculo", 5, "Ajudar os alunos", "", "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Periodo de monitoria Vazio");
			} catch (Exception e) {
				Assert.assertEquals("Periodo nulo ou vazio", e.getMessage());
			}
			
		//Adicionando Monitoria com apenas a Data fora da formatacao
			try {
				projetoController.adicionaMonitoria("Monitoria Calculo 2", "Calculo", 5, "Ajudar os alunos", "Segundo", "302/2017", 5);
				Assert.fail("Lancamento de Exception com a Data fora da formatacao");
			} catch (Exception e) {
				Assert.assertEquals("Data invalida.", e.getMessage());
			}
			
		//Adicionando Monitoria com apenas a Data Nula
			try {
				projetoController.adicionaMonitoria("Monitoria Calculo 2", "Calculo", 5, "Ajudar os alunos", "Segundo", null, 5);
				Assert.fail("Lancamento de Exception com a Data Nula");
			} catch (Exception e) {
				Assert.assertEquals("Data nula ou vazia", e.getMessage());
			}
			
		//Adicionando Monitoria com apenas a Data Vazia
			try {
				projetoController.adicionaMonitoria("Monitoria Calculo 2", "Calculo", 5, "Ajudar os alunos", "Segundo", "", 5);
				Assert.fail("Lancamento de Exception com a Data Vazia");
			} catch (Exception e) {
				Assert.assertEquals("Data nula ou vazia", e.getMessage());
			}
			
		//Adicionando Monitoria com apenas a duracao negativa
			try {
				projetoController.adicionaMonitoria("Monitoria Calculo 2", "Calculo", 5, "Ajudar os alunos", "Segundo", "25/02/2017", -5);
				Assert.fail("Lancamento de Exception com a duracao negativa");
			} catch (Exception e) {
				Assert.assertEquals("Duracao Invalida", e.getMessage());
			}
			
		//Adicionando Monitoria com apenas a duracao igual a zero
			try {
				projetoController.adicionaMonitoria("Monitoria Calculo 2", "Calculo", 5, "Ajudar os alunos", "Segundo", "25/02/2017", 0);
				Assert.fail("Lancamento de Exception com a duracao igual a 0");
			} catch (Exception e) {
				Assert.assertEquals("Duracao Invalida", e.getMessage());
			}
			
		
			
		
	
		
	}

	@Test
	public void testAdicionaPET() {
		
		//Adicionando PET com o nome Nulo
			try {
				projetoController.adicionaPET(null, "objetivo muito legal", 2, 20, 2,6,3, "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Nome de PET nulo");
			} catch (Exception e) {
				Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
		}
	
		//Adicionando PET com o nome Vazio
			try {
				projetoController.adicionaPET("", "objetivo mutio legal", 2, 20, 2,6,3, "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Nome de PET vazio");
				} catch (Exception e) {
					Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
				}
		
		//Adicionando PET com o OBjetivo nulo
			try {
				projetoController.adicionaPET("Birl", null, 2, 20, 2,6,3, "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Objetivo de PET nulo");
					} catch (Exception e) {
					Assert.assertEquals("Objetivo nulo ou vazio", e.getMessage());
						}
			
		//Adicionando PET com o OBjetivo vazio
			try {
				projetoController.adicionaPET("Birl", "", 2, 20, 2,6,3, "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Objetivo de PET vazio");
					} catch (Exception e) {
					Assert.assertEquals("Objetivo nulo ou vazio", e.getMessage());
						}
			
		//Adicionando PET com o Impacto negativo
			try {
				projetoController.adicionaPET("Birl", "objetivo legal", -2, 20, 2,6,3, "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Impacto de PET negativo");
					} catch (Exception e) {
					Assert.assertEquals("Impacto invalido", e.getMessage());
						}
			
		//Adicionando PET com o Rendimento negativo
			try {
				projetoController.adicionaPET("Birl", "objetivo legal", 2, -20, 2,6,3, "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com Rendimento de PET negativo");
					} catch (Exception e) {
					Assert.assertEquals("Rendimento invalido", e.getMessage());
						}
			
		//Adicionando PET com a Producao tecnica negativo
			try {
				projetoController.adicionaPET("Birl", "objetivo legal", 2, 20, -2,6,3, "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com a producao tecnica de PET negativo");
					} catch (Exception e) {
					Assert.assertEquals("Numero de producoes tecnicas invalido", e.getMessage());
						}
			
		//Adicionando PET com a Producao academica negativo
			try {
				projetoController.adicionaPET("Birl", "objetivo legal", 2, 20, 2, -6, 3, "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com a producao academica de PET negativo");
					} catch (Exception e) {
					Assert.assertEquals("Numero de producoes academicas invalido", e.getMessage());
						}
			
		//Adicionando PET com a Producao academica negativo
			try {
				projetoController.adicionaPET("Birl", "objetivo legal", 2, 20, 2, 6, -3, "25/02/2017", 5);
				Assert.fail("Lancamento de Exception com patentes de PET negativo");
					} catch (Exception e) {
					Assert.assertEquals("Numero de patentes invalido", e.getMessage());
						}
			
		//Adicionando PET com a Data na formatacao errada
			try {
				projetoController.adicionaPET("Birl", "objetivo legal", 2, 20, 2, 6, 3, "2502/2017", 5);
				Assert.fail("Lancamento de Exception a Data de PET na formatacao errada");
					} catch (Exception e) {
					Assert.assertEquals("Data invalida.", e.getMessage());
						}
			
		//Adicionando PET com a Data nula
			try {
				projetoController.adicionaPET("Birl", "objetivo legal", 2, 20, 2, 6, 3, null, 5);
				Assert.fail("Lancamento de Exception a Data de PET nula");
					} catch (Exception e) {
					Assert.assertEquals("Data nula ou vazia", e.getMessage());
						}
			
		//Adicionando PET com a Data vazia
			try {
				projetoController.adicionaPET("Birl", "objetivo legal", 2, 20, 2, 6, 3, "", 5);
				Assert.fail("Lancamento de Exception a Data de PET vazia");
					} catch (Exception e) {
					Assert.assertEquals("Data nula ou vazia", e.getMessage());
						}
			
		//Adicionando PET com a duracao igual a zero
			try {
				projetoController.adicionaPET("Birl", "objetivo legal", 2, 20, 2, 6, 3, "25/02/2017", 0);
				Assert.fail("Lancamento de Exception de duracao de PET igual a zero");
					} catch (Exception e) {
					Assert.assertEquals("Duracao invalida", e.getMessage());
						}
			
		//Adicionando PET com a duracao negativa
			try {
				projetoController.adicionaPET("Birl", "objetivo legal", 2, 20, 2, 6, 3, "25/02/2017", -5);
				Assert.fail("Lancamento de Exception de duracao de PET negativa");
					} catch (Exception e) {
					Assert.assertEquals("Duracao invalida", e.getMessage());
						}
		
	
	}

	@Test
	public void testAdicionaExtensao() {
		
		//Adicionando Extensao com o nome Nulo
		try {
			projetoController.adicionaExtensao(null,"Ficar monstro",1,"25/02/2017",5);
			Assert.fail("Lancamento de Exception com Nome de Extensao nulo");
		} catch (Exception e) {
			Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
	}
		
		//Adicionando Extensao com o nome Nulo
				try {
					projetoController.adicionaExtensao("","Ficar monstro",1,"25/02/2017",5);
					Assert.fail("Lancamento de Exception com Nome de Extensao vazio");
				} catch (Exception e) {
					Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
			}
				
		//Adicionando Extensao com o Objetivo Nulo
				try {
					projetoController.adicionaExtensao("Birl",null,1,"25/02/2017",5);
					Assert.fail("Lancamento de Exception com Objetivo de Extensao nulo");
				} catch (Exception e) {
					Assert.assertEquals("Objetivo nulo ou vazio", e.getMessage());
			}	
				
		//Adicionando Extensao com o Objetivo Nulo
				try {
					projetoController.adicionaExtensao("Birl","",1,"25/02/2017",5);
					Assert.fail("Lancamento de Exception com Objetivo de Extensao vazio");
				} catch (Exception e) {
					Assert.assertEquals("Objetivo nulo ou vazio", e.getMessage());
			}
				
		//Adicionando Extensao com o Impacto Negativo
				try {
					projetoController.adicionaExtensao("Birl","Ficar monstro",-1,"25/02/2017",5);
					Assert.fail("Lancamento de Exception com Impacto de Extensao negativo");
				} catch (Exception e) {
					Assert.assertEquals("Impacto invalido", e.getMessage());
			}
				
		//Adicionando Extensao com a data na formatacao errada
				try {
					projetoController.adicionaExtensao("Birl","Ficar monstro",1,"2502/2017",5);
					Assert.fail("Lancamento de Exception com a data de extensao na formatacao errada ");
				} catch (Exception e) {
					Assert.assertEquals("Data invalida.", e.getMessage());
			}
				
		//Adicionando Extensao com a data nula
				try {
					projetoController.adicionaExtensao("Birl","Ficar monstro",1,null,5);
					Assert.fail("Lancamento de Exception com a data de extensao nula ");
				} catch (Exception e) {
					Assert.assertEquals("Data nula ou vazia", e.getMessage());
			}
				
		//Adicionando Extensao com a data vazia
				try {
					projetoController.adicionaExtensao("Birl","Ficar monstro",1,null,5);
					Assert.fail("Lancamento de Exception com a data de extensao vazia ");
				} catch (Exception e) {
					Assert.assertEquals("Data nula ou vazia", e.getMessage());
			}
				
		//Adicionando Extensao com a duracao igual a zero
				try {
					projetoController.adicionaExtensao("Birl","Ficar monstro",1,"25/02/2017",0);
					Assert.fail("Lancamento de Exception com a duracao de extensao igual a zero ");
				} catch (Exception e) {
					Assert.assertEquals("Duracao invalida", e.getMessage());
			}
				
		//Adicionando Extensao com a duracao igual a zero
				try {
					projetoController.adicionaExtensao("Birl","Ficar monstro",1,"25/02/2017",-5);
					Assert.fail("Lancamento de Exception com a duracao de extensao igual a zero ");
				} catch (Exception e) {
					Assert.assertEquals("Duracao invalida", e.getMessage());
			}
				
	}

	@Test
	public void testAdicionaPED() {
		
		//Adicionando PED com o nome Nulo
				try {
					projetoController.adicionaPED(null, "pibic", 1, 2, 3, "objetivo é ficar monstro", "25/02/2017", 5);
					Assert.fail("Lancamento de Exception com Nome de PED nulo");
				} catch (Exception e) {
					Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
			}
				
		//Adicionando PED com o nome Nulo
				try {
					projetoController.adicionaPED("", "pibic", 1, 2, 3, "objetivo é ficar monstro", "25/02/2017", 5);
					Assert.fail("Lancamento de Exception com Nome de PED vazio");
				} catch (Exception e) {
					Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
			}
				
		//Adicionando PED com o categoria Nulo
				try {
					projetoController.adicionaPED("Birl", null, 1, 2, 3, "objetivo é ficar monstro", "25/02/2017", 5);
					Assert.fail("Lancamento de Exception com categoria de PED nula");
				} catch (Exception e) {
					Assert.assertEquals("Categoria invalida", e.getMessage());
			}
				
		//Adicionando PED com o categoria vazio
				try {
					projetoController.adicionaPED("Birl", "", 1, 2, 3, "objetivo é ficar monstro", "25/02/2017", 5);
					Assert.fail("Lancamento de Exception com categoria de PED vazio");
				} catch (Exception e) {
					Assert.assertEquals("Categoria invalida", e.getMessage());
			}
				
		//Adicionando PED com o numero de producoes tecnicas negativa
				try {
					projetoController.adicionaPED("Birl", "pibic", -1, 2, 3, "objetivo é ficar monstro", "25/02/2017", 5);
					Assert.fail("Lancamento de Exception com numero de producoes tecnica  de PED negativo");
				} catch (Exception e) {
					Assert.assertEquals("Numero de producoes tecnicas invalido", e.getMessage());
			}
				
		//Adicionando PED com o numero de producoes academica negativa
				try {
					projetoController.adicionaPED("Birl", "pibic", 1, -2, 3, "objetivo é ficar monstro", "25/02/2017", 5);
					Assert.fail("Lancamento de Exception com numero de producoes academica  de PED negativo");
				} catch (Exception e) {
					Assert.assertEquals("Numero de producoes academicas invalido", e.getMessage());
			}
				
		//Adicionando PED com o numero de patentes negativa
				try {
					projetoController.adicionaPED("Birl", "pibic", 1, 2, -3, "objetivo é ficar monstro", "25/02/2017", 5);
					Assert.fail("Lancamento de Exception com numero de patentes  de PED negativo");
				} catch (Exception e) {
					Assert.assertEquals("Numero de patentes invalido", e.getMessage());
			}
				
		//Adicionando PED com o objetivo nulo
				try {
					projetoController.adicionaPED("Birl", "pibic", 1, 2, 3, null, "25/02/2017", 5);
					Assert.fail("Lancamento de Exception com o objetivo de PED nulo");
				} catch (Exception e) {
					Assert.assertEquals("Objetivo nulo ou vazio", e.getMessage());
			}
				
		//Adicionando PED com o objetivo nulo
				try {
					projetoController.adicionaPED("Birl", "pibic", 1, 2, 3, "", "25/02/2017", 5);
					Assert.fail("Lancamento de Exception com o objetivo de PED vazio");
				} catch (Exception e) {
					Assert.assertEquals("Objetivo nulo ou vazio", e.getMessage());
			}
				
		//Adicionando PED com a data fora da formatacao
				try {
					projetoController.adicionaPED("Birl", "pibic", 1, 2, 3, "objetivo ficar monstrao", "2502/2017", 5);
					Assert.fail("Lancamento de Exception com a data de PED fora de formatacao");
				} catch (Exception e) {
					Assert.assertEquals("Data invalida.", e.getMessage());
			}
				
		//Adicionando PED com a data nula
				try {
					projetoController.adicionaPED("Birl", "pibic", 1, 2, 3, "objetivo ficar monstrao", null, 5);
					Assert.fail("Lancamento de Exception com a data de PED nula");
				} catch (Exception e) {
					Assert.assertEquals("Data nula ou vazia", e.getMessage());
			}
				
		//Adicionando PED com a data vazia
				try {
					projetoController.adicionaPED("Birl", "pibic", 1, 2, 3, "objetivo ficar monstrao", "", 5);
					Assert.fail("Lancamento de Exception com a data de PED vazia");
				} catch (Exception e) {
					Assert.assertEquals("Data nula ou vazia", e.getMessage());
			}
				
		//Adicionando PED com a data vazia
				try {
					projetoController.adicionaPED("Birl", "pibic", 1, 2, 3, "objetivo ficar monstrao", "25/02/2017", -5);
					Assert.fail("Lancamento de Exception com a duracao de PED negativa");
				} catch (Exception e) {
					Assert.assertEquals("Duracao invalida", e.getMessage());
			}
	}

	@Test
	public void testGetInfoProjeto() throws ValidacaoException, ParseException, CadastroException {
		
		
		//Tentando fazer o getInfo como o codigo negativo
			try {
				projetoController.getInfoProjeto(-1, "nome");
				Assert.fail("Lancamento de Exception do getInfo com o codigo negativo");
		} catch (Exception e) {
			Assert.assertEquals("Codigo invalido", e.getMessage());
	}
			
		//Tentando fazer o getInfo como o atributo nulo
			try {
				projetoController.getInfoProjeto(1, null);
				Assert.fail("Lancamento de Exception do getInfo com o atributo nulo");
		} catch (Exception e) {
			Assert.assertEquals("Atributo nulo ou invalido", e.getMessage());
	}
			
		//Ultilizando o getInfo para acessar o nome dos projetos
			Assert.assertEquals("Monitoria Calculo 2", projetoController.getInfoProjeto(1, "nome"));
			Assert.assertEquals("Projeto PET", projetoController.getInfoProjeto(2, "nome"));
			Assert.assertEquals("Projeto Extensao", projetoController.getInfoProjeto(3, "nome"));
			Assert.assertEquals("Projeto PED", projetoController.getInfoProjeto(4, "nome"));
			
		//Ultilizando o getInfo para acessar o Objetivo dos projetos
			Assert.assertEquals("Ajudar os Alunos", projetoController.getInfoProjeto(1, "objetivo"));
			Assert.assertEquals("objetivo muito legal", projetoController.getInfoProjeto(2, "objetivo"));
			Assert.assertEquals("Ficar monstro", projetoController.getInfoProjeto(3, "objetivo"));
			Assert.assertEquals("objetivo e ficar monstro", projetoController.getInfoProjeto(4, "objetivo"));
			
		//Ultilizando o getInfo para acessar a data de inicio dos projetos
			Assert.assertEquals("20/02/2017", projetoController.getInfoProjeto(1, "data de inicio"));
			Assert.assertEquals("21/02/2017", projetoController.getInfoProjeto(2, "data de inicio"));
			Assert.assertEquals("22/02/2017", projetoController.getInfoProjeto(3, "data de inicio"));
			Assert.assertEquals("25/02/2017", projetoController.getInfoProjeto(4, "data de inicio"));
			
		//Ultilizando o getInfo para acessar a Disciplina
			//Monitoria
			Assert.assertEquals("Calculo", projetoController.getInfoProjeto(1, "disciplina"));
			
			//PET
			try {
				projetoController.getInfoProjeto(2, "disciplina");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar disciplina em PET");
			} catch (Exception e) {
				Assert.assertEquals("PET nao possui disciplina", e.getMessage());
			}
			
			//Extensao
			try {
				projetoController.getInfoProjeto(3, "disciplina");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar disciplina em Extensao");
			} catch (Exception e) {
				Assert.assertEquals("Extensao nao possui disciplina", e.getMessage());
			}
			
			//PED
			try {
				projetoController.getInfoProjeto(4, "disciplina");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar disciplina em PED");
			} catch (Exception e) {
				Assert.assertEquals("PED nao possui disciplina", e.getMessage());
			}
			
		//Ultilizando o getInfo para acessar o Rendimento
			
			//Monitoria
			Assert.assertEquals("20", projetoController.getInfoProjeto(1, "rendimento"));
			
			//PET
			Assert.assertEquals("50", projetoController.getInfoProjeto(2, "rendimento"));
			
			//Extensao
			try {
				projetoController.getInfoProjeto(3, "rendimento");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar rendimento em Extensao");
			} catch (Exception e) {
				Assert.assertEquals("Extensao nao possui rendimento", e.getMessage());
			}
			
			//PED
			try {
				projetoController.getInfoProjeto(4, "rendimento");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar rendimento em PED");
			} catch (Exception e) {
				Assert.assertEquals("PED nao possui rendimento", e.getMessage());
			}
			
		//Ultilizando o getInfo para acessar o periodo
			
			//Monitoria
			Assert.assertEquals("Segundo", projetoController.getInfoProjeto(1, "periodo"));
			
			//PET
			try {
				projetoController.getInfoProjeto(2, "periodo");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar periodo em PET");
			} catch (Exception e) {
				Assert.assertEquals("PET nao possui periodo", e.getMessage());
			}
			
			//Extensao
			try {
				projetoController.getInfoProjeto(3, "periodo");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar periodo em Extensao");
			} catch (Exception e) {
				Assert.assertEquals("Extensao nao possui periodo", e.getMessage());
			}
			
			//PED
			try {
				projetoController.getInfoProjeto(4, "periodo");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar periodo em PED");
			} catch (Exception e) {
				Assert.assertEquals("PED nao possui periodo", e.getMessage());
			}
			
		//Ultilizando o getInfo para acessar a duracao
			Assert.assertEquals("5", projetoController.getInfoProjeto(1, "duracao"));
			Assert.assertEquals("5", projetoController.getInfoProjeto(2, "duracao"));
			Assert.assertEquals("5", projetoController.getInfoProjeto(3, "duracao"));
			Assert.assertEquals("5", projetoController.getInfoProjeto(4, "duracao"));
			
			
		//Ultilizando o getInfo para acessar o Impacto
			
			//Monitoria
			try {
				projetoController.getInfoProjeto(1, "impacto");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar impacto de monitoria");
			} catch (Exception e) {
				Assert.assertEquals("Monitoria nao possui impacto", e.getMessage());
			}
			
			//PET
			Assert.assertEquals("Cidade", projetoController.getInfoProjeto(2, "impacto"));
			
			//Extensao
			Assert.assertEquals("Comunidade Academica", projetoController.getInfoProjeto(3, "impacto"));
			
			//PED
			try {
				projetoController.getInfoProjeto(4, "impacto");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar impacto em PED");
			} catch (Exception e) {
				Assert.assertEquals("PED nao possui impacto", e.getMessage());
			}
			
		//Ultilizando o getInfo para acessar Producao tecnica
			
			//Monitoria
			try {
				projetoController.getInfoProjeto(1, "producao tecnica");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar producao tecnica em Monitoria");
			} catch (Exception e) {
				Assert.assertEquals("Monitoria nao possui producao tecnica", e.getMessage());
			}
			
			//PET
			Assert.assertEquals("2", projetoController.getInfoProjeto(2, "producao tecnica"));
			
			//Extensao
			try {
				projetoController.getInfoProjeto(3, "producao tecnica");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar producao tecnica em Extensao");
			} catch (Exception e) {
				Assert.assertEquals("Extensao nao possui producao tecnica", e.getMessage());
			}
			
			//PED
			Assert.assertEquals("1", projetoController.getInfoProjeto(4, "producao tecnica"));
			
		
			//Ultilizando o getInfo para acessar Producao academica
			
				//Monitoria
				try {
				projetoController.getInfoProjeto(1, "producao academica");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar producao academica em Monitoria");
				} catch (Exception e) {
				Assert.assertEquals("Monitoria nao possui producao academica", e.getMessage());
				}
			
				//PET
				Assert.assertEquals("6", projetoController.getInfoProjeto(2, "producao academica"));
			
				//Extensao
				try {
					projetoController.getInfoProjeto(3, "producao academica");
					Assert.fail("Lancamento de Exception do getInfo: Tentando acessar producao academica em Extensao");
				} catch (Exception e) {
					Assert.assertEquals("Extensao nao possui producao academica", e.getMessage());
				}
			
				//PED
				Assert.assertEquals("2", projetoController.getInfoProjeto(4, "producao academica"));
				
				
		//Ultilizando o getInfo para acessar Patentes
				
				//Monitoria
				try {
				projetoController.getInfoProjeto(1, "patentes");
				Assert.fail("Lancamento de Exception do getInfo: Tentando acessar patentes em Monitoria");
				} catch (Exception e) {
				Assert.assertEquals("Monitoria nao possui patentes", e.getMessage());
				}
			
				//PET
				Assert.assertEquals("3", projetoController.getInfoProjeto(2, "patentes"));
			
				//Extensao
				try {
					projetoController.getInfoProjeto(3, "patentes");
					Assert.fail("Lancamento de Exception do getInfo: Tentando acessar patentes em Extensao");
				} catch (Exception e) {
					Assert.assertEquals("Extensao nao possui patentes", e.getMessage());
				}
			
				//PED
				Assert.assertEquals("3", projetoController.getInfoProjeto(4, "patentes"));
			
		//Ultilizando o getInfo para acessar Patentes

				//Monitoria
				try {
					projetoController.getInfoProjeto(1, "categoria");
					Assert.fail("Lancamento de Exception do getInfo: Tentando acessar categoria em Monitoria");
				} catch (Exception e) {
					Assert.assertEquals("Monitoria nao possui categoria", e.getMessage());
				}
				
				//PET
				try {
					projetoController.getInfoProjeto(2, "categoria");
					Assert.fail("Lancamento de Exception do getInfo: Tentando acessar categoria em PET");
				} catch (Exception e) {
					Assert.assertEquals("PET nao possui categoria", e.getMessage());
				}
				
				
				//Extensao
				try {
					projetoController.getInfoProjeto(3, "categoria");
					Assert.fail("Lancamento de Exception do getInfo: Tentando acessar categoria em Extensao");
				} catch (Exception e) {
					Assert.assertEquals("Extensao nao possui categoria", e.getMessage());
				}
				
				//PED
				Assert.assertEquals("pibic", projetoController.getInfoProjeto(4, "categoria"));
				
		//Ultilizando o getInfo para acessar um atributo invalido
				try {
					projetoController.getInfoProjeto(3, "Kappa");
					Assert.fail("Lancamento de Exception do getInfo: Tentando acessar atributo invalido");
				} catch (Exception e) {
					Assert.assertEquals("Atributo nulo ou invalido", e.getMessage());
				}
				
				
	}

		
	@Test
	public void testGetProjetos() throws DataException, CadastroException {
		//Tentando fazer o getProjetos como o codigo negativo
			try {
			projetoController.getProjetos(5);
			Assert.fail("Lancamento de Exception do getProjetos com o codigo de um projeto que n existe");
			} catch (Exception e) {
			Assert.assertEquals("Projeto nao encontrado", e.getMessage());
			
			//Fazendo o get do  projeto
			Monitoria monitoria = new Monitoria("Monitoria Calculo 2", "Calculo", 20, "Ajudar os Alunos", "Segundo", "20/02/2017", 5, 1);
			Assert.assertEquals(monitoria.getNome(), projetoController.getProjetos(1).getNome());
			
			
}

	}

	
	@Test
	public void testEditaProjeto() throws ValidacaoException, CadastroException, ParseException, DataException {
	
		//Tentando fazer o editaInfo com o codigo negativo
				try {
					projetoController.editaProjeto(-1, "nome", "Exemplo");
					Assert.fail("Lancamento de Exception do getInfo com o codigo invalido");
				} catch (Exception e) {
					Assert.assertEquals("Codigo invalido", e.getMessage());
			}
		
		
		//Tentando fazer o editaInfo com o atributo nulo
		try {
			projetoController.editaProjeto(1, null, "Exemplo");
			Assert.fail("Lancamento de Exception do getInfo com o atributo nulo");
		} catch (Exception e) {
			Assert.assertEquals("Atributo nao pode ser vazio ou invalido", e.getMessage());
	}
		
		//Tentando fazer editaInfo com o atributo vazio
		try {
			projetoController.editaProjeto(1, "", "Exemplo");
			Assert.fail("Lancamento de Exception do getInfo com o atributo vazio");
		} catch (Exception e) {
			Assert.assertEquals("Atributo nao pode ser vazio ou invalido", e.getMessage());
	}
		
		//Ultilizando o editaInfo: nome dos projetos
			
			//Monitoria
			projetoController.editaProjeto(1, "nome", "Kappa");
			Assert.assertEquals("Kappa", projetoController.getInfoProjeto(1, "nome"));
			
			//PET
			projetoController.editaProjeto(2, "nome", "Cabalo");
			Assert.assertEquals("Cabalo", projetoController.getInfoProjeto(2, "nome"));
			
			//Extensao
			projetoController.editaProjeto(3, "nome", "Hastad");
			Assert.assertEquals("Hastad", projetoController.getInfoProjeto(3, "nome"));
			
			//PED
			projetoController.editaProjeto(4, "nome", "Gugiba");
			Assert.assertEquals("Gugiba", projetoController.getInfoProjeto(4, "nome"));
			
		//Ultilizando o editaInfo: Objetivo dos projetos
			
			//Monitoria
			projetoController.editaProjeto(1, "objetivo", "Kappa");
			Assert.assertEquals("Kappa", projetoController.getInfoProjeto(1, "objetivo"));
			
			//PET
			projetoController.editaProjeto(2, "objetivo", "Cabalo");
			Assert.assertEquals("Cabalo", projetoController.getInfoProjeto(2, "objetivo"));
			
			//Extensao
			projetoController.editaProjeto(3, "objetivo", "Hastad");
			Assert.assertEquals("Hastad", projetoController.getInfoProjeto(3, "objetivo"));
			
			//PED
			projetoController.editaProjeto(4, "objetivo", "Gugiba");
			Assert.assertEquals("Gugiba", projetoController.getInfoProjeto(4, "objetivo"));
		
		//Ultilizando o EditaInfo: Disciplina
			
			//Monitoria
			projetoController.editaProjeto(1, "disciplina", "Kappa");
			Assert.assertEquals("Kappa", projetoController.getInfoProjeto(1, "disciplina"));
			
			//PET
			try {
				projetoController.editaProjeto(2, "disciplina", "Cabalo");
				Assert.fail("Laçando Exception de EditaProjeto: Disciplina em PET");
			} catch (Exception e) {
				Assert.assertEquals("PET nao possui disciplina", e.getMessage());
			}
			
			
		 //Extensao
			try {
				projetoController.editaProjeto(3, "disciplina", "terceiro");
				Assert.fail("Lancamento de Exception do EditaInfo: disciplina em Extensao");
			} catch (Exception e) {
				Assert.assertEquals("Extensao nao possui disciplina", e.getMessage());
			}
			
			//PED
			try {
				projetoController.editaProjeto(4, "disciplina", "Gugiba");
				Assert.fail("Lancamento de Exception do EditaInfo: disciplina em PED");
			} catch (Exception e) {
				Assert.assertEquals("PED nao possui disciplina", e.getMessage());
			}
			
		//Ultilizando o EditaInfo: Periodo
			
			//Monitoria
			projetoController.editaProjeto(1, "periodo", "Kappa");
			Assert.assertEquals("Kappa", projetoController.getInfoProjeto(1, "periodo"));
			
			//PET
			try {
				projetoController.editaProjeto(2, "periodo", "Cabalo");
				Assert.fail("Laçando Exception de EditaProjeto: periodo em PET");
			} catch (Exception e) {
				Assert.assertEquals("PET nao possui periodo", e.getMessage());
			}
			
			
		 //Extensao
			try {
				projetoController.editaProjeto(3, "periodo", "Hastad");
				Assert.fail("Lancamento de Exception do EditaInfo: periodo em Extensao");
			} catch (Exception e) {
				Assert.assertEquals("Extensao nao possui periodo", e.getMessage());
			}
			
			//PED
			try {
				projetoController.editaProjeto(4, "periodo", "Gugiba");
				Assert.fail("Lancamento de Exception do EditaInfo: periodo em PED");
			} catch (Exception e) {
				Assert.assertEquals("PED nao possui periodo", e.getMessage());
			}
			
			
       //Ultilizando o editaInfo: Data de inicio dos projetos
			
			//Monitoria
			projetoController.editaProjeto(1, "data de inicio", "28/02/2015");
			Assert.assertEquals("28/02/2015", projetoController.getInfoProjeto(1, "data de inicio"));
			
			//PET
			projetoController.editaProjeto(2, "data de inicio", "28/02/2015");
			Assert.assertEquals("28/02/2015", projetoController.getInfoProjeto(2, "data de inicio"));
			
			//Extensao
			projetoController.editaProjeto(3, "data de inicio", "28/02/2015");
			Assert.assertEquals("28/02/2015", projetoController.getInfoProjeto(3, "data de inicio"));
			
			//PED
			projetoController.editaProjeto(4, "data de inicio", "28/02/2015");
			Assert.assertEquals("28/02/2015", projetoController.getInfoProjeto(4, "data de inicio"));
			
			
      //Ultilizando o EditaInfo: Categoria
			
			//Monitoria
			try {
				projetoController.editaProjeto(1, "categoria", "pivic");
				Assert.fail("Laçando Exception de EditaProjeto: categoria em Monitoria");
			} catch (Exception e) {
				Assert.assertEquals("Monitoria nao possui categoria", e.getMessage());
			}
			
			//PET
			try {
				projetoController.editaProjeto(2, "categoria", "pivic");
				Assert.fail("Laçando Exception de EditaProjeto: categoria em PET");
			} catch (Exception e) {
				Assert.assertEquals("PET nao possui categoria", e.getMessage());
			}
			
			
		 //Extensao
			try {
				projetoController.editaProjeto(3, "categoria", "pivic");
				Assert.fail("Lancamento de Exception do EditaInfo: categoria em Extensao");
			} catch (Exception e) {
				Assert.assertEquals("Extensao nao possui categoria", e.getMessage());
			}
			
			//PED
			projetoController.editaProjeto(4, "categoria", "pivic");
			Assert.assertEquals("pivic", projetoController.getInfoProjeto(4, "categoria"));
			
			
		//Ultilizando o editaInfo: duracao dos projetos
			
			//Monitoria
			projetoController.editaProjeto(1, "duracao", "3");
			Assert.assertEquals("3", projetoController.getInfoProjeto(1, "duracao"));
			
			//PET
			projetoController.editaProjeto(2, "duracao", "3");
			Assert.assertEquals("3", projetoController.getInfoProjeto(2, "duracao"));
			
			//Extensao
			projetoController.editaProjeto(3, "duracao", "3");
			Assert.assertEquals("3", projetoController.getInfoProjeto(3, "duracao"));
			
			//PED
			projetoController.editaProjeto(4, "duracao", "3");
			Assert.assertEquals("3", projetoController.getInfoProjeto(4, "duracao"));
			
		//Ultilizando o editaInfo: Impacto
			
			//Monitoria
			try {
				projetoController.editaProjeto(1, "Impacto", "3");
				Assert.fail("Laçando Exception de EditaProjeto: Impacto em Monitoria");
			} catch (Exception e) {
				Assert.assertEquals("Monitoria nao possui impacto", e.getMessage());
			}
			
			//PET
			projetoController.editaProjeto(2, "Impacto", "3");
			Assert.assertEquals("Regional (Dentro do Estado)", projetoController.getInfoProjeto(2, "Impacto"));
			
			//Extensao
			projetoController.editaProjeto(3, "Impacto", "3");
			Assert.assertEquals("Regional (Dentro do Estado)", projetoController.getInfoProjeto(3, "Impacto"));
			
			//PED
			try {
				projetoController.editaProjeto(4, "Impacto", "3");
				Assert.fail("Lancamento de Exception do EditaInfo: impacto em PED");
			} catch (Exception e) {
				Assert.assertEquals("PED nao possui impacto", e.getMessage());
			}
			
			
		//Ultilizando o editaInfo: producao tecnica
			
			//Monitoria
			try {
				projetoController.editaProjeto(1, "producao tecnica", "3");
				Assert.fail("Laçando Exception de EditaProjeto: producao tecnica em Monitoria");
			} catch (Exception e) {
				Assert.assertEquals("Monitoria nao possui producao tecnica", e.getMessage());
			}
			
			//PET
			projetoController.editaProjeto(2, "producao tecnica", "3");
			Assert.assertEquals("3", projetoController.getInfoProjeto(2, "producao tecnica"));
			
			//Extensao
			try {
				projetoController.editaProjeto(3, "producao tecnica", "3");
				Assert.fail("Lancamento de Exception do EditaInfo: producao tecnica em Extensao");
			} catch (Exception e) {
				Assert.assertEquals("Extensao nao possui producao tecnica", e.getMessage());
			}
			
			//PED
			projetoController.editaProjeto(4, "producao tecnica", "3");
			Assert.assertEquals("3", projetoController.getInfoProjeto(4, "producao tecnica"));
			
		//Ultilizando o editaInfo: producao academica
			
			//Monitoria
			try {
				projetoController.editaProjeto(1, "producao academica", "3");
				Assert.fail("Laçando Exception de EditaProjeto: producao academica em Monitoria");
			} catch (Exception e) {
				Assert.assertEquals("Monitoria nao possui producao academica", e.getMessage());
			}
			
			//PET
			projetoController.editaProjeto(2, "producao academica", "3");
			Assert.assertEquals("3", projetoController.getInfoProjeto(2, "producao academica"));
			
			//Extensao
			try {
				projetoController.editaProjeto(3, "producao academica", "3");
				Assert.fail("Lancamento de Exception do EditaInfo: producao academica em Extensao");
			} catch (Exception e) {
				Assert.assertEquals("Extensao nao possui producao academica", e.getMessage());
			}
			
			//PED
			projetoController.editaProjeto(4, "producao academica", "3");
			Assert.assertEquals("3", projetoController.getInfoProjeto(4, "producao academica"));
			
        //Ultilizando o editaInfo: patentes
			
			//Monitoria
			try {
				projetoController.editaProjeto(1, "patentes", "3");
				Assert.fail("Laçando Exception de EditaProjeto: patentes em Monitoria");
			} catch (Exception e) {
				Assert.assertEquals("Monitoria nao possui patentes", e.getMessage());
			}
			
			//PET
			projetoController.editaProjeto(2, "patentes", "3");
			Assert.assertEquals("3", projetoController.getInfoProjeto(2, "patentes"));
			
			//Extensao
			try {
				projetoController.editaProjeto(3, "patentes", "3");
				Assert.fail("Lancamento de Exception do EditaInfo: patentes em Extensao");
			} catch (Exception e) {
				Assert.assertEquals("Extensao nao possui patentes", e.getMessage());
			}
			
			//PED
			projetoController.editaProjeto(4, "patentes", "3");
			Assert.assertEquals("3", projetoController.getInfoProjeto(4, "patentes"));
			
		
			
	}

	@Test
	public void testRemoveProjeto() throws CadastroException, ValidacaoException {
		
		//Fazendo o Remove com o codigo inválido
			try {
				projetoController.removeProjeto(-5);
				Assert.fail("Lancamento de Exception do removeProjetos com o codigo invalido");
			} catch (Exception e) {
				Assert.assertEquals("Codigo invalido", e.getMessage());
			}
			
		//Removendo Projeto
			projetoController.removeProjeto(1);
			
			try {
				projetoController.getProjetos(1);
				Assert.fail("Lancamento de Exception do removeProjetos");
				
			} catch (Exception e) {
				Assert.assertEquals("Projeto nao encontrado",e.getMessage());
			}
	}

	@Test
	public void testGetCodigoProjeto() throws CadastroException, ValidacaoException {
		
		//GetCodigoProjeto com o nome nulo
			try {
				projetoController.getCodigoProjeto(null);
				Assert.fail("Lancamento de Exception do getCodigo com nome nulo");
			} catch (Exception e) {
				Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
		}
		
		//GetCodigoProjeto com o nome vazio
				try {
					projetoController.getCodigoProjeto("");
					Assert.fail("Lancamento de Exception do getCodigo com nome vazio");
				} catch (Exception e) {
					Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
				}
				
		//GetCodigoProjeto do projeto de 1
				Assert.assertEquals(1, projetoController.getCodigoProjeto("Monitoria Calculo 2"));
				
		
		
	}

	@Test
	public void testPesquisaProjeto() throws CadastroException{
		
		//Codigo de projeto que invalido
			try {
				projetoController.pesquisaProjeto(-5);
				Assert.fail("Laçando Exception de PesquisaProjeto com codigo invalido");
			} catch (Exception e) {
				Assert.assertEquals("Projeto nao encontrado", e.getMessage());
			}
			
		//Pesquisando projeto que existe
			Assert.assertTrue(projetoController.pesquisaProjeto(1));
		
	}
}
