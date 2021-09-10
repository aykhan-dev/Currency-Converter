package az.kapital.test.ui.view.fragments.exchanger.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import az.kapital.test.domain.model.News;

public class NewsDiffUtil extends DiffUtil.ItemCallback<News> {

    @Override
    public boolean areItemsTheSame(@NonNull News oldItem, @NonNull News newItem) {
        return oldItem.id() == newItem.id();
    }

    @Override
    public boolean areContentsTheSame(@NonNull News oldItem, @NonNull News newItem) {
        return oldItem.equals(newItem);
    }

}
