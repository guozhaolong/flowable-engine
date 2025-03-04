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
package org.flowable.bpmn.converter;

import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamWriter;

import org.flowable.bpmn.converter.child.BaseChildElementParser;
import org.flowable.bpmn.converter.child.EventInParameterParser;
import org.flowable.bpmn.converter.child.EventOutParameterParser;
import org.flowable.bpmn.model.BaseElement;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.SendEventServiceTask;

/**
 * @author Tijs Rademakers
 */
public class SendEventServiceTaskXMLConverter extends ServiceTaskXMLConverter {
    
    @Override
    public Class<? extends BaseElement> getBpmnElementType() {
        return SendEventServiceTask.class;
    }

}
