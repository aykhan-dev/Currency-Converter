package az.kapital.test.ui.view.fragments.selector.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import az.kapital.test.domain.model.Currency;

public class CurrencyDiffUtil extends DiffUtil.ItemCallback<Currency> {

    @Override
    public boolean areItemsTheSame(@NonNull Currency oldItem, @NonNull Currency newItem) {
        return oldItem.key().equals(newItem.key());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Currency oldItem, @NonNull Currency newItem) {
        return oldItem.equals(newItem);
    }

}
