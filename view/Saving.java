/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Caedes
 */
public class Saving extends JDialog {
    
    private JTextField textName;
    private JButton cancel;
    private JButton save;

    public Saving(Frame owner) {
        super(owner);    
        this.setTitle("Sauvegarde");
        
        JLabel NameJLabel = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();

        NameJLabel.setText("Nom :");
        textName.setText("");
        cancel.setText("Annuler");
        save.setText("Sauvegarder");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(cancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(save)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(NameJLabel)
                .addGap(18, 18, 18)
                .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(save)
                    .addComponent(cancel))
                .addGap(30, 30, 30))
        );

        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();
 
	if(source == cancel){
		
	} else if(source == save){
		
	}
    }
}
