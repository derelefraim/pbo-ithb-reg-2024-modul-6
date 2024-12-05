package View;

import Controller.Controller;
import Controller.DBController;
import Model.Class.KTP;
import Model.Enum.JenisAgama;
import Model.Enum.JenisKelamin;
import Model.Enum.StatusPerkawinan;

import java.util.Date;
import java.util.Properties;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class FormInputData {

    private File photoFile;
    private File signatureFile;

    public FormInputData(int actionValue, KTP myKtp) {

        showForm(actionValue, myKtp);

    }

    public void showForm(int actionValue, KTP myKtp) {

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // INIT TOOLKIT
        Dimension screenSize = toolkit.getScreenSize(); // GET MY SCREEN SIZE

        int screenWidth = screenSize.width; // GET PIXELS FOR WIDTH
        int screenHeight = screenSize.height; // GET PIXELS FOR HEIGHT

        final int FRAME_WIDTH = 1200; // SET WIDTH
        final int FRAME_HEIGHT = 800; // SET WEIGHT

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2); // SET START LOCATION FOR X
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2); // SET START LOCATION FOR Y

        JFrame myFrame = new JFrame("Form Input Data Penduduk"); // CREATE FRAME AND SET TITLE

        myFrame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT); // SET FRAME BOUND
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel formPanel = new JPanel(); // MAKE PANEL
        formPanel.setLayout(null);
        formPanel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        JLabel nikLabel = new JLabel("NIK"); // MAKE LABEL FOR NIK
        nikLabel.setBounds(50, 50, 200, 50);
        nikLabel.setFont(new Font("Arial", Font.PLAIN, 20)); // CHANGE FONT
        formPanel.add(nikLabel); // ADD LABEL TO PANEL

        JTextField nikField = new JTextField();
        nikField.setBounds(250, 60, 300, 30);
        formPanel.add(nikField);

        JLabel namaLabel = new JLabel("NAMA");
        namaLabel.setBounds(50, 100, 200, 50);
        namaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(namaLabel);

        JTextField namaField = new JTextField();
        namaField.setBounds(250, 110, 300, 30);
        formPanel.add(namaField);

        JLabel tempatLahirLabel = new JLabel("TEMPAT LAHIR");
        tempatLahirLabel.setBounds(50, 150, 200, 50);
        tempatLahirLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(tempatLahirLabel);

        JTextField tempatLahirField = new JTextField();
        tempatLahirField.setBounds(250, 160, 300, 30);
        formPanel.add(tempatLahirField);

        JLabel tglLahirLabel = new JLabel("TANGGAL LAHIR");
        tglLahirLabel.setBounds(50, 200, 200, 50);
        tglLahirLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(tglLahirLabel);

        // MAKE DATE PICKER
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        datePicker.setBounds(250, 210, 300, 30);
        formPanel.add(datePicker);

        JLabel genderLabel = new JLabel("JENIS KELAMIN");
        genderLabel.setBounds(50, 250, 200, 50);
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(genderLabel);

        JRadioButton priaRadio = new JRadioButton("Pria");
        JRadioButton wanitaRadio = new JRadioButton("Wanita");

        priaRadio.setBounds(250, 250, 90, 50);
        wanitaRadio.setBounds(340, 250, 100, 50);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(priaRadio);
        genderGroup.add(wanitaRadio);

        formPanel.add(priaRadio);
        formPanel.add(wanitaRadio);

        JLabel golDarahLabel = new JLabel("GOLONGAN DARAH");
        golDarahLabel.setBounds(50, 300, 200, 50);
        golDarahLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(golDarahLabel);

        JRadioButton aRadio = new JRadioButton("A");
        JRadioButton bRadio = new JRadioButton("B");
        JRadioButton oRadio = new JRadioButton("O");
        JRadioButton abRadio = new JRadioButton("AB");

        aRadio.setBounds(250, 300, 50, 50);
        bRadio.setBounds(340, 300, 50, 50);
        oRadio.setBounds(430, 300, 50, 50);
        abRadio.setBounds(510, 300, 50, 50);

        ButtonGroup bloodGroup = new ButtonGroup();
        bloodGroup.add(aRadio);
        bloodGroup.add(bRadio);
        bloodGroup.add(oRadio);
        bloodGroup.add(abRadio);

        aRadio.setActionCommand("A");
        bRadio.setActionCommand("B");
        oRadio.setActionCommand("O");
        abRadio.setActionCommand("AB");

        formPanel.add(aRadio);
        formPanel.add(bRadio);
        formPanel.add(oRadio);
        formPanel.add(abRadio);

        JLabel alamatLabel = new JLabel("ALAMAT");
        alamatLabel.setBounds(50, 350, 200, 50);
        alamatLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(alamatLabel);

        JTextField alamatField = new JTextField();
        alamatField.setBounds(250, 360, 300, 30);
        formPanel.add(alamatField);

        JLabel rtLabel = new JLabel("RT");
        rtLabel.setBounds(250, 400, 50, 50);
        rtLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(rtLabel);

        JTextField rtField = new JTextField();
        rtField.setBounds(300, 410, 50, 30);
        formPanel.add(rtField);

        JLabel rwLabel = new JLabel("RW");
        rwLabel.setBounds(450, 400, 50, 50);
        rwLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(rwLabel);

        JTextField rwField = new JTextField();
        rwField.setBounds(500, 410, 50, 30);
        formPanel.add(rwField);

        JLabel kelurahanLabel = new JLabel("KEL/DESA");
        kelurahanLabel.setBounds(50, 450, 200, 50);
        kelurahanLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(kelurahanLabel);

        JTextField kelurahanField = new JTextField();
        kelurahanField.setBounds(250, 460, 300, 30);
        formPanel.add(kelurahanField);

        JLabel kecamatanLabel = new JLabel("KECAMATAN");
        kecamatanLabel.setBounds(50, 500, 200, 50);
        kecamatanLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(kecamatanLabel);

        JTextField kecamatanField = new JTextField();
        kecamatanField.setBounds(250, 510, 300, 30);
        formPanel.add(kecamatanField);

        // -------------------------------- RIGHT SIDE --------------------------------

        JLabel agamaLabel = new JLabel("AGAMA");
        agamaLabel.setBounds(600, 50, 200, 50);
        agamaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(agamaLabel);

        // MAKE COMBO BOX
        JComboBox<String> agamaComboBox = new JComboBox<>();
        agamaComboBox.addItem("KRISTEN");
        agamaComboBox.addItem("KATHOLIK");
        agamaComboBox.addItem("ISLAM");
        agamaComboBox.addItem("HINDU");
        agamaComboBox.addItem("BUDDHA");
        agamaComboBox.addItem("KONGHUCU");
        agamaComboBox.addItem("ADAT KEPERCAYAAN");

        agamaComboBox.setBounds(850, 60, 300, 30);
        formPanel.add(agamaComboBox);

        JLabel statusPerkawinanLabel = new JLabel("STATUS PERKAWINAN");
        statusPerkawinanLabel.setBounds(600, 100, 300, 50);
        statusPerkawinanLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(statusPerkawinanLabel);

        // MAKE COMBO BOX
        JComboBox<String> perkawinanBox = new JComboBox<>();
        perkawinanBox.addItem("BELUM MENIKAH");
        perkawinanBox.addItem("MENIKAH");
        perkawinanBox.addItem("JANDA");
        perkawinanBox.addItem("DUDA");

        perkawinanBox.setBounds(850, 110, 300, 30);
        formPanel.add(perkawinanBox);

        JLabel pekerjaanLabel = new JLabel("PEKERJAAN");
        pekerjaanLabel.setBounds(600, 150, 300, 50);
        pekerjaanLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(pekerjaanLabel);

        JCheckBox karyawanSwastaCheck = new JCheckBox("Karyawan Swasta");
        karyawanSwastaCheck.setBounds(850, 150, 150, 50);

        JCheckBox pnsCheck = new JCheckBox("PNS");
        pnsCheck.setBounds(1000, 150, 150, 50);

        JCheckBox wiraswastaCheck = new JCheckBox("Wiraswasta");
        wiraswastaCheck.setBounds(850, 190, 150, 50);

        JCheckBox akademisiCheck = new JCheckBox("Akademisi");
        akademisiCheck.setBounds(1000, 190, 150, 50);

        JCheckBox pengangguranCheck = new JCheckBox("Pengangguran");
        pengangguranCheck.setBounds(850, 230, 150, 50);

        // ADD ALL CHECKBOX
        formPanel.add(karyawanSwastaCheck);
        formPanel.add(pnsCheck);
        formPanel.add(wiraswastaCheck);
        formPanel.add(akademisiCheck);
        formPanel.add(pengangguranCheck);

        pengangguranCheck.addActionListener(new ActionListener() { // ADD EVENT LISTENER

            public void actionPerformed(ActionEvent e) {

                if (pengangguranCheck.isSelected()) {

                    karyawanSwastaCheck.setEnabled(false);
                    pnsCheck.setEnabled(false);
                    wiraswastaCheck.setEnabled(false);
                    akademisiCheck.setEnabled(false);

                    karyawanSwastaCheck.setSelected(false);
                    pnsCheck.setSelected(false);
                    wiraswastaCheck.setSelected(false);
                    akademisiCheck.setSelected(false);

                } else {

                    karyawanSwastaCheck.setEnabled(true);
                    pnsCheck.setEnabled(true);
                    wiraswastaCheck.setEnabled(true);
                    akademisiCheck.setEnabled(true);

                }

            }

        });

        JLabel citizenshipLabel = new JLabel("KEWARGANEGARAAN");
        citizenshipLabel.setBounds(600, 280, 300, 50);
        citizenshipLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(citizenshipLabel);

        JRadioButton wniRadio = new JRadioButton("WNI");
        JRadioButton wnaRadio = new JRadioButton("WNA");

        wniRadio.setBounds(850, 280, 100, 50);
        wnaRadio.setBounds(1000, 280, 100, 50);

        wniRadio.setActionCommand("WNI");
        wnaRadio.setActionCommand("WNA");

        ButtonGroup citizenshipGroup = new ButtonGroup();
        citizenshipGroup.add(wniRadio);
        citizenshipGroup.add(wnaRadio);

        formPanel.add(wniRadio);
        formPanel.add(wnaRadio);

        JLabel countryLabel = new JLabel("ASAL NEGARA");
        countryLabel.setBounds(600, 320, 300, 50);
        countryLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        countryLabel.setVisible(false); // SET VISIBLE FALSE -> DEFAULT
        formPanel.add(countryLabel);

        JTextField citizenshipField = new JTextField();
        citizenshipField.setBounds(850, 330, 300, 30);
        citizenshipField.setVisible(false); // SET VISIBLE FALSE -> DEFAULT
        formPanel.add(citizenshipField);

        wnaRadio.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                countryLabel.setVisible(true);
                citizenshipField.setVisible(true);

            }

        });

        wniRadio.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                countryLabel.setVisible(false);
                citizenshipField.setVisible(false);
                citizenshipField.setText("");

            }

        });

        JLabel photoLabel = new JLabel("FOTO");
        photoLabel.setBounds(600, 380, 100, 50);
        photoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(photoLabel);

        JButton photoButton = new JButton("Upload Photo");
        photoButton.setBounds(850, 380, 300, 40);
        formPanel.add(photoButton);

        photoButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();

                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {

                    photoFile = fileChooser.getSelectedFile();

                }

            }

        });

        JLabel signatureLabel = new JLabel("TANDA TANGAN");
        signatureLabel.setBounds(600, 450, 200, 50);
        signatureLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(signatureLabel);

        JButton signatureButton = new JButton("Upload Signature");
        signatureButton.setBounds(850, 450, 300, 40);
        formPanel.add(signatureButton);

        signatureButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();

                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {

                    signatureFile = fileChooser.getSelectedFile();

                }

            }

        });

        JLabel tglBerlakuLabel = new JLabel("BERLAKU HINGGA");
        tglBerlakuLabel.setBounds(600, 500, 200, 50);
        tglBerlakuLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(tglBerlakuLabel);

        JTextField tglBerlakuField = new JTextField();
        tglBerlakuField.setBounds(850, 510, 300, 30);
        formPanel.add(tglBerlakuField);

        JLabel kotaPembuatanLabel = new JLabel("KOTA PEMBUATAN");
        kotaPembuatanLabel.setBounds(600, 550, 200, 50);
        kotaPembuatanLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(kotaPembuatanLabel);

        JTextField kotaPembuatanField = new JTextField();
        kotaPembuatanField.setBounds(850, 560, 300, 30);
        formPanel.add(kotaPembuatanField);

        JLabel tglPembuatanLabel = new JLabel("TANGGAL PEMBUATAN");
        tglPembuatanLabel.setBounds(600, 600, 220, 50);
        tglPembuatanLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        formPanel.add(tglPembuatanLabel);

        UtilDateModel tglPembuatanmodel = new UtilDateModel();
        Properties tglPembuatanProperties = new Properties();
        JDatePanelImpl tglPembuatanPanel = new JDatePanelImpl(tglPembuatanmodel, tglPembuatanProperties);
        JDatePickerImpl tglPembuatanPicker = new JDatePickerImpl(tglPembuatanPanel, new DateLabelFormatter());

        tglPembuatanPicker.setBounds(850, 610, 300, 30);
        formPanel.add(tglPembuatanPicker);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(950, 660, 200, 30);
        formPanel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (Controller.checkInput(nikField, namaField, tempatLahirField, datePicker, genderGroup, bloodGroup,
                        alamatField, rtField, rwField, kelurahanField, kecamatanField, agamaComboBox, perkawinanBox,
                        karyawanSwastaCheck, pnsCheck, wiraswastaCheck, akademisiCheck, pengangguranCheck,
                        citizenshipGroup, citizenshipField, photoFile, signatureFile, tglBerlakuField,
                        kotaPembuatanField, tglPembuatanPicker)) {

                    String nik = nikField.getText();
                    String nama = namaField.getText();
                    String tempatLahir = tempatLahirField.getText();

                    Date tanggalLahir = (Date) datePicker.getModel().getValue();
                    LocalDate tanggalLahirlocalDate = tanggalLahir.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    String tanggalLahirlocalDateFormatted = tanggalLahirlocalDate
                            .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    System.out.println(tanggalLahir);
                    JenisKelamin jenisKelamin = priaRadio.isSelected() ? JenisKelamin.PRIA : JenisKelamin.WANITA;
                    String golDarah = bloodGroup.getSelection().getActionCommand();
                    String alamat = alamatField.getText();
                    String rt = rtField.getText();
                    String rw = rwField.getText();
                    String kelDesa = kelurahanField.getText();
                    String kecamatan = kecamatanField.getText();
                    JenisAgama agama = Controller.getJenisAgama(String.valueOf(agamaComboBox.getSelectedItem()));
                    StatusPerkawinan statusPerkawinan = Controller
                            .getStatusPerkawinan(String.valueOf(perkawinanBox.getSelectedItem()));
                    String pekerjaan = Controller.getSelectedJobs(karyawanSwastaCheck, pnsCheck, wiraswastaCheck,
                            akademisiCheck, pengangguranCheck);
                    String wargaNegaraAsal = wnaRadio.isSelected() ? citizenshipField.getText() : null;
                    String kewarganegaraan = Controller
                            .getCitizenship(citizenshipGroup.getSelection().getActionCommand(), wargaNegaraAsal);
                    String berlakuHingga = tglBerlakuField.getText();
                    String kotaPembuatan = kotaPembuatanField.getText();

                    Date tanggalPembuatan = (Date) tglPembuatanPicker.getModel().getValue();
                    LocalDate tanggalPembuatanlocalDate = tanggalPembuatan.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    String tanggalPembuatanlocalDateFormatted = tanggalPembuatanlocalDate
                            .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    KTP ktp = Controller.createKTP(nik, nama, tempatLahir, tanggalLahirlocalDateFormatted, jenisKelamin,
                            golDarah, alamat, rt, rw, kelDesa, kecamatan, agama, statusPerkawinan,
                            pekerjaan, kewarganegaraan, wargaNegaraAsal, photoFile, signatureFile, berlakuHingga,
                            kotaPembuatan, tanggalPembuatanlocalDateFormatted, 1);

                    myFrame.dispose();

                    new PrintKTP(ktp);

                } else {

                    JOptionPane.showMessageDialog(myFrame, "Semua field harus diisi", "Error",
                            JOptionPane.ERROR_MESSAGE);

                }

            }

        });

        JButton updateButton = new JButton("UPDATE");
        updateButton.setBounds(950, 660, 200, 30);
        formPanel.add(updateButton);

        updateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String nik = nikField.getText();
                String nama = namaField.getText();
                String tempatLahir = tempatLahirField.getText();

                Date tanggalLahir = (Date) datePicker.getModel().getValue();
                LocalDate tanggalLahirlocalDate = tanggalLahir.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                String tanggalLahirlocalDateFormatted = tanggalLahirlocalDate
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                JenisKelamin jenisKelamin = priaRadio.isSelected() ? JenisKelamin.PRIA : JenisKelamin.WANITA;
                String golDarah = bloodGroup.getSelection().getActionCommand();
                String alamat = alamatField.getText();
                String rt = rtField.getText();
                String rw = rwField.getText();
                String kelDesa = kelurahanField.getText();
                String kecamatan = kecamatanField.getText();
                JenisAgama agama = Controller.getJenisAgama(String.valueOf(agamaComboBox.getSelectedItem()));
                StatusPerkawinan statusPerkawinan = Controller
                        .getStatusPerkawinan(String.valueOf(perkawinanBox.getSelectedItem()));
                String pekerjaan = Controller.getSelectedJobs(karyawanSwastaCheck, pnsCheck, wiraswastaCheck,
                        akademisiCheck, pengangguranCheck);
                String wargaNegaraAsal = wnaRadio.isSelected() ? citizenshipField.getText() : null;
                String kewarganegaraan = Controller.getCitizenship(citizenshipGroup.getSelection().getActionCommand(),
                        wargaNegaraAsal);
                String berlakuHingga = tglBerlakuField.getText();
                String kotaPembuatan = kotaPembuatanField.getText();

                Date tanggalPembuatan = (Date) tglPembuatanPicker.getModel().getValue();
                LocalDate tanggalPembuatanlocalDate = tanggalPembuatan.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                String tanggalPembuatanlocalDateFormatted = tanggalPembuatanlocalDate
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                KTP ktp = Controller.createKTP(nik, nama, tempatLahir, tanggalLahirlocalDateFormatted, jenisKelamin,
                        golDarah, alamat, rt, rw, kelDesa, kecamatan, agama, statusPerkawinan,
                        pekerjaan, kewarganegaraan, wargaNegaraAsal, photoFile, signatureFile, berlakuHingga,
                        kotaPembuatan, tanggalPembuatanlocalDateFormatted, 2);
                myFrame.dispose();
                JOptionPane.showMessageDialog(myFrame, "Berhasil edit data!", "Notifikasi",
                        JOptionPane.INFORMATION_MESSAGE);

                new PrintKTP(ktp);

            }

        });

        JButton deleteButton = new JButton("DELETE");
        deleteButton.setBounds(720, 660, 200, 30);
        formPanel.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nik = nikField.getText();
                int option = JOptionPane.showConfirmDialog(myFrame, "Apakah Anda yakin ingin menghapus data ?",
                        "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    myFrame.dispose();
                    boolean deleteSuccess = DBController.deleteData(nik);

                    if (deleteSuccess) {
                        JOptionPane.showMessageDialog(myFrame, "Data dengan NIK " + nik + " berhasil dihapus.");
                    } else {
                        JOptionPane.showMessageDialog(myFrame, "Gagal menghapus data dengan NIK " + nik + ".");
                    }
                    new MainMenu();

                }

            }

        });

        JButton mainMenuButton = new JButton("BACK TO MAIN MENU");
        mainMenuButton.setBounds(50, 660, 250, 30);
        formPanel.add(mainMenuButton);

        mainMenuButton.addActionListener(e -> {
            myFrame.dispose();
            new MainMenu();
        });

        if (actionValue == 1) {

            submitButton.setVisible(true);
            updateButton.setVisible(false);
            deleteButton.setVisible(false);

        } else {

            submitButton.setVisible(false);
            updateButton.setVisible(true);
            deleteButton.setVisible(true);

            nikField.setText(myKtp.getNik());
            namaField.setText(myKtp.getNama());
            tempatLahirField.setText(myKtp.getTempatLahir());

            String tanggalLahirString = myKtp.getTanggalLahir();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate tanggalLahirLocalDate = LocalDate.parse(tanggalLahirString, formatter);
            Date tanggalLahir = Date.from(tanggalLahirLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            model.setValue(tanggalLahir);

            if (myKtp.getJenisKelamin() == JenisKelamin.PRIA) {
                priaRadio.setSelected(true);
            } else {
                wanitaRadio.setSelected(true);
            }
            String golDarah = myKtp.getGolDarah();
            switch (golDarah) {
                case "A":
                    aRadio.setSelected(true);
                    break;
                case "B":
                    bRadio.setSelected(true);
                    break;
                case "O":
                    oRadio.setSelected(true);
                    break;
                case "AB":
                    abRadio.setSelected(true);
                    break;
            }
            alamatField.setText(myKtp.getAlamat());
            rtField.setText(myKtp.getRt());
            rwField.setText(myKtp.getRw());
            kelurahanField.setText(myKtp.getKelDesa());
            kecamatanField.setText(myKtp.getKecamatan());

            agamaComboBox.setSelectedItem(myKtp.getAgama().toString());
            perkawinanBox.setSelectedItem(myKtp.getStatusPerkawinan().toString());
            String[] listJobs = Controller.setSelectedJobs(myKtp.getPekerjaan());
            for (int i = 0; i < listJobs.length; i++) {
                switch (listJobs[i]) {
                    case "KARYAWAN SWASTA":
                        karyawanSwastaCheck.setSelected(true);
                        break;
                    case "PNS":
                        pnsCheck.setSelected(true);
                        break;
                    case "WIRASWASTA":
                        wiraswastaCheck.setSelected(true);
                        break;
                    case "AKADEMISI":
                        akademisiCheck.setSelected(true);
                        break;
                    case "PENGANGGURAN":
                        pengangguranCheck.setSelected(true);
                        break;

                }
            }
            String kewarganegaraan = myKtp.getKewarganegaraan();
            if (kewarganegaraan.equals("WNI")) {
                wniRadio.setSelected(true);
                citizenshipField.setVisible(false);
            } else {
                wnaRadio.setSelected(true);
                citizenshipField.setVisible(true);
                citizenshipField.setText(myKtp.getWargaNegaraAsal());
            }
            photoFile = myKtp.getFotoFilePath();
            signatureFile = myKtp.getTandaTanganFilePath();

            tglBerlakuField.setText(myKtp.getBerlakuHingga());
            kotaPembuatanField.setText(myKtp.getKotaPembuatan());

            String tanggalPembuatanString = myKtp.getTanggalPembuatan();
            DateTimeFormatter tanggalPembuatanformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate tanggalPembuatanLocalDate = LocalDate.parse(tanggalPembuatanString, tanggalPembuatanformatter);
            Date tanggalPembuatan = Date
                    .from(tanggalPembuatanLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            tglPembuatanmodel.setValue(tanggalPembuatan);

        }

        myFrame.add(formPanel); // ADD PANEL TO FRAME
        myFrame.setVisible(true); // SET FRAME TO VISIBLE
    }

}
