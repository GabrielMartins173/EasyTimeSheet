package com.ufrgs.EasyTimesheet.components.classroom;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassroomRepository extends PagingAndSortingRepository<Classroom, Long> {

    public List<Classroom> findAll();

    public Optional<Classroom> findById(Long id);

    public Classroom save(Classroom classroom);

}
