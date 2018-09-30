package com.desafiolatam.prueba4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.desafiolatam.prueba4.QuoteFragment.OnListFragmentInteractionListener;
import com.desafiolatam.prueba4.model.QuoteModel;

import java.util.List;

public class MyQuoteRecyclerViewAdapter extends RecyclerView.Adapter<MyQuoteRecyclerViewAdapter.ViewHolder> {

    private final List<QuoteModel> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyQuoteRecyclerViewAdapter(List<QuoteModel> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_quote, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //holder.mItem = mValues.get(position);
        holder.mQuoteView.setText(mValues.get(position).getQuote());
        holder.mAuthorView.setText(mValues.get(position).getAuthor());
        holder.mCategoryView.setText(mValues.get(position).getCategory());

        /*holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mQuoteView;
        public final TextView mAuthorView;
        public final TextView mCategoryView;
        //public QuoteModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mQuoteView = (TextView) view.findViewById(R.id.quoteTv);
            mAuthorView = (TextView) view.findViewById(R.id.authorTv);
            mCategoryView = (TextView) view.findViewById(R.id.categoryTv);
        }

    }
}
