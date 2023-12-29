package No_4;

class Matakuliah {
    private String kode, namaMatkul, nilai;
    private int sks;

    public Matakuliah(String kode, String namaMatkul, String nilai, int sks) {
        this.kode = kode;
        this.namaMatkul = namaMatkul;
        this.nilai = nilai;
        this.sks = sks;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    @Override
    public String toString() {
        return "Matakuliah{" + "kode=" + kode + ", namaMatkul=" + namaMatkul + ", nilai=" + nilai + ", sks=" + sks + '}';
    }
    
    
}
