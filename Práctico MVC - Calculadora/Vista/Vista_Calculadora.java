package Vista;

/**
 * @author Pablo Valentini
 */

public class Vista_Calculadora extends javax.swing.JFrame {

    public Vista_Calculadora() {
        initComponents();
        this.setTitle("Calculadora MVC Valentini");
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTResultado = new javax.swing.JTextField();
        jBSuma = new javax.swing.JButton();
        jBResta = new javax.swing.JButton();
        jBDivide = new javax.swing.JButton();
        jBMultiplica = new javax.swing.JButton();
        jBRaiz = new javax.swing.JButton();
        jBPotencia = new javax.swing.JButton();
        jBBorrar = new javax.swing.JButton();
        jTNum1 = new javax.swing.JTextField();
        jTNum2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBPorcentaje = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTResultado.setHighlighter(null);

        jBSuma.setBackground(new java.awt.Color(255, 255, 255));
        jBSuma.setForeground(new java.awt.Color(255, 255, 255));
        jBSuma.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lima\\Documents\\Pablo\\UTN\\2º Semestre\\Vargas - Programación II\\Mis Ejercicios\\Calculadora MVC Valentini\\Imagenes\\Simbolos\\plus.png")); // NOI18N

        jBResta.setBackground(new java.awt.Color(255, 255, 255));
        jBResta.setForeground(new java.awt.Color(255, 255, 255));
        jBResta.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lima\\Documents\\Pablo\\UTN\\2º Semestre\\Vargas - Programación II\\Mis Ejercicios\\Calculadora MVC Valentini\\Imagenes\\Simbolos\\minus.png")); // NOI18N

        jBDivide.setBackground(new java.awt.Color(255, 255, 255));
        jBDivide.setForeground(new java.awt.Color(255, 255, 255));
        jBDivide.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lima\\Documents\\Pablo\\UTN\\2º Semestre\\Vargas - Programación II\\Mis Ejercicios\\Calculadora MVC Valentini\\Imagenes\\Simbolos\\division.png")); // NOI18N

        jBMultiplica.setBackground(new java.awt.Color(255, 255, 255));
        jBMultiplica.setForeground(new java.awt.Color(255, 255, 255));
        jBMultiplica.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lima\\Documents\\Pablo\\UTN\\2º Semestre\\Vargas - Programación II\\Mis Ejercicios\\Calculadora MVC Valentini\\Imagenes\\Simbolos\\multiply.png")); // NOI18N

        jBRaiz.setBackground(new java.awt.Color(255, 255, 255));
        jBRaiz.setForeground(new java.awt.Color(255, 255, 255));
        jBRaiz.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lima\\Documents\\Pablo\\UTN\\2º Semestre\\Vargas - Programación II\\Mis Ejercicios\\Calculadora MVC Valentini\\Imagenes\\Simbolos\\square-root.png")); // NOI18N

        jBPotencia.setBackground(new java.awt.Color(255, 255, 255));
        jBPotencia.setForeground(new java.awt.Color(255, 255, 255));
        jBPotencia.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lima\\Documents\\Pablo\\UTN\\2º Semestre\\Vargas - Programación II\\Mis Ejercicios\\Calculadora MVC Valentini\\Imagenes\\Simbolos\\is-greater-than.png")); // NOI18N

        jBBorrar.setBackground(new java.awt.Color(255, 255, 255));
        jBBorrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lima\\Documents\\Pablo\\UTN\\2º Semestre\\Vargas - Programación II\\Mis Ejercicios\\Calculadora MVC Valentini\\Imagenes\\Simbolos\\Borrar.png")); // NOI18N

        jTNum1.setHighlighter(null);

        jTNum2.setHighlighter(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("1° Valor");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Resultado");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("2° Valor");

        jBPorcentaje.setBackground(new java.awt.Color(255, 255, 255));
        jBPorcentaje.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lima\\Documents\\Pablo\\UTN\\2º Semestre\\Vargas - Programación II\\Mis Ejercicios\\Calculadora MVC Valentini\\Imagenes\\Simbolos\\percentage.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBSuma)
                            .addComponent(jBRaiz)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jBResta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBMultiplica))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jBPotencia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBPorcentaje)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBDivide)
                                    .addComponent(jBBorrar))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTResultado)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTNum2)
                            .addComponent(jTNum1))))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jTNum1))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTNum2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBSuma)
                    .addComponent(jBResta)
                    .addComponent(jBMultiplica)
                    .addComponent(jBDivide))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBRaiz)
                    .addComponent(jBPotencia)
                    .addComponent(jBPorcentaje)
                    .addComponent(jBBorrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14))
        );

        jLabel1.getAccessibleContext().setAccessibleName("2° Valor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista_Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_Calculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBBorrar;
    public javax.swing.JButton jBDivide;
    public javax.swing.JButton jBMultiplica;
    public javax.swing.JButton jBPorcentaje;
    public javax.swing.JButton jBPotencia;
    public javax.swing.JButton jBRaiz;
    public javax.swing.JButton jBResta;
    public javax.swing.JButton jBSuma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField jTNum1;
    public javax.swing.JTextField jTNum2;
    public javax.swing.JTextField jTResultado;
    // End of variables declaration//GEN-END:variables
}
