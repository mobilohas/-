package org.mobilohas.bell.account.application.port.out;

import org.mobilohas.bell.account.domain.Account;

public interface UpdateAccountStatePort {
  void updateActivities(Account account);
}
