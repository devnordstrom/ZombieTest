/*
 * Copyright (C) 2019 Orville Nordström
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package zombietest.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.SwingUtilities;
import zombietest.experiment.Experiment;

/**
 *
 * @author Orville Nordström
 */
public class ManageExperimentGUI extends javax.swing.JFrame 
{
    /**
     * Creates new form MainGui
     */
    public ManageExperimentGUI() 
    {
        initComponents();
    }
    
    public void startGUI()
    {
        reset();
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void closeGUI()
    {
        dispose();
        
        System.exit(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        consoleJScrollPane = new javax.swing.JScrollPane();
        consoleJTextArea = new javax.swing.JTextArea();
        screenJPanel = new javax.swing.JPanel(){
            @Override
            public void paint(Graphics g)
            {
                Image image = createImage(getWidth(), getHeight());
                Graphics screenGraphics = image.getGraphics();
                paintComponent(screenGraphics);
                g.drawImage(image, 0, 0, this);
            }

            @Override
            public void paintComponent(Graphics g)
            {
                paintExperiment(g);
                repaint();
            }
        };
        infoJLabel = new javax.swing.JLabel();
        closeJButton = new javax.swing.JButton();
        startSingleRoundJButton = new javax.swing.JButton();
        startExperimentJButton = new javax.swing.JButton();
        resultJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        consoleJTextArea.setEditable(false);
        consoleJTextArea.setColumns(20);
        consoleJTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        consoleJTextArea.setLineWrap(true);
        consoleJTextArea.setRows(5);
        consoleJScrollPane.setViewportView(consoleJTextArea);

        javax.swing.GroupLayout screenJPanelLayout = new javax.swing.GroupLayout(screenJPanel);
        screenJPanel.setLayout(screenJPanelLayout);
        screenJPanelLayout.setHorizontalGroup(
            screenJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        screenJPanelLayout.setVerticalGroup(
            screenJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        infoJLabel.setText("Displays information");

        closeJButton.setText("Close");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });

        startSingleRoundJButton.setText("Start single round");
        startSingleRoundJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSingleRoundJButtonActionPerformed(evt);
            }
        });

        startExperimentJButton.setText("Start experiment");
        startExperimentJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startExperimentJButtonActionPerformed(evt);
            }
        });

        resultJLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        resultJLabel.setText("Displays the result");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(screenJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resultJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startExperimentJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startSingleRoundJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeJButton))
                    .addComponent(consoleJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(consoleJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(screenJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeJButton)
                    .addComponent(startSingleRoundJButton)
                    .addComponent(startExperimentJButton)
                    .addComponent(resultJLabel))
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJButtonActionPerformed
        closeGUI();
    }//GEN-LAST:event_closeJButtonActionPerformed

    private void startSingleRoundJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSingleRoundJButtonActionPerformed
        startSingleExperiment();
    }//GEN-LAST:event_startSingleRoundJButtonActionPerformed

    private void startExperimentJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startExperimentJButtonActionPerformed
        int numberOfExperiments = 10;
        manageStartMultipleExperiments(numberOfExperiments);
    }//GEN-LAST:event_startExperimentJButtonActionPerformed
    
    public void setExperiment(Experiment experiment) 
    {
        this.experiment = experiment;

        this.experiment.setOutput(getConsolePrintStream());
    }

    private PrintStream getConsolePrintStream() 
    {
        OutputStream consoleOutputStream = new OutputStream() {
            @Override
            public void write(int c) throws IOException {
                consoleJTextArea.append(String.valueOf((char) c));
                consoleJTextArea.setCaretPosition(consoleJTextArea.getDocument().getLength());
            }
        };

        return new PrintStream(consoleOutputStream);
    }

    private void reset() 
    {
        infoJLabel.setText("Ready to start simulation.");
        resultJLabel.setText("");
        consoleJTextArea.setText("");
    }    
    
    private void enableExperimentComponents(boolean enable)
    {
        SwingUtilities.invokeLater(()-> {
            startSingleRoundJButton.setEnabled(enable);
            startExperimentJButton.setEnabled(enable);
        });
    }
    
    private void paintExperiment(Graphics g)
    {
        if(experiment == null) {
            return;
        }
        
        experiment.paint(g);
    }
    
    private void startSingleExperiment()
    {        
        enableExperimentComponents(false);
        
        resultJLabel.setText("");
        consoleJTextArea.setText("");
        
        delayTime = DEFAULT_DELAY_TIME;
        
        new Thread(() -> {
            int rounds = runExperiment();
            
            String result = "All humans infected in "+ rounds +" rounds.";
            resultJLabel.setText(result);
            
            enableExperimentComponents(true);
        }).start();
    }
    
    private void manageStartMultipleExperiments(int numberOfExperiments)
    {
        enableExperimentComponents(false);
        
        resultJLabel.setText("");
        consoleJTextArea.setText("");
        
        delayTime = SHORT_DELAY_TIME;
        
        new Thread(() -> {
            int rounds = 0;
            for(int i = 0; i < numberOfExperiments; i++) {
                resultJLabel.setText("Now running experiment #"+(i+1)+".");
                
                rounds += runExperiment();
            }
            
            double averageRoundsPerExperiment = (rounds*1.0) / (numberOfExperiments*1.0);
            
            String result = numberOfExperiments + " experiments completed, average number of rounds was "
                    + String.format("%.2f", averageRoundsPerExperiment) +".";
            
            resultJLabel.setText(result);
            
            enableExperimentComponents(true);
        }).start();
    }
    
    private int runExperiment()
    {
        experiment.reset();
            
        int roundCount = 0;
        
        while(true) {
            roundCount++;
            
            experiment.runRound();

            String experimentInfo = experiment.getInformation();

            //Repaints entities on the "screen".
            SwingUtilities.invokeLater(()-> {
                infoJLabel.setText(experimentInfo);

                screenJPanel.repaint();
            });

            if(experiment.isCompleted()) {
                break;
            }

            delay();
        }
        
        return roundCount;
    }
    
    private void delay()
    {
        try {
            Thread.sleep(delayTime);
        } catch(InterruptedException interEx) {
        }
    }
    
    private static final long DEFAULT_DELAY_TIME = 500;
    private static final long SHORT_DELAY_TIME = 100;
    
    private Experiment experiment;
    
    private long delayTime = DEFAULT_DELAY_TIME;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeJButton;
    private javax.swing.JScrollPane consoleJScrollPane;
    private javax.swing.JTextArea consoleJTextArea;
    private javax.swing.JLabel infoJLabel;
    private javax.swing.JLabel resultJLabel;
    private javax.swing.JPanel screenJPanel;
    private javax.swing.JButton startExperimentJButton;
    private javax.swing.JButton startSingleRoundJButton;
    // End of variables declaration//GEN-END:variables
}