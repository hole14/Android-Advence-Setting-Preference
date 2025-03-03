package com.example.mysettingpreference

import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.CheckBoxPreference
import androidx.preference.EditTextPreference
import androidx.preference.PreferenceFragmentCompat

class MyPreferenceFragment: PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {
    private lateinit var NAME: String
    private lateinit var EMAIL: String
    private lateinit var AGE: String
    private lateinit var PHONE_NUMBER: String
    private lateinit var LOVE: String

    private lateinit var namePreference: EditTextPreference
    private lateinit var emailPreference: EditTextPreference
    private lateinit var agePreference: EditTextPreference
    private lateinit var phonePreference: EditTextPreference
    private lateinit var isLovePreference: CheckBoxPreference

    companion object {
        private const val DEFAULT_VALUE = "Tidak Ada"
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preference)

        init()
        summaries()


    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences?.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences?.unregisterOnSharedPreferenceChangeListener(this)
    }


    private fun summaries() {
        val sh = preferenceManager.sharedPreferences
        namePreference.summary = sh?.getString(NAME, DEFAULT_VALUE)
        emailPreference.summary = sh?.getString(EMAIL, DEFAULT_VALUE)
        agePreference.summary = sh?.getString(AGE, DEFAULT_VALUE)
        phonePreference.summary = sh?.getString(PHONE_NUMBER, DEFAULT_VALUE)
        isLovePreference.isChecked = sh?.getBoolean(LOVE, false) ?: false
    }

    private fun init() {
        NAME = resources.getString(R.string.key_name)
        EMAIL = resources.getString(R.string.key_email)
        AGE = resources.getString(R.string.key_age)
        PHONE_NUMBER = resources.getString(R.string.key_phone)
        LOVE = resources.getString(R.string.key_love)

        namePreference = findPreference<EditTextPreference>(NAME) as EditTextPreference
        emailPreference = findPreference<EditTextPreference>(EMAIL) as EditTextPreference
        agePreference = findPreference<EditTextPreference>(AGE) as EditTextPreference
        phonePreference = findPreference<EditTextPreference>(PHONE_NUMBER) as EditTextPreference
        isLovePreference = findPreference<CheckBoxPreference>(LOVE) as CheckBoxPreference

    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String?) {
        if (key == NAME) {
            namePreference.summary = sharedPreferences.getString(NAME, DEFAULT_VALUE)
        }
        if (key == EMAIL) {
            namePreference.summary = sharedPreferences.getString(EMAIL, DEFAULT_VALUE)
        }
        if (key == AGE) {
            namePreference.summary = sharedPreferences.getString(AGE, DEFAULT_VALUE)
        }
        if (key == PHONE_NUMBER) {
            namePreference.summary = sharedPreferences.getString(PHONE_NUMBER, DEFAULT_VALUE)
        }
        if (key == LOVE) {
            namePreference.summary = sharedPreferences.getBoolean(LOVE, false).toString()
        }

    }
}
