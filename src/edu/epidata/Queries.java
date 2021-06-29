package edu.epidata;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Queries {

	
	public static void reporteLibrosEditadosDTO(EntityManager em, int anio) {
		em.getTransaction().begin();
		TypedQuery<Reporte1DTO> q = em.createQuery("SELECT new "
			+ "edu.epidata.Reporte1DTO(p.id, count(*))"
			+ " FROM Libro l JOIN l.editores p"
			+ " WHERE l.anio = :anio"
			+ " GROUP BY p.id ",
			Reporte1DTO.class);
		q.setParameter("anio", anio);
		List<Reporte1DTO> res = q.getResultList();
		//Imprime los resultados
		System.out.printf("\n\n   Reporte Libros editados en %d   \n\n",anio);
		res.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		
	}
	
	
	public static void reportePaginasRevisadasDTO(EntityManager em, int anio) {
		em.getTransaction().begin();
		TypedQuery<Reporte2DTO> q = em.createQuery("SELECT new "
			+ "edu.epidata.Reporte2DTO(c.revisor.id, sum(c.paginas))"
			+ " FROM Libro l JOIN l.capitulos c"
			+ " WHERE l.anio = :anio"
			+ " GROUP BY c.revisor.id ",
			Reporte2DTO.class);
		q.setParameter("anio", anio);
		List<Reporte2DTO> res = q.getResultList();
		//Imprime los resultados
		System.out.printf("\n\n  Reporte paginas revisadas en %d  \n\n",anio);
		res.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		
	}
	
	public static void reporteParticipacionAutorDTO(EntityManager em) {
		em.getTransaction().begin();
		TypedQuery<Reporte3DTO> q = em.createQuery("SELECT new "
			+ "edu.epidata.Reporte3DTO(p.id, count(*))"
			+ " FROM Libro l JOIN l.capitulos c"
			+ " JOIN c.autores p"
			+ " GROUP BY p.id ",
			Reporte3DTO.class);
		List<Reporte3DTO> res = q.getResultList();
		System.out.println("\n\n    Reporte Autores   \n\n");
		//Imprime los resultados
		res.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
	}
	
}
