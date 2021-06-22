package edu.epidata;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Queries {

	
	public static void reporteDTO(EntityManager em) {
		em.getTransaction().begin();
		TypedQuery<Reporte1DTO> q = em.createQuery("SELECT new "
			+ "edu.epidata.Reporte1DTO(p.id, count(*))"
			+ " FROM Libro l JOIN l.editores p"
			+ " WHERE l.anio = :anio"
			+ " GROUP BY p.id ",
			Reporte1DTO.class);
		q.setParameter("anio", 2017);
		List<Reporte1DTO> res = q.getResultList();
		//Imprime los resultados
		res.forEach(r -> System.out.println(r));
		em.getTransaction().commit();
		
	}
	
}
