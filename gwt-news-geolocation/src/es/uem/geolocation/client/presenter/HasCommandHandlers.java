package es.uem.geolocation.client.presenter;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasCommandHandlers extends HasHandlers {
	public HandlerRegistration addCommandHandler(CommandHandler handler); 
}
