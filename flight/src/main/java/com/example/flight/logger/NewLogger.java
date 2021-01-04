package com.example.flight.logger;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class NewLogger
{
    public final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public NewLogger()
    {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        //Config Console Logging Format
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);

        ch.setFormatter(new SimpleFormatter() {
            private static final String format = "%1$tF %1$tT %2$-7s %3$s %n";

            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
            }
        });
        logger.addHandler(ch);

        //Config log file Logging Format
        try
        {
            FileHandler fh = new FileHandler("LOG_FILE.log");
            fh.setLevel(Level.ALL);

            fh.setFormatter(new SimpleFormatter() {
                private static final String format = "%1$tF %1$tT %2$-7s %3$s %n";

                @Override
                public synchronized String format(LogRecord lr) {
                    return String.format(format,
                            new Date(lr.getMillis()),
                            lr.getLevel().getLocalizedName(),
                            lr.getMessage()
                    );
                }
            });
            logger.addHandler(fh);
        }catch (IOException e){
            logger.log(Level.SEVERE, "ERROR with system log file");
        }
    }
}
