package searchlinks.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import searchlinks.entities.Page;
import searchlinks.entities.Site;
import java.util.List;

@Repository
public interface PagesRepository extends PagingAndSortingRepository<Page, Integer> {

    List<Page> findBySite(Site site);
}
