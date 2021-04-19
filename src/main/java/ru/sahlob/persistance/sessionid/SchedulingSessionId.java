package ru.sahlob.persistance.sessionid;

import lombok.Data;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.sahlob.db.DBSessionIDService;

@EnableScheduling
@EnableAsync
@Component
@Data
public class SchedulingSessionId {

    private final DBSessionIDService dbSessionIDService;

    @Scheduled(cron = "0 1 1 * * *")
    public void checkOldSessionID() {
        dbSessionIDService.deleteOldSession();
    }
}
