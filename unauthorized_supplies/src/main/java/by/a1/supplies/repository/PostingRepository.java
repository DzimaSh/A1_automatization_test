package by.a1.supplies.repository;

import by.a1.supplies.entity.Posting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(path = "postings")
public interface PostingRepository extends CrudRepository<Posting, Long> {

    List<Posting> findAllByMatDoc(String matDoc);

    @RestResource(path = "/filter")
    @Query("""
    SELECT p FROM Posting p
    WHERE (p.docDate BETWEEN :startDate AND :endDate) AND
        (:authorized IS NULL OR p.authorized = :authorized)
    """)
    List<Posting> findAllByDocDateBetweenAndAuthorized(@Param("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                       @Param("endDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                                       @Param("authorized") Boolean authorized);

}
