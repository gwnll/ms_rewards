package tourGuide;

import tourGuide.dto.Attraction;
import tourGuide.dto.VisitedLocation;

import java.util.List;
import java.util.UUID;

public class CalculateRewardsRequest {

    public UUID userId;
    public int proximityBuffer;
    public List<VisitedLocation> userLocations;
    public List<Attraction> attractions;

    public CalculateRewardsRequest(UUID userId, List<VisitedLocation> userLocations, List<Attraction> attractions) {
        this.userId = userId;
        this.userLocations = userLocations;
        this.attractions = attractions;
    }

    public CalculateRewardsRequest(UUID userId, int proximityBuffer, List<VisitedLocation> userLocations, List<Attraction> attractions) {
        this.userId = userId;
        this.proximityBuffer = proximityBuffer;
        this.userLocations = userLocations;
        this.attractions = attractions;
    }
}
