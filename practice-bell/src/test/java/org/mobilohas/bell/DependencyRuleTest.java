package org.mobilohas.bell;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mobilohas.bell.archunit.HexagonalArchitecture;

public class DependencyRuleTest {

  @Test
  void domainLayerDoesNotDependOnApplicationLayer() {
    noClasses()
        .that()
        .resideInAPackage("bell.domain")
        .should()
        .dependOnClassesThat()
        .resideInAPackage("bell.application")
        .check(new ClassFileImporter().importPackages("bell..."));
  }

  @Test
  void validateRegistrationContextArchitecture() {
    HexagonalArchitecture.boundedContext("org.mobilohas.bell.account")
        .withDomainLayer("domain")
        .withAdaptersLayer("adapter")
          .incoming("in.web")
          .outgoing("out.persistence")
          .and()
        .withApplicationLayer("application")
          .services("service")
          .incomingPorts("port.in")
          .outgoingPorts("port.out")
          .and()
        .withConfiguration("configuration")
        .check(new ClassFileImporter().importPackages("org.mobilohas.bell.."));
  }
}
