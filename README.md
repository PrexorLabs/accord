# Prexor server API

The public API for Minecraft servers that work with [Prexor](https://prexorlabs.dev), the Minecraft client by
PrexorLabs. A server learns which of its players use Prexor and which features their client supports, sets rules
such as "minimap off" or "zoom at most 4x", and shows things vanilla cannot, such as notifications. The client
never tells a server which mods a player has installed.

It will hold the protocol (Protobuf schemas), a Java API that knows no server platform, and plugins for Paper
(with Folia) and Velocity. Client modules stay first-party; this repository used to be planned as a module SDK.

Nothing here is stable yet. The API gets its first release together with the Prexor client; until 1.0, every
new part is marked `@ApiStatus.Experimental`.

## Building

```sh
./gradlew build checkJavaFormat
./gradlew formatJava   # formats all Java sources
```

Java 25 is downloaded automatically through Gradle toolchains.

## License

[MIT](LICENSE)
