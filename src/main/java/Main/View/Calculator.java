/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Main.View;

import Main.Controller.Formula;
import Main.Controller.Validation;
import Main.View.Table;
import javax.swing.JOptionPane;

/**Classe do view que representa a calculadora de fórmulas lógicas
 *
 * @author havillon
 */
public class Calculator extends javax.swing.JFrame {

    /**
     * Creates new form Calculator
     */
    public Calculator() {
        initComponents();
    }
    
    int posicao = 0;
    Formula f;
    Validation val;
    
    /** Método que adicinona um caractere no campo de texto, de forma a inseri-lo onde o cursor está apontando
     * 
     * @param txt String - Texto antes da inserção do caractere
     * @param pos Integer - Posição onde o caractere deve ser inserido
     * @param c Character - Caractere a ser inserido
     * @return String - Texto com o caractere
     */
    public String adcChar(String txt, int pos, char c){
        return txt.substring(0, pos) + c + txt.substring(pos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfInput = new javax.swing.JTextField();
        bClear = new javax.swing.JButton();
        bParentesesAbrindo = new javax.swing.JButton();
        bParentesesFechando = new javax.swing.JButton();
        bOperandoA = new javax.swing.JButton();
        bOperandoB = new javax.swing.JButton();
        bOperandoC = new javax.swing.JButton();
        bOperandoD = new javax.swing.JButton();
        bCalcular = new javax.swing.JButton();
        bOperandoE = new javax.swing.JButton();
        bOperadorOR = new javax.swing.JButton();
        bOperadorAND = new javax.swing.JButton();
        bOperadorNOT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora de Fórmulas Lógicas");
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 800));
        setType(java.awt.Window.Type.UTILITY);

