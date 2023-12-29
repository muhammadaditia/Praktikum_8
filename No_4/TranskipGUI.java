package OperasiCRUD;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TranskipGUI extends javax.swing.JFrame {

    //variable
    private Data data = null;
    private File fileData = null;

    //tabel
    private String[] header = new String[]{"KODE", "MATAKULIAH", "NILAI", "SKS"};
    int row = 0;
    DefaultTableModel dtm = new DefaultTableModel(header, row);

    public TranskipGUI() {
        initComponents();
        data = new Data();
        fileData = new File("Data.csv");

        tabel.setModel(dtm);
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = tabel.getSelectedRow();
                //System.out.println("Row = " + row);
                if (data != null && data.getTrankrip() != null) {
                    ArrayList<Matakuliah> trankrip = data.getTrankrip();
                    textKode.setText(trankrip.get(row).getKode());
                    textMatkul.setText(trankrip.get(row).getNamaMatkul());
                    textNilai.setText(trankrip.get(row).getNilai());
                    textSks.setText("" + trankrip.get(row).getSks());
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textNIM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textProdi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textSemester = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        textKode = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textMatkul = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textNilai = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textSks = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScroll = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Program Transkrip Nilai");
        getContentPane().setLayout(new java.awt.BorderLayout(4, 4));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Mahasiswa"));
        jPanel4.setLayout(new java.awt.GridLayout(5, 2));

        jLabel1.setText("Nama");
        jPanel4.add(jLabel1);

        textNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaActionPerformed(evt);
            }
        });
        jPanel4.add(textNama);

        jLabel2.setText("NIM");
        jPanel4.add(jLabel2);
        jPanel4.add(textNIM);

        jLabel3.setText("Program Studi");
        jPanel4.add(jLabel3);
        jPanel4.add(textProdi);

        jLabel4.setText("Semester");
        jPanel4.add(jLabel4);
        jPanel4.add(textSemester);
        jPanel4.add(jLabel5);

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(153, 102, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Matakuliah"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(4, 2));

        jLabel6.setText("Kode");
        jPanel2.add(jLabel6);
        jPanel2.add(textKode);

        jLabel7.setText("Nama Matakuliah");
        jPanel2.add(jLabel7);
        jPanel2.add(textMatkul);

        jLabel8.setText("Nilai");
        jPanel2.add(jLabel8);
        jPanel2.add(textNilai);

        jLabel9.setText("SKS");
        jPanel2.add(jLabel9);
        jPanel2.add(textSks);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jButton6.setText("Read");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jButton3.setText("Insert");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel5.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jScroll.setBackground(new java.awt.Color(102, 102, 255));
        jScroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Trankrip"));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScroll.setViewportView(tabel);

        jPanel5.add(jScroll, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        data = new Data();
        data.read(fileData);
        okrefresh();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String Kode = textKode.getText().trim();
        String namaMatkul = textMatkul.getText().trim();
        String Nilai = textNilai.getText().trim();
        int Sks = Integer.parseInt(textSks.getText().trim());
        Matakuliah matkul = new Matakuliah(Kode, namaMatkul, Nilai, Sks);
        data.insert(matkul);
        data.save(fileData);
        clear();
        okrefresh();
        JOptionPane.showMessageDialog(this, "Matakuliah BERHASIL ditambahkan ", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        row = tabel.getSelectedRow();
        String namaMatkul = data.getTrankrip().get(row).getNamaMatkul();
        //proses membuat kotak dialog
        int dialog = JOptionPane.YES_NO_OPTION;
        int Option = JOptionPane.showConfirmDialog(this, "Hapus Matakuliah " + namaMatkul, "Delete", dialog);
        if (Option == 0) {//yes
            data.delete(row);
            data.save(fileData);
            clear();
            okrefresh();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String Kode = textKode.getText().trim();
        String namaMatkul = textMatkul.getText().trim();
        String Nilai = textNilai.getText().trim();
        int Sks = Integer.parseInt(textSks.getText().trim());
        Matakuliah matkul = new Matakuliah(Kode, namaMatkul, Nilai, Sks);
        data.update(row, matkul);
        data.save(fileData);
        clear();
        okrefresh();
        JOptionPane.showMessageDialog(this, "Matakuliah BERHASIL diupdate", "Info", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String Nama = textNama.getText();
        String NIM = textNIM.getText();
        String Prodi = textProdi.getText();
        int Semeseter = Integer.parseInt(textSemester.getText());
        ArrayList<Matakuliah> trankrip = new ArrayList<>();
        data = new Data(Nama, NIM, Prodi, Semeseter, trankrip);
        data.save(fileData);
        clear();
        okrefresh();
        JOptionPane.showMessageDialog(this, "Transkrip baru BERHASIL dibuat", "Info", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNamaActionPerformed

    public void clear() {
        textKode.setText(" ");
        textMatkul.setText(" ");
        textNilai.setText(" ");
        textSks.setText(" ");
    }

    public void okrefresh() {
        if (data != null) {
            //menulis biodata mahasiswa
            textNama.setText(data.getNama());
            textNIM.setText(data.getNim());
            textProdi.setText(data.getProdi());
            textSemester.setText("" + data.getSemester());

            ArrayList<Matakuliah> trankrip = data.getTrankrip();
            if (data.getTrankrip() != null) {
                dtm.setRowCount(0);
                for (int i = 0; i < trankrip.size(); i++) {
                    String kode = trankrip.get(i).getKode();
                    String namaMatkul = trankrip.get(i).getNamaMatkul();
                    String nilai = trankrip.get(i).getNilai();
                    int sks = trankrip.get(i).getSks();
                    Object[] baris = new Object[]{kode, namaMatkul, nilai, sks};
                    dtm.addRow(baris);
                }
            }
        }
    }
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TranskipGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScroll;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField textKode;
    private javax.swing.JTextField textMatkul;
    private javax.swing.JTextField textNIM;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textNilai;
    private javax.swing.JTextField textProdi;
    private javax.swing.JTextField textSemester;
    private javax.swing.JTextField textSks;
    // End of variables declaration//GEN-END:variables
}
