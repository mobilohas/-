package org.mobilohas.bell.account.adapter.out.persistence;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.mobilohas.bell.account.application.port.out.LoadAccountPort;
import org.mobilohas.bell.account.application.port.out.UpdateAccountStatePort;
import org.mobilohas.bell.account.domain.Account;
import org.mobilohas.bell.account.domain.Account.AccountId;
import org.mobilohas.bell.account.domain.Activity;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {

  private final SpringDataAccountRepository springDataAccountRepository;
  private final ActivityRepository activityRepository;
  private final AccountMapper accountMapper;

  @Override
  public Account loadAccount(final AccountId accountId, final LocalDateTime baselineDate) {
    AccountJpaEntity account = springDataAccountRepository.findById(accountId.getValue())
        .orElseThrow(EntityNotFoundException::new);

    List<ActivityJpaEntity> activities = activityRepository.findByOwnerSince(
        accountId.getValue(), baselineDate);

    Long withdrawalBalance = orZero(
        activityRepository.getWithdrawalBalanceUntil(accountId.getValue(), baselineDate));

    Long depositBalance = orZero(
        activityRepository.getDepositBalanceUntil(accountId.getValue(), baselineDate));

    return accountMapper.mapToDomainEntity(
        account,
        activities,
        withdrawalBalance,
        depositBalance);
  }

  private Long orZero(Long value) {
    return value == null? 0L: value;
  }

  @Override
  public void updateActivities(final Account account) {
    for (Activity activity: account.getActivityWindow().getActivities()) {
      if (activity.getId() == null) {
        activityRepository.save(accountMapper.mapToJpaEntity(activity));
      }
    }
  }
}
