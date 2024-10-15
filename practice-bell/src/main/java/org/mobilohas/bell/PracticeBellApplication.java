package org.mobilohas.bell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = "org.mobilohas")
@ServletComponentScan
public class PracticeBellApplication {

  public static void main(String[] args) {
    SpringApplication.run(PracticeBellApplication.class, args);
  }
}
