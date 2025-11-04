package org.emp.gl.clients ;

import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService ;

import java.beans.PropertyChangeEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class CompteARebours implements TimerChangeListener {

    String name;
    int time;
    TimerService timerService ;


    public CompteARebours (String name , int time) {
        this.name = name ;
        this.time=time;
        timerService = new DummyTimeServiceImpl();
        timerService.addTimeChangeListener(this);
        System.out.println ("timercount  "+name+" initialized!") ;
    }


    public void propertyChange(PropertyChangeEvent evt) {
        if (time > 0 && evt.getPropertyName().equals(TimerChangeListener.SECONDE_PROP)) {
            time--;
            System.out.println("Reste "+ name+ " : " + time);
        }
        if (time == 0) {
            timerService.removeTimeChangeListener(this);
            }
        }



    }


