package org.sdgtest.collect.android.widgets;

import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;

import org.junit.Test;
import org.sdgtest.collect.android.formentry.questions.QuestionDetails;
import org.sdgtest.collect.android.widgets.base.GeneralSelectOneWidgetTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

/**
 * @author James Knight
 */

public class ListWidgetTest extends GeneralSelectOneWidgetTest<ListWidget> {
    @NonNull
    @Override
    public ListWidget createWidget() {
        return new ListWidget(activity, new QuestionDetails(formEntryPrompt, "formAnalyticsID"), false, false);
    }

    @Test
    public void usingReadOnlyOptionShouldMakeAllClickableElementsDisabled() {
        when(formEntryPrompt.isReadOnly()).thenReturn(true);

        for (RadioButton radioButton : getSpyWidget().buttons) {
            assertThat(radioButton.getVisibility(), is(View.VISIBLE));
            assertThat(radioButton.isEnabled(), is(Boolean.FALSE));
        }
    }
}
