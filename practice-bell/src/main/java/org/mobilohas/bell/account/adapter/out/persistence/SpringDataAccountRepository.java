package org.mobilohas.bell.account.adapter.out.persistence;

import org.mobilohas.bell.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

interface AccountRepository extends JpaRepository<AccountJpaEntity, Long> {

}
