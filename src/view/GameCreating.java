/*  
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog; 
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Caedes
 */
public class GameCreating extends JDialog {
    
    private Image background_img;
    private JButton cancel;
    private JButton save;
    private JTextField nom_J1;
    private JTextField nom_J2;
    private JComboBox nb_case;
    private JComboBox type_J1;
    private JComboBox color;
    private JComboBox type_J2;
    private MainWindow main;
    
    public GameCreating(Frame owner, MainWindow main) {
        super(owner);
        this.main = main;
        
        this.setTitle("Creation de partie");
        
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JLabel jLabel5 = new javax.swing.JLabel();
        JLabel jLabel6 = new javax.swing.JLabel();
        JLabel jLabel7 = new javax.swing.JLabel();
        JLabel jLabel8 = new javax.swing.JLabel();
        nom_J1 = new javax.swing.JTextField();
        nom_J2 = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();
        type_J2 = new javax.swing.JComboBox();
        color = new javax.swing.JComboBox();
        type_J1 = new javax.swing.JComboBox();
        nb_case = new javax.swing.JComboBox();

        jLabel1.setText("Joueur1");
        jLabel2.setText("Joueur2");
        nom_J1.setText("");
        cancel.setText("Annuler");       
        save.setText("Créer");
        nom_J2.setText("");
        jLabel3.setText("Nom");
        jLabel4.setText("Nom");
        jLabel5.setText("Type");
        jLabel6.setText("Type");
        jLabel7.setText("Couleur");
        jLabel8.setText("Nombre de cases :");
        type_J2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Humain", "IA niveau 1", "IA niveau 2", "IA niveau 3" }));
        color.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "blanc", "noir" }));
        type_J1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Humain" }));
        nb_case.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"4","6", "8", "10" }));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(save)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(type_J2, 0, 99, Short.MAX_VALUE)
                                    .addComponent(nom_J2)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nom_J1)
                                    .addComponent(color, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(type_J1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(nb_case, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nb_case, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom_J1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type_J1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom_J2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(type_J2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(cancel))
                .addGap(37, 37, 37))
        );
        
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createGame();
                setVisible(false);
            }
        });

        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    //Fonctions
    public void createGame(){
        
        String nameJ1 = "", nameJ2 = "";
        int typeP1 = 0; int typeP2 = 0;
         
        int nb_Case_Choosed = Integer.parseInt(nb_case.getSelectedItem().toString());        
        String color_Choosed = color.getSelectedItem().toString();
        
        if("blanc".equals(color_Choosed)){
            nameJ1 = nom_J1.getText();
            nameJ2 = nom_J2.getText();
            typeP2 = getIntType(type_J2.getSelectedItem().toString());
        }
        else if("noir".equals(color_Choosed)){
            nameJ1 = nom_J2.getText();
            typeP1 = getIntType(type_J2.getSelectedItem().toString());
            nameJ2 = nom_J1.getText();
        }
        
        this.main.beginGame(nameJ1, nameJ2, nb_Case_Choosed, typeP1, typeP2);
    }
    
    public void paintComponent(Graphics g) {
        g.drawImage(this.background_img, 0, 0, null);
    }
    
    public int getIntType(String val){
        int type = 0;
        if("IA niveau 1".equals(val)){
                type = 1;
            }
            else if("IA niveau 2".equals(val)){
                type = 2;
            }
            else if("IA niveau 3".equals(val)){
                type = 3;
            }
            else if("Humain".equals(val)){
                type = 0;
            }
        return type;
    }
}
