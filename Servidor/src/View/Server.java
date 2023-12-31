package View;


import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server extends javax.swing.JFrame implements Runnable{
ArrayList<Controles> lista2=new ArrayList<Controles>(); 

    public Server() {
        initComponents();
        this.setLocationRelativeTo(null);

        cerrar.setBackground(new Color(0,0,0,64));
        cerrar.setBorder(null);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        scroll.setViewportBorder(null);
        historial.setBorder(null);
        
        historial.setBackground(new Color(0,0,0,64));
        historial.setForeground(Color.BLACK);
        

        cerrar.setOpaque(false);
        cerrar.setContentAreaFilled(false);
        cerrar.setBorderPainted(false);
       Thread mihilo = new Thread(this);
       mihilo.start();    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        cerrar = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        historial = new javax.swing.JTextArea();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(null);

        cerrar.setFont(new java.awt.Font("Eras Bold ITC", 2, 18)); // NOI18N
        cerrar.setForeground(new java.awt.Color(150, 191, 218));
        cerrar.setText("X");
        cerrar.setBorder(null);
        cerrar.setBorderPainted(false);
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(cerrar);
        cerrar.setBounds(450, 10, 30, 22);

        historial.setColumns(20);
        historial.setForeground(new java.awt.Color(150, 191, 218));
        historial.setRows(5);
        historial.setCaretColor(new java.awt.Color(150, 191, 218));
        historial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        historial.setSelectedTextColor(new java.awt.Color(150, 191, 218));
        scroll.setViewportView(historial);

        getContentPane().add(scroll);
        scroll.setBounds(0, 80, 500, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        System.exit(0);
       
    }//GEN-LAST:event_cerrarActionPerformed
     private int xx;
        private int yy;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        
                                  
         xx=evt.getX();
         yy=evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
         int x=evt.getXOnScreen();
         int y=evt.getYOnScreen();
         setLocation(x-xx,y-yy);        
// TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar;
    private javax.swing.JTextArea historial;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() { 
        try {
            ServerSocket servidor = new ServerSocket(1024);
            String nick,mensaje2,ip;
            ArrayList <String> listaIp4 = new ArrayList<String>(); 
            
            Paquete1 paquete_recibido;
              Controles aux = new Controles();
                    
            while(true){   
            Socket misocket = servidor.accept(); 
            
     
            ObjectInputStream entrada =new ObjectInputStream(misocket.getInputStream()); 
            
            paquete_recibido=(Paquete1) entrada.readObject();
        
            nick=paquete_recibido.getNick2();
            mensaje2=paquete_recibido.getMensaje();
            ip=paquete_recibido.getIp();
            int puertoCliente=9999;
            if(!mensaje2.equals(" Online")){
                String aux2=null;
                for(int i=0;i<lista2.size();i++){
                if(lista2.get(i).getNombrecontrol().equalsIgnoreCase(paquete_recibido.getDestinatario())){
                 aux2=lista2.get(i).getIpcontrol();
                  puertoCliente=lista2.get(i).getPuerto();
                  System.out.println("se quiere conectar con: "+puertoCliente);
                }
                }
            historial.append("\n"+ nick+": "+mensaje2+"  para "+aux2);


            Socket enviaDestinatario = new Socket(ip,puertoCliente);
            ObjectOutputStream reenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
            reenvio.writeObject(paquete_recibido);
                     
                     
            reenvio.close();
            enviaDestinatario.close();
            misocket.close();
            }else{  
       Controles hola = new Controles();
                     
                     InetAddress localizacion = misocket.getInetAddress();
                     int puerto = paquete_recibido.getPuerto();
                     String ipremota = localizacion.getHostAddress();
                     aux.setIpcontrol(ipremota);
                     aux.setNombrecontrol(paquete_recibido.getNick2());
                     hola.setIpcontrol(ipremota);
                     hola.setNombrecontrol(nick);
                     hola.setPuerto(puerto);
                     lista2.add(hola);
          
                     historial.append("\n--------------------------------------------------- -Conectado------------------------------------------------------");
                     historial.append("\n"+ nick+" : ip "+ipremota +"  conectado desde el puerto "+puerto);
      
                     historial.append("\n\n");
  
                     paquete_recibido.setControl(lista2);
                   
                    for(int i=0;i<lista2.size();i++){
                     Socket enviaDestinatario = new Socket(lista2.get(i).getIpcontrol(),lista2.get(i).getPuerto());
                     ObjectOutputStream reenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                      reenvio.writeObject(paquete_recibido);
                      reenvio.close();
                       enviaDestinatario.close();
                       misocket.close();
                    }
                    }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
class Paquete1 implements Serializable{
private String mensaje;
private String ip;
private String nick2;
private ArrayList<String> dirIps;
private ArrayList<Controles> control;
private int puerto;
private String destinatario;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public ArrayList<Controles> getControl() {
        return control;
    }

    public void setControl(ArrayList<Controles> control) {
        this.control = control;
    }
    
    
    public ArrayList<String> getDirIps() {
        return dirIps;
    }

    public void setDirIps(ArrayList<String> dirIps) {
        this.dirIps = dirIps;
    }

 
   

  
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNick2() {
        return nick2;
    }

    public void setNick2(String nick2) {
        this.nick2 = nick2;
    }

  

}
class Controles implements Serializable{
private String ipcontrol;
private String nombrecontrol;
private int puerto;

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getIpcontrol() {
        return ipcontrol;
    }

    public void setIpcontrol(String ipcontrol) {
        this.ipcontrol = ipcontrol;
    }

    public String getNombrecontrol() {
        return nombrecontrol;
    }

    public void setNombrecontrol(String nombrecontrol) {
        this.nombrecontrol = nombrecontrol;
    }

}