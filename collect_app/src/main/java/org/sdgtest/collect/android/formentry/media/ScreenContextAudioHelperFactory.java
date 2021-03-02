package org.sdgtest.collect.android.formentry.media;

import android.content.Context;

import org.sdgtest.collect.android.audio.AudioHelper;
import org.sdgtest.collect.android.utilities.ScreenContext;

public class ScreenContextAudioHelperFactory implements AudioHelperFactory {

    public AudioHelper create(Context context) {
        ScreenContext screenContext = (ScreenContext) context;
        return new AudioHelper(screenContext.getActivity(), screenContext.getViewLifecycle());
    }
}
