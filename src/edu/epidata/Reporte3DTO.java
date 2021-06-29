package edu.epidata;


public class Reporte3DTO {
	private int personaId;
	private long cant;

	public Reporte3DTO(int personaId, long cant) {
		super();
		this.personaId = personaId;
		this.cant = cant;
	}
//Getters y Setters
	
	
	@Override
	public String toString() {
		return "Reporte3DTO [personaId=" + personaId + ", cant=" + cant + "]";
	}


	public int getPersonaId() {
		return personaId;
	}


	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}


	public long getCant() {
		return cant;
	}


	public void setCant(long cant) {
		this.cant = cant;
	}
}