package banking.ads.infrastructure.users.persistence.hibernate.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import banking.ads.domain.users.contracts.IUserClaimRepository;
import banking.ads.domain.users.entities.UserClaim;
import banking.ads.infrastructure.hibernate.HibernateRepository;


@Transactional
@Repository
public class UserClaimHibernateRepository extends HibernateRepository<UserClaim> implements IUserClaimRepository{

	@Override
	public List<UserClaim> findByUserId(Long userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
