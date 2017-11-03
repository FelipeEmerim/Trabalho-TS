package trabalho_TS;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import br.edu.ifrs.canoas.Pojo.Visita;

public class VisitaTest {

	
//	String nome, String data, String tipo, boolean guia, String telefone, boolean conteudoP, 
//    boolean auxilio, String cidade, int hora, String curso, int num, String anoSemestre, 
//    String conteudo, int tempo
	
	@Test
	public void testa_cria_visita() {
		
		Visita v = new Visita("Felipe", "26/06/1998", "Inutil", true, "982979456", true, true, "Canoas", 14, "TADS", 4, "2017/2", "Nada", 30);
		assertThat(v.getNomeInstituicao()).as("Felipe");
	}

	@Test(expected = NullPointerException.class)
	public void cria_visita_campo_nulo(){
		try{
			Visita v = new Visita("Felipe", "26/06/1998", null, true, "982979456", true, true, "Canoas", 14, "TADS", 4, "2017/2", "Nada", 30);
		}catch(NullPointerException e){
			assertThat(e.getMessage()).as("Campo obrigatório com valor nulo");
			throw e;
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testa_cria_visita_campo_branco(){
		try{
			Visita v = new Visita("Felipe", "26/06/1998", "", true, "982979456", true, true, "Canoas", 14, "TADS", 4, "2017/2", "Nada", 30);
		}catch(IllegalArgumentException e){
			assertThat(e.getMessage()).as("Campo obrigatório não preenchido");
			throw e;
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testa_cria_visita_intervalo_invalido(){
		
		try{
			Visita v = new Visita("Felipe", "26/06/1998", "Inutil", true, "982979456", true, true, "Canoas", 14, "TADS", 4, "2017/2", "Nada", 35);
		}catch(IllegalArgumentException e){
			assertThat(e.getMessage()).as("A duração das visitas deve ser de 30 minutos");
			throw e;
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testa_cria_visita_visitantes_negativos(){
		try{
			Visita v = new Visita("Felipe", "26/06/1998", "Inutil", true, "982979456", true, true, "Canoas", 14, "TADS", -1, "2017/2", "Nada", 30);
		}catch(IllegalArgumentException e){
			assertThat(e.getMessage()).as("Valor inválido no campo número de visitantes");
			throw e;
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testa_cria_visita_hora_invalida(){
		
		try{
			Visita v = new Visita("Felipe", "26/06/1998", "Inutil", true, "982979456", true, true, "Canoas", 18, "TADS", 4, "2017/2", "Nada", 30);
		}catch(IllegalArgumentException e){
			assertThat(e.getMessage()).as("Valor inválido no campo hora");
			throw e;
		}
	}
	
	@Test
	public void testa_lista_dados(){
		
		Visita v = new Visita("Felipe", "26/06/1998", "Inutil", true, "982979456", true, true, "Canoas", 14, "TADS", 4, "2017/2", "Nada", 30);
		v.listaDados();
	}
}
