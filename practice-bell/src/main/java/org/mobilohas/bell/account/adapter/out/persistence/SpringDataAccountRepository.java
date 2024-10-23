package org.mobilohas.bell.account.adapter.out.persistence;

import org.mobilohas.bell.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAccountRepository extends JpaRepository<Account, Long> {

}
