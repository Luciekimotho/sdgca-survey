package org.sdg.collect.android.preferences.utilities;

import android.app.Activity;

import org.sdg.collect.android.R;
import org.sdg.collect.android.activities.MainMenuActivity;
import org.sdg.collect.android.application.Collect;
import org.sdg.collect.android.listeners.ActionListener;
import org.sdg.collect.android.preferences.AdminSharedPreferences;
import org.sdg.collect.android.preferences.GeneralSharedPreferences;
import org.sdg.collect.android.preferences.PreferenceSaver;
import org.sdg.collect.android.utilities.LocaleHelper;
import org.sdg.collect.android.utilities.ToastUtils;

import timber.log.Timber;

import static org.sdg.collect.android.activities.ActivityUtils.startActivityAndCloseAllOthers;

public class SettingsUtils {

    private SettingsUtils() {
    }

    public static void applySettings(Activity activity, String content) {
        new PreferenceSaver(GeneralSharedPreferences.getInstance(), AdminSharedPreferences.getInstance()).fromJSON(content, new ActionListener() {
            @Override
            public void onSuccess() {
                Collect.getInstance().initializeJavaRosa();
                ToastUtils.showLongToast(Collect.getInstance().getString(R.string.successfully_imported_settings));
                final LocaleHelper localeHelper = new LocaleHelper();
                localeHelper.updateLocale(activity);
                startActivityAndCloseAllOthers(activity, MainMenuActivity.class);
            }

            @Override
            public void onFailure(Exception exception) {
                if (exception instanceof GeneralSharedPreferences.ValidationException) {
                    ToastUtils.showLongToast(Collect.getInstance().getString(R.string.invalid_qrcode));
                } else {
                    Timber.e(exception);
                }
            }
        });
    }
}
