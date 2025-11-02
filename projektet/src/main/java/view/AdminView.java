package view;

import java.awt.*;
import javax.swing.*;
import controller.*;
import model.*;
import view.lists.*;
import java.util.List;

public class AdminView extends BaseView {

    private AdminCon ac;
    private KurstillfälleCon kfc;
    private BetygCon bc;
    private RapporteringCon rc;

    private JButton connectTeacher, disconnectTeacher, svararRapport, showkurser, visaRapport;
    private LärareLista lärarLista;
    private KurstillfälleLista KurstillfälleLista;
    private LärarTilldelningLista lärarTilldelningLista;
    private RapportLista rapportLista;
    private KursLista KursLista;
    private JDialog dialog, dialog2;

    public AdminView(String user, AdminCon ac, LärareCon lc, StudentCon sc, KursCon kc, KurstillfälleCon kfc,
            BetygCon bc, RapporteringCon rc, LärarTilldelningCon ltc) {
        super("Välkommen Admin: " + user);
        this.ac = ac;
        this.kfc = kfc;
        this.bc = bc;
        this.rc = rc;
        setBackground(Color.DARK_GRAY);

        lärarLista = new LärareLista(lc);
        KurstillfälleLista = new KurstillfälleLista(kfc);
        KursLista = new KursLista(ac.getKc());
        lärarTilldelningLista = new LärarTilldelningLista(ac.getLtc());
        rapportLista = new RapportLista(rc);

        initComponents();
    }

    public void initComponents() {
        connectTeacher = new JButton("Koppla Lärare");
        disconnectTeacher = new JButton("Bortkoppla Lärare");
        svararRapport = new JButton("Svara Rapporteringar");
        showkurser = new JButton("Visa kurser");
        visaRapport = new JButton("Visa Rapportering");

        showkurser.addActionListener(e -> visaKurser());
        connectTeacher.addActionListener(e -> koppla());
        disconnectTeacher.addActionListener(e -> Bortkoppla());
        visaRapport.addActionListener(e -> visaRapport());

        dialog = new JDialog(this, "KursLista");
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.add(KursLista);
        dialog.add(panel);
        dialog.setSize(800, 800);
        
        dialog2 = new JDialog(this, "Rapportering");
        dialog2.setLocationRelativeTo(null);
        dialog2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.DARK_GRAY);
        panel2.add(rapportLista);
        dialog2.add(panel2);
        dialog2.setSize(400, 600);


        style(connectTeacher);
        style(disconnectTeacher);
        style(svararRapport);
        style(showkurser);

        contentPanel.add(KurstillfälleLista);
        contentPanel.add(lärarLista);
        contentPanel.add(lärarTilldelningLista);
        footerPanel.add(connectTeacher);
        footerPanel.add(disconnectTeacher);
        footerPanel.add(svararRapport);
        footerPanel.add(showkurser);
    }

    public void koppla() {
        Lärare l = lärarLista.getSelectedEntity();
        Kurstillfälle k = KurstillfälleLista.getSelectedEntity();

        if (l != null && k != null) {
            ac.assignTeacher(l.getID(), k.getID());
            lärarTilldelningLista.updateList(ac.getLtc().getAll());
        }
        else {
            JOptionPane.showMessageDialog(this, "Välj en lärare och en kurs!");
        }
    }

    public void Bortkoppla() {
        Lärare l = lärarLista.getSelectedEntity();
        Kurs k = KursLista.getSelectedEntity();
        if (l != null && k != null) {
            ac.removeTeacher(l.getID(), k.getID());
            lärarTilldelningLista.updateList(ac.getLtc().getAll());
        }
        else {
            JOptionPane.showMessageDialog(this, "Välj en lärare och en kurs!");
        }

    }

    private void visaKurser() {
        if (dialog.isVisible()) {
            showkurser.setText("Visa Kurser");
            dialog.setVisible(false);
        } else {
            showkurser.setText("Dölj Kurser");
            dialog.setVisible(true);
        }
    }

    private void visaRapport() {
        if (dialog2.isVisible()) {
            visaRapport.setText("Visa Rapportering");
            dialog2.setVisible(false);
        } else {
            visaRapport.setText("Dölj Rapportering");
            dialog2.setVisible(true);
        }
    }

    private void style(JButton button) {
        if (button instanceof JButton) {
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Segoe UI", Font.BOLD, 18));
            button.setFocusable(false);
        }
    }

}
