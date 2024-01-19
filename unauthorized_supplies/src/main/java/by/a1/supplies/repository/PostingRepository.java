package by.a1.supplies.repository;

import by.a1.supplies.entity.Posting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostingRepository extends CrudRepository<Posting, Long> {
    List<Posting> findAllByMatDoc(String matDoc);
}
