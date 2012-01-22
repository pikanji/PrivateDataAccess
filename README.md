PrivateDataAccess
=================

Over View
---------
This project demonstrates access to private data in different process.

Requirements
------------
Android 2.1+

### Git Tags
*demo1 -- shows that an Activity has access to its private data even if it is started from other app.
*demo2 -- shows how to provide access to private data in SharedPreferences limitting to certain apps. 

### demo1
This shows that an Activity has access to its private data in SharedPreferences even if it is started from other app by startActvity(). This also shows that the Activity started by other app is running on the different process from the calling process.

### demo2
This shows how to provide access to private data in SharedPreferences limitting to certain apps. PrivateDataAccessServer app creates its data in SharedPreferences in private mode, and returns the private data as a result of startActivityForResult(). The security is provided by setting permission to start PrivateDataProviderActivity, which has access to the private data. The permission is given to only apps that are signed with the same signature as PrivateDataAccessServer, and defined in AndroidManifest.xml.
