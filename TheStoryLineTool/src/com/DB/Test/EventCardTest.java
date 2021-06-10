package com.DB.Test;

import com.DB.DaoImplement.eventcard.Impl_EventCardDao;
import com.Domain.eventcard.Dom_EventCard;
import org.junit.Test;

import java.time.LocalDate;

/**
 * @ author Andrej Simionenko, Raheela Tasneem, Fei Gu, Ibraheem Swaidan
 * @ create 2021-06-08-10.47
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description This is the EASV D20 2nd semester final exam project
 * @ Supervisors Karsten Skov, Tommy Haugaard, Frank Østergaard Hansen
 * @ Version 0.1
 */
public class EventCardTest {
    @Test
    public void testInsert(){
        Impl_EventCardDao impl_eventCardDao = new Impl_EventCardDao();
        Dom_EventCard dom_eventCard = new Dom_EventCard(1,"Event1","Raheela",LocalDate.now());
        dom_eventCard.getDom_comment().setCommentID(2);
        dom_eventCard.getDom_event().setEventID(2);
        dom_eventCard.getDom_note().setNoteID(1);


        impl_eventCardDao.add(dom_eventCard);

    }

    @Test
    public void testModify(){

    }

    @Test
    public void testDelete(){
        Impl_EventCardDao impl_eventCardDao = new Impl_EventCardDao();
        impl_eventCardDao.delete(new Dom_EventCard(1,"Event1","Raheela",LocalDate.now()));

    }
}
