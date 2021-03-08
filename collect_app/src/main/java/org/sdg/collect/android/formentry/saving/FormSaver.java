package org.sdg.collect.android.formentry.saving;

import android.net.Uri;

import org.sdg.collect.android.analytics.Analytics;
import org.sdg.collect.android.javarosawrapper.FormController;
import org.sdg.collect.android.tasks.SaveToDiskResult;

public interface FormSaver {
    SaveToDiskResult save(Uri instanceContentURI, FormController formController, boolean shouldFinalize, boolean exitAfter, String updatedSaveName, ProgressListener progressListener, Analytics analytics);

    interface ProgressListener {
        void onProgressUpdate(String message);
    }
}
