plugins {
    `java-library`
}

group = "dev.prexorlabs"
version = "0.1.0"
base.archivesName = "prexor-api"

java {
    withSourcesJar()
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}
