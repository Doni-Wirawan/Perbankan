package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

    public class MainFrame extends JFrame {
        // Deklarasi Tampilan
        JLabel lblNoRek,lblNamaRek,lblSaldoRek,lblKotaRek,lblgender;
        JTextField txtNoRek,txtNamaRek,txtSaldoRek,txtKotaRek,txtgender;
        JButton btnBaru,btnSave,btnShow,btnQuit;
        JRadioButton rdbLaki,rdbPerempuan;
        ButtonGroup btnGroupGender;
        JList<Rekening> jListRekening;
        DefaultComboBoxModel<Kota> cmdComboBoxKota;
        JPanel p1,p2,p3,p4,p5;


        LinkedList<Rekening> linkedListRekening = new LinkedList<>();
        LinkedList<Transaksi> linkedListTransaksi = new LinkedList<>();
        boolean newRek = false;
        Rekening newRekening,x;
        DefaultTableModel tableModel;
        JTable table;


        public MainFrame() {
            super("Bank POLIWANGI");
            setLayout(null);
            setSize(600,400);
            // Menambahkan Panel
            p1 = new JPanel();
//        p1.setBackground(Color.BLUE);
            p1.setBounds(5,5,300,150);
            add(p1);
            p2 = new JPanel();
            p2.setBackground(Color.GRAY);
            p2.setBounds(5,155,300,40);
            add(p2);
            p3 = new JPanel();
            p3.setBackground(Color.GREEN);
            p3.setBounds(5,195,600,40);
            add(p3);
            p4 = new JPanel();
            p4.setBackground(Color.MAGENTA);
            p4.setBounds(5,240,580,120);
            add(p4);
            p5 = new JPanel();
            p5.setBackground(Color.RED);
            p5.setBounds(305,5,300,190);
            add(p5);

            // Menambahakan label
            p1.setLayout(new GridLayout(5,2));
            lblNoRek = new JLabel("Nama Dokter");
            lblNamaRek = new JLabel("Hari");
            lblSaldoRek = new JLabel("Poli");
            lblKotaRek = new JLabel("Jam Praktek");
            // menambahkan txt Field
            txtNoRek = new JTextField();
            txtNoRek.setEnabled(false);
            txtNamaRek = new JTextField();
            txtSaldoRek = new JTextField();
            txtKotaRek = new JTextField();
            // Menambahkan Combo box
            cmdComboBoxKota = new DefaultComboBoxModel<>();
            cmdComboBoxKota.addElement(null);
            cmdComboBoxKota.addElement(new Kota("06.30","12.00"));
            cmdComboBoxKota.addElement(new Kota("12.30","18.30"));
            JComboBox<Kota> cmbKota= new JComboBox<Kota>(cmdComboBoxKota);
            // Menambahkan radio button
            rdbLaki = new JRadioButton("Laki",true);
            rdbPerempuan = new JRadioButton("Perempuan");
            btnGroupGender = new ButtonGroup();
            btnGroupGender.add(rdbLaki);
            btnGroupGender.add(rdbPerempuan);

            // mengisi tampilan
            p1.add(lblNoRek);
            p1.add(txtNoRek);
            p1.add(lblNamaRek);
            p1.add(txtNamaRek);
            p1.add(lblSaldoRek);
            p1.add(txtSaldoRek);
            p1.add(lblKotaRek);
            p1.add(cmbKota);
//
            //p2.add
            p2.setLayout(new FlowLayout());
            btnBaru = new JButton("New");
            btnSave = new JButton("Save");
            btnShow = new JButton("Show");
            btnQuit = new JButton("Quit");
            p2.add(btnBaru);
            p2.add(btnSave);
            p2.add(btnShow);
            p2.add(btnQuit);

            //p3.add
            JLabel lblnamapasien = new JLabel("nama pasien");
            JTextField txtnamapasien = new JTextField();
            txtnamapasien.setPreferredSize(new Dimension(75,25));
            JLabel lblkeluhan = new JLabel("keluhan");
            JTextField txtkeluhan = new JTextField();
            txtkeluhan.setPreferredSize(new Dimension(75,25));
            JLabel lblJumlah = new JLabel("Obat");
            JTextField txtJumlah = new JTextField();
            txtJumlah.setPreferredSize(new Dimension(75,25));
            JButton btnTabung = new JButton("Tambah");
            JButton btnTarik = new JButton("Hapus");
            p3.setLayout(new FlowLayout());
            p3.add(lblnamapasien);
            p3.add(txtnamapasien);
            p3.add(lblkeluhan);
            p3.add(txtkeluhan);
            p3.add(lblJumlah);
            p3.add(txtJumlah);
            p3.add(btnTabung);
            p3.add(btnTarik);

            //p4.add
            p4.setLayout(new BorderLayout());
            tableModel = new DefaultTableModel();
            table = new JTable(tableModel);
            tableModel.addColumn("Tgl Periksa");
            tableModel.addColumn("Nama Pasien");
            tableModel.addColumn("Keluhan");
            tableModel.addColumn("obat");
            JScrollPane scrollPane = new JScrollPane(table);
            p4.add(scrollPane);

            //p5.add
            p5.setLayout(new BorderLayout());
            DefaultListModel<Rekening> listModelRekening = new DefaultListModel<>();
            jListRekening = new JList<>(listModelRekening);
            p5.add(jListRekening);

            //action
            btnBaru.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtNoRek.setText("");
                    txtNamaRek.setText("");
                    txtSaldoRek.setText("");
                    cmbKota.setSelectedIndex(0);
                    rdbLaki.setSelected(true);
                    newRek = true;

                }
            });
            //action save
            btnSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (newRek) {
                        if(txtNamaRek.getText().length()!=0){
                            newRekening = new Rekening(txtNamaRek.getText(),(Kota)cmbKota.getSelectedItem(),
                                    rdbLaki.isSelected()?'L':'P');
                            txtNoRek.setText(String.valueOf(newRekening.noRek));
                            linkedListRekening.add(newRekening);
                            listModelRekening.addElement(newRekening);
                            newRek= false;
                        } else {
                            JOptionPane.showMessageDialog(null,"Nama Pemilik tolong Diisi");
                        }

                    }
                }
            });
            //action button tabung
            btnTabung.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!newRek && txtJumlah.getText().length()!=0){
                        Transaksi transaksi = new Transaksi(newRekening, LocalDate.now(),
                                'D',Double.parseDouble(txtJumlah.getText()));
                        newRekening.tabung(Double.parseDouble(txtJumlah.getText()));
                        txtSaldoRek.setText(String.valueOf(newRekening.saldoRek));
                        tampilTransaksiTabel(transaksi);
                        linkedListTransaksi.add(transaksi);
                    }

                    }

            });
        //fungsi button tarik
            btnTarik.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!newRek && txtJumlah.getText().length()!=0){
                        Transaksi transaksi = new Transaksi(newRekening, LocalDate.now(),
                                'K',Double.parseDouble(txtJumlah.getText()));
                        newRekening.tarik(Double.parseDouble(txtJumlah.getText()));
                        txtSaldoRek.setText(String.valueOf(newRekening.saldoRek));
                        tampilTransaksiTabel(transaksi);
                        linkedListTransaksi.add(transaksi);
                    }

                }
            });

            jListRekening.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    newRekening=x=jListRekening.getSelectedValue();
                    txtNoRek.setText(String.valueOf(newRekening.noRek));
                    txtNamaRek.setText(newRekening.pemilikRek);
                    txtSaldoRek.setText(String.valueOf(newRekening.saldoRek));
                    cmbKota.setSelectedItem(newRekening.kotaRek);
                    if(newRekening.genderRek=='L'){
                        rdbLaki.setSelected(true);
                    }else {
                        rdbPerempuan.setSelected(true);
                    }
                    newRek = false;

                    for(int i =tableModel.getRowCount()-1;i>=0;i--){
                        tableModel.removeRow(i);
                    }
                    cariTransaksiList(newRekening.noRek);
                }
            });

            //action button transaksi

           // cari transaksi


        }

        private void cariTransaksiList(int noRek) {
            ArrayList<Transaksi> filterList = new ArrayList<>();
            for(Transaksi t : linkedListTransaksi){
                if(t.noRek.noRek==noRek){
                    filterList.add(t);
                }

            }
            for(Transaksi t:filterList){
                tableModel.addRow(new Object[]{
                        t.noTransaksi,
                        t.tgl,
                        t.operasi,
                        t.jmlTrans
                });
            }
        }

        private void tampilTransaksiTabel(Transaksi transaksi) {
            tableModel.addRow(new Object[]{
                    transaksi.getNoTransaksi(),
                    transaksi.getTgl(),
                    transaksi.getOperasi(),
                    transaksi.getJmlTrans()
            });
        }

        public static void main(String[] args) {
            com.company.MainFrame frameUtama = new com.company.MainFrame();
            frameUtama.setVisible(true);
            frameUtama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        }

    }
