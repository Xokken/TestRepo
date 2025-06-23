plugins {
    kotlin("jvm") version "2.1.20"
    id("io.gitlab.arturbosch.detekt").version("1.23.6")
}

detekt {
    toolVersion = "1.23.6"
    config = files("config/detekt/detekt.yml")  // путь к вашему конфигу
    buildUponDefaultConfig = true
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}