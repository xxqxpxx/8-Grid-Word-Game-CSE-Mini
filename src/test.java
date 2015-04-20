
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import javax.swing.*;
import javax.swing.Timer;
import java.sql.*;
import java.util.ArrayList;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mohammed Talal Zidan
 */
public class test extends javax.swing.JFrame {
    
  
     // array of JButton to put the buttons in it
        JButton [] arr = new JButton[8];
    
    // the x position of the button which we want to move
    int localX;
    // the y position of the button which we want to move
    int localY;
    // the x position of the empty button
    int emptyX;
    // the y position of the empty button
    int emptyY;
    // the counter of the timer 120 sec.
    int count = 120;
    // object from the timer class
    Timer time;
    
    
    // array of strings with 1000 word in which the strings
    // from the database will be saved 
    // the indexOFstring keeps track of the random selected e
    // word so that we can check later is it right or wrong
    String [] string = new String[1000];
    int indexOFstring  =  0; 
    int scorex = 0;


       
   // Constructor 
    public test() {
        
        initComponents();
        
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String host = "jdbc:sqlserver://localhost:1433;databaseName=puzzle";
                String user = "mohammed";
                String pass = "m7mdtalal";
            Connection con = DriverManager.getConnection(host,user,pass);
           
            Statement stm = con.createStatement();
            
            
        
            String sql = "Select * from words";
            ResultSet rs= stm.executeQuery(sql);
            
                    int Q = 0 ;
                   while(rs.next())
                   {
                      
                      string[Q++] =  rs.getString("word");                
                   
                   }
                   stm.close();
                   con.close();
                  
        }
        catch (Exception e) 
        {
            System.out.println(e.getStackTrace());   
        }
        
        
        // the hidden button (the empty one )
        jButton11.setVisible(false);
        
        fillButtons();
        
            // time  is object from Timer class 
           //Timer class contains 2 arguments (... , ... )
          // first argument responsible for the speed of the passage of time , 1000 : main 1 second
         // ActionListeneer is responsible for implement action event
            time = new Timer(1000, new ActionListener() {

             public void actionPerformed(ActionEvent e) {   
               //decrement time allowed in the game level
              count--;               
              //timerlbl : name of timer label on design
              //and make this timer visible on design
             timerlbl.setText(String.valueOf("Time out : "+count));

             //condition to stop game when time finish
               if (count ==0)
                {
                   //to show message when time of level game finish
                  JOptionPane.showMessageDialog(timerlbl,"Time out");
                    setVisible(false);
                   // StartForm s = new StartForm();
                    score s= new score();
                    s.scorey = scorex;
                    
                  s.setVisible(true);
                    time.stop();
                   
                    
                } //end If condition    
                     
                    } //end of actionPerformed method
                }) ;
                //to start timer
                time.start();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        timerlbl = new java.awt.Label();
        submit_bttn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Word Puzzle");
        setResizable(false);

