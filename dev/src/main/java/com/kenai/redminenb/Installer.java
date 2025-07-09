package com.kenai.redminenb;

import org.openide.modules.ModuleInstall;

import javax.swing.UIManager;

/**
 * Module installer.
 */
public class Installer extends ModuleInstall {

	private static final long serialVersionUID = 1L;

    @Override
    public void restored() {
        // Support for dark LAFs (derive JXMonthView colors from "default" swing
        // colors
        Boolean dark = (Boolean) UIManager.get("nb.dark.theme");
        if (dark != null && dark) {
            UIManager.put("JXMonthView.background", UIManager.getColor("Table.background"));
            UIManager.put("JXMonthView.foreground", UIManager.getColor("Table.foreground"));
            UIManager.put("JXMonthView.selectedBackground", UIManager.getColor("Table.selectionBackground"));
            UIManager.put("Hyperlink.linkColor", UIManager.getColor("nb.html.link.foreground"));
            UIManager.put("Hyperlink.visitedColor", UIManager.getColor("nb.html.link.foreground.visited"));
            UIManager.put("Hyperlink.hoverColor", UIManager.getColor("nb.html.link.foreground.hover"));
            UIManager.put("Hyperlink.activeColor", UIManager.getColor("nb.html.link.foreground.focus"));
        }
    }
}
