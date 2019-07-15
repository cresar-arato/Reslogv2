package id.tugas.reslogv2.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import id.tugas.reslogv2.DetailTugasActivity;
import id.tugas.reslogv2.InputTugasActivity;
import id.tugas.reslogv2.R;
import id.tugas.reslogv2.ReadTugasActivity;
import id.tugas.reslogv2.model.modelTugas;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdapterTugas extends RecyclerView.Adapter<AdapterTugas.ViewHolder> {

    private ArrayList<modelTugas> daftarTugas;
    private Context context;
    ReadTugasActivity listener;

    public AdapterTugas(ArrayList<modelTugas> Tugasi, Context ctx){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        daftarTugas = Tugasi;
        context = ctx;
        listener = (ReadTugasActivity) ctx;
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
        System.out.println("BARANG DATA one by one "+position+daftarTugas.size());
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial <span data-mce-type="bookmark" style="display: inline-block; width: 0px; overflow: hidden; line-height: 0;" class="mce_SELRES_start"></span>Read detail data
                 */
                context.startActivity(DetailTugasActivity.getActIntent((Activity) context).putExtra("data", daftarTugas.get(position)));
            }
        });
        holder.tvTitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial delete dan update data
                 */
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_lihat);
                dialog.setTitle("Pilih Aksi");
                dialog.show();

                Button editButton = (Button) dialog.findViewById(R.id.btn_edit_tugas);
                Button delButton = (Button) dialog.findViewById(R.id.btn_delete_tugas);

                //apabila tombol edit diklik
                editButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                context.startActivity(InputTugasActivity.getActIntent((Activity) context).putExtra("data", daftarTugas.get(position)));
                            }
                        }
                );

                //apabila tombol delete diklik
                delButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                listener.onDeleteData(daftarTugas.get(position), position);
                            }
                        }
                );
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
