[![Maven Central](https://img.shields.io/maven-central/v/net.sourceforge.streamsupport/java9-concurrent-backport.svg)](http://mvnrepository.com/artifact/net.sourceforge.streamsupport/java9-concurrent-backport)
[![javadoc.io](https://javadoc.io/badge2/net.sourceforge.streamsupport/java9-concurrent-backport/javadoc.svg)](https://javadoc.io/doc/net.sourceforge.streamsupport/java9-concurrent-backport)

# java9-concurrent-backport

![](art/streamsupport-sf.png)

java9-concurrent-backport is a backport of the upgraded (`JEP 266`) Java 9 CompletableFuture API
(extended by the new Java 12 CSR `JDK-8211010` exception handling methods) for Java 8.
In addition, it contains a Java 8 version of the new Java 9 reactive-streams Flow and SubmissionPublisher
API (also JEP 266) and of the new Java 9 Collections factory methods from `JEP 269` (updated to the
Java 14 implementation).

The API is exactly the same as in Java 14 with the exception that it doesn't live in the package
`java.util(.concurrent)` but rather in the package `java9.util(.concurrent)`.

The JEP 269 convenience factory methods for collections are located in companion classes for the
corresponding `java.util` interfaces:

* `java9.util.Lists`
* `java9.util.Maps`
* `java9.util.Sets`


### Maven:

```xml
<dependency>
    <groupId>net.sourceforge.streamsupport</groupId>
    <artifactId>java9-concurrent-backport</artifactId>
    <version>2.0.4</version>
</dependency>
```


The minimum runtime requirement is OpenJDK (Oracle) Java 8.


## LICENSE

GNU General Public License, version 2, with the Classpath Exception  (and [CC0 1.0](https://creativecommons.org/publicdomain/zero/1.0/) for JSR-166 derived code)
