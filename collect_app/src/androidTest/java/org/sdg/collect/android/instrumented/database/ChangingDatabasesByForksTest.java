package org.sdg.collect.android.instrumented.database;

import org.junit.Test;
import org.sdg.collect.android.dao.FormsDao;
import org.sdg.collect.android.dao.InstancesDao;
import org.sdg.collect.android.database.helpers.FormsDatabaseHelper;
import org.sdg.collect.android.database.helpers.InstancesDatabaseHelper;
import org.sdg.collect.android.instrumented.database.helpers.SqlLiteHelperTest;

import java.io.File;
import java.io.IOException;

import static org.sdg.collect.android.support.FileUtils.copyFileFromAssets;

public class ChangingDatabasesByForksTest extends SqlLiteHelperTest {

    @Test
    public void appShouldNotCrashAfterChangingFormsDbByItsFork() throws IOException {
        // getting forms cursor creates the newest version of form.db
        new FormsDao().getFormsCursor();

        // a fork changes our forms.db downgrading it
        copyFileFromAssets("database" + File.separator + "forms_v4.db", FormsDatabaseHelper.getDatabasePath());

        // the change should be detected and handled, app shouldn't crash
        new FormsDao().getFormsCursor();
    }

    @Test
    public void appShouldNotCrashAfterChangingInstancesDbByItsFork() throws IOException {
        // getting instances cursor creates the newest version of instances.db
        new InstancesDao().getSentInstancesCursor();

        // a fork changes our instances.db downgrading it
        copyFileFromAssets("database" + File.separator + "instances_v3.db", InstancesDatabaseHelper.getDatabasePath());

        // the change should be detected and handled, app shouldn't crash
        new InstancesDao().getSentInstancesCursor();
    }
}