package org.sdg.collect.android.support;

import androidx.test.rule.ActivityTestRule;

import org.sdg.collect.android.activities.MainMenuActivity;
import org.sdg.collect.android.support.pages.MainMenuPage;

public class CollectTestRule extends ActivityTestRule<MainMenuActivity> {

    public CollectTestRule() {
        super(MainMenuActivity.class);
    }

    public MainMenuPage mainMenu() {
        return new MainMenuPage(this).assertOnPage();
    }
}
