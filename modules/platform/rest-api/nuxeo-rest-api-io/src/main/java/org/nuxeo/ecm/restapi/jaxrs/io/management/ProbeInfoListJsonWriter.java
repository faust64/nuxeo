/*
 * (C) Copyright 2019 Nuxeo (http://nuxeo.com/) and others.
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
 *
 * Contributors:
 *     Nour Al Kotob
 */

package org.nuxeo.ecm.restapi.jaxrs.io.management;

import static org.nuxeo.ecm.core.io.registry.reflect.Instantiations.SINGLETON;
import static org.nuxeo.ecm.core.io.registry.reflect.Priorities.REFERENCE;

import org.nuxeo.ecm.core.io.marshallers.json.DefaultListJsonWriter;
import org.nuxeo.ecm.core.io.registry.reflect.Setup;
import org.nuxeo.ecm.core.management.api.ProbeInfo;

/**
 * @since 11.3
 */
@Setup(mode = SINGLETON, priority = REFERENCE)
public class ProbeInfoListJsonWriter extends DefaultListJsonWriter<ProbeInfo> {

    public static final String ENTITY_TYPE = "probes";

    public ProbeInfoListJsonWriter() {
        super(ENTITY_TYPE, ProbeInfo.class);
    }
}
