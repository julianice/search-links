package searchlinks.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import searchlinks.entities.Link;
import searchlinks.entities.Site;

import java.util.List;

@Repository
public interface LinksRepository extends PagingAndSortingRepository<Link, Integer> {

    @Query("select link from Link link where link.site = ?1 and link.willBeDeleted = true")
    List<Link> findAllByWillBeDeleted(Site site);
}
