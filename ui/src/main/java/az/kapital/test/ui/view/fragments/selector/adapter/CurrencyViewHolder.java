package az.kapital.test.ui.view.fragments.selector.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import az.kapital.test.domain.model.Currency;
import az.kapital.test.ui.databinding.LayoutItemCurrencyBinding;

public class CurrencyViewHolder extends RecyclerView.ViewHolder {

    static CurrencyViewHolder build(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutItemCurrencyBinding binding = LayoutItemCurrencyBinding.inflate(inflater, parent, false);
        return new CurrencyViewHolder(binding);
    }

    private final LayoutItemCurrencyBinding binding;

    private CurrencyViewHolder(LayoutItemCurrencyBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Currency data, CurrencySelectionListener listener) {

        binding.textViewCurrencyKey.setText(data.key());
        binding.textViewCurrencyName.setText(data.name());

        binding.getRoot().setOnClickListener(view -> listener.onSelect(data));

    }

}
