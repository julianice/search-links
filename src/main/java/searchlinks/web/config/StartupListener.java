package searchlinks.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import searchlinks.entities.User;

import javax.persistence.NoResultException;


@Component
public class StartupListener {


    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent ctxStartEvt) {

    }
}
