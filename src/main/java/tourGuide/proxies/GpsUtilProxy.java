package tourGuide.proxies;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tourGuide.dto.Attraction;

import java.util.List;

@FeignClient(name = "gpsutil", url = "localhost:8082")
public interface GpsUtilProxy {

    @GetMapping("/getAttractions")
    public List<Attraction> getAttractions();

    @GetMapping("/near")
    public boolean near(@RequestParam double lat1, @RequestParam double long1,
                        @RequestParam double lat2, @RequestParam double long2);
}
