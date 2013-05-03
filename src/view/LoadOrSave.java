/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.KonaneException;
import controller.SaveFilter;
import java.awt.Frame;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

/**
 *
 * @author Caedes
 */
public class LoadOrSave extends JDialog {

    private JButton online;
    private JButton local;
    private int type_dialog;   //0 = load, 1 = save
    
    public LoadOrSave(Frame owner, int type) {
        super(owner);
        this.type_dialog = type;
        online = new javax.swing.JButton();
        local = new javax.swing.JButton();

        online.setText("En ligne");
        local.setText("En local");
        
        if(type == 0){
            local.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    LoadFileLocal();
                }
            });
            online.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                     LoadFileOnline();
                }
            });
        }
        else if(type == 1){
            local.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        SaveFileLocal();
                    } catch (KonaneException ex) {
                        
                    }
                }
            });
            online.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                     SaveFileOnline();
                }
            });
        }
        
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(online, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(local, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(local)
                .addGap(18, 18, 18)
                .addComponent(online)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        this.setLocationRelativeTo(null);
    }

    //Getter and setter
    public int getTypeDiag() {
        return type_dialog;
    }

    public void setTypeDiag(int type) {
        this.type_dialog = type;
    }

    //Fonctions
    public void LoadFileLocal(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new SaveFilter());
        //fileChooser.setCurrentDirectory(new File("/../.."));

        int reponse = fileChooser.showOpenDialog(this);
        if (reponse == JFileChooser.APPROVE_OPTION) {
            File selection = fileChooser.getSelectedFile();
            //partie.load
        }
    }
    
    public void SaveFileLocal() throws KonaneException{
        final JFileChooser fileChooser = new JFileChooser();
        int reponse = fileChooser.showSaveDialog(this);

        if (reponse == JFileChooser.APPROVE_OPTION) {
            File selection = fileChooser.getSelectedFile();
            save(selection);
            //Ecrire le contenu dans le fichier
 
        }
    }
    
    public void LoadFileOnline(){
        
    }
    
    public void SaveFileOnline(){
        
    }
    
    public void save(File file) throws KonaneException {
        String fname = file.getName();
        int lastPeriod = fname.lastIndexOf(".");
        if (lastPeriod != -1) {
            String extension = fname.substring(lastPeriod + 1).toLowerCase();
            if (("ini".equals(extension) ) || ("txt".equals(extension))) {
               //enregistrer

            }
            else {
                throw new KonaneException(); //manque l'erreur : mauvaise extension
            }
        }
        else {
            fname += ".ini";
            //enregistrer
        }
    }
}
