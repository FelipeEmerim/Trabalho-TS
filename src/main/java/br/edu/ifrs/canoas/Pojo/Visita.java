package br.edu.ifrs.canoas.Pojo;

public class Visita {

	private String nomeInstituicao;
	private String dtVisita;
	private String tipoInstituicao;
	private boolean guia;
	private String telefone;
	private boolean conteudoPlanejado;
	private boolean auxilioConteudo;
	private String cidade;
	private int hora;
	private String cursoVisitante;
	private int numVisitante;
	private String anoSemestre;
	private String conteudo;
	private int tempoVisita;
	
	public Visita(String nome, String data, String tipo, boolean guia, String telefone, boolean conteudoP, 
			      boolean auxilio, String cidade, int hora, String curso, int num, String anoSemestre, 
			      String conteudo, int tempo){
		
		if(nome == null || data == null || tipo == null || telefone == null || cidade == null ||
				curso == null||conteudo == null || anoSemestre == null){
			
			throw new NullPointerException("Campo obrigatório com valor nulo");
		}
		
		if(nome.isEmpty()||data.isEmpty()||tipo.isEmpty()||telefone.isEmpty()||cidade.isEmpty()||
				curso.isEmpty()||curso.isEmpty()||conteudo.isEmpty() || anoSemestre.isEmpty()){
			throw new IllegalArgumentException("Campo obrigatório não preenchido");
		}
		
		if(tempo != 30){
			throw new IllegalArgumentException("A duração das visitas deve ser de 30 minutos");
		}
		
		if(num <= 0){
			throw new IllegalArgumentException("Valor inválido no campo número de visitantes");
		}
		
		if(hora < 10 || hora > 16){
			
			throw new IllegalArgumentException("Valor inválido no campo hora");
		}
		
		this.nomeInstituicao = nome;
		this.dtVisita = data;
		this.tipoInstituicao = tipo;
		this.guia = guia;
		this.telefone = telefone;
		this.conteudoPlanejado = conteudoP;
		this.auxilioConteudo = auxilio;
		this.cidade = cidade;
		this.hora = hora;
		this.cursoVisitante = curso;
		this.numVisitante = num;
		this.anoSemestre = anoSemestre;
		this.conteudo = conteudo;
		this.tempoVisita = tempo;
		
	}
	
	public String getNomeInstituicao() {
		return nomeInstituicao;
	}
	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}
	public String getDtVisita() {
		return dtVisita;
	}
	public void setDtVisita(String dtVisita) {
		this.dtVisita = dtVisita;
	}
	public String getTipoInstituicao() {
		return tipoInstituicao;
	}
	public void setTipoInstituicao(String tipoInstituicao) {
		this.tipoInstituicao = tipoInstituicao;
	}
	public boolean isGuia() {
		return guia;
	}
	public void setGuia(boolean guia) {
		this.guia = guia;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public boolean isConteudoPlanejado() {
		return conteudoPlanejado;
	}
	public void setConteudoPlanejado(boolean conteudoPlanejado) {
		this.conteudoPlanejado = conteudoPlanejado;
	}
	public boolean isAuxilioConteudo() {
		return auxilioConteudo;
	}
	public void setAuxilioConteudo(boolean auxilioConteudo) {
		this.auxilioConteudo = auxilioConteudo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public String getCursoVisitante() {
		return cursoVisitante;
	}
	public void setCursoVisitante(String cursoVisitante) {
		this.cursoVisitante = cursoVisitante;
	}
	public int getNumVisitante() {
		return numVisitante;
	}
	public void setNumVisitante(int numVisitante) {
		this.numVisitante = numVisitante;
	}
	public String getSemestre() {
		return anoSemestre;
	}
	public void setAnoSemestre(String semestre) {
		this.anoSemestre = semestre;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public int getTempoVisita() {
		return tempoVisita;
	}
	public void setTempoVisita(int tempoVisita) {
		this.tempoVisita = tempoVisita;
	}
	
	public void listaDados(){
		
		System.out.println("Instituiçao: "+nomeInstituicao);
		System.out.println("Data: "+dtVisita);
		System.out.println("Tipo de instituição: "+tipoInstituicao);
		if(guia){
			System.out.println("Guia: sim");
		}
		else{
			System.out.println("Guia: não");
		}
		
		System.out.println("Telefone: "+telefone);
		
		if(conteudoPlanejado){
			System.out.println("Conteudo planejado: sim");
		}
		else{
			System.out.println("Conteudo planejado: não");
		}
		
		if(auxilioConteudo){
			System.out.println("Auxílio para conteúdo: sim");
		}
		else{
			System.out.println("Auxílio para conteúdo: não");
		}
		
		System.out.println("Cidade: "+cidade);
		System.out.println("Hora: "+hora);
		System.out.println("Curso dos visitantes: "+cursoVisitante);
		System.out.println("Numero de visitantes: "+numVisitante);
		System.out.println("Ano/Semestre: "+anoSemestre);
		System.out.println("Conteúdo: "+conteudo);
		System.out.println("Tempo da visita: "+tempoVisita);
	}
	
	
}

