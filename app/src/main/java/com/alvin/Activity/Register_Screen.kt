package com.alvin.Activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.alvin.Api.ApiClient
import com.alvin.Api.Common
import com.alvin.ModelClasses.RegisterModel
import com.alvin.R
import com.alvin.databinding.ActivityRegisterScreenBinding
import com.google.android.material.snackbar.Snackbar
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register_Screen : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterScreenBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       /* if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.white)
        }

       */ binding = ActivityRegisterScreenBinding.inflate(layoutInflater)

        clickevents()

        setContentView(binding.root)

    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun clickevents() {
        binding.loginBtn.setOnClickListener {
            val intent = Intent(this, Login_Screen::class.java)
            startActivity(intent)
            finish()

        }
        binding.registerbtn.setOnClickListener {
            if (Isvalidation()) {

                callApiRegister()

            }
        }


    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun Isvalidation(): Boolean {
        if (binding.username.text.toString().trim().isEmpty()) {
            Snackbar.make(binding.root, getString(R.string.invalid_username), Snackbar.LENGTH_LONG)
                .setBackgroundTint(getColor(R.color.red)).setTextColor(getColor(R.color.white))
                .setAction("Action", null).show()
            return false
        } else {

            if (binding.email.text.toString().trim().isEmpty()) {
                Snackbar.make(
                    binding.root,
                    getString(R.string.invalid_email),
                    Snackbar.LENGTH_LONG
                ).setBackgroundTint(getColor(R.color.red)).setTextColor(getColor(R.color.white))
                    .setAction("Action", null).show()
                return false
            } else {

                if (binding.phonenumber.text.toString().trim().isEmpty()) {
                    Snackbar.make(
                        binding.root,
                        getString(R.string.mobilenumbererror),
                        Snackbar.LENGTH_LONG
                    ).setBackgroundTint(getColor(R.color.red)).setTextColor(getColor(R.color.white))
                        .setAction("Action", null).show()
                    return false
                } else {

                    if (binding.password.text.toString().trim()
                            .isEmpty() && binding.confirmpassword.text.toString().trim().isEmpty()
                    ) {
                        Snackbar.make(
                            binding.root,
                            getString(R.string.passworderror),
                            Snackbar.LENGTH_LONG
                        ).setBackgroundTint(getColor(R.color.red))
                            .setTextColor(getColor(R.color.white))
                            .setAction("Action", null).show()
                        return false
                    } else {
                        if (binding.confirmpassword.text.toString()
                                .trim() != binding.password.text.toString()
                        ) {
                            Snackbar.make(
                                binding.root,
                                getString(R.string.passwordnotmatch),
                                Snackbar.LENGTH_LONG
                            ).setBackgroundTint(getColor(R.color.red))
                                .setTextColor(getColor(R.color.white))
                                .setAction("Action", null).show()
                            return false
                        } else {
                            return true
                        }

                    }
                }
            }
        }


    }

    private fun callApiRegister() {
        Common.showLoadingProgress(this)
        val call = ApiClient.getClient.getRegister(
            binding.username.text.toString(),
            binding.phonenumber.text.toString(),
            binding.email.text.toString(),
            binding.password.text.toString()
        )
        call.enqueue(object : Callback<RegisterModel> {

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onResponse(call: Call<RegisterModel>, response: Response<RegisterModel>) {

                println("==============" + response.code())

                if (response.code() == 200) {
                    val registerModel: RegisterModel = response.body()!!
                    Common.dismissLoadingProgress()
                    Log.i("TAG", "=======message=======" + response.body())

                    if (registerModel.code.equals("200")) {
                        showmessage(registerModel.message.toString())
                        val intent = Intent(applicationContext, Login_Screen::class.java)
                        startActivity(intent)
                        finish()

                    }

                } else {

                    Common.dismissLoadingProgress()
                    val error = JSONObject(response.errorBody()!!.string())
                    showmessage(error.toString())

                }
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
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