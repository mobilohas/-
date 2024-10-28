package org.mobilohas.bell.account.application.service;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.mobilohas.bell.account.application.port.in.GetAccountBalanceQuery;
import org.mobilohas.bell.account.application.port.out.LoadAccountPort;
import org.mobilohas.bell.account.domain.Account.AccountId;
import org.mobilohas.bell.account.domain.Money;

@RequiredArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceQuery {

  private final LoadAccountPort loadAccountPort;

  @Override
  public Money getAccountBalance(final AccountId accountId) {
    return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
        .calculateBalance();
  }
}
