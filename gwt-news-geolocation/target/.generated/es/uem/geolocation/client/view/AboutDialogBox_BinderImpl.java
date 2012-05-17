package es.uem.geolocation.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AboutDialogBox_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, es.uem.geolocation.client.view.AboutDialogBox>, es.uem.geolocation.client.view.AboutDialogBox.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<b>Producto:</b>")
    SafeHtml html1();
     
    @Template("<b>Version:</b>")
    SafeHtml html2();
     
    @Template("<b>Autor:</b>")
    SafeHtml html3();
     
    @Template("<b>Detalle:</b>")
    SafeHtml html4();
     
    @Template("<br> <br>")
    SafeHtml html5();
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final es.uem.geolocation.client.view.AboutDialogBox owner) {

    es.uem.geolocation.client.view.AboutDialogBox_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (es.uem.geolocation.client.view.AboutDialogBox_BinderImpl_GenBundle) GWT.create(es.uem.geolocation.client.view.AboutDialogBox_BinderImpl_GenBundle.class);
    com.google.gwt.resources.client.ImageResource image = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.image();
    es.uem.geolocation.client.view.AboutDialogBox_BinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    com.google.gwt.user.client.ui.Image headerImage = new com.google.gwt.user.client.ui.Image(image);
    com.google.gwt.user.client.ui.HTML f_HTML2 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label labelProduct = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HTML f_HTML3 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label labelVersion = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HTML f_HTML4 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label labelAutor = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HTML f_HTML5 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Label labelDesc = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    com.google.gwt.user.client.ui.HTML f_HTML6 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
    com.google.gwt.user.client.ui.Button buttonClose = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
    com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel7 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
    com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel1 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);

    headerImage.setAltText("");
    f_VerticalPanel1.add(headerImage);
    f_HTML2.setHTML(template.html1().asString());
    f_VerticalPanel1.add(f_HTML2);
    labelProduct.setText("Geolocalización de Noticias");
    f_VerticalPanel1.add(labelProduct);
    f_HTML3.setHTML(template.html2().asString());
    f_VerticalPanel1.add(f_HTML3);
    labelVersion.setText("1.0");
    f_VerticalPanel1.add(labelVersion);
    f_HTML4.setHTML(template.html3().asString());
    f_VerticalPanel1.add(f_HTML4);
    labelAutor.setText("Guillermo Santos García");
    f_VerticalPanel1.add(labelAutor);
    f_HTML5.setHTML(template.html4().asString());
    f_VerticalPanel1.add(f_HTML5);
    labelDesc.setText("Junio 2012 - Proyecto Fin de Grado - Ingenieria de Informática");
    f_VerticalPanel1.add(labelDesc);
    f_HTML6.setHTML(template.html5().asString());
    f_VerticalPanel1.add(f_HTML6);
    f_HorizontalPanel7.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
    buttonClose.setText("Close");
    f_HorizontalPanel7.add(buttonClose);
    f_VerticalPanel1.add(f_HorizontalPanel7);
    f_VerticalPanel1.setStyleName("style.panel");



    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.doClose(event);
      }
    };
    buttonClose.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

    owner.buttonClose = buttonClose;
    owner.labelVersion = labelVersion;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_VerticalPanel1;
  }
}
