package es.uem.geolocation.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class HelpDialogBox_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, es.uem.geolocation.client.view.HelpDialogBox>, es.uem.geolocation.client.view.HelpDialogBox.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<b>Geolocalización de Noticias</b> <br> <br> <span>Aplicación que usa fuentes de información en formato RSS (formato XML) y en español,</span> <br> <span>de distintos periodicos, agencias de noticias, organismos públicos,.. </span> <br> <span>para detectar posibles nombres de lugares (topónimos) dentro de cada noticia,</span> <br> <span>para despues utilizar la cartografía de Google Maps</span> <br> <span>para posicionar geográficamente las noticias.</span> <br>  <br> <br>")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final es.uem.geolocation.client.view.HelpDialogBox owner) {

    es.uem.geolocation.client.view.HelpDialogBox_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (es.uem.geolocation.client.view.HelpDialogBox_BinderImpl_GenBundle) GWT.create(es.uem.geolocation.client.view.HelpDialogBox_BinderImpl_GenBundle.class);
    es.uem.geolocation.client.view.HelpDialogBox_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.HTML f_HTML2 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Button buttonClose = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    f_HTML2.setHTML(template.html1().asString());
    f_VerticalPanel1.add(f_HTML2);
    f_HorizontalPanel3.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    buttonClose.setText("Close");
    f_HorizontalPanel3.add(buttonClose);
    f_VerticalPanel1.add(f_HorizontalPanel3);
    f_VerticalPanel1.setStyleName("style.panel");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.doClose(event);
      }
    };
    buttonClose.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.buttonClose = buttonClose;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
