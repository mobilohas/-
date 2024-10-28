package org.mobilohas.bell.account.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mobilohas.bell.common.AccountTestData.defaultAccount;
import static org.mobilohas.bell.common.ActivityTestData.defaultActivity;

import org.junit.jupiter.api.Test;
import org.mobilohas.bell.account.domain.Account.AccountId;

class AccountTest {

  @Test
  void withdrawalSucceeds() {
    //given
    AccountId accountId = new AccountId(1L);
    Account account = defaultAccount()
        .withAccountId(accountId)
        .withBaselineBalance(Money.of(555L))
        .withActivityWindow(new ActivityWindow(
            defaultActivity()
                .withTargetAccount(accountId)
                .withMoney(Money.of(999L)).build(),
            defaultActivity()
                .withTargetAccount(accountId)
                .withMoney(Money.of(1L)).build()))
        .build();

    //when
    boolean success = account.withdraw(Money.of(555L), new AccountId(99L));

    //then
    assertThat(success).isTrue();
    assertThat(account.getActivityWindow().getActivities()).hasSize(3);
    assertThat(account.calculateBalance()).isEqualTo(Money.of(1000L));
  }
}