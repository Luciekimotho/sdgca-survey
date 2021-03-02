package org.sdgtest.collect.android.formentry.media;

import android.content.Context;

import org.sdgtest.collect.android.audio.AudioHelper;

public interface AudioHelperFactory {

    AudioHelper create(Context context);
}
