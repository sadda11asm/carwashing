package com.example.carwashing.ui.login

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

import com.facebook.accountkit.AccountKit
import com.facebook.accountkit.AccessToken
import com.facebook.accountkit.ui.AccountKitActivity
import com.facebook.accountkit.ui.LoginType
import com.facebook.accountkit.ui.AccountKitConfiguration
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.carwashing.R
import com.example.carwashing.ui.MapsActivity
import com.facebook.accountkit.AccountKitLoginResult
import org.koin.androidx.scope.ext.android.bindScope
import org.koin.androidx.scope.ext.android.getOrCreateScope


class LoginActivity: AppCompatActivity() {

    val APP_REQUEST_CODE = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var accessToken: AccessToken? = AccountKit.getCurrentAccessToken()
        Log.v("LOGLOG", "fsdf")
        bindScope(getOrCreateScope("login"))
        if (accessToken != null) {
            MapsActivity.open( this)
        }
    }

    fun phoneLogin(view: View) {
        val intent = Intent(this, AccountKitActivity::class.java)
        val configurationBuilder = AccountKitConfiguration.AccountKitConfigurationBuilder(
            LoginType.PHONE,
            AccountKitActivity.ResponseType.CODE
        ) // or .ResponseType.TOKEN
        // ... perform additional configuration ...
        intent.putExtra(
            AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
            configurationBuilder.build()
        )
        startActivityForResult(intent, APP_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == APP_REQUEST_CODE) { // confirm that this response matches your request
            var loginResult: AccountKitLoginResult = data!!.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
            var toastMessage: String
            if (loginResult.error != null) {
                toastMessage = loginResult.error!!.errorType.message
                //showErrorActivity(loginResult.getError())
            } else if (loginResult.wasCancelled()) {
                toastMessage = "Login Cancelled"
            } else {
                if (loginResult.getAccessToken() != null) {
                    toastMessage = "Success:" + loginResult.getAccessToken()!!.getAccountId()
                } else {
                    toastMessage = String.format(
                        "Success:%s...",
                        loginResult.authorizationCode!!.substring(0, 10)
                    )
                }
                MapsActivity.open( this)
            }

            // Surface the result to your user in an appropriate way.
            Toast.makeText(
                this,
                toastMessage,
                Toast.LENGTH_LONG
            )
                .show()
        }
    }
}


//AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
//    @Override
//    public void onSuccess(final Account account) {
//        // Get Account Kit ID
//        String accountKitId = account.getId();
//
//        // Get phone number
//        PhoneNumber phoneNumber = account.getPhoneNumber();
//        if (phoneNumber != null) {
//            String phoneNumberString = phoneNumber.toString();
//        }
//
//        // Get email
//        String email = account.getEmail();
//    }
//
//    @Override
//    public void onError(final AccountKitError error) {
//        // Handle Error
//    }
//});



