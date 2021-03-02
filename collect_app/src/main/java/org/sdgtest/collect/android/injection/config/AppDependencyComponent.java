package org.sdgtest.collect.android.injection.config;

import android.app.Application;
import android.telephony.SmsManager;

import org.javarosa.core.reference.ReferenceManager;
import org.sdgtest.collect.android.activities.FormDownloadListActivity;
import org.sdgtest.collect.android.activities.FormEntryActivity;
import org.sdgtest.collect.android.activities.FormHierarchyActivity;
import org.sdgtest.collect.android.activities.FormMapActivity;
import org.sdgtest.collect.android.activities.GeoPointMapActivity;
import org.sdgtest.collect.android.activities.GeoPolyActivity;
import org.sdgtest.collect.android.activities.GoogleDriveActivity;
import org.sdgtest.collect.android.activities.GoogleSheetsUploaderActivity;
import org.sdgtest.collect.android.activities.InstanceUploaderListActivity;
import org.sdgtest.collect.android.activities.MainMenuActivity;
import org.sdgtest.collect.android.activities.SplashScreenActivity;
import org.sdgtest.collect.android.adapters.InstanceUploaderAdapter;
import org.sdgtest.collect.android.analytics.Analytics;
import org.sdgtest.collect.android.application.Collect;
import org.sdgtest.collect.android.events.RxEventBus;
import org.sdgtest.collect.android.formentry.ODKView;
import org.sdgtest.collect.android.formentry.saving.SaveFormProgressDialogFragment;
import org.sdgtest.collect.android.fragments.DataManagerList;
import org.sdgtest.collect.android.fragments.MapBoxInitializationFragment;
import org.sdgtest.collect.android.geo.GoogleMapFragment;
import org.sdgtest.collect.android.geo.MapboxMapFragment;
import org.sdgtest.collect.android.geo.OsmDroidMapFragment;
import org.sdgtest.collect.android.logic.PropertyManager;
import org.sdgtest.collect.android.openrosa.OpenRosaHttpInterface;
import org.sdgtest.collect.android.preferences.AdminPasswordDialogFragment;
import org.sdgtest.collect.android.preferences.AdminSharedPreferences;
import org.sdgtest.collect.android.preferences.FormManagementPreferences;
import org.sdgtest.collect.android.preferences.FormMetadataFragment;
import org.sdgtest.collect.android.preferences.GeneralSharedPreferences;
import org.sdgtest.collect.android.preferences.IdentityPreferences;
import org.sdgtest.collect.android.preferences.ServerPreferencesFragment;
import org.sdgtest.collect.android.preferences.UserInterfacePreferencesFragment;
import org.sdgtest.collect.android.preferences.qr.QRCodeTabsActivity;
import org.sdgtest.collect.android.preferences.qr.ShowQRCodeFragment;
import org.sdgtest.collect.android.storage.StorageInitializer;
import org.sdgtest.collect.android.storage.migration.StorageMigrationDialog;
import org.sdgtest.collect.android.storage.migration.StorageMigrationService;
import org.sdgtest.collect.android.tasks.InstanceServerUploaderTask;
import org.sdgtest.collect.android.tasks.ServerPollingJob;
import org.sdgtest.collect.android.tasks.sms.SmsNotificationReceiver;
import org.sdgtest.collect.android.tasks.sms.SmsSender;
import org.sdgtest.collect.android.tasks.sms.SmsSentBroadcastReceiver;
import org.sdgtest.collect.android.tasks.sms.SmsService;
import org.sdgtest.collect.android.tasks.sms.contracts.SmsSubmissionManagerContract;
import org.sdgtest.collect.android.upload.AutoSendWorker;
import org.sdgtest.collect.android.utilities.AuthDialogUtility;
import org.sdgtest.collect.android.utilities.FormDownloader;
import org.sdgtest.collect.android.widgets.ExStringWidget;
import org.sdgtest.collect.android.widgets.QuestionWidget;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Dagger component for the application. Should include
 * application level Dagger Modules and be built with Application
 * object.
 *
 * Add an `inject(MyClass myClass)` method here for objects you want
 * to inject into so Dagger knows to wire it up.
 *
 * Annotated with @Singleton so modules can include @Singletons that will
 * be retained at an application level (as this an instance of this components
 * is owned by the Application object).
 *
 * If you need to call a provider directly from the component (in a test
 * for example) you can add a method with the type you are looking to fetch
 * (`MyType myType()`) to this interface.
 *
 * To read more about Dagger visit: https://google.github.io/dagger/users-guide
 **/

@Singleton
@Component(modules = {
        AppDependencyModule.class
})
public interface AppDependencyComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        Builder appDependencyModule(AppDependencyModule testDependencyModule);

        AppDependencyComponent build();
    }

    void inject(Collect collect);

    void inject(SmsService smsService);

    void inject(SmsSender smsSender);

    void inject(SmsSentBroadcastReceiver smsSentBroadcastReceiver);

    void inject(SmsNotificationReceiver smsNotificationReceiver);

    void inject(InstanceUploaderAdapter instanceUploaderAdapter);

    void inject(DataManagerList dataManagerList);

    void inject(PropertyManager propertyManager);

    void inject(FormEntryActivity formEntryActivity);

    void inject(InstanceServerUploaderTask uploader);

    void inject(ServerPreferencesFragment serverPreferencesFragment);

    void inject(FormDownloader formDownloader);

    void inject(ServerPollingJob serverPollingJob);

    void inject(AuthDialogUtility authDialogUtility);

    void inject(FormDownloadListActivity formDownloadListActivity);

    void inject(InstanceUploaderListActivity activity);

    void inject(GoogleDriveActivity googleDriveActivity);

    void inject(GoogleSheetsUploaderActivity googleSheetsUploaderActivity);

    void inject(QuestionWidget questionWidget);

    void inject(ExStringWidget exStringWidget);

    void inject(ODKView odkView);

    void inject(FormMetadataFragment formMetadataFragment);

    void inject(GeoPointMapActivity geoMapActivity);

    void inject(GeoPolyActivity geoPolyActivity);

    void inject(FormMapActivity formMapActivity);

    void inject(OsmDroidMapFragment mapFragment);

    void inject(GoogleMapFragment mapFragment);

    void inject(MapboxMapFragment mapFragment);

    void inject(MainMenuActivity mainMenuActivity);

    void inject(QRCodeTabsActivity qrCodeTabsActivity);

    void inject(ShowQRCodeFragment showQRCodeFragment);

    void inject(StorageInitializer storageInitializer);

    void inject(StorageMigrationService storageMigrationService);

    void inject(AutoSendWorker autoSendWorker);

    void inject(StorageMigrationDialog storageMigrationDialog);

    void inject(AdminPasswordDialogFragment adminPasswordDialogFragment);

    void inject(SplashScreenActivity splashScreenActivity);

    void inject(FormHierarchyActivity formHierarchyActivity);

    void inject(FormManagementPreferences formManagementPreferences);

    void inject(IdentityPreferences identityPreferences);

    void inject(UserInterfacePreferencesFragment userInterfacePreferencesFragment);

    void inject(SaveFormProgressDialogFragment saveFormProgressDialogFragment);

    void inject(MapBoxInitializationFragment mapBoxInitializationFragment);

    SmsManager smsManager();

    SmsSubmissionManagerContract smsSubmissionManagerContract();

    RxEventBus rxEventBus();

    OpenRosaHttpInterface openRosaHttpInterface();

    ReferenceManager referenceManager();

    Analytics analytics();

    GeneralSharedPreferences generalSharedPreferences();

    AdminSharedPreferences adminSharedPreferences();
}