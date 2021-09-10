package az.kapital.test.ui.view.activities;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import az.kapital.test.ui.R;
import az.kapital.test.ui.base.BaseActivity;
import az.kapital.test.ui.base.callback.ActivityBindingCallback;
import az.kapital.test.ui.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private NavController navController;

    @Override
    protected ActivityBindingCallback<ActivityMainBinding> getBindingCallback() {
        return ActivityMainBinding::inflate;
    }

    @Override
    protected void onReadyUI(ActivityMainBinding ui) {

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_host);
        navController = navHostFragment.getNavController();

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            String pageTitle = controller.getCurrentDestination().getLabel().toString();
            ui.textViewPageTitle.setText(pageTitle);
        });

    }

}