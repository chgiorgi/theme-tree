package com.cybernostics.themetree.config;

/*
 * #%L
 * spring-thymeleaf-themetree
 * %%
 * Copyright (C) 1992 - 2017 Cybernostics Pty Ltd
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 * #L%
 */
import com.cybernostics.themetree.paths.ThemePathResolver;
import com.cybernostics.themetree.resource.resolvers.ThemeResourceResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 *
 * @author jason
 */
@Configuration
public class ResolverConfiguration
{

    @Autowired
    ThemePathResolver themePathResolver;

    @Bean
    @Order(Integer.MIN_VALUE)
    public ThemeResourceResolver themedResourceResolver()
    {
        return new ThemeResourceResolver(themePathResolver);
    }
}
