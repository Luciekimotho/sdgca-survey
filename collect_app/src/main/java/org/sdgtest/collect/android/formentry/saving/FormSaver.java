package org.sdgtest.collect.android.formentry.saving;

import android.net.Uri;

import org.sdgtest.collect.android.analytics.Analytics;
import org.sdgtest.collect.android.javarosawrapper.FormController;
import org.sdgtest.collect.android.tasks.SaveToDiskResult;

public interface FormSaver {
    SaveToDiskResult save(Uri instanceContentURI, FormController formController, boolean shouldFinalize, boolean exitAfter, String updatedSaveName, ProgressListener progressListener, Analytics analytics);

    interface ProgressListener {
        void onProgressUpdate(String message);
    }
}
