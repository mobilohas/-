package org.mobilohas.bell.account.application.port.out;

import org.mobilohas.bell.account.domain.Account;

public interface AccountLock {

  void lockAccount(Account.AccountId accountId);

  void releaseAccount(Account.AccountId accountId);
}
