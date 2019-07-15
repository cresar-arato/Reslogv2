package id.tugas.reslogv2.model;
import java.io.Serializable;

public class modelTugas implements Serializable {

    private String matakuliah;
    private String detailtugas;
    private String key;

    public modelTugas(){

    }
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
        
        public String getMatakuliah() {
            return matakuliah;
        }

        public void setMatakuliah(String matakuliah) {
            this.matakuliah = matakuliah;
    }

        public String getDetailtugas() {
            return detailtugas;
        }

        public void setDetailtugas(String detailtugas) {
            this.detailtugas = detailtugas;
        }

    @Override
    public String toString() {
        return " "+matakuliah+"\n" +
                " "+detailtugas;
    }
    public modelTugas(String mk, String dt){
        matakuliah = mk;
        detailtugas = dt;
    }
}