        jPanel4.setLayout(new java.awt.GridLayout(3, 3));

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);

        jButton9.setText("jButton9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9);

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5);

        jButton6.setText("jButton6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6);

        jButton7.setText("jButton7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7);

        jButton8.setText("jButton8");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8);

        jButton10.setText("jButton10");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton10);

        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton11);

        jButton2.setText("pause");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        submit_bttn.setText("Submit");
        submit_bttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_bttnActionPerformed(evt);
            }
        });

        jLabel1.setText("Score :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(timerlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submit_bttn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timerlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(submit_bttn)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // pause button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        time.stop();
        setVisible(false);
        JOptionPane.showMessageDialog(null, "Click ok to resume game");
        setVisible(true);
        time.start();
    }//GEN-LAST:event_jButton2ActionPerformed

    
  // button10 event
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       
        /* here localX ,localY -- is the variable contain the X, Y of buttons
           emptyX ,emptyY   --    is the variable contain the X, Y of empty button
        
           getY() component to return current position of X of button
           getY() component to return current X of button
        
        */
        
         localX = jButton10.getX();
         localY = jButton10.getY();
        
         emptyX = jButton11.getX();
         emptyY = jButton11.getY();
        
        
        /*
        check if position of button we want to move it next to empty button (y3ni elbutton 2le 3ayz a7rko ganb el button elfady wala la)
        
        Math.abs(X,y) : calculate the ratio between X and Y  
        
        this to replace button10 by button 11 (empty button)
        */
        
        if ( ( localX < emptyX && localY == emptyY ) && Math.abs(localX - emptyX) == 109 )
        {
           jButton11.setLocation(localX, localY);
           jButton10.setLocation(emptyX, emptyY);
        }
        
        else if (localX > emptyX && localY == emptyY && Math.abs(localX - emptyX) == 109 )
        {
           jButton11.setLocation(localX, localY);
           jButton10.setLocation(emptyX, emptyY);
        }
        else if (localX == emptyX && localY < emptyY && Math.abs(localY - emptyY) == 63 )
        {
           jButton11.setLocation(localX, localY);
           jButton10.setLocation(emptyX, emptyY);
        }
        
        else if (localX == emptyX && localY > emptyY && Math.abs(localY - emptyY) == 63)
        {
           jButton11.setLocation(localX, localY);
           jButton10.setLocation(emptyX, emptyY);
        }
        
    }//GEN-LAST:event_jButton10ActionPerformed
//end of button 10
    
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         localX = jButton7.getX();
         localY = jButton7.getY();
        
         emptyX = jButton11.getX();
         emptyY = jButton11.getY();
        
        
        if ( ( localX < emptyX && localY == emptyY ) && Math.abs(localX - emptyX) == 109 )
        {
           jButton11.setLocation(localX, localY);
           jButton7.setLocation(emptyX, emptyY);
        }
        
        else if (localX > emptyX && localY == emptyY && Math.abs(localX - emptyX) == 109 )
        {
           jButton11.setLocation(localX, localY);
           jButton7.setLocation(emptyX, emptyY);
        }
        
        
        else if (localX == emptyX && localY < emptyY && Math.abs(localY - emptyY) == 63 )
        {
           jButton11.setLocation(localX, localY);
           jButton7.setLocation(emptyX, emptyY);
        }
        
        else if (localX == emptyX && localY > emptyY && Math.abs(localY - emptyY) == 63)
        {
           jButton11.setLocation(localX, localY);
           jButton7.setLocation(emptyX, emptyY);
        }
    }//GEN-LAST:event_jButton7ActionPerformed
//end of button7
    
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       //this is the empty button        
    }//GEN-LAST:event_jButton11ActionPerformed
