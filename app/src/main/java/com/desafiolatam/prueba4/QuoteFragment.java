package com.desafiolatam.prueba4;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desafiolatam.prueba4.model.QuoteModel;
import com.desafiolatam.prueba4.networks.QuoteInterceptor;
import com.desafiolatam.prueba4.networks.QuotesService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteFragment extends Fragment {

    RecyclerView recyclerView;
    MyQuoteRecyclerViewAdapter adapter;

    public QuoteFragment() {
    }

    public static QuoteFragment newInstance() {
        QuoteFragment fragment = new QuoteFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quote_list, container, false);

        recyclerView = view.findViewById(R.id.list);

        LinearLayoutManager lManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(lManager);
        recyclerView.setHasFixedSize(true);

        setQuotes();
        return view;
    }

    private void setQuotes(){

        QuotesService serv = new QuoteInterceptor().get();
        Call<List<QuoteModel>> quotesRequest = serv.getQuotes("movies","15");
        quotesRequest.enqueue(new Callback<List<QuoteModel>>() {
            @Override
            public void onResponse(Call<List<QuoteModel>> call, Response<List<QuoteModel>> response) {
                MyQuoteRecyclerViewAdapter adapter = new MyQuoteRecyclerViewAdapter(response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<QuoteModel>> call, Throwable t) {

            }
        });
    }


}
