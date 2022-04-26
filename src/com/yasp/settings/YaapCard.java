package com.yasp.settings;

import androidx.appcompat.app.AppCompatActivity;

import com.android.internal.logging.nano.MetricsProto;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Surface;
import android.preference.Preference;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;
import android.view.View;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.ComponentName;
import androidx.cardview.widget.CardView;

import com.android.settings.R;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.content.res.Resources;
import android.view.Window;

import com.yasp.settings.fragments.Customisation;
import com.yasp.settings.fragments.StatusBarSettings;
import com.yasp.settings.fragments.QuickSettings;

import com.android.settings.SettingsPreferenceFragment;

public class BlazeCard extends SettingsPreferenceFragment implements View.OnClickListener {

    CardView mStatusbarSettingsCard;
    CardView mThemeSettingsCard;
    CardView mQuickSettingsCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.yaap_card, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Resources res = getResources();
        Window win = getActivity().getWindow();
        getActivity().setTitle(getResources().getString(R.string.app_name));

        mStatusbarSettingsCard = (CardView) view.findViewById(R.id.statusbarsettings_card);
        mStatusbarSettingsCard.setOnClickListener(this);

        mQuickSettingsCard = (CardView) view.findViewById(R.id.quicksettings_card);
        mQuickSettingsCard.setOnClickListener(this);

        mThemeSettingsCard = (CardView) view.findViewById(R.id.themesettings_card);
        mThemeSettingsCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.statusbarsettings_card)
        {
            StatusBarSettings statusbarsettingsfragment = new StatusBarSettings();
            FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
            transaction1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction1.replace(this.getId(), statusbarsettingsfragment);
            transaction1.addToBackStack(null);
            transaction1.commit();
        }
        if (id == R.id.powersettings_card)
        {
            QuickSettings quicksettingsfragment = new QuickSettings();
            FragmentTransaction transaction3 = getFragmentManager().beginTransaction();
            transaction3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction3.replace(this.getId(), quicksettingsfragment);
            transaction3.addToBackStack(null);
            transaction3.commit();
        }
        if (id == R.id.themesettings_card)
        {
            Customisation customisationfragment = new Customisation();
            FragmentTransaction transaction5 = getFragmentManager().beginTransaction();
            transaction5.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction5.replace(this.getId(), customisationfragment);
            transaction5.addToBackStack(null);
            transaction5.commit();
        }
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.YASP;
    }

}