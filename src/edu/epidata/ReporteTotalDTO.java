package edu.epidata;

public class ReporteTotalDTO {
	
	private int personaId;
	private long librosEditados;
	private long paginasRevisadas;
	private long librosEscritos;
	
	public ReporteTotalDTO(int personaId, long librosEditados, long paginasRevisadas, long librosEscritos) {
		super();
		this.personaId = personaId;
		this.librosEditados = librosEditados;
		this.paginasRevisadas = paginasRevisadas;
		this.librosEscritos = librosEscritos;
	}

	public int getPersonaId() {
		return personaId;
	}

	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	public long getLibrosEditados() {
		return librosEditados;
	}

	public void setLibrosEditados(long librosEditados) {
		this.librosEditados = librosEditados;
	}

	public long getPaginasRevisadas() {
		return paginasRevisadas;
	}

	public void setPaginasRevisadas(long paginasRevisadas) {
		this.paginasRevisadas = paginasRevisadas;
	}

	public long getLibrosEscritos() {
		return librosEscritos;
	}

	public void setLibrosEscritos(long librosEscritos) {
		this.librosEscritos = librosEscritos;
	}


}
