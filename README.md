# Accord

Accord is the server API for [Prexor](https://prexorlabs.dev), the Minecraft client by PrexorLabs. A server
learns which of its players use Prexor and which features their client supports, sets rules such as "minimap
off" or "zoom at most 4x", and shows things vanilla cannot, such as notifications. The client tells the server
which rules it applied, and never which mods a player has installed.

It will hold the protocol (Protobuf schemas), a Java API that knows no server platform, and plugins for Paper
(with Folia) and Velocity. Accord is for servers; Prexor's client modules come from PrexorLabs alone.

Nothing here is stable yet. The API gets its first release together with the Prexor client; until 1.0, every
new part is marked `@ApiStatus.Experimental`.

## Building

```sh
./gradlew build checkJavaFormat
./gradlew formatJava   # formats all Java sources
```

Java 25 is downloaded automatically through Gradle toolchains; the API itself is compiled for Java 8, so servers
on old versions can use it.

## License

[MIT](LICENSE)
