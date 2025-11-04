package org.emp.gl.clients ; 

import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService ;

import java.beans.PropertyChangeEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class Horloge implements TimerChangeListener {

    String name; 
    TimerService timerService ;


    public Horloge (String name) {
        this.name = name ;
        timerService = new DummyTimeServiceImpl();
        timerService.addTimeChangeListener(this);
        System.out.println ("Horloge "+name+" initialized!") ;
    }

    public void afficherHeure () {
        if (timerService != null)
            System.out.println (name + " affiche " + 
                                timerService.getHeures() +":"+
                                timerService.getMinutes()+":"+
                                timerService.getSecondes()) ;
    }
    public void propertyChange (PropertyChangeEvent evt){
        if(Objects.equals(evt.getPropertyName(), TimerChangeListener.SECONDE_PROP))
            this.afficherHeure();
    }

}
