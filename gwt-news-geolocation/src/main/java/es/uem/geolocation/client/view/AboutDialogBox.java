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

public class AboutDialogBox extends DialogBox {	
	//private static final AppConstants appConstants = GWT.create(AppConstants.class); 
    private static final Binder binder = GWT.create(Binder.class);
    private final AppConstants constants =  GWT.create(AppConstants.class);
    interface Binder extends UiBinder<Widget, AboutDialogBox> {
    }
    
    @UiField
    Label labelProduct;
    
    @UiField 
    Label labelVersion; 
    
    @UiField
    Label labelAuthor;

    @UiField
    Label labelDetail;

    @UiField
    Button buttonClose; 
    
    /** 
     * Constructor 
     */
    public AboutDialogBox() {
        setWidget(binder.createAndBindUi(this));
        buttonClose.setFocus(true);        
        labelProduct.setText(constants.applicationName()); 
        labelVersion.setText(constants.version());
        labelAuthor.setText(constants.author());
        labelDetail.setText(constants.detail());
    }
    
    @UiHandler("buttonClose")
    protected void doClose(ClickEvent event) {
        this.hide();
    }
}    
