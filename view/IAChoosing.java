/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author Caedes
 */
public class IAChoosing extends JDialog {
    
    private JList list_IA;
    private JButton cancel;
    private JButton save;

    public IAChoosing(Frame owner) {
        super(owner);
        this.setTitle("Choix de l'IA");
        
        JScrollPane scrollJ = new javax.swing.JScrollPane();
        list_IA = new javax.swing.JList();
        JLabel LabelIA = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();

        list_IA.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "IA niveau 1", "IA niveau 2", "IA niveau 3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrollJ.setViewportView(list_IA);
        LabelIA.setText("Choix du niveau de l'IA : ");
        cancel.setText("Annuler");
        save.setText("Choisir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(cancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(save)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelIA, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(scrollJ))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(LabelIA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollJ, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(save))
                .addGap(22, 22, 22))
        );

        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    
}
