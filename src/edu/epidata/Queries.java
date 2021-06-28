package edu.epidata;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Queries {

	
	public static void reporteDTO(EntityManager em, int anio) {
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
		res.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		
	}
	
	
	public static void reporteRevisionDTO(EntityManager em, int anio) {
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
		res.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		
	}
	
	public static void reporteAutorDTO(EntityManager em) {
		em.getTransaction().begin();
		TypedQuery<Reporte2DTO> q = em.createQuery("SELECT new "
			+ "edu.epidata.Reporte2DTO(p.id, count(*))"
			+ " FROM Libro l JOIN l.capitulos c"
			+ " JOIN c.autores p"
			+ " GROUP BY p.id ",
			Reporte2DTO.class);
		List<Reporte2DTO> res = q.getResultList();
		//Imprime los resultados
		res.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		
	}
	
	public static void reporteTotalDTO(EntityManager em, int anio) {
		em.getTransaction().begin();
		TypedQuery<ReporteTotalDTO> q = em.createQuery("SELECT new "
			+ "edu.epidata.Reporte2DTO(p.id, count(*), sum(c.paginas))"
			+ " FROM Libro l JOIN l.capitulos c"
			+ " JOIN l.editores e"
			+ " JOIN c.autores p"	
			+ " JOIN c.revisores r"
			+ " WHERE l.anio = :anio"
			+ " GROUP BY p.id ",
			ReporteTotalDTO.class);
		q.setParameter("anio", anio);
		List<ReporteTotalDTO> res = q.getResultList();
		//Imprime los resultados
		res.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Editorial");
		EntityManager em = emf.createEntityManager();
		Queries.reporteDTO(em, 2017);
		Queries.reporteRevisionDTO(em, 2017);
		Queries.reporteAutorDTO(em);
		em.close();
		emf.close();

	}
}
