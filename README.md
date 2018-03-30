# java9-concurrent-backport

![](art/streamsupport-sf.png)

java9-concurrent-backport is a backport of the upgraded (`JEP 266`) Java 9 CompletableFuture API for Java 8.
In addition, it contains a Java 8 version of the new Java 9 reactive-streams Flow and SubmissionPublisher
API (also JEP 266) and of the new Java 9 Collections factory methods (`JEP 269`).

The API is exactly the same as in Java 9 with the exception that it doesn't live in the package
`java.util(.concurrent)` but rather in the package `java9.util(.concurrent)`.

The JEP 269 convenience factory methods for collections are located in companion classes for the
corresponding `java.util` interfaces:

* `java9.util.Lists`
* `java9.util.Maps`
* `java9.util.Sets`

