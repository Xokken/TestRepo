plugins {
    kotlin("jvm") version "2.1.20"
    id("io.gitlab.arturbosch.detekt").version("1.23.6")
}

detekt {
    toolVersion = "1.23.6"
    config = files("config/detekt/detekt.yml")  // путь к вашему конфигу
    buildUponDefaultConfig = true
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        html.required.set(true)
        xml.required.set(false)
        txt.required.set(false)
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.6")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}