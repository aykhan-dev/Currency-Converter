package az.kapital.test.ui.view.fragments.selector.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import javax.inject.Inject;

import az.kapital.test.domain.model.Currency;

public class CurrenciesListAdapter extends ListAdapter<Currency, CurrencyViewHolder> {

    private CurrencySelectionListener listener;

    @Inject
    protected CurrenciesListAdapter() {
        super(new CurrencyDiffUtil());
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CurrencyViewHolder.build(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder holder, int position) {
        holder.bind(getItem(position), listener);
    }

    public void setListener(CurrencySelectionListener listener) {
        this.listener = listener;
    }

}
