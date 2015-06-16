//
// Built on Fri May 22 05:44:16 CEST 2015 by logback-translator
// For more information on configuration files in Groovy
// please see http://logback.qos.ch/manual/groovy.html

// For assistance related to this tool or configuration files
// in general, please contact the logback user mailing list at
//    http://qos.ch/mailman/listinfo/logback-user

// For professional support please see
//   http://www.qos.ch/shop/products/professionalSupport

import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender

import static ch.qos.logback.classic.Level.DEBUG

appender("FILE", FileAppender) {
    file = "foo.log"
    encoder(PatternLayoutEncoder) {
        pattern = "%date %level [%thread] %logger{10} [%file : %line] %msg%n"
    }
}
appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%date %level %logger{10} [%line] %msg%n"
    }
}
root(INFO, ["STDOUT","FILE"])