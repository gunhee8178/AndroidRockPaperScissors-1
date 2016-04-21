// Copyright 2011 Google Inc. All Rights Reserved.

package com.example.android.wifidirect;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * A service that process each file transfer request i.e Intent by opening a
 * socket connection with the WiFi Direct Group Owner and writing the file
 */
public class FileTransferService extends IntentService {

    private static final int SOCKET_TIMEOUT = 5000;
    public static final String ACTION_SEND_MOVE = "com.example.android.wifidirect.SEND_MOVE";
		public static final String SEND_MESSAGE = "message to send";
    public static final String EXTRAS_FILE_PATH = "file_url";
    public static final String EXTRAS_GROUP_OWNER_ADDRESS = "go_host";
    public static final String EXTRAS_GROUP_OWNER_PORT = "go_port";

    public FileTransferService(String name) {
        super(name);
    }

    public FileTransferService() {
        super("FileTransferService");
    }

    /*
     * (non-Javadoc)
     * @see android.app.IntentService#onHandleIntent(android.content.Intent)
     */
    @Override
		protected void onHandleIntent(Intent intent) {
			Context context = getApplicationContext();
			if (intent.getAction().equals(ACTION_SEND_MOVE)) {
				String host = intent.getExtras().getString(EXTRAS_GROUP_OWNER_ADDRESS);
				Socket socket = new Socket();
				int port = intent.getExtras().getInt(EXTRAS_GROUP_OWNER_PORT);
				DataOutputStream stream = null;
				try {
					socket.connect((new InetSocketAddress(host, port)), SOCKET_TIMEOUT);
					stream = new DataOutputStream(socket.getOutputStream());
					String message = intent.getExtras().getString(SEND_MESSAGE);
					stream.writeUTF(message);
				} catch (IOException e) {
					Log.e(WiFiDirectActivity.TAG, e.getMessage());
				} finally {
					if (stream != null) {
							 try {
									stream.close();
							 } catch (IOException e) {
									e.printStackTrace();
							 }    
					}
					if (socket != null) {
							if (socket.isConnected()) {
									try {
											socket.close();
									} catch (IOException e) {
											e.printStackTrace();
									}
							}
					}
				}
			}
		}
}
