/**
 * Copyright (C) 2014 Ovea (dev@ovea.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.testatoo.sample.presentation

import org.testatoo.bundle.html5.Img
import org.testatoo.bundle.html5.Paragraph
import org.testatoo.bundle.html5.heading.H2
import org.testatoo.bundle.html5.list.Ul
import org.testatoo.core.component.Heading
import org.testatoo.core.component.Image
import org.testatoo.core.component.ListView
import org.testatoo.sample.presentation.component.Presentation
import org.testatoo.sample.presentation.component.Teaser
import org.testatoo.sample.presentation.component.matcher.AuthorMatcher
import org.testatoo.sample.presentation.component.matcher.CompanyMatcher

import static org.testatoo.core.Testatoo.$

/**
 * @author David Avenante (d.avenante@gmail.com)
 */
class Factory {

    static Presentation presentation = $('[data-role=slides]') as Presentation
    static Image testatoo_logo = $('#logo') as Img

    static AuthorMatcher author(String name) { new AuthorMatcher(name) }

    static CompanyMatcher company(String name) { new CompanyMatcher(name) }

    static Teaser first_teaser = $('[data-role=first-teaser]') as Teaser
    static Teaser second_teaser = $('[data-role=second-teaser]') as Teaser

    static ListView reproaches_list = $('[data-role=reproaches-list]') as Ul
    static ListView rethink_list = $('[data-role=rethink-list]') as Ul

    static Heading first_conclusion = $('[data-role=first-conclusion]') as H2
    static Paragraph second_conclusion = $('[data-role=second-conclusion]') as Paragraph

    static Heading lens = $('[data-role=lens]') as H2
    static Heading recap = $('[data-role=recap]') as H2

    static Heading philosophy_title = $('[data-role=philosophy-title]') as H2
    static Heading practice_title = $('[data-role=practice-title]') as H2

    static Heading term_title = $('[data-role=term-title]') as H2
    static ListView terms_list = $('[data-role=terms-list]') as Ul

    static Paragraph what_message = $('[data-role=what]') as Paragraph
    static Paragraph how_message = $('[data-role=how]') as Paragraph

    static Heading functional_tests_specificity_title = $('[data-role=func-test-spec-title]') as H2
    static ListView functional_tests_specificity_list = $('[data-role=func-test-spec-list]') as Ul

    static Teaser last_teaser = $('[data-role=last-teaser]') as Teaser
}
