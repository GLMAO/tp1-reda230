package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.Objects;

public class HorlogeGUI extends JFrame implements TimerChangeListener {

    private final JLabel labelHeure;
    private final TimerService timerService;

    public HorlogeGUI(TimerService timerService) {
        super("Horloge graphique");

        this.timerService = timerService;

        // Configuration de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new BorderLayout());

        // Label principal
        labelHeure = new JLabel("", SwingConstants.CENTER);
        labelHeure.setFont(new Font("Consolas", Font.BOLD, 36));
        add(labelHeure, BorderLayout.CENTER);

        // S'abonner au timer
        timerService.addTimeChangeListener(this);

        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (Objects.equals(evt.getPropertyName(), TimerChangeListener.DIXEME_DE_SECONDE_PROP)) {
            SwingUtilities.invokeLater(() -> {
                String texte = String.format("%02d:%02d:%02d:%02d",
                        timerService.getHeures(),
                        timerService.getMinutes(),
                        timerService.getSecondes(),
                        timerService.getDixiemeDeSeconde());
                labelHeure.setText(texte);
            });
        }
    }
}
