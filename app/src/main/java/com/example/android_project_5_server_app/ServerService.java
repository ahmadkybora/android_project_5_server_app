package com.example.android_project_5_server_app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class ServerService extends Service {
    public ServerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }

    IMyAidlInterface.Stub binder = new IMyAidlInterface.Stub() {

        @Override
        public String sum(int a, int b) {
            return "a + b =" + (a + b);
        }

        @Override
        public void stop() throws RemoteException {
            stopSelf();
            System.exit(0);
        }
    };
}