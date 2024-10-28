package org.mobilohas.bell;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "buckpal")
public class BuckpalConfigurationProperties {

  private long transferThreshold = Long.MAX_VALUE;
}
