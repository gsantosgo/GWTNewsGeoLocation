package es.uem.geolocation.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import es.uem.geolocation.client.AppConstants;

public class HelpDialogBox extends DialogBox {	
    private static final Binder binder = GWT.create(Binder.class);
    private final AppConstants constants =  GWT.create(AppConstants.class);    
    interface Binder extends UiBinder<Widget, HelpDialogBox> {
    }
        
    @UiField
    Label labelProduct;
    
    @UiField
    Button buttonClose; 
    
    /** 
     * Constructor 
     */
    public HelpDialogBox() {
        setWidget(binder.createAndBindUi(this));
        labelProduct.setText(constants.applicationName());        
        buttonClose.setFocus(true);
    }

    
    @UiHandler("buttonClose")
    protected void doClose(ClickEvent event) {
        this.hide();
    }
}    
