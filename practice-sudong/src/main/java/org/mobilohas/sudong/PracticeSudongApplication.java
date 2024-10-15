package org.mobilohas.sudong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = "org.mobilohas")
@ServletComponentScan
public class PracticeSudongApplication {

  public static void main(String[] args) {
    SpringApplication.run(PracticeSudongApplication.class, args);
  }
}
