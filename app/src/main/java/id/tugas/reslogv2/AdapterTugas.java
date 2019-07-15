package id.tugas.reslogv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import id.tugas.reslogv2.model.modelTugas;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdapterTugas extends RecyclerView.Adapter<AdapterTugas.ViewHolder> {

    private ArrayList<modelTugas> daftarTugas;
    private Context context;

    public AdapterTugas(ArrayList<modelTugas> Tugasi, Context ctx){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        daftarTugas = Tugasi;
        context = ctx;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        /**
         * Inisiasi View
         * Di tutorial ini kita hanya menggunakan data String untuk tiap item
         * dan juga view nya hanyalah satu TextView
         */
        TextView tvTitle;

        ViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tv_namatugas);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tugas, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String name = daftarTugas.get(position).getMatakuliah();
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Read detail data
                 */
            }
        });
        holder.tvTitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Delete dan update data
                 */
                return true;
            }
        });
        holder.tvTitle.setText(name);
    }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada tugas
         */
        return daftarTugas.size();
    }
}
