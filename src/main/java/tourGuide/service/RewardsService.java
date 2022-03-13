package tourGuide.service;


import org.springframework.stereotype.Service;
import rewardCentral.RewardCentral;
import tourGuide.dto.*;
import tourGuide.proxies.GpsUtilProxy;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RewardsService {
    private static final double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;

    // proximity in miles
    private int defaultProximityBuffer = 10;
    private int proximityBuffer = defaultProximityBuffer;
    private int attractionProximityRange = 200;
    private final GpsUtilProxy gpsUtilProxy;
    private final RewardCentral rewardsCentral;

    public RewardsService(GpsUtilProxy gpsUtilProxy, RewardCentral rewardCentral) {
        this.gpsUtilProxy = gpsUtilProxy;
        this.rewardsCentral = rewardCentral;
    }

    public void setProximityBuffer(int proximityBuffer) {
        this.proximityBuffer = proximityBuffer;
    }

    public void setDefaultProximityBuffer() {
        proximityBuffer = defaultProximityBuffer;
    }

    public List<UserReward> calculateRewards(User user) {
        List<VisitedLocation> userLocations = user.getVisitedLocations();
        List<Attraction> attractions = gpsUtilProxy.getAttractions().stream()
                .filter(a -> user.getUserRewards().stream().noneMatch(r -> r.attraction.attractionName.equals(a.attractionName)))
                .collect(Collectors.toList());

        for (VisitedLocation visitedLocation : userLocations) {
            for (Attraction attraction : attractions) {
                Location location = visitedLocation.location;
                if (gpsUtilProxy.near(location.latitude, location.longitude, attraction.latitude, attraction.longitude)) {
                    user.addUserReward(new UserReward(visitedLocation, attraction, getRewardPoints(attraction.attractionId.toString(), user.getUserId().toString())));
                }
            }
        }

        return user.getUserRewards();
    }

    public int getRewardPoints(String attractionId, String userId) {
        return rewardsCentral.getAttractionRewardPoints(UUID.fromString(attractionId), UUID.fromString(userId));
    }

}
