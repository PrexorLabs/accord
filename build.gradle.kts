plugins {
    `jvm-toolchains`
}

// Same formatter and style as the client (AOSP google-java-format), run in its own JVM.
repositories {
    mavenCentral()
}

val googleJavaFormat: Configuration = configurations.create("googleJavaFormat")

dependencies {
    // The self-contained jar: without the java plugin, Gradle cannot pick Guava's JRE variant for the normal one
    googleJavaFormat("com.google.googlejavaformat:google-java-format:1.37.0:all-deps") { isTransitive = false }
}

val javaSources = fileTree(".") { include("*/src/**/*.java") }

fun registerFormatter(name: String, description: String, vararg mode: String) = tasks.register<JavaExec>(name) {
    group = "formatting"
    this.description = description
    classpath = googleJavaFormat
    mainClass = "com.google.googlejavaformat.java.Main"
    javaLauncher = javaToolchains.launcherFor { languageVersion = JavaLanguageVersion.of(25) }
    // The formatter parses with javac's internal classes
    jvmArgs(listOf("api", "code", "file", "parser", "tree", "util").map {
        "--add-exports=jdk.compiler/com.sun.tools.javac.$it=ALL-UNNAMED"
    })
    val files = javaSources
    inputs.files(files)
    argumentProviders.add(CommandLineArgumentProvider { listOf("--aosp", *mode) + files.files.map { it.path } })
}

registerFormatter("formatJava", "Formats all Java sources in place", "--replace")
registerFormatter("checkJavaFormat", "Fails if a Java source is not formatted", "--dry-run", "--set-exit-if-changed")
