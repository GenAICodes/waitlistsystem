
import com.waitlistsystem.entity.WaitlistUser;
import com.waitlistsystem.repository.WaitlistUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaitlistAnalyticsService {

    private final WaitlistUserRepository waitlistUserRepository;

    @Autowired
    public WaitlistAnalyticsService(WaitlistUserRepository waitlistUserRepository) {
        this.waitlistUserRepository = waitlistUserRepository;
    }

    public int getNumberOfUsers() {
        return waitlistUserRepository.findAll().size();
    }

    public double getAverageWaitTime() {
        double totalWaitTime = 0;
        int numberOfUsers = 0;
        for (WaitlistUser user : waitlistUserRepository.findAll()) {
            if (user.getWaitTime() != null) {
                totalWaitTime += user.getWaitTime();
                numberOfUsers++;
            }
        }
        if (numberOfUsers == 0) {
            return 0;
        }
        return totalWaitTime / numberOfUsers;
    }

    public Long getLongestWaitTime() {
        Long longestWaitTime = 0L;
        for (WaitlistUser user : waitlistUserRepository.findAll()) {
            if (user.getWaitTime() != null && user.getWaitTime() > longestWaitTime) {
                longestWaitTime = user.getWaitTime();
            }
        }
        return longestWaitTime;
    }

    public Long getShortestWaitTime() {
        Long shortestWaitTime = Long.MAX_VALUE;
        for (WaitlistUser user : waitlistUserRepository.findAll()) {
            if (user.getWaitTime() != null && user.getWaitTime() < shortestWaitTime) {
                shortestWaitTime = user.getWaitTime();
            }
        }
        if (shortestWaitTime == Long.MAX_VALUE) {
            return 0L;
        }
        return shortestWaitTime;
    }
}
