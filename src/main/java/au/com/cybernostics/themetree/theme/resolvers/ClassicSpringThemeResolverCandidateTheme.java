package au.com.cybernostics.themetree.theme.resolvers;

/*-
 * #%L
 * themetree
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

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ThemeResolver;

/**
 *
 * @author jason wraxall
 */
public class ClassicSpringThemeResolverCandidateTheme implements CandidateTheme
{

    /**
     * The classic theme resolver
     */
    private ThemeResolver resolver;
    private int order;

    public ClassicSpringThemeResolverCandidateTheme(ThemeResolver resolver)
    {
        this.resolver = resolver;
    }

    @Override
    public String getName(HttpServletRequest request)
    {
        return resolver.resolveThemeName(request);
    }

    @Override
    public int getOrder()
    {
        return order;
    }

    @Override
    public boolean isActive(HttpServletRequest request)
    {
        return true;
    }

}