package trabalho_TS;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.Pojo.Usuario;
import br.edu.ifrs.canoas.Pojo.Visita;

public class UsuarioTest {
	
	Usuario usuario2;
	@Before
	public void setup(){
		usuario2= new Usuario ("Carina", "02080158", "moodle2017", "Eternia", "982686416", "51", 
		  		  "TIM", "34783615", "10 as 18h", "carinaemerim2@gmail.com");
	}

	@Test
	public void testa_cria_usuario() {
		
		Usuario usuario = new Usuario ("Carina", "02080158", "moodle2017", "Eternia", "982686416", "51", 
		  		  "TIM", "34783615", "10 as 18h", "carinaemerim2@gmail.com");
		
		assertThat(usuario.getNome()).as("Carina");
	}
	
	@Test(expected = NullPointerException.class)
	public void cria_usuario_campo_nulo(){
		try{
			Usuario usuario = new Usuario(null, "02080158", "moodle2017", "Eternia", "982686416", "51", 
			  		  "TIM", "34783615", "10 as 18h", "carinaemerim2@gmail.com");
		}catch(NullPointerException e){
			assertThat(e.getMessage()).as("Campo obrigatório com valor nulo.");
			throw e;
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testa_cria_usuario_campo_branco(){
		try{
			Usuario usuario = new Usuario("", "02080158", "moodle2017", "Eternia", "982686416", "51", 
			  		  "TIM", "34783615", "10 as 18h", "carinaemerim2@gmail.com");
		}catch(IllegalArgumentException e){
			assertThat(e.getMessage()).as("Campo obrigatório não preenchido");
			throw e;
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void cria_usuario_caracteres_invalidos(){
		try{
			Usuario usuario = new Usuario ("C@rin@", "02080158", "moodle2017", "Eternia", "982686416", "51", 
			  		  "TIM", "34783615", "10 as 18h", "carinaemerim2@gmail.com");
		} catch (IllegalArgumentException e){
			assertThat(e.getMessage()).as("Campo não aceita caracteres especiais.");
			throw e;
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void cria_usuario_letras_telefone(){
		try{
			Usuario usuario = new Usuario ("Carina", "02080158", "moodle2017", "Eternia", "98268641E", "51", 
			  		  "TIM", "34783615", "10 as 18h", "carinaemerim2@gmail.com");
		} catch (IllegalArgumentException e){
			assertThat(e.getMessage()).as("Campo só aceita números.");
			throw e;
		}
	}
	
	@Test
	public void testa_salva_visita(){
		
		Visita visita = mock(Visita.class);
		
		when(visita.getNomeInstituicao()).thenReturn("Felipe");
		
		
		usuario2.salvaVisita(visita);
		
		assertThat(usuario2.getVisitas().get(0).getNomeInstituicao()).as("Felipe");
	}
	
	@Test(expected = NullPointerException.class)
	public void testa_salva_visita_null(){
		
		try{
			usuario2.salvaVisita(null);
		}catch(NullPointerException e){
			assertThat(e.getMessage()).as("O valor de visita não pode ser null");
			throw e;
		}
	}
	
	@Test
	public void testa_exclui_visita(){
		
		Visita visita = mock(Visita.class);
		
		when(visita.getNomeInstituicao()).thenReturn("Felipe");
		when(visita.getDtVisita()).thenReturn("26/06/1998");
		when(visita.getHora()).thenReturn(14);
		
		
		usuario2.salvaVisita(visita);
		
		assertThat(usuario2.getVisitas()).hasSize(1);
		
		usuario2.excluiVisita("26/06/1998", 14);
		
		assertThat(usuario2.getVisitas()).hasSize(0);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testa_exclui_visita_data_nula(){
		
		try{
			
			usuario2.excluiVisita(null, 14);
		}catch(NullPointerException e){
			assertThat(e.getMessage()).as("Você informou uma data nula");
			throw e;
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testa_exclui_visita_data_invalida(){
		
		try{
			usuario2.excluiVisita("26/06/19998", 14);
		}catch(IllegalArgumentException e){
			assertThat(e.getMessage()).as("Você informou um valor inválido");
			throw e;
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testa_exclui_visita_hora_invalida(){
		
		try{
			usuario2.excluiVisita("26/06/1998", 8);
		}catch(IllegalArgumentException e){
			assertThat(e.getMessage()).as("Você informou um valor inválido");
			throw e;
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testa_exclui_visita_nao_encontrada(){
		
		Visita visita = mock(Visita.class);
		
		when(visita.getNomeInstituicao()).thenReturn("Felipe");
		when(visita.getDtVisita()).thenReturn("26/06/1998");
		when(visita.getHora()).thenReturn(14);
		
		usuario2.salvaVisita(visita);
		
		assertThat(usuario2.getVisitas()).hasSize(1);
		
		try{
			usuario2.excluiVisita("27/06/1998", 14);
		}catch(RuntimeException e){
			assertThat(usuario2.getVisitas()).hasSize(1);
			assertThat(e.getMessage()).as("Visita não encontrada");
			throw e;
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testa_edita_visita(){
		
		Visita visita = mock(Visita.class);
		
		when(visita.getNomeInstituicao()).thenReturn("Felipe");
		when(visita.getDtVisita()).thenReturn("26/06/1998");
		when(visita.getHora()).thenReturn(14);
		
		Visita visita2 = mock(Visita.class);
		when(visita.getNomeInstituicao()).thenReturn("Carina");
		when(visita.getDtVisita()).thenReturn("23/01/1990");
		when(visita.getHora()).thenReturn(16);
		
		
		usuario2.salvaVisita(visita);
		
		assertThat(usuario2.getVisitas()).hasSize(1);
		
		usuario2.editaVisita("26/06/1998", 14, visita2);
		assertThat(usuario2.getVisitas()).hasSize(1);
		assertThat(usuario2.getVisitas().get(0).getDtVisita()).as("23/01/1990");
	}
	
	@Test(expected = NullPointerException.class)
	public void testa_edita_visita_nula(){
		
		try{
			usuario2.editaVisita("26/06/1998", 14, null);
		}catch(NullPointerException e){
			
			assertThat(e.getMessage()).as("Você informou um parâmetro nulo");
			throw e;
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void testa_edita_visita_data_nula(){
		
		Visita visita = mock(Visita.class);
		
		try{
			usuario2.editaVisita(null, 14, visita);
		}catch(NullPointerException e){
			
			assertThat(e.getMessage()).as("Você informou um parâmetro nulo");
			throw e;
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testa_edita_visita_data_invalida(){
		
		Visita visita = mock(Visita.class);
		
		try{
			usuario2.editaVisita("26/06/19998", 14, visita);
		}catch(IllegalArgumentException e){
			assertThat(e.getMessage()).as("Você informou um valor inválido");
			throw e;
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testa_edita_visita_hora_invalida(){
		
		Visita visita = mock(Visita.class);
		
		try{
			usuario2.editaVisita("26/06/1999", 8, visita);
		}catch(IllegalArgumentException e){
			assertThat(e.getMessage()).as("Você informou um valor inválido");
			throw e;
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testa_edita_visita_nao_encontrada(){
		
		Visita visita = mock(Visita.class);
		when(visita.getNomeInstituicao()).thenReturn("Felipe");
		when(visita.getDtVisita()).thenReturn("26/06/1998");
		when(visita.getHora()).thenReturn(14);
		
		Visita visita2 = mock(Visita.class);
		when(visita.getNomeInstituicao()).thenReturn("Carina");
		when(visita.getDtVisita()).thenReturn("23/01/1990");
		when(visita.getHora()).thenReturn(16);
		
		usuario2.salvaVisita(visita);
		
		assertThat(usuario2.getVisitas()).hasSize(1);
		assertThat(usuario2.getVisitas().get(0).getNomeInstituicao()).as("Felipe");
		
		try{
			usuario2.editaVisita("27/06/1998", 14, visita2);
		}catch(RuntimeException e){
			assertThat(usuario2.getVisitas()).hasSize(1);
			assertThat(usuario2.getVisitas().get(0).getNomeInstituicao()).as("Felipe");
			assertThat(e.getMessage()).as("Visita não encontrada");
			throw e;
		}
	}
	
	@Test
	public void testa_deleta_usuarios(){
		
		
		assertThat(Usuario.getUsuarios()).hasAtLeastOneElementOfType(Usuario.class);
		Usuario.deletaUsuarios();
		assertThat(Usuario.getUsuarios()).hasSize(0);
		
	}
	
	@Test
	public void testa_consulta_visitas(){ //deve apenas os dados do usuário pois visita não foi implementada
		
		usuario2.consultaVisitas();
		
	}
	

}
