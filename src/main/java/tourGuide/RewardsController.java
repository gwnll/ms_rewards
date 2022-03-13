package tourGuide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tourGuide.dto.UserReward;
import tourGuide.service.RewardsService;
import tourGuide.dto.User;

import java.util.List;

@RestController
public class RewardsController {

    @Autowired
    RewardsService rewardsService;

    @PostMapping("/calculateRewards")
    public ResponseEntity<List<UserReward>> calculateRewards(@RequestBody User user) {
        return new ResponseEntity<>(rewardsService.calculateRewards(user),
                HttpStatus.OK);
    }

    @GetMapping("/getRewardPoints")
    public ResponseEntity<Integer> getRewardPoints(@RequestParam String attractionId, @RequestParam String userId) {
        return new ResponseEntity<>(rewardsService.getRewardPoints(attractionId, userId),
                HttpStatus.OK);
    }

}
