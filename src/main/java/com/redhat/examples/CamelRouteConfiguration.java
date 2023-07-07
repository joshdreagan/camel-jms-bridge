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
package com.redhat.examples;

import com.ibm.mq.spring.boot.MQConfigurationProperties;
import org.apache.camel.ExchangePattern;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties({ ArtemisProperties.class, MQConfigurationProperties.class })
public class CamelRouteConfiguration extends RouteBuilder {

  private static final Logger log = LoggerFactory.getLogger(CamelRouteConfiguration.class);

  @DependsOn({ "artemisJmsConnectionFactory", "ibmmqJmsConnectionFactory" })
  @Override
  public void configure() {

    from("jms:queue://DEV.QUEUE.1?connectionFactory=#ibmmqJmsConnectionFactory")
      .to(ExchangePattern.InOnly, "jms:queue://foo?connectionFactory=#artemisJmsConnectionFactory")
    ;
  }
}
