package org.mobilohas.bell.account.application.port.in;

import org.mobilohas.bell.account.domain.Account.AccountId;
import org.mobilohas.bell.account.domain.Money;

public interface GetAccountBalanceQuery {
  Money getAccountBalance(AccountId accountId);
}
