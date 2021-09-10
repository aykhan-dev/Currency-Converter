package az.kapital.test.ui.view.fragments.exchanger.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import javax.inject.Inject;

import az.kapital.test.domain.model.News;

public class NewsListAdapter extends ListAdapter<News, NewsViewHolder> {

    @Inject
    public NewsListAdapter() {
        super(new NewsDiffUtil());
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NewsViewHolder.build(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

}
