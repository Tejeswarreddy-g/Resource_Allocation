package com.resourceallocation.repository;

import com.resourceallocation.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
   
	@Query("SELECT r FROM Resource r JOIN r.skills s WHERE s IN :skills GROUP BY r HAVING COUNT(DISTINCT s) = :size AND r.experience < :maxExperience")
	List<Resource> findBySkillsInAndExperienceLessThan(@Param("skills") List<String> skills, @Param("size") long size, @Param("maxExperience") int maxExperience);

	
    @Query("SELECT r FROM Resource r JOIN r.skills s WHERE s IN :skills GROUP BY r HAVING COUNT(s) = :size")
    List<Resource> findBySkillsIn(@Param("skills") List<String> skills, @Param("size") long size);
    

}
