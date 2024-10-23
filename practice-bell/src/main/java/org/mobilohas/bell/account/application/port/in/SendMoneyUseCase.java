package org.mobilohas.bell.account.application.port.in;

public interface SendMoneyUseCase {

  boolean sendMoney(SendMoneyCommand sendMoneyCommand);
}
