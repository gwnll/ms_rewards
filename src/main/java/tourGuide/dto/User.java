package tourGuide.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID userId;
    private List<VisitedLocation> visitedLocations = new ArrayList<>();
    private List<UserReward> userRewards = new ArrayList<>();

    public User(UUID userId) {
        this.userId = userId;
    }

    public User(UUID userId, List<VisitedLocation> visitedLocations, List<UserReward> userRewards) {
        this.userId = userId;
        this.visitedLocations = visitedLocations;
        this.userRewards = userRewards;
    }

    public UUID getUserId() {
        return userId;
    }

    public List<VisitedLocation> getVisitedLocations() {
        return new ArrayList<>(visitedLocations);
    }

    public List<UserReward> getUserRewards() {
        return userRewards;
    }

    public void addUserReward(UserReward userReward) {
        if(userRewards.stream().noneMatch(r -> r.attraction.attractionName.equals(userReward.attraction.attractionName))) {
            userRewards.add(userReward);
        }
    }
}