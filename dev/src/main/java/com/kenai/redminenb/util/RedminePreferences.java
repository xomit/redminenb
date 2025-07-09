package com.kenai.redminenb.util;

import com.kenai.redminenb.RedmineConfig;

import org.openide.util.NbPreferences;

import java.util.prefs.Preferences;

/**
 *
 * @author Mykolas
 */
public class RedminePreferences {

    public static Preferences getPreferences() {
        return NbPreferences.forModule(RedmineConfig.class);
    }

	private RedminePreferences() {
	}
}
