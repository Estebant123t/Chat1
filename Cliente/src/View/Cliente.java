package View;



import java.awt.Color;
import java.awt.Shape;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class Cliente extends javax.swing.JFrame implements Runnable{
    ArrayList<Controles> lista2=new ArrayList<Controles>(); 
     private static int puertoF;
    private static String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getPuerto() {
        return puertoF;
    }

    public void setPuerto(int puerto) {
        this.puertoF = puerto;
    }

    public Cliente() {
        try {
            String nombre2 = JOptionPane.showInputDialog("nombre: ");
            Socket misocket = new Socket("192.168.61.172",1024);
            ServerSocket auxiliar = new ServerSocket(0);
            int puertoDisponible=auxiliar.getLocalPort();
            auxiliar.close();
            
            Paquete1 datos = new Paquete1(); 
            nombre=nombre2;
            datos.setNick2(nombre);
            datos.setPuerto(puertoDisponible);
            puertoF=puertoDisponible;
            System.out.println(puertoF);
            datos.setMensaje(" Online");
            
            ObjectOutputStream salida = new ObjectOutputStream(misocket.getOutputStream());
            salida.writeObject(datos);
            misocket.close();
        } catch (IOException ex) {
            historial.append(ex.getMessage());
        }
        
        initComponents();
        mensaje.setBackground(new Color(0,0,0,64));
        mensaje.setForeground(Color.BLACK);
        this.setLocationRelativeTo(null);
        
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        scroll.setViewportBorder(null);
        historial.setBorder(null);
        historial.setBackground(new Color(0,0,0,64));
        
        cerrar1.setOpaque(false);
        cerrar1.setContentAreaFilled(false);
        cerrar1.setBorderPainted(false);
        enviar.setOpaque(false);
        enviar.setContentAreaFilled(false);
        enviar.setBorderPainted(false);
         nick.setText(nombre);

     
        Thread mihilo = new Thread(this);
        mihilo.start();
        
    }
   


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mensaje = new javax.swing.JTextField();
        num = new javax.swing.JLabel();
        nick = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        historial = new javax.swing.JTextArea();
        ipdestino = new javax.swing.JComboBox<>();
        cerrar1 = new javax.swing.JButton();
        enviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(360, 360));
        setUndecorated(true);
        setSize(new java.awt.Dimension(300, 500));
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

        mensaje.setForeground(new java.awt.Color(150, 191, 218));
        mensaje.setBorder(null);
        mensaje.setCaretColor(new java.awt.Color(150, 191, 218));
        mensaje.setSelectedTextColor(new java.awt.Color(150, 191, 218));
        getContentPane().add(mensaje);
        mensaje.setBounds(20, 270, 280, 70);

        num.setFont(new java.awt.Font("Haettenschweiler", 1, 24)); // NOI18N
        num.setForeground(new java.awt.Color(51, 153, 0));
        getContentPane().add(num);
        num.setBounds(190, 30, 29, 25);
        getContentPane().add(nick);
        nick.setBounds(20, 30, 72, 17);

        historial.setColumns(20);
        historial.setForeground(new java.awt.Color(150, 191, 218));
        historial.setRows(5);
        historial.setCaretColor(new java.awt.Color(150, 191, 218));
        historial.setSelectedTextColor(new java.awt.Color(150, 191, 218));
        scroll.setViewportView(historial);

        getContentPane().add(scroll);
        scroll.setBounds(20, 70, 320, 180);

        ipdestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipdestinoActionPerformed(evt);
            }
        });
        getContentPane().add(ipdestino);
        ipdestino.setBounds(220, 30, 121, 22);

        cerrar1.setText("Cerrar");
        cerrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(cerrar1);
        cerrar1.setBounds(290, 0, 70, 23);

        enviar.setText("Send");
        enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        getContentPane().add(enviar);
        enviar.setBounds(310, 290, 39, 38);

        jLabel1.setText("Enviar");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 330, 32, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents
        private int xx;
        private int yy;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
         xx=evt.getX();
         yy=evt.getY();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
         int x=evt.getXOnScreen();
         int y=evt.getYOnScreen();
         setLocation(x-xx,y-yy);
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void ipdestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipdestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipdestinoActionPerformed

    private void cerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar1ActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrar1ActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        // InetAddress direccion;

        /*
        direccion = InetAddress.getLocalHost(); //para obtener la ip de nuestro dispositivo
        String ip = direccion.getHostAddress();*/
        //  String ipdes = ipserver.getText();

        try {                //nuestra ip del servidor y el puerto que va a estar abierto
            Socket miSocket =new Socket("192.168.61.172",1024);
            Paquete1 datos = new Paquete1();
            datos.setNick2(nick.getText());
            datos.setDestinatario(ipdestino.getSelectedItem().toString());
            String aux;
            aux=ipdestino.getSelectedItem().toString();
            for(int i=0;i<lista2.size();i++){
                if(aux.equalsIgnoreCase(lista2.get(i).getNombrecontrol())){
                    datos.setIp(lista2.get(i).getIpcontrol());
                }

            }
            // datos.setIp(ipdestino.getSelectedItem().toString()); //pasar en String el objeto que devuelve el jcombobox
            historial.append("\n-"+mensaje.getText());
            historial.setForeground(Color.BLACK);
            datos.setMensaje(mensaje.getText());

            ObjectOutputStream salida = new ObjectOutputStream(miSocket.getOutputStream());
            salida.writeObject(datos);
            mensaje.setText(null);
            miSocket.close();
            //el flujo se conducira por el socket previamente creado
            /* DataOutputStream salida = new DataOutputStream(miSocket.getOutputStream());
            salida.writeUTF(mensaje.getText());  //escribe en el flujo el texto del mensaje

            salida.close();*/
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            // Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_enviarActionPerformed
        
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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
                        

                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar1;
    private javax.swing.JButton enviar;
    private javax.swing.JTextArea historial;
    private javax.swing.JComboBox<String> ipdestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField mensaje;
    private javax.swing.JLabel nick;
    private javax.swing.JLabel num;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            ServerSocket servidor_cliente = new ServerSocket(puertoF);
            
            
            ArrayList<String> ipsMenu = new ArrayList<String>();
            Socket cliente;
            Paquete1 paquete_recibido;
            while(true){
            cliente = servidor_cliente.accept();
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            paquete_recibido= (Paquete1) entrada.readObject();
            if(!paquete_recibido.getMensaje().equalsIgnoreCase(" Online")){

            historial.append("\n\t\t"+paquete_recibido.getNick2()+ ": "+ paquete_recibido.getMensaje());
            //historial.setForeground(Color.BLACK);
            } else{
            Controles hola = new Controles();
            ipsMenu=paquete_recibido.getDirIps();
            String nombre=paquete_recibido.getNick2();
            lista2=paquete_recibido.getControl();
            
            String conected = String.valueOf(lista2.size());
            num.setText(conected);
         ipdestino.removeAllItems();
            for(int i=0;i<lista2.size();i++){
            ipdestino.addItem(lista2.get(i).getNombrecontrol());
            }
            }
            
            
            }
            } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
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
class EnvioOnline extends WindowAdapter{ 
    
    String nickx,ipserver;
    public void hola (String s){
      nickx=s;
    }
    public void hola2 (String e){
      ipserver=e;
    }
    
    public void windowOpened(WindowEvent e){
        try {
            
            Socket misocket = new Socket("192.168.43.104",1024);
            Paquete1 datos = new Paquete1();
            
            datos.setNick2(nickx);
            datos.setMensaje(" Online");
        
            ObjectOutputStream salida = new ObjectOutputStream(misocket.getOutputStream());
            salida.writeObject(datos);
            misocket.close();
        } catch (IOException ex) {
            Logger.getLogger(EnvioOnline.class.getName()).log(Level.SEVERE, null, ex);
        }
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