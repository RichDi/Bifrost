package com.example.ricardodelgado.bifrost;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class EnterpriseListAdapter extends RecyclerView.Adapter<EnterpriseListAdapter.ViewHolder> {
    private ArrayList<EnterpriseObj> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        View mView ;
        ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    EnterpriseListAdapter(ArrayList<EnterpriseObj> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public EnterpriseListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.enterprise_layout, parent, false);

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView nombreEmpresa = holder.mView.findViewById(R.id.textView2);
        TextView numeroEmpleados = holder.mView.findViewById(R.id.textView3);
        TextView proyectoReciente = holder.mView.findViewById(R.id.textView5);

        nombreEmpresa.setText(mDataset.get(position).getNombreDeEmpresa());
        numeroEmpleados.setText("Coolaboradores" + mDataset.get(position).getNumeroDeEmpleados());
        proyectoReciente.setText(mDataset.get(position).getProyectoReciente());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
