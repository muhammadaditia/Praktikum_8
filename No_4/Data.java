package No_4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data {

    private String nama = null, nim = null, prodi = null;
    private int semester = 0;
    private ArrayList<Matakuliah> trankrip = null;

    public Data() {

    }

    public Data(String nama, String nim, String prodi, int semester, ArrayList<Matakuliah> trankrip) {
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
        this.semester = semester;
        this.trankrip = trankrip;
    }

    public boolean insert(Matakuliah matakuliah) {
        boolean result = false;
        if (nama != null && nim != null && prodi != null && semester > 0 && semester <= 14 && trankrip != null) {
            trankrip.add(matakuliah);
        }
        return result;
    }

    public boolean insert(String kode, String namaMatkul, String nilai, int sks) {
        boolean result = false;
        if (nama != null && nim != null && prodi != null && semester > 0 && semester <= 14 && trankrip != null) {
            Matakuliah mk = new Matakuliah(kode, namaMatkul, nilai, sks);
            trankrip.add(mk);
        }
        return result;
    }

    public boolean delete(int index) {
        boolean status = false;
        if (trankrip != null && index >= 0 && index < trankrip.size()) {
            trankrip.remove(index);
        }
        return status;
    }

    public boolean update(int index, Matakuliah matakuliah) {
        boolean status = false;
        if (trankrip != null && index >= 0 && index < trankrip.size()) {
            trankrip.set(index, matakuliah);
        }
        return status;
    }

    public boolean update(int index, String kode, String namaMatkul, String nilai, int sks) {
        boolean status = false;
        if (trankrip != null && index >= 0 && index < trankrip.size()) {
            Matakuliah mk = new Matakuliah(kode, namaMatkul, nilai, sks);
            trankrip.set(index, mk);
        }
        return status;
    }

    public Data read(File file) {
        try {
            Scanner sc = new Scanner(file);

            //baris1
            String baris = sc.nextLine();
            String[] elemens = baris.split(";");
            nama = elemens[1];

            //baris2
            baris = sc.nextLine();
            elemens = baris.split(";");
            nim = elemens[1];

            //baris3
            baris = sc.nextLine();
            elemens = baris.split(";");
            prodi = elemens[1];

            //baris4
            baris = sc.nextLine();
            elemens = baris.split(";");
            semester = Integer.parseInt(elemens[1].trim());

            //baris5
            sc.nextLine();

            //baris 6
            trankrip = new ArrayList<>();
            while (sc.hasNext()) {
                baris = sc.nextLine();
                elemens = baris.split(";");
                String kode = elemens[0];
                String namaMatkul = elemens[1];
                String nilai = elemens[2];
                int sks = Integer.parseInt(elemens[3]);

                Matakuliah mk = new Matakuliah(kode, namaMatkul, nilai, sks);
                trankrip.add(mk);
            }

            sc.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return this;
    }

    public void save(File file) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            if (nama != null && nim != null && prodi != null && semester > 0 && semester <= 14) {
                bw.write("Nama;" + nama + "\n");
                bw.write("Nim;" + nim + "\n");
                bw.write("Prodi;" + prodi + "\n");
                bw.write("Semester;" + semester + "\n");
                bw.write("Kode;Matakuliah;Nilai;Sks\n");

                if (trankrip != null) {
                    for (Matakuliah mk : trankrip) {
                        bw.write(mk.getKode() + ";" + mk.getNamaMatkul() + ";" + mk.getNilai() + ";" + mk.getSks() + "\n");
                    }
                }
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public ArrayList<Matakuliah> getTrankrip() {
        return trankrip;
    }

    public void setTrankrip(ArrayList<Matakuliah> trankrip) {
        this.trankrip = trankrip;
    }

    @Override
    public String toString() {
        return "Data{" + "nama=" + nama + ", nim=" + nim + ", prodi=" + prodi + ", semester=" + semester + ", trankrip=" + trankrip + '}';
    }

}
