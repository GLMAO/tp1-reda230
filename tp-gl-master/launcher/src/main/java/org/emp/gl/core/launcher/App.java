package org.emp.gl.core.launcher;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge ;
import org.emp.gl.clients.HorlogeGUI;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        //testDuTimeService();
        //testDuHorloge();
        testDeGUI();
    }

    private static void testDuTimeService() {
        CompteARebours c1 = new CompteARebours("Num 1",10) ;
        CompteARebours c2 = new CompteARebours("Num 2",15) ;
        CompteARebours c3 = new CompteARebours("Num 3",16) ;
        CompteARebours c4 = new CompteARebours("Num 4",13) ;
        CompteARebours c5 = new CompteARebours("Num 5",13) ;
        CompteARebours c6 = new CompteARebours("Num 6",19) ;
        CompteARebours c7 = new CompteARebours("Num 7",17) ;
        CompteARebours c8 = new CompteARebours("Num 8",13) ;
        CompteARebours c9 = new CompteARebours("Num 9",11) ;
        CompteARebours c10 = new CompteARebours("Num 10",15) ;

    }
    public static void testDuHorloge(){
        Horloge h1=new Horloge("h1");
    }
    public static void testDeGUI(){
        TimerService timer = new DummyTimeServiceImpl();
        new HorlogeGUI(timer);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

