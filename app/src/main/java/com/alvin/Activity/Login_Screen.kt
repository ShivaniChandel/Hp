package com.alvin.Activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.alvin.Api.ApiClient
import com.alvin.Api.Common
import com.alvin.Api.SharePreference
import com.alvin.ModelClasses.LoginModel
import com.alvin.R
import com.alvin.databinding.ActivityLoginScreenBinding
import com.google.android.material.snackbar.Snackbar
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Login_Screen : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginScreenBinding.inflate(layoutInflater)

        clickevents()

        setContentView(binding.root)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun clickevents() {
        binding.clickHere.setOnClickListener {
            val intent = Intent(this, Register_Screen::class.java)
            startActivity(intent)

        }
        binding.loginBtn.setOnClickListener {
            if (Isvalidation()) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        }


    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun Isvalidation(): Boolean {
        if (binding.mobileNumber.text.toString().trim().isEmpty()) {
            Snackbar.make(binding.root, getString(R.string.mobilenumbererror), Snackbar.LENGTH_LONG)
                .setBackgroundTint(getColor(R.color.red)).setTextColor(getColor(R.color.white))
                .setAction("Action", null).show()
            return false
        } else {

            if (binding.password.text.toString().trim().isEmpty()) {
                Snackbar.make(
                    binding.root,
                    getString(R.string.passworderror),
                    Snackbar.LENGTH_LONG
                ).setBackgroundTint(getColor(R.color.red)).setTextColor(getColor(R.color.white))
                    .setAction("Action", null).show()
                return false
            } else {
                return true
            }
        }


    }

    private fun callApiLogin() {
        Common.showLoadingProgress(this)
        val call = ApiClient.getClient.getLogin(
            binding.mobileNumber.text.toString(),
            binding.password.text.toString()
        )
        call.enqueue(object : Callback<LoginModel> {

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {

                println("==============" + response.code())

                if (response.code() == 200) {
                    val loginModel: LoginModel = response.body()!!
                    Common.dismissLoadingProgress()
                    Log.i("TAG", "=======message=======" + response.body())
                  /*  if (loginModel.statusCode == 200) {
                        SharePreference.setStringPref(
                            activity!!,
                            SharePreference.username,
                            loginModel.username!!
                        )

                    } else {
                        showmessage("SSSSSSSSS")                    }*/

                } else {

                    Common.dismissLoadingProgress()
                    val error = JSONObject(response.errorBody()!!.string())
                    showmessage(error.toString())

                }
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                Common.dismissLoadingProgress()
                showmessage(t.message.toString())
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun showmessage(msg: String) {
        Snackbar.make(
            binding.root,
            msg,
            Snackbar.LENGTH_LONG
        ).setBackgroundTint(getColor(R.color.red)).setTextColor(getColor(R.color.white))
            .setAction("Action", null).show()
    }

}