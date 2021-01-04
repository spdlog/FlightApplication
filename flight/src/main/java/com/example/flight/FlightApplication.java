package com.example.flight;
import com.example.flight.logger.NewLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class FlightApplication {
	public final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args) throws IOException {
		NewLogger l = new NewLogger();
		AppData data = new AppData();
		logger.log(Level.INFO, "Flight Application Has Started");
		SpringApplication.run(FlightApplication.class, args);
	}
}
