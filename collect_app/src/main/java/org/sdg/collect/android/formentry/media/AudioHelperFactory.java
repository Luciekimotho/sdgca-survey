package org.sdg.collect.android.formentry.media;

import android.content.Context;

import org.sdg.collect.android.audio.AudioHelper;

public interface AudioHelperFactory {

    AudioHelper create(Context context);
}
