package com.cabinet.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import com.cabinet.dao.PatientDAO;
import com.cabinet.dao.RendezVousDAO;
import com.cabinet.models.Patient;
import com.cabinet.models.RendezVous;

import java.util.List;

public class FormeGUI extends JFrame {

	private JTextField txtNom = new JTextField(15);
    private JTextField txtPrenom = new JTextField(15);
    private JTextField txtTel = new JTextField(15);
    private JTextField txtCin = new JTextField(15);
    private JTextField txtDate = new JTextField(15);
    private JButton btnAjouter = new JButton("Ajouter Patient");
    
    private DefaultTableModel modelPatient;
    private JTable tablePatient;
    private DefaultTableModel modelRdv;
    private JTable tableRdv;

    private PatientDAO patientDao = new PatientDAO();
    private RendezVousDAO rdvDao = new RendezVousDAO();

    private JTextField txtDateRdv = new JTextField(10);
    private JTextField txtHeureRdv = new JTextField(10);
    private JButton btnReserver = new JButton("Réserver");
    private JButton btnAfficher = new JButton("Afficher RDV du jour");

    public FormeGUI() {
        setTitle("Gestion Cabinet Médical");
        setSize(1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelForm = new JPanel(new GridLayout(6, 2, 5, 5));
        panelForm.setBorder(BorderFactory.createTitledBorder("Infos Patient"));
        panelForm.add(new JLabel("Prénom:")); panelForm.add(txtPrenom);
        panelForm.add(new JLabel("Nom:")); panelForm.add(txtNom);
        panelForm.add(new JLabel("Tel:")); panelForm.add(txtTel);
        panelForm.add(new JLabel("CIN:")); panelForm.add(txtCin);
        panelForm.add(new JLabel("Date Naiss (YYYY-MM-DD):")); panelForm.add(txtDate);
        panelForm.add(btnAjouter);
        add(panelForm, BorderLayout.WEST);
        
        JPanel panelTables = new JPanel(new GridLayout(1, 2, 10, 0));
        
        String[] colPatient = {"ID", "Nom", "Prénom", "Tel", "CIN"};
        modelPatient = new DefaultTableModel(colPatient, 0);
        tablePatient = new JTable(modelPatient);
        panelTables.add(new JScrollPane(tablePatient));

        String[] colRdv = {"ID", "Date", "Heure", "Statut"};
        modelRdv = new DefaultTableModel(colRdv, 0);
        tableRdv = new JTable(modelRdv);
        panelTables.add(new JScrollPane(tableRdv));

        add(panelTables, BorderLayout.CENTER);

        JPanel panelRdv = new JPanel(new FlowLayout());
        panelRdv.setBorder(BorderFactory.createTitledBorder("Nouveau RDV / Recherche"));
        panelRdv.add(new JLabel("Date (YYYY-MM-DD):")); panelRdv.add(txtDateRdv);
        panelRdv.add(new JLabel("Heure (HH:MM):")); panelRdv.add(txtHeureRdv);
        panelRdv.add(btnReserver);
        panelRdv.add(btnAfficher);
        add(panelRdv, BorderLayout.SOUTH);

        btnAjouter.addActionListener(e -> ajouterPatient());
        btnReserver.addActionListener(e -> reserverRdv());
        btnAfficher.addActionListener(e -> afficherRdvParDate());

        chargerPatients();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void chargerPatients() {
        modelPatient.setRowCount(0);
        List<Patient> liste = patientDao.getAllPatients();
        for (Patient p : liste) {
            modelPatient.addRow(new Object[]{p.getId(), p.getNom(), p.getPrénom(), p.getTéléphone(), p.getCIN()});
        }
    }

    private void ajouterPatient() {
        try {
            Patient p = new Patient(txtNom.getText(), txtPrenom.getText(), txtTel.getText(), txtCin.getText(), Date.valueOf(txtDate.getText()));
            patientDao.addPatient(p);
            chargerPatients();
            JOptionPane.showMessageDialog(this, "Patient ajouté!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur format date!");
        }
    }

    private void reserverRdv() {
        int row = tablePatient.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Sélectionnez un patient!");
            return;
        }
        try {
            long id = (long) modelPatient.getValueAt(row, 0);
            Patient p = new Patient(); 
            p.setId(id);

            RendezVous rdv = new RendezVous(0, Date.valueOf(txtDateRdv.getText()), txtHeureRdv.getText(), "Confirmé", p);
            rdvDao.addRDV(rdv);
            JOptionPane.showMessageDialog(this, "RDV enregistré!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur de saisie!");
        }
    }

    private void afficherRdvParDate() {
        try {
            modelRdv.setRowCount(0);
            Date d = Date.valueOf(txtDateRdv.getText());
            List<RendezVous> liste = rdvDao.getRendezVousParDate(d);
            for (RendezVous r : liste) {
                modelRdv.addRow(new Object[]{r.getPatient().getId(), r.getDateRdv(), r.getHeureRDV(), r.getStatut()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Entrez une date valide!");
        }
    }

    public static void main(String[] args) {
        new FormeGUI();
    }
}