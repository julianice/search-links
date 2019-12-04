package searchlinks.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import searchlinks.entities.Site;

@Repository
public interface SitesRepository extends PagingAndSortingRepository<Site, Integer> {
}
