package com.example.register_service.repository;

import com.example.register_service.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query("SELECT s FROM Subject s WHERE s.id IN :ids")
    List<Subject> findAllByIds(@Param("ids") List<Long> ids);

    @Query("SELECT DISTINCT s FROM Subject s JOIN FETCH s.users")
    List<Subject> findAllSubjectsWithUsers();
}
