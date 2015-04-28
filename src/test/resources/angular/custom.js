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
(function(w) {

  var cartridge = {
    name: 'angular',
    components: []
  };

  var $ = w.testatoo;
  var html5 = $.getCartridge('html5').support;

  $.registerCartridge(cartridge);

  cartridge.components.push($.support([html5.base], {
    type: 'NavigationMenu',
    match: function(el) { return el.is('nav') },
    size: function(el) {
      return el.find('a').length;
    }
  }));

  cartridge.components.push($.support([html5.base], {
    type: 'Item',
    match: function(el) { return el.is('a') && el.parent().is('nav') },
    title: function(el) {
      return el.text().trim();
    },
    selected: function(el) {
      return el.attr('class') === el.closest('nav').attr('class');
    },
    unselected: function(el) {
      return !this.selected(el);
    }
  }));

}(window));