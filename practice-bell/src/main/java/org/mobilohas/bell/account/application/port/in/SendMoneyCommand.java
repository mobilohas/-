package org.mobilohas.bell.account.application.port.in;

import static java.util.Objects.requireNonNull;

import lombok.Getter;
import lombok.NonNull;
import org.mobilohas.bell.account.domain.Account.AccountId;
import org.mobilohas.bell.account.domain.Money;
import org.mobilohas.bell.common.SelfValidating;

@Getter
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

  @NonNull
  private final AccountId sourceAccountId;
  @NonNull
  private final AccountId targetAccountId;
  @NonNull
  private final Money money;

  public SendMoneyCommand(final AccountId sourceAccountId, final AccountId targetAccountId,
      final Money money) {
    this.sourceAccountId = sourceAccountId;
    this.targetAccountId = targetAccountId;
    this.money = money;
    this.validateSelf();
  }
}
