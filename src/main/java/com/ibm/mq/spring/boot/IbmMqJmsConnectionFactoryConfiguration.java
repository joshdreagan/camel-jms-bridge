/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.mq.spring.boot;

import com.ibm.mq.jms.MQConnectionFactory;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties({ MQConfigurationProperties.class })
public class IbmMqJmsConnectionFactoryConfiguration {

  private static final Logger log = LoggerFactory.getLogger(IbmMqJmsConnectionFactoryConfiguration.class);

  @Bean
  @Autowired
  public MQConnectionFactory ibmmqJmsConnectionFactory(MQConfigurationProperties properties, ObjectProvider<List<MQConnectionFactoryCustomizer>> factoryCustomizers) {
    return new MQConnectionFactoryFactory(properties, factoryCustomizers.getIfAvailable()).createConnectionFactory(MQConnectionFactory.class);
  }
}
