package searchlinks.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import searchlinks.entities.Site;

public interface SitesRepository extends PagingAndSortingRepository<Site, Integer> {
}
