/*
 * Copyright (c) 2016 Cybernostics Pty Ltd.
 * All rights reserved.
 */
package au.com.cybernostics.themetree.defaults;

/*
 * #%L
 * theme-tree
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

import au.com.cybernostics.themetree.resource.resolvers.TemplateExistenceChecker;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.ApplicationContext;

/**
 * Default implementation to find Thymeleaf templates based on prefix and suffix
 * properties
 *
 * @author jason
 * @version $Id: $Id
 */
public class DefaultTemplateExistenceChecker implements TemplateExistenceChecker
{

    private ThymeleafProperties thymeleafProperties;
    private ApplicationContext applicationContext;

    /**
     * <p>Constructor for DefaultTemplateExistenceChecker.</p>
     *
     * @param thymeleafProperties a {@link org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties} object.
     * @param applicationContext a {@link org.springframework.context.ApplicationContext} object.
     */
    public DefaultTemplateExistenceChecker(ThymeleafProperties thymeleafProperties, ApplicationContext applicationContext)
    {
        this.thymeleafProperties = thymeleafProperties;
        this.applicationContext = applicationContext;
    }

    /**
     * <p>getThymeleafResourceUrlForName.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public String getThymeleafResourceUrlForName(String name)
    {
        return thymeleafProperties.getPrefix() + name + thymeleafProperties.getSuffix();
    }

    /** {@inheritDoc} */
    public boolean templateExists(String name)
    {
        String resource = getThymeleafResourceUrlForName(name);
        return applicationContext.getResource(resource).exists();
    }
}
