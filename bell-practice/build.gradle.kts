plugins {
    id("java")
}

group = "org.mobilohas"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.tngtech.archunit:archunit:0.16.0")
    testImplementation("org.junit.platform:junit-platform-launcher:1.4.2")
    testImplementation("com.h2database:h2")

    runtimeOnly("com.h2database:h2")
}

tasks.test {
    useJUnitPlatform()
}