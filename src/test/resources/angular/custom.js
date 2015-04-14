/*
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
/*
 * Copyright (C) 2013 Ovea (dev@ovea.com)
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
(function (w) {

    var cartridge = {
        name: 'angular',
        components: []
    };

    var $ = w.testatoo;

    var base = {
        hidden: function(el) {
            return el.is(':hidden');
        },
        visible: function(id) {
            return !this.hidden(id);
        },
        enabled: function(el) {
            return !this.disabled(el);
        },
        disabled: function(el) {
            return el.is(':disabled') || el.attr('disabled') != undefined;
        },
        contains: function(el, ids) {
            var not = [];
            $.each(ids, function(index, _id) {
                !$.contains(el[0], $('#' + _id)[0]) && not.push(_id);
            });
            return not;
        },
        display: function(el, ids) {
            return this.contains(el, ids);
        }
    };

    $.registerCartridge(cartridge);

    cartridge.components.push($.extend({}, base, {
        type: 'NavigationMenu',
        match: function(el) { return el.is('nav') },
        size: function(el) {
            return el.find('a').length;
        }
    }));

    cartridge.components.push($.extend({}, base, {
        type: 'Item',
        match: function(el) { return el.is('a') && el.parent().is('nav') },
        title: function(el) {
            return el.text().trim();
        },
        selected: function(el) {
            return  el.attr('class') === el.closest('nav').attr('class');
        },
        unselected: function(el) {
            return !this.selected(el);
        }

    }));

}(window));