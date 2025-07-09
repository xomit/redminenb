package com.kenai.redminenb.util;

import org.openide.DialogDescriptor;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;

/**
 *
 * @author Mykolas
 */
public abstract class ActionListenerPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
    protected JButton okButton;
    protected JButton cancelButton;
    protected DialogDescriptor dialogDescribtor;

    public void setOkButton(JButton okButton) {
        this.okButton = okButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public void setDialogDescribtor(DialogDescriptor dialogDescribtor) {
        this.dialogDescribtor = dialogDescribtor;
    }
}
