/*
 * (C) Copyright 2011 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Contributors:
 * Nuxeo - initial API and implementation
 */

package org.nuxeo.theme.localconfiguration;

import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentRef;
import org.nuxeo.ecm.core.api.PropertyException;
import org.nuxeo.ecm.core.api.localconfiguration.AbstractLocalConfiguration;

/**
 * Default implementation of {@code LocalThemeConfig}.
 *
 * @author <a href="mailto:qlamerand@nuxeo.com">Quentin Lamerand</a>
 */
public class LocalThemeConfigAdapter extends AbstractLocalConfiguration<LocalThemeConfig> implements LocalThemeConfig {

    protected DocumentRef documentRef;

    protected String theme;

    protected String page;

    protected String perspective;

    protected String engine;

    protected String mode;

    protected String flavor;

    public LocalThemeConfigAdapter(DocumentModel doc) {
        documentRef = doc.getRef();
        try {
            theme = (String) doc.getPropertyValue(LocalThemeConfigConstants.THEME_CONFIGURATION_THEME_PROPERTY);
            page = (String) doc.getPropertyValue(LocalThemeConfigConstants.THEME_CONFIGURATION_PAGE_PROPERTY);
            perspective = (String) doc.getPropertyValue(LocalThemeConfigConstants.THEME_CONFIGURATION_PERSPECTIVE_PROPERTY);
            engine = (String) doc.getPropertyValue(LocalThemeConfigConstants.THEME_CONFIGURATION_ENGINE_PROPERTY);
            mode = (String) doc.getPropertyValue(LocalThemeConfigConstants.THEME_CONFIGURATION_MODE_PROPERTY);
            flavor = (String) doc.getPropertyValue(LocalThemeConfigConstants.THEME_CONFIGURATION_FLAVOR_PROPERTY);
        } catch (PropertyException e) {
        }
    }

    @Override
    public DocumentRef getDocumentRef() {
        return documentRef;
    }

    @Override
    public boolean canMerge() {
        return false;
    }

    @Override
    public LocalThemeConfig merge(LocalThemeConfig other) {
        return this;
    }

    @Override
    public String getTheme() {
        return theme;
    }

    @Override
    public String getPage() {
        return page;
    }

    @Override
    public String getPerspective() {
        return perspective;
    }

    @Override
    public String getEngine() {
        return engine;
    }

    @Override
    public String getMode() {
        return mode;
    }

    /**
     * @since 5.5
     */
    @Override
    public String getFlavor() {
        return flavor;
    }

    @Override
    public String computePagePath() {
        if (theme == null || page == null) {
            return null;
        }
        return theme + "/" + page;
    }

}