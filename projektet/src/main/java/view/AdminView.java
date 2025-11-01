package view;

import java.awt.*;
import javax.swing.*;
import controller.*;
import model.Kurs;
import view.lists.*;

public class AdminView extends BaseView {

    private BaseController ac, lc, sc;
    private JButton addKurstillfälle,  removeKurstillfälle, connectTeacher, disconnectTeacher, svararRapport, showkurser;
    private LärarLista lärarLista;
    private KurstillfälleLista KurstillfälleLista;
    private KursLista KursLista;

    public AdminView(String user, AdminCon adminCon, LärareCon lärareCon, StudentCon studentCon, KursCon KursCon, KurstillfälleCon KurstillfälleCon, BetygCon BetygCon, RapporteringCon RapporteringCon) {
        super("Välkommen Admin: " + user);
        this.ac = adminCon;
        setBackground(Color.DARK_GRAY);
        
        lärarLista = new LärarLista(lärareCon);
        KursLista = new KursLista(KursCon);
        KurstillfälleLista = new KurstillfälleLista(KurstillfälleCon);
        
        initComponents();
    }

    public void initComponents() {
        addKurstillfälle = new JButton("Lägg till Kurstillfälle");
        removeKurstillfälle = new JButton("Ta bort Kurstillfälle");
        connectTeacher = new JButton("Lägg till Lärare");
        disconnectTeacher = new JButton("Ta bort Lärare");
        svararRapport = new JButton("Svara rapportering");
        showkurser = new JButton("Visa kurser");

        style(addKurstillfälle);
        style(removeKurstillfälle);
        style(connectTeacher);
        style(disconnectTeacher);
        style(svararRapport);
        style(showkurser);

        KursLista.setVisible(false);

        contentPanel.add(KursLista);
        contentPanel.add(KurstillfälleLista);
        contentPanel.add(lärarLista);
        footerPanel.add(addKurstillfälle);
        footerPanel.add(removeKurstillfälle);
        footerPanel.add(connectTeacher);
        footerPanel.add(disconnectTeacher);
        footerPanel.add(svararRapport);
        footerPanel.add(showkurser);

        showkurser.addActionListener(e -> VisaKurser());
    }

    private void VisaKurser() {
        if (KursLista.isVisible()) {
            showkurser.setText("Visa kurser");
            KursLista.setVisible(false);
        } else {
            showkurser.setText("Dölj Kurser");
            KursLista.setVisible(true);
        }
    }

    private void style(JButton button) {
        if (button instanceof JButton) {
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Segoe UI", Font.BOLD, 16));
            button.setFocusable(false);
        }
    }

}
