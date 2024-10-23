package org.mobilohas.bell.account.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.mobilohas.bell.account.application.port.in.SendMoneyCommand;
import org.mobilohas.bell.account.application.port.in.SendMoneyUseCase;
import org.mobilohas.bell.account.domain.Account;
import org.mobilohas.bell.account.domain.Account.AccountId;
import org.mobilohas.bell.account.domain.Money;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMoneyController {

  private final SendMoneyUseCase sendMoneyUseCase;

  @PostMapping("/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
  void sendMoney(
      @PathVariable Long sourceAccountId,
      @PathVariable Long targetAccountId,
      @PathVariable Long amount) {
    SendMoneyCommand command = new SendMoneyCommand(
        new AccountId(sourceAccountId),
        new AccountId(targetAccountId),
        Money.of(amount));
    sendMoneyUseCase.sendMoney(command);
  }
}
