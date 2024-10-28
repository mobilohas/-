package org.mobilohas.bell.account.application.service;

import org.mobilohas.bell.account.application.port.out.AccountLock;
import org.mobilohas.bell.account.domain.Account.AccountId;
import org.springframework.stereotype.Component;

@Component
public class NoOpAccountLock implements AccountLock {

  @Override
  public void lockAccount(final AccountId accountId) {
    // do nothing
  }

  @Override
  public void releaseAccount(final AccountId accountId) {
    // do nothing
  }
}
