package jsample.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.logging.log4j.core.appender.rolling.DefaultRolloverStrategy;
import org.apache.logging.log4j.core.appender.rolling.TimeBasedTriggeringPolicy;
import org.apache.logging.log4j.core.appender.rolling.action.Action;
import org.apache.logging.log4j.core.appender.rolling.action.DeleteAction;
import org.apache.logging.log4j.core.appender.rolling.action.Duration;
import org.apache.logging.log4j.core.appender.rolling.action.IfLastModified;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;

public class DynamicLoggerManager {

	public static synchronized void configureLogger(String basePath) {

		final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
		final Configuration config = ctx.getConfiguration();

		PatternLayout patternLayout = PatternLayout.newBuilder()
				.withPattern("%d{yyyy-MM-dd HH:mm:ss.SSS}	%level [%t] [%c] [%M] [%l] - %msg%n").build();

		TimeBasedTriggeringPolicy timeBasedTriggeringPolicy = TimeBasedTriggeringPolicy.newBuilder().withInterval(1)
				.withModulate(true).build();

		IfLastModified ifLastModified = IfLastModified.createAgeCondition(Duration.parse("2d"));

		DeleteAction deleteAction = DeleteAction.createDeleteAction(basePath, false, 1, false, null,
				new IfLastModified[] { ifLastModified }, null, config);

		DefaultRolloverStrategy defaultRolloverStrategy = DefaultRolloverStrategy.newBuilder().withConfig(config)
				.withCustomActions(new Action[] { deleteAction }).build();

		Appender rollingFileAppender = RollingFileAppender.newBuilder().withName("fileLogger")
				.withFileName(basePath + "dynamicLogger.log")
				.withFilePattern(basePath + "dynamicLogger_%d{yyyyMMdd}.log.gz").withLayout(patternLayout)
				.withPolicy(timeBasedTriggeringPolicy).withStrategy(defaultRolloverStrategy).build();

		rollingFileAppender.start();

		config.addAppender(rollingFileAppender);

		AppenderRef ref = AppenderRef.createAppenderRef("fileLogger", null, null);
		AppenderRef[] refs = new AppenderRef[] { ref };

		LoggerConfig dynamicLogger = LoggerConfig.createLogger(false, Level.INFO, "jsample.dynamic.logs", null, refs,
				null, config, null);

		dynamicLogger.addAppender(rollingFileAppender, null, null);
		config.addLogger("jsample.dynamic.logs", dynamicLogger);
		ctx.updateLoggers();
	}
}