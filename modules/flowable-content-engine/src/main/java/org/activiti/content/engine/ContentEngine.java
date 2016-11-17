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
package org.activiti.content.engine;

import org.activiti.content.api.ContentManagementService;
import org.activiti.content.api.ContentService;

public interface ContentEngine {

    /**
     * the version of the flowable content library
     */
    public static String VERSION = "6.0.0";

    /**
     * The name as specified in 'process-engine-name' in the activiti.cfg.xml configuration file. The default name for a process engine is 'default
     */
    String getName();

    void close();

    ContentManagementService getContentManagementService();
    
    ContentService getContentService();

    ContentEngineConfiguration getContentEngineConfiguration();
}
