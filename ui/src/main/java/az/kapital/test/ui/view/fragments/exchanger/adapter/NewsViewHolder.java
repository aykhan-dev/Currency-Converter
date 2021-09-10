package az.kapital.test.ui.view.fragments.exchanger.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import az.kapital.test.domain.model.News;
import az.kapital.test.ui.databinding.LayoutItemNewsBinding;

class NewsViewHolder extends RecyclerView.ViewHolder {

    static NewsViewHolder build(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutItemNewsBinding binding = LayoutItemNewsBinding.inflate(inflater, parent, false);
        return new NewsViewHolder(binding);
    }

    private final LayoutItemNewsBinding binding;

    private NewsViewHolder(LayoutItemNewsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(News data) {

        binding.textViewTitle.setText(data.title());
        binding.textViewContent.setText(data.content());

        binding.textViewDate.setText(data.date());

    }

}