package es.uem.geolocation.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MapView_MapViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, es.uem.geolocation.client.view.MapView>, es.uem.geolocation.client.view.MapView.MapViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("   <span id='{0}'></span> <span>Geolocalización de Noticias</span>")
    SafeHtml html1(String arg0);
     
    @Template("Ayuda")
    SafeHtml html2();
     
    @Template("Acerca de")
    SafeHtml html3();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html4(String arg0);
     
    @Template("<span id='{0}'></span>  <div class='{1}'> <span class='{2}'>Fuente RSS:  </span> <span id='{3}'></span> <span class='{4}'>Enlace RSS:  </span> <span id='{5}'></span><br>  <span class='{6}'>Copyright:  </span> <span id='{7}'></span><br> </div>  <span id='{8}'></span>")
    SafeHtml html5(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
  }

  Template template = GWT.create(Template.class);

  public com.google.gwt.user.client.ui.Widget createAndBindUi(final es.uem.geolocation.client.view.MapView owner) {

    es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenBundle) GWT.create(es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenBundle.class);
    com.google.gwt.resources.client.ImageResource image = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.image();
    es.uem.geolocation.client.view.MapView_MapViewUiBinderImpl_GenCss_style style = clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style();
    java.lang.String domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
    java.lang.String domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Image headerImage = new com.google.gwt.user.client.ui.Image(image);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template.html1(domId1).asString());
    java.lang.String domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.MenuItem abcPortadaMenuItem = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem abcUltimaHoraMenuItem = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar f_MenuBar6 = new com.google.gwt.user.client.ui.MenuBar(true);
    com.google.gwt.user.client.ui.MenuItem f_MenuItem5 = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem elmundoPortadaMenuItem = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem elmundoEspanaMenuItem = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem elmundoInternacionalMenuItem = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar f_MenuBar8 = new com.google.gwt.user.client.ui.MenuBar(true);
    com.google.gwt.user.client.ui.MenuItem f_MenuItem7 = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem elpaisPortadaMenuItem = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem elpaisUltimaNoticiasMenuItem = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem elpaisInternacionalMenuItem = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar f_MenuBar10 = new com.google.gwt.user.client.ui.MenuBar(true);
    com.google.gwt.user.client.ui.MenuItem f_MenuItem9 = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem rssMenuItem = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem helpMenuItem = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuItem aboutMenuItem = new com.google.gwt.user.client.ui.MenuItem("", (com.google.gwt.user.client.Command) null);
    com.google.gwt.user.client.ui.MenuBar menuBar = (com.google.gwt.user.client.ui.MenuBar) GWT.create(com.google.gwt.user.client.ui.MenuBar.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template.html4(domId2).asString());
    java.lang.String domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label state = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label sourceRSSTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Anchor sourceRSSLink = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
    java.lang.String domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.Label sourceRSSCopyright = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
    java.lang.String domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
    com.google.gwt.user.client.ui.SimplePanel mapWrapper = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template.html5(domId3, "" + style.sourceblock() + "", "" + style.label() + "", domId4, "" + style.label() + "", domId5, "" + style.label() + "", domId6, domId7).asString());
    com.google.gwt.user.client.ui.VerticalPanel newsList = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
    com.google.gwt.user.client.ui.ScrollPanel contentNews = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
    com.google.gwt.user.client.ui.DockLayoutPanel f_DockLayoutPanel2 = new com.google.gwt.user.client.ui.DockLayoutPanel(com.google.gwt.dom.client.Style.Unit.EM);
    com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template.html6(domId0).asString());

    headerImage.addStyleName("" + style.headerimage() + "");
    headerImage.setAltText("Geolocalización de Noticias");
    f_HTMLPanel3.setStyleName("" + style.header() + "");
    f_DockLayoutPanel2.addNorth(f_HTMLPanel3, 5);
    abcPortadaMenuItem.setText("Portada");
    abcPortadaMenuItem.setTitle("ABC.es.- Portada");
    f_MenuBar6.addItem(abcPortadaMenuItem);
    abcUltimaHoraMenuItem.setText("Última Hora");
    abcUltimaHoraMenuItem.setTitle("ABC.es - Última hora");
    f_MenuBar6.addItem(abcUltimaHoraMenuItem);
    f_MenuItem5.setSubMenu(f_MenuBar6);
    f_MenuItem5.setText("ABC.es");
    menuBar.addItem(f_MenuItem5);
    elmundoPortadaMenuItem.setText("Portada");
    elmundoPortadaMenuItem.setTitle("ElMundo.es - Portada");
    f_MenuBar8.addItem(elmundoPortadaMenuItem);
    elmundoEspanaMenuItem.setText("España");
    elmundoEspanaMenuItem.setTitle("ElMundo.es - España");
    f_MenuBar8.addItem(elmundoEspanaMenuItem);
    elmundoInternacionalMenuItem.setText("Internacional");
    elmundoInternacionalMenuItem.setTitle("ElMundo.es - Internacional");
    f_MenuBar8.addItem(elmundoInternacionalMenuItem);
    f_MenuItem7.setSubMenu(f_MenuBar8);
    f_MenuItem7.setText("ElMundo.es");
    menuBar.addItem(f_MenuItem7);
    elpaisPortadaMenuItem.setText("Portada");
    elpaisPortadaMenuItem.setTitle("ELPAIS.com - Portada");
    f_MenuBar10.addItem(elpaisPortadaMenuItem);
    elpaisUltimaNoticiasMenuItem.setText("Últimas Noticias");
    elpaisUltimaNoticiasMenuItem.setTitle("ELPAIS.com - Últimas Noticias");
    f_MenuBar10.addItem(elpaisUltimaNoticiasMenuItem);
    elpaisInternacionalMenuItem.setText("Internacional");
    elpaisInternacionalMenuItem.setTitle("ELPAIS.com - Internacional");
    f_MenuBar10.addItem(elpaisInternacionalMenuItem);
    f_MenuItem9.setSubMenu(f_MenuBar10);
    f_MenuItem9.setText("EL PAIS.com");
    menuBar.addItem(f_MenuItem9);
    rssMenuItem.setText("RSS");
    rssMenuItem.setTitle("Introduzca Fuente RSS");
    menuBar.addItem(rssMenuItem);
    helpMenuItem.setHTML(template.html2().asString());
    helpMenuItem.setTitle("Ayuda");
    menuBar.addItem(helpMenuItem);
    aboutMenuItem.setHTML(template.html3().asString());
    aboutMenuItem.setTitle("Acerca de");
    menuBar.addItem(aboutMenuItem);
    f_DockLayoutPanel2.addNorth(f_HTMLPanel4, 1.7);
    sourceRSSTitle.addStyleName("" + style.label() + "");
    sourceRSSLink.addStyleName("" + style.sourcelink() + "");
    sourceRSSCopyright.addStyleName("" + style.label() + "");
    contentNews.add(newsList);
    contentNews.addStyleName("" + style.contentNews() + "");
    f_DockLayoutPanel2.addEast(contentNews, 20);
    f_DockLayoutPanel2.add(f_HTMLPanel11);
    f_DockLayoutPanel2.addStyleName("" + style.fullscreen() + "");
    f_HTMLPanel1.addStyleName("" + style.fullscreen() + "");

    UiBinderUtil.TempAttachment attachRecord0 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
    UiBinderUtil.TempAttachment attachRecord1 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
    com.google.gwt.user.client.Element domId1Element = com.google.gwt.dom.client.Document.get().getElementById(domId1).cast();
    attachRecord1.detach();
    f_HTMLPanel3.addAndReplaceElement(headerImage, domId1Element);
    UiBinderUtil.TempAttachment attachRecord2 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
    com.google.gwt.user.client.Element domId2Element = com.google.gwt.dom.client.Document.get().getElementById(domId2).cast();
    attachRecord2.detach();
    f_HTMLPanel4.addAndReplaceElement(menuBar, domId2Element);
    UiBinderUtil.TempAttachment attachRecord3 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
    com.google.gwt.user.client.Element domId3Element = com.google.gwt.dom.client.Document.get().getElementById(domId3).cast();
    com.google.gwt.user.client.Element domId4Element = com.google.gwt.dom.client.Document.get().getElementById(domId4).cast();
    com.google.gwt.user.client.Element domId5Element = com.google.gwt.dom.client.Document.get().getElementById(domId5).cast();
    com.google.gwt.user.client.Element domId6Element = com.google.gwt.dom.client.Document.get().getElementById(domId6).cast();
    com.google.gwt.user.client.Element domId7Element = com.google.gwt.dom.client.Document.get().getElementById(domId7).cast();
    attachRecord3.detach();
    f_HTMLPanel11.addAndReplaceElement(state, domId3Element);
    f_HTMLPanel11.addAndReplaceElement(sourceRSSTitle, domId4Element);
    f_HTMLPanel11.addAndReplaceElement(sourceRSSLink, domId5Element);
    f_HTMLPanel11.addAndReplaceElement(sourceRSSCopyright, domId6Element);
    f_HTMLPanel11.addAndReplaceElement(mapWrapper, domId7Element);
    com.google.gwt.user.client.Element domId0Element = com.google.gwt.dom.client.Document.get().getElementById(domId0).cast();
    attachRecord0.detach();
    f_HTMLPanel1.addAndReplaceElement(f_DockLayoutPanel2, domId0Element);


    owner.abcPortadaMenuItem = abcPortadaMenuItem;
    owner.abcUltimaHoraMenuItem = abcUltimaHoraMenuItem;
    owner.aboutMenuItem = aboutMenuItem;
    owner.contentNews = contentNews;
    owner.elmundoEspanaMenuItem = elmundoEspanaMenuItem;
    owner.elmundoInternacionalMenuItem = elmundoInternacionalMenuItem;
    owner.elmundoPortadaMenuItem = elmundoPortadaMenuItem;
    owner.elpaisInternacionalMenuItem = elpaisInternacionalMenuItem;
    owner.elpaisPortadaMenuItem = elpaisPortadaMenuItem;
    owner.elpaisUltimaNoticiasMenuItem = elpaisUltimaNoticiasMenuItem;
    owner.helpMenuItem = helpMenuItem;
    owner.mapWrapper = mapWrapper;
    owner.menuBar = menuBar;
    owner.newsList = newsList;
    owner.rssMenuItem = rssMenuItem;
    owner.sourceRSSCopyright = sourceRSSCopyright;
    owner.sourceRSSLink = sourceRSSLink;
    owner.sourceRSSTitle = sourceRSSTitle;
    owner.state = state;
    clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay.style().ensureInjected();

    return f_HTMLPanel1;
  }
}
