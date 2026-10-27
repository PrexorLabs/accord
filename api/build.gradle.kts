plugins {
    `java-library`
}

group = "dev.prexorlabs"
version = "0.1.0"
base.archivesName = "accord-api"

java {
    withSourcesJar()
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

// Servers still run 1.8.8 on Java 8, so the API is compiled for Java 8 (ADR 0048).
tasks.compileJava {
    options.release = 8
    // javac warns that Java 8 is obsolete; for this API that is the point.
    options.compilerArgs.add("-Xlint:-options")
}
