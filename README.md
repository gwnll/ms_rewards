[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com) 

# TourGuide
TourGuide is a Spring Boot application that has been a centerpiece in TripMasters app portfolio. It allows users to see tourist attractions and to get package deals on hotel stays and admission to various attractions.
***
## ms_rewards
## Modules complémentaires
- [Module User](https://github.com/gwnll/ms_user)
- [Module GPS](https://github.com/gwnll/ms_gps)
## Architectural Diagram
![alt text](https://github.com/gwnll/ms_user/blob/main/diagramme_architecture.png?raw=true)
## Technologies
- Java
- Gradle
- Spring 
- Docker
## Endpoints
#### POST http://localhost:81/calculateRewards
> calculate rewards of a user by getting the history of his visited locations and comparing it to the attractions' location. add a UserReward to his UserReward list when eligible to said reward.
> ``@RequestBody User user``
#### GET http://localhost:81/getRewardPoints
>  ``@RequestParam String attractionId, @RequestParam String userId``
