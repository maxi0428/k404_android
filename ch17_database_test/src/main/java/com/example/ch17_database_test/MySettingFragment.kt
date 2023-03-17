package com.example.ch17_database_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.EditTextPreference
import android.preference.ListPreference
import android.preference.Preference
import android.text.TextUtils
import androidx.preference.PreferenceFragmentCompat

class MySettingFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        val idPreference: androidx.preference.EditTextPreference? = findPreference("id")
        val colorPreference: androidx.preference.ListPreference? = findPreference("color")

        colorPreference?.summaryProvider = androidx.preference.ListPreference.SimpleSummaryProvider.getInstance()
        idPreference?.summaryProvider =
            androidx.preference.Preference.SummaryProvider<androidx.preference.EditTextPreference>{ preference ->
                val text = preference.text
                if(TextUtils.isEmpty(text)){
                    "설정이 되지 않았습니다."
                }else {
                    "설정된 id 값은 $text 입니다. "
                }
            }
    }
}