package za.co.span.assessment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"za.co.span.assessment"})
public class StartLeagueRankingClientApplication {

    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING LEAGUE RANKING CLIENT");
        SpringApplication.run(StartLeagueRankingClientApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }
}
