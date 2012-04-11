package org.jboss.essc.web.pages;

import javax.inject.Inject;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.resource.CssResourceReference;
import org.jboss.essc.web.dao.ContactDao;


/**
 * Dynamic behavior for the ListContact page
 * 
 * @author Ondrej Zizka
 */
@SuppressWarnings("serial")
public class HomePage extends BaseLayoutPage {

    // Inject the ContactDao using @Inject
    @Inject
    private ContactDao contactDao;

    
    public HomePage() {
        
        /*
        // Add the dynamic welcome message, specified in web.xml
        add(new ListView<Contact>("contacts", contactDao.getContacts()) {

            // Populate the table of contacts
            @Override
            protected void populateItem(final ListItem<Contact> item) {
                Contact contact = item.getModelObject();
                item.add(new Label("name", contact.getName()));
                item.add(new Label("email", contact.getEmail()));
                item.add(new Link<Contact>("delete", item.getModel()) {

                    @Override
                    public void onClick() {
                        contactDao.remove(item.getModelObject());
                        setResponsePage(HomePage.class);
                    }
                });
            }
        });
        */
    }
    
    
    /** Adds CSS reference. */
    public void renderHead(IHeaderResponse response) {
        //response.renderCSSReference(new PackageResourceReference(HomePage.class, "default/calendar.css"));
        response.renderCSSReference(new CssResourceReference( HomePage.class, "default.css" ));
    }

}
