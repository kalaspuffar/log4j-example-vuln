import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.ErrorHandler;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;

import java.io.Serializable;

public class MyAppender implements Appender {
    @Override
    public void append(LogEvent logEvent) {
        System.out.println(logEvent.getMessage().getFormattedMessage());
    }

    @Override
    public String getName() {
        return "My appender";
    }

    @Override
    public Layout<? extends Serializable> getLayout() {
        return null;
    }

    @Override
    public boolean ignoreExceptions() {
        return false;
    }

    @Override
    public ErrorHandler getHandler() {
        return new ErrorHandler() {
            @Override
            public void error(String msg) {
                System.out.println(msg);
            }

            @Override
            public void error(String msg, Throwable t) {
                error(msg);
                t.printStackTrace();
            }

            @Override
            public void error(String msg, LogEvent event, Throwable t) {
                error(msg, t);
            }
        };
    }

    @Override
    public void setHandler(ErrorHandler errorHandler) {

    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return true;
    }

    @Override
    public boolean isStopped() {
        return false;
    }
}
