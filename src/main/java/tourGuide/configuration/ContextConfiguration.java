package tourGuide.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rewardCentral.RewardCentral;

@Configuration
public class ContextConfiguration {

    @Bean
    public RewardCentral rewardCentral() {
        return new RewardCentral();
    }
}
