package searchlinks.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import searchlinks.entities.User;

@Repository
public interface UsersRepository extends PagingAndSortingRepository<User, Integer> {

    User findByLoginAndPassword (String login, String password);

    User findByLogin (String login);
}