        tfInput.setFont(new java.awt.Font("Ubuntu", 0, 30)); // NOI18N
        tfInput.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfInputFocusGained(evt);
            }
        });
        tfInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfInputMouseClicked(evt);
            }
        });
        tfInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfInputActionPerformed(evt);
            }
        });
        tfInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfInputKeyReleased(evt);
            }
        });

        bClear.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        bClear.setText("Clear");
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });

        bParentesesAbrindo.setFont(new java.awt.Font("Ubuntu", 0, 25)); // NOI18N
        bParentesesAbrindo.setText("(");
        bParentesesAbrindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bParentesesAbrindoActionPerformed(evt);
            }
        });

        bParentesesFechando.setFont(new java.awt.Font("Ubuntu", 0, 25)); // NOI18N
        bParentesesFechando.setText(")");
        bParentesesFechando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bParentesesFechandoActionPerformed(evt);
            }
        });

        bOperandoA.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        bOperandoA.setText("A");
        bOperandoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOperandoAActionPerformed(evt);
            }
        });

        bOperandoB.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        bOperandoB.setText("B");
        bOperandoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOperandoBActionPerformed(evt);
            }
        });

        bOperandoC.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        bOperandoC.setText("C");
        bOperandoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOperandoCActionPerformed(evt);
            }
        });

        bOperandoD.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        bOperandoD.setText("D");
        bOperandoD.setName("bOperandoD"); // NOI18N
        bOperandoD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOperandoDActionPerformed(evt);
            }
        });

        bCalcular.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        bCalcular.setText("=");
        bCalcular.setName("bIgual"); // NOI18N
        bCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalcularActionPerformed(evt);
            }
        });

        bOperandoE.setFont(new java.awt.Font("Ubuntu", 1, 25)); // NOI18N
        bOperandoE.setText("E");
        bOperandoE.setName("bOperandoE"); // NOI18N
        bOperandoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOperandoEActionPerformed(evt);
            }
        });

        bOperadorOR.setFont(new java.awt.Font("Ubuntu", 0, 25)); // NOI18N
        bOperadorOR.setText("+");
        bOperadorOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOperadorORActionPerformed(evt);
            }
        });

        bOperadorAND.setFont(new java.awt.Font("Ubuntu", 0, 25)); // NOI18N
        bOperadorAND.setText(".");
        bOperadorAND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOperadorANDActionPerformed(evt);
            }
        });

        bOperadorNOT.setFont(new java.awt.Font("Ubuntu", 0, 25)); // NOI18N
        bOperadorNOT.setText("~");
        bOperadorNOT.setPreferredSize(new java.awt.Dimension(40, 52));
        bOperadorNOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOperadorNOTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfInput)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(bOperandoD, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bOperandoA, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bOperandoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bOperandoE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bOperandoC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bCalcular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bOperadorOR, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bOperadorAND, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bOperadorNOT, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bParentesesAbrindo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bParentesesFechando, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tfInput, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(bClear, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(bOperadorOR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bOperadorAND, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bOperadorNOT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bParentesesAbrindo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bParentesesFechando, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOperandoA, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bOperandoB, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bOperandoC, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOperandoD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bOperandoE, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfInputActionPerformed

    private void bCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCalcularActionPerformed
        val = new Validation(tfInput.getText());
        String message = Validation.validate();
        if(!"".equals(message)){
            JOptionPane.showMessageDialog(null,message, "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            f = new Formula(tfInput.getText());
            f.fillMap();
            f.variablesToFormulas();
            f.separateFormulas(tfInput.getText());
            f.generateTable();
            String forms[] = new String[f.formulas.size()];
            for (int i = 0; i < forms.length; i++) {
                forms[i] = f.formulas.get(i);
            }
            Table tabela = new Table(f.tabela, forms);
            tabela.setVisible(true);
        }
        
    }//GEN-LAST:event_bCalcularActionPerformed

    private void bParentesesFechandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bParentesesFechandoActionPerformed
        tfInput.setText(adcChar(tfInput.getText(), posicao, ')'));
        posicao = tfInput.getCaretPosition();
    }//GEN-LAST:event_bParentesesFechandoActionPerformed

    private void bOperadorANDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOperadorANDActionPerformed
        tfInput.setText(adcChar(tfInput.getText(), posicao, '.'));
        posicao = tfInput.getCaretPosition();
    }//GEN-LAST:event_bOperadorANDActionPerformed

    private void bOperandoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOperandoAActionPerformed
        tfInput.setText(adcChar(tfInput.getText(), posicao, 'A'));
        posicao = tfInput.getCaretPosition();
    }//GEN-LAST:event_bOperandoAActionPerformed

    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed
        tfInput.setText("");
        posicao = 0;
    }//GEN-LAST:event_bClearActionPerformed

    private void bOperadorORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOperadorORActionPerformed
        tfInput.setText(adcChar(tfInput.getText(), posicao, '+'));
        posicao = tfInput.getCaretPosition();
    }//GEN-LAST:event_bOperadorORActionPerformed

    private void bOperandoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOperandoBActionPerformed
        tfInput.setText(adcChar(tfInput.getText(), posicao, 'B'));
        posicao = tfInput.getCaretPosition();
    }//GEN-LAST:event_bOperandoBActionPerformed

    private void bOperandoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOperandoCActionPerformed
        tfInput.setText(adcChar(tfInput.getText(), posicao, 'C'));
        posicao = tfInput.getCaretPosition();
    }//GEN-LAST:event_bOperandoCActionPerformed

    private void bOperandoDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOperandoDActionPerformed
        tfInput.setText(adcChar(tfInput.getText(), posicao, 'D'));
        posicao = tfInput.getCaretPosition();
    }//GEN-LAST:event_bOperandoDActionPerformed

    private void bOperandoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOperandoEActionPerformed
        tfInput.setText(adcChar(tfInput.getText(), posicao, 'E'));
        posicao = tfInput.getCaretPosition();
    }//GEN-LAST:event_bOperandoEActionPerformed

    private void bParentesesAbrindoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bParentesesAbrindoActionPerformed
        tfInput.setText(adcChar(tfInput.getText(), posicao, '('));
        posicao = tfInput.getCaretPosition();
    }//GEN-LAST:event_bParentesesAbrindoActionPerformed

    private void bOperadorNOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOperadorNOTActionPerformed
        tfInput.setText(adcChar(tfInput.getText(), posicao, '~'));
        posicao = tfInput.getCaretPosition();
    }//GEN-LAST:event_bOperadorNOTActionPerformed

    private void tfInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfInputFocusGained
        
    }//GEN-LAST:event_tfInputFocusGained

    private void tfInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfInputMouseClicked
        posicao = tfInput.getCaretPosition();
    }//GEN-LAST:event_tfInputMouseClicked

    private void tfInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfInputKeyReleased
        posicao = tfInput.getCaretPosition();
    }//GEN-LAST:event_tfInputKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCalcular;
    private javax.swing.JButton bClear;
    private javax.swing.JButton bOperadorAND;
    private javax.swing.JButton bOperadorNOT;
    private javax.swing.JButton bOperadorOR;
    private javax.swing.JButton bOperandoA;
    private javax.swing.JButton bOperandoB;
    private javax.swing.JButton bOperandoC;
    private javax.swing.JButton bOperandoD;
    private javax.swing.JButton bOperandoE;
    private javax.swing.JButton bParentesesAbrindo;
    private javax.swing.JButton bParentesesFechando;
    private javax.swing.JTextField tfInput;
    // End of variables declaration//GEN-END:variables
}