//end of button11 (empty button)
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         localX = jButton3.getX();
         localY = jButton3.getY();      
         emptyX = jButton11.getX();
         emptyY = jButton11.getY();
        
        if ( ( localX < emptyX && localY == emptyY ) && Math.abs(localX - emptyX) == 109 )
        {
           jButton11.setLocation(localX, localY);
           jButton3.setLocation(emptyX, emptyY);
        }
        else if (localX > emptyX && localY == emptyY && Math.abs(localX - emptyX) == 109 )
        {
           jButton11.setLocation(localX, localY);
           jButton3.setLocation(emptyX, emptyY);
        }           
        else if (localX == emptyX && localY < emptyY && Math.abs(localY - emptyY) == 63 )
        {
           jButton11.setLocation(localX, localY);
           jButton3.setLocation(emptyX, emptyY);
        }     
        else if (localX == emptyX && localY > emptyY && Math.abs(localY - emptyY) == 63)
        {
           jButton11.setLocation(localX, localY);
           jButton3.setLocation(emptyX, emptyY);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
//end of button3
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        localX = jButton4.getX();
         localY = jButton4.getY();
        
         emptyX = jButton11.getX();
         emptyY = jButton11.getY();
        
        
        if ( ( localX < emptyX && localY == emptyY ) && Math.abs(localX - emptyX) == 109 )
        {
           jButton11.setLocation(localX, localY);
           jButton4.setLocation(emptyX, emptyY);
        }
        
        else if (localX > emptyX && localY == emptyY && Math.abs(localX - emptyX) == 109 )
        {
           jButton11.setLocation(localX, localY);
           jButton4.setLocation(emptyX, emptyY);
        }
        
        
        else if (localX == emptyX && localY < emptyY && Math.abs(localY - emptyY) == 63 )
        {
           jButton11.setLocation(localX, localY);
           jButton4.setLocation(emptyX, emptyY);
        }
        
        else if (localX == emptyX && localY > emptyY && Math.abs(localY - emptyY) == 63)
        {
           jButton11.setLocation(localX, localY);
           jButton4.setLocation(emptyX, emptyY);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
//end of button4
    
    
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
            //System.out.println( jButton9.getLocation());        
         localX = jButton9.getX();
         localY = jButton9.getY();
        
         emptyX = jButton11.getX();
         emptyY = jButton11.getY();
        
        
        if ( ( localX < emptyX && localY == emptyY ) && Math.abs(localX - emptyX) == 109 )
        {
           jButton11.setLocation(localX, localY);
           jButton9.setLocation(emptyX, emptyY);
        }
        
        else if (localX > emptyX && localY == emptyY && Math.abs(localX - emptyX) == 109 )
        {
           jButton11.setLocation(localX, localY);
           jButton9.setLocation(emptyX, emptyY);
        }
        
        
        else if (localX == emptyX && localY < emptyY && Math.abs(localY - emptyY) == 63 )
        {
           jButton11.setLocation(localX, localY);
           jButton9.setLocation(emptyX, emptyY);
        }
        
        else if (localX == emptyX && localY > emptyY && Math.abs(localY - emptyY) == 63)
        {
           jButton11.setLocation(localX, localY);
           jButton9.setLocation(emptyX, emptyY);
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed
//end of button9
    
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          // System.out.println( jButton5.getLocation());    
        
         localX = jButton5.getX();
         localY = jButton5.getY();
        
         emptyX = jButton11.getX();
         emptyY = jButton11.getY();
        if ((localX < emptyX && emptyY == localY )  && Math.abs(emptyX - localX) == 109 )
            {
                jButton11.setLocation(localX, localY);
                jButton5.setLocation(emptyX, emptyY);
            }
         else if (  (localX == emptyX && localY < emptyY ) &&   Math.abs(localY - emptyY)==63)
        {
             jButton11.setLocation(localX, localY);
             jButton5.setLocation(emptyX, emptyY);
        }
        else if (  (localX == emptyX && localY > emptyY ) &&   Math.abs(localY - emptyY)==63)
        {
             jButton11.setLocation(localX, localY);
             jButton5.setLocation(emptyX, emptyY);
        }
        else if (  (localX > emptyX && localY == emptyY ) &&   Math.abs(localX - emptyX)==109)
        {
             jButton11.setLocation(localX, localY);
             jButton5.setLocation(emptyX, emptyY);
        }
    }//GEN-LAST:event_jButton5ActionPerformed
//end of button5
    
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            localX = jButton6.getX();
            localY = jButton6.getY();
        
          emptyX = jButton11.getX();
          emptyY = jButton11.getY();
        if ((localX == emptyX && emptyY > localY )  && Math.abs(emptyY - localY) == 63 )
            {
                jButton11.setLocation(localX, localY);
                jButton6.setLocation(emptyX, emptyY);
            }
         else if (  (localX == emptyX && localY > emptyY ) &&   Math.abs(localY - emptyY)==63)
        {
             jButton11.setLocation(localX, localY);
             jButton6.setLocation(emptyX, emptyY);
        }
        
        else if (  (localX < emptyX && localY == emptyY ) &&   Math.abs(localX - emptyX)==109)
        {
             jButton11.setLocation(localX, localY);
             jButton6.setLocation(emptyX, emptyY);
        }
         else if (  (localX > emptyX && localY == emptyY ) &&   Math.abs(localX - emptyX)==109)
        {
             jButton11.setLocation(localX, localY);
             jButton6.setLocation(emptyX, emptyY);
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed
//end of button6
    
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
            
         localX = jButton8.getX();
         localY = jButton8.getY();      
         emptyX = jButton11.getX();
         emptyY = jButton11.getY();
        
        if ( ( localX < emptyX && localY == emptyY ) && Math.abs(localX - emptyX) == 109 )
        {
           jButton11.setLocation(localX, localY);
           jButton8.setLocation(emptyX, emptyY);
        }
        else if (localX > emptyX && localY == emptyY && Math.abs(localX - emptyX) == 109 )
        {
           jButton11.setLocation(localX, localY);
           jButton8.setLocation(emptyX, emptyY);
        }
        else if (localX == emptyX && localY < emptyY && Math.abs(localY - emptyY) == 63 )
        {
           jButton11.setLocation(localX, localY);
           jButton8.setLocation(emptyX, emptyY);
        }        
        else if (localX == emptyX && localY > emptyY && Math.abs(localY - emptyY) == 63)
        {
           jButton11.setLocation(localX, localY);
           jButton8.setLocation(emptyX, emptyY);
        }  
    }//GEN-LAST:event_jButton8ActionPerformed

    
    
    private void fillButtons()
    {
        
                     Generator g = new Generator();
        
                     Random anyword = new Random();
                     String x = g.randomizer(string[ indexOFstring = anyword.nextInt(string.length)]);    

                    jButton3.setText( (String.valueOf(x.charAt(0))));
                    jButton4.setText( (String.valueOf(x.charAt(1))));
                    jButton5.setText( (String.valueOf(x.charAt(2))));
                    jButton6.setText( (String.valueOf(x.charAt(3))));
                    jButton7.setText( (String.valueOf(x.charAt(4))));
                    jButton8.setText( (String.valueOf(x.charAt(5))));
                    jButton9.setText( (String.valueOf(x.charAt(6))));
                    jButton10.setText( (String.valueOf(x.charAt(7))));
                  
    }
    
    
    
    
    
        @SuppressWarnings("empty-statement")
    private void submit_bttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_bttnActionPerformed

        
        String row = "" , column = "";
        
         // array of buttons to store all the button's data & locations 
         JButton [] locations = new JButton[8];
                 
         locations[0]=jButton3;
         locations[1]=jButton4;
         locations[2]=jButton5;
         locations[3]=jButton6;
         locations[4]=jButton7;
         locations[5]=jButton8;
         locations[6]=jButton9;
         locations[7]=jButton10;
         
         /*
         array of numbers in which i will store the index of the button 
         and loop throw locations to get the Y-axis 
         the idea here that the first row buttons will have Y = 1 
         so i will have the three buttons in the first row 
              
         */
         int []temp = new int [3] ;
         int j = 0 ;
         
         for (int i = 0 ; i < 8 ; ++i)
         {
             if (1 == locations[i].getY())
                 temp[j++] = i ; 
         }
         
         // comparing the locations of the buttons 
         // they are 3 buttons with 2^3 permutions of 
         // i will search in locations with the indexs stored in temp
         // and get the chars in  the sequance of buttons according to their locations 
         
         
         // enta htshel elprint w t7ot ely hytl3 da f string w t3mlo compare m3 el final answer 
         if ( ( locations[temp[0]].getX() < locations[temp[1]].getX() ) && ( locations[temp[0]].getX() < locations[temp[2]].getX() ) )
                if( ( locations[temp[1]].getX() < locations[temp[2]].getX() ) )
                    row = ( ( locations[temp[0]].getText() + locations[temp[1]].getText()   + locations[temp[2]].getText()).toString());
                    
                else
                   row =( ( locations[temp[0]].getText() + locations[temp[2]].getText()   + locations[temp[1]].getText()).toString());
                    
         
         
         
          if ( ( locations[temp[0]].getX() > locations[temp[1]].getX() ) && ( locations[temp[0]].getX() > locations[temp[2]].getX() ) )
                if( ( locations[temp[1]].getX() > locations[temp[2]].getX() ) )
                        row = ( ( locations[temp[2]].getText() + locations[temp[1]].getText()   + locations[temp[0]].getText()).toString());
          
                else
                     row =( ( locations[temp[1]].getText() + locations[temp[2]].getText()   + locations[temp[0]].getText()).toString());
                   
          
           if ( ( locations[temp[1]].getX() > locations[temp[0]].getX() ) && ( locations[temp[1]].getX() > locations[temp[2]].getX() ) )
                if( ( locations[temp[0]].getX() < locations[temp[2]].getX() ) )
                        row =( ( locations[temp[0]].getText() + locations[temp[2]].getText()   + locations[temp[1]].getText()).toString());
          
                else
                   row =( ( locations[temp[2]].getText() + locations[temp[0]].getText()   + locations[temp[1]].getText()).toString());
          
         
            
         
         
               int []temp1 = new int [3] ;
                    int j1 = 0 ;

                    for (int i = 0 ; i < 8 ; ++i)
                    {
                        if (0 == locations[i].getX())
                            temp1[j1++] = i ; 
                    }
                    
                
               if ( ( locations[temp1[0]].getY() > locations[temp1[1]].getY() ) && ( locations[temp1[0]].getY() > locations[temp1[2]].getY() ) )
                if( ( locations[temp1[1]].getY() > locations[temp1[2]].getY() ) )
                    column = ( ( locations[temp1[0]].getText() + locations[temp1[1]].getText()   + locations[temp1[2]].getText()).toString());
                    
                else
                   column =( ( locations[temp1[0]].getText() + locations[temp1[2]].getText()   + locations[temp1[1]].getText()).toString());
                    
         
         
         
          if ( ( locations[temp1[0]].getY() < locations[temp1[1]].getY() ) && ( locations[temp1[0]].getY() < locations[temp1[2]].getY() ) )
                if( ( locations[temp1[1]].getY() < locations[temp1[2]].getY() ) )
                        column = ( ( locations[temp1[2]].getText() + locations[temp1[1]].getText()   + locations[temp1[0]].getText()).toString());
          
                else
                     column =( ( locations[temp1[1]].getText() + locations[temp1[2]].getText()   + locations[temp1[0]].getText()).toString());
                   
          
           if ( ( locations[temp1[1]].getY() < locations[temp1[0]].getY() ) && ( locations[temp1[1]].getY() < locations[temp1[2]].getY() ) )
                if( ( locations[temp1[0]].getY() > locations[temp1[2]].getY() ) )
                        column =( ( locations[temp1[0]].getText() + locations[temp1[2]].getText()   + locations[temp1[1]].getText()).toString());
          
                else
                   column =( ( locations[temp1[2]].getText() + locations[temp1[0]].getText()   + locations[temp1[1]].getText()).toString());
          
           
            Generator g = new Generator();
            
            column = g.reverse(column);
           
             
            
            // check if the word that the user compiled is equal to the secret word
               // row.equalsIgnoreCase(string[indexOFstring])

            
            if ( g.search(string , row ) == 1  || g.search(string , column ) == 1  ) {
                
                JOptionPane.showMessageDialog(null, "Congratulation\nContinued to play");
                
                 g.setscore(10);
                    
                 jLabel2.setText(""+( g.getscore() ));
                 
                 scorex = g.getscore();
                 
                 fillButtons(); // el 5olaasa de bt3ml new randomize
                 
                     score s= new score();
                    s.scorey = scorex;
           
         }//end IF Condition
            else
                 JOptionPane.showMessageDialog(null, "Wrong Word");
            
          
         
    }//GEN-LAST:event_submit_bttnActionPerformed

    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try 
        {
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
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test().setVisible(true);
                
                
                java.awt.event.ActionEvent evt;
            }
        });
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton submit_bttn;
    private java.awt.Label timerlbl;
    // End of variables declaration//GEN-END:variables
}
