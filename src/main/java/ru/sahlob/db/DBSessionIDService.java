package ru.sahlob.db;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.sahlob.db.interfaces.DBSessionIdRepository;
import ru.sahlob.persistance.sessionid.SessionId;

import java.util.Calendar;
import java.util.Date;

@Service
@Data
public class DBSessionIDService {
    private final DBSessionIdRepository dbSessionIdRepository;

    public void deleteOldSession() {
        var allSession = dbSessionIdRepository.findAll();
        if (!allSession.isEmpty()) {
            for (var session : allSession) {
                if (isSessionOld(session)) {
                    dbSessionIdRepository.delete(session);
                }
            }
        }
    }


    private boolean isSessionOld(SessionId sessionId) {
        var nawDate = new Date();
        var cal = Calendar.getInstance();
        cal.setTime(nawDate);
        var nawWeekNum = cal.get(Calendar.WEEK_OF_YEAR);
        var sessionIdWeekNum = sessionId.getNumOfWeek();
        if (sessionIdWeekNum == 52) {
            sessionIdWeekNum = -1;
        } else if (sessionIdWeekNum == 51) {
            sessionIdWeekNum = 0;
        }
        return nawWeekNum - sessionIdWeekNum >= 2;
    }
}
