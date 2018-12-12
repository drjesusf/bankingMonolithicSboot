package banking.ads.infrastructure.users.persistence.hibernate.repository;

import seedWork.IRepository;
import banking.ads.domain.users.entities.User;
import banking.ads.infrastructure.hibernate.HibernateRepository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import banking.ads.domain.users.contracts.IUserRepository;

@Transactional
@Repository
public class UserHibernateRepository extends HibernateRepository<User> implements IUserRepository {

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getPaginated(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
