/*
 * Copyright 2011 JBoss Inc
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.drools.guvnor.client.explorer;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import org.drools.guvnor.client.explorer.IFramePerspectiveView.Presenter;

public class IFramePerspectiveActivity extends AbstractActivity implements Presenter {

    private ClientFactory clientFactory;
    private IFramePerspectivePlace place;

    public IFramePerspectiveActivity(ClientFactory clientFactory, IFramePerspectivePlace place) {
        this.clientFactory = clientFactory;
        this.place = place;
    }

    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        IFramePerspectiveView view = clientFactory.getIFramePerspectiveView();

        view.setName(place.getName());
        view.setUrl(place.getUrl());

        view.setPresenter(this);

        panel.setWidget(view);
    }

    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}
