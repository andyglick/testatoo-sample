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
(function (w) {

    var cartridge = {
        name: 'polymerjs',
        components: []
    };

    var $ = w.testatoo;
    var html5 = $.getCartridge('html5').support;

    $.registerCartridge(cartridge);

    cartridge.components.push($.support([html5.base], {
        type: 'TabPanel',
        match: function(el) { return el.attr('role') === 'tablist'; }
    }));

    cartridge.components.push($.support([html5.base], {
        type: 'Tab',
        match: function(el) { return el.is('paper-tab'); }
    }));

}(window));
