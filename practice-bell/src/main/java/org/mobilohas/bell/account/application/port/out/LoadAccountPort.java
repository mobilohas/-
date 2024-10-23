package org.mobilohas.bell.account.application.port.out;

import java.time.LocalDateTime;
import org.mobilohas.bell.account.domain.Account;
import org.mobilohas.bell.account.domain.Account.AccountId;
import org.mobilohas.bell.account.domain.Money;

public interface LoadAccountPort {

  Account loadAccount(AccountId accountId, LocalDateTime now);
}
