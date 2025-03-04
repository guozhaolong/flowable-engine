/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.eventregistry.impl.deployer;

import org.flowable.common.engine.impl.persistence.deploy.DeploymentCache;
import org.flowable.eventregistry.impl.EventRegistryEngineConfiguration;
import org.flowable.eventregistry.impl.persistence.deploy.EventDefinitionCacheEntry;
import org.flowable.eventregistry.impl.persistence.entity.EventDefinitionEntity;
import org.flowable.eventregistry.impl.persistence.entity.EventDeploymentEntity;
import org.flowable.eventregistry.impl.util.CommandContextUtil;
import org.flowable.eventregistry.json.converter.EventJsonConverter;
import org.flowable.eventregistry.model.EventModel;

/**
 * Updates caches and artifacts for a deployment and its forms
 */
public class CachingAndArtifactsManager {

    protected EventJsonConverter eventJsonConverter = new EventJsonConverter();

    /**
     * Ensures that the decision table is cached in the appropriate places, including the deployment's collection of deployed artifacts and the deployment manager's cache.
     */
    public void updateCachingAndArtifacts(ParsedDeployment parsedDeployment) {
        final EventRegistryEngineConfiguration eventRegistryEngineConfiguration = CommandContextUtil.getEventRegistryConfiguration();
        DeploymentCache<EventDefinitionCacheEntry> eventDefinitionCache = eventRegistryEngineConfiguration.getDeploymentManager().getEventDefinitionCache();
        EventDeploymentEntity deployment = parsedDeployment.getDeployment();

        for (EventDefinitionEntity eventDefinition : parsedDeployment.getAllEventDefinitions()) {
            EventModel eventModel = parsedDeployment.getEventModelForEventDefinition(eventDefinition);
            EventDefinitionCacheEntry cacheEntry = new EventDefinitionCacheEntry(eventDefinition, eventJsonConverter.convertToJson(eventModel));
            eventDefinitionCache.add(eventDefinition.getId(), cacheEntry);

            // Add to deployment for further usage
            deployment.addDeployedArtifact(eventDefinition);
        }
    }
}
