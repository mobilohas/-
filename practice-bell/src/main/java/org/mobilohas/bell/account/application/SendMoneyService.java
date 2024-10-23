package org.mobilohas.bell.account.application;

import lombok.RequiredArgsConstructor;
import org.mobilohas.bell.account.application.port.in.SendMoneyCommand;
import org.mobilohas.bell.account.application.port.in.SendMoneyUseCase;
import org.mobilohas.bell.account.application.port.out.AccountLock;
import org.mobilohas.bell.account.application.port.out.LoadAccountPort;
import org.mobilohas.bell.account.application.port.out.UpdateAccountStatePort;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

  private final LoadAccountPort loadAccountPort;
  private final AccountLock accountLock;
  private final UpdateAccountStatePort updateAccountStatePort;

  @Override
  public boolean sendMoney(SendMoneyCommand sendMoneyCommand) {
    return true;
  }
}
