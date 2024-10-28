package org.mobilohas.bell.account.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityJpaEntity {

  @Id
  @GeneratedValue
  private Long id;

  private LocalDateTime timestamp;
  private Long ownerAccountId;
  private Long sourceAccountId;
  private Long targetAccountId;
  private Long amount;
}
