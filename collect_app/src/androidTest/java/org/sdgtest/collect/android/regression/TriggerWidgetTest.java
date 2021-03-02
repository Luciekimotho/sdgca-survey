package org.sdgtest.collect.android.regression;

import android.Manifest;

import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.runner.RunWith;
import org.sdgtest.collect.android.R;
import org.sdgtest.collect.android.support.CollectTestRule;
import org.sdgtest.collect.android.support.CopyFormRule;
import org.sdgtest.collect.android.support.ResetStateRule;
import org.sdgtest.collect.android.support.pages.GeneralSettingsPage;
import org.sdgtest.collect.android.support.pages.MainMenuPage;

//Issue NODK-415
@RunWith(AndroidJUnit4.class)
public class TriggerWidgetTest {

    public CollectTestRule rule = new CollectTestRule();

    @Rule
    public RuleChain copyFormChain = RuleChain
            .outerRule(GrantPermissionRule.grant(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_PHONE_STATE)
            )
            .around(new ResetStateRule())
            .around(new CopyFormRule("Automated_guidance_hint_form.xml"))
            .around(rule);

    @Test
    public void guidanceIcons_ShouldBeAlwaysShown() {
        new MainMenuPage(rule)
                .clickOnMenu()
                .clickGeneralSettings()
                .openFormManagement()
                .openShowGuidanceForQuestions()
                .clickOnString(R.string.guidance_yes)
                .pressBack(new GeneralSettingsPage(rule))
                .pressBack(new MainMenuPage(rule))
                .startBlankForm("Guidance Form Sample")
                .assertText("Guidance text")
                .swipeToEndScreen()
                .clickSaveAndExit();

    }

    @Test
    public void guidanceIcons_ShouldBeCollapsed() {
        new MainMenuPage(rule)
                .clickOnMenu()
                .clickGeneralSettings()
                .openFormManagement()
                .openShowGuidanceForQuestions()
                .clickOnString(R.string.guidance_yes_collapsed)
                .pressBack(new GeneralSettingsPage(rule))
                .pressBack(new MainMenuPage(rule))
                .startBlankForm("Guidance Form Sample")
                .checkIsIdDisplayed(R.id.help_icon)
                .clickOnText("TriggerWidget")
                .assertText("Guidance text")
                .swipeToEndScreen()
                .clickSaveAndExit();
    }
}