package com.desafiolatam.prueba4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.desafiolatam.prueba4.model.QuoteModel;

import java.util.List;

public class MyQuoteRecyclerViewAdapter extends RecyclerView.Adapter<MyQuoteRecyclerViewAdapter.ViewHolder> {

    private final List<QuoteModel> mValues;

    public MyQuoteRecyclerViewAdapter(List<QuoteModel> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_quote, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mQuoteView.setText(mValues.get(position).getQuote());
        holder.mAuthorView.setText(mValues.get(position).getAuthor());
        holder.mCategoryView.setText(mValues.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mQuoteView;
        public final TextView mAuthorView;
        public final TextView mCategoryView;

        public ViewHolder(View view) {
            super(view);
            mQuoteView = (TextView) view.findViewById(R.id.quoteTv);
            mAuthorView = (TextView) view.findViewById(R.id.authorTv);
            mCategoryView = (TextView) view.findViewById(R.id.categoryTv);
        }

    }
}
